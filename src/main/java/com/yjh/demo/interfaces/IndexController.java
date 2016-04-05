package com.yjh.demo.interfaces;

import com.yjh.demo.core.Imagecaptcha.VerifyCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * Created by YJH on 2016/3/30.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }


    @RequestMapping(value = "/verificationCode")
    @ResponseBody
    public void verificationCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        //生成思维随机验证码
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4).toLowerCase();
        session.setAttribute("code",verifyCode);

        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        // 将图像输出到Servlet输出流中。
        int w = 200, h = 80;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
    }

    @RequestMapping(value = "/page404.htm")
    public ModelAndView page404() {
        return new ModelAndView("/error/404");
    }

    @RequestMapping(value = "/page500.htm")
    public ModelAndView page500() {
        return new ModelAndView("/error/500");
    }

    @RequestMapping(value = "/test")
    public ModelAndView test() {
        return new ModelAndView("/test");
    }
}
