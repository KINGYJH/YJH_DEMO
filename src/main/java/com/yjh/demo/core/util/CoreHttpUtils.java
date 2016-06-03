package com.yjh.demo.core.util;

import com.yjh.demo.application.account.representation.AccountRepresentation;
import com.yjh.demo.application.auth.command.LoginCommand;
import com.yjh.demo.core.common.Constants;
import com.yjh.demo.core.exception.NoLoginException;
import com.yjh.demo.core.util.httpclient.CustomHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by YJH on 2016/4/5 0005.
 */
public class CoreHttpUtils {

    private static final Charset DEFAULT_CHARSET = Consts.UTF_8;

    public static final RequestConfig DEFAULT_REQUEST_CONFIG = RequestConfig.custom()
            .setExpectContinueEnabled(true)
            .setStaleConnectionCheckEnabled(true)
            .setSocketTimeout(30000)
            .setConnectTimeout(30000)
            .setConnectionRequestTimeout(30000)
            .setCookieSpec(CookieSpecs.BROWSER_COMPATIBILITY)
            .build();
//                .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
//                .setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC))

    private static String[] HTTP_PROXY_HEADER_NAME = new String[]{
            "CLIENTIP",
            "X-FORWARDED-FOR"
    };

    private enum LoginPlatform {
        WINDOW("PC", 0),
        IPHONE("iPhone", 1),
        ANDROID("Android", 2);

        private String name;
        private int value;

        LoginPlatform(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }

    public static String getClientIP(HttpServletRequest request) {
        for (String headerName : HTTP_PROXY_HEADER_NAME) {
            String clientIP = request.getHeader(headerName);
            if (StringUtils.isNotBlank(clientIP)) {
                return clientIP;
            }
        }
        return request.getRemoteAddr();
    }

    public static String getLoginPlatform(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent").toUpperCase();
        if (userAgent.contains(LoginPlatform.WINDOW.name())) {
            return LoginPlatform.WINDOW.getName();
        } else if (userAgent.contains(LoginPlatform.IPHONE.name())) {
            return LoginPlatform.IPHONE.getName();
        } else if (userAgent.contains(LoginPlatform.ANDROID.name())) {
            return LoginPlatform.ANDROID.getName();
        }
        return null;
    }

    public static String[] getClientIPArray(HttpServletRequest request) {
        String clientIP = getClientIP(request);
        if (StringUtils.isEmpty(clientIP)) {
            return null;
        }
        return StringUtils.split(clientIP, ",");
    }


    public static CloseableHttpClient getHttpClient() {
        return CustomHttpClient.getInstance().getHttpClient();
    }

    public static String post(String url, Map<String, String> headerMap, HttpContext localContext,
                              NameValuePair... params) throws IOException {
        return post(url, null, localContext, null, headerMap, null, params);
    }

    public static String post(String url, Map<String, String> headerMap, HttpContext localContext,
                              String requestBody) throws IOException {
        return post(url, null, localContext, null, headerMap, requestBody);
    }

    /**
     * Post方法302直接返回Location地址
     *
     * @param url
     * @param charset
     * @param localContext
     * @param requestConfig
     * @param headerMap
     * @param requestBody
     * @param params
     * @return
     * @throws IOException
     */
    public static String post(String url, Charset charset, HttpContext localContext, RequestConfig requestConfig,
                              Map<String, String> headerMap, String requestBody,
                              NameValuePair... params) throws IOException {
        String postString;
        if (charset == null) {
            charset = DEFAULT_CHARSET;
        }

        if (requestConfig == null) {
            requestConfig = DEFAULT_REQUEST_CONFIG;
        }

        StringEntity entity;
        if (CoreStringUtils.isEmpty(requestBody)) {
            List<NameValuePair> formParams = new ArrayList<NameValuePair>();
            for (NameValuePair p : params) {
                formParams.add(p);
            }
            entity = new UrlEncodedFormEntity(formParams, charset);
        } else {
            entity = new StringEntity(requestBody, ContentType.create("text/plain", charset));
        }

        HttpPost request = new HttpPost(url);
        request.setEntity(entity);


        request.setConfig(requestConfig);

        if (null != headerMap) {
            Header[] headerArr = new BasicHeader[headerMap.size()];
            int counter = 0;
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                headerArr[counter++] = new BasicHeader(entry.getKey(), entry.getValue());
            }
            request.setHeaders(headerArr);
        }

        CloseableHttpClient client = getHttpClient();

        CloseableHttpResponse response;

        response = client.execute(request, localContext);
        HttpEntity resEntity = response.getEntity();

        postString = response.getStatusLine().getStatusCode() == 302 ? response.getFirstHeader("Location").toString()
                : (resEntity == null) ?
                null :
                EntityUtils.toString(resEntity, charset);

        if (response != null) {
            response.close();
        }

        return postString;
    }

    public static BufferedImage getImage(String url, Map<String, String> headerMap,
                                         HttpContext localContext) throws IOException {
        return getImage(url, null, headerMap, localContext);
    }

    public static BufferedImage getImage(String url, RequestConfig requestConfig, Map<String, String> headerMap,
                                         HttpContext localContext) throws IOException {

        BufferedImage bufferedImage = null;

        if (requestConfig == null) {
            requestConfig = DEFAULT_REQUEST_CONFIG;
        }

        HttpGet request = new HttpGet(url);

        request.setConfig(requestConfig);

        if (null != headerMap) {
            Header[] headerArr = new BasicHeader[headerMap.size()];
            int counter = 0;
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                headerArr[counter++] = new BasicHeader(entry.getKey(), entry.getValue());
            }
            request.setHeaders(headerArr);
        }

        CloseableHttpClient client = getHttpClient();
        CloseableHttpResponse response = null;
        InputStream inputStream = null;

        response = client.execute(request, localContext);
        // Get hold of the response entity
        HttpEntity entity = response.getEntity();

        // If the response does not enclose an entity, there is no need
        // to bother about connection release
        if (entity != null) {
            inputStream = entity.getContent();
            BufferedImage temp = ImageIO.read(inputStream);
            int width = temp.getWidth();
            int height = temp.getHeight();
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
            g.drawImage(temp, 0, 0, width, height, null); //画图
            g.dispose();
            bufferedImage.flush();
        }

        if (response != null) {
            response.close();
        }

        if (null != inputStream) {
            inputStream.close();
        }

        return bufferedImage;
    }

    public static String get(String url, Map<String, String> headerMap, HttpContext localContext) throws IOException {
        return get(url, null, null, headerMap, localContext);
    }

    public static String get(String url, Charset charset, RequestConfig requestConfig, Map<String, String> headerMap,
                             HttpContext localContext) throws IOException {
        String postString = null;
        if (charset == null) {
            charset = DEFAULT_CHARSET;
        }

        if (requestConfig == null) {
            requestConfig = DEFAULT_REQUEST_CONFIG;
        }

        HttpGet request = new HttpGet(url);

        request.setConfig(requestConfig);

        if (null != headerMap) {
            Header[] headerArr = new BasicHeader[headerMap.size()];
            int counter = 0;
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                headerArr[counter++] = new BasicHeader(entry.getKey(), entry.getValue());
            }
            request.setHeaders(headerArr);
        }

        CloseableHttpClient client = getHttpClient();
        CloseableHttpResponse response = null;

        response = client.execute(request, localContext);
        HttpEntity resEntity = response.getEntity();
        postString = (resEntity == null) ?
                null :
                EntityUtils.toString(resEntity, charset);

        if (response != null) {
            response.close();
        }

        return postString;
    }

    /**
     * 保存用户cookie
     *
     * @param command
     * @param request
     * @param response
     */
    public static void writeCookie(LoginCommand command, HttpServletRequest request, HttpServletResponse response) {
        if (command.isRememberMe()) {
            String encryptStr = command.getUserName() + "," + command.getPassword();
            Cookie cookie = new Cookie(Constants.COOKIE_USER, CoreRc4Utils.encry_RC4_string(encryptStr, Constants.PASSWORD_ENCRYP_KEY));
            cookie.setMaxAge(604800);
            response.addCookie(cookie);
        } else {
            clearCookie(request, response);
        }
    }

    /**
     * 移除用户保存的cookie
     *
     * @param request
     * @param response
     */
    public static void clearCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (null != cookies && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(Constants.COOKIE_USER)) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
    }

    public static AccountRepresentation getSessionAccount(HttpSession session) {
        AccountRepresentation account = (AccountRepresentation) session.getAttribute(Constants.SESSION_USER);
        if (null == account) {
            throw new NoLoginException("没有登录");
        }
        return account;
    }

}
