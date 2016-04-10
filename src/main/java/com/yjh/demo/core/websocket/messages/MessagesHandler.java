package com.yjh.demo.core.websocket.messages;

import com.yjh.demo.core.websocket.bean.WebSocketClient;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by YJH on 2016/4/10 0010.
 */
public class MessagesHandler extends TextWebSocketHandler {
    private static Map<String, WebSocketClient> socketClients = new HashMap<String, WebSocketClient>();

    /**
     * 接收到客户端消息时调用
     *
     * @param session
     * @param message
     */
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        //获取发送消息的ip
        WebSocketClient sendClient = socketClients.get(session.getId());
        String clientIp = sendClient.getClientIp();
        System.out.println("handleTextMessage: " + session.getId() + "-" + clientIp + "-" + message.getPayload());
        Set<String> sessionIDs = socketClients.keySet();
        Iterator<String> i = sessionIDs.iterator();
        while(i.hasNext()) {
            String sessionID = i.next();
            WebSocketClient client = socketClients.get(sessionID);
            WebSocketSession clientSession = client.getSocketSession();
            try {
                clientSession.sendMessage(new TextMessage((clientIp + "(" + clientIp + ")\n" + message.getPayload()).getBytes("UTF-8")));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * 与客户端完成连接后调用
     *
     * @param session
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws UnsupportedEncodingException {
        //获取连接的唯一session id
        String sessionID = session.getId();

        //获取客户端ip地址
        String clientIp = session.getRemoteAddress().getAddress().getHostAddress();
        //将已连接的socket客户端保存
        WebSocketClient client = new WebSocketClient();
        client.setClientIp(clientIp);
        client.setSocketSession(session);

        System.out.println("afterConnectionEstablished: " + sessionID + "===IP:"+clientIp);

        //保存已连接的客户端信息
        socketClients.put(sessionID, client);
    }

    /**
     * 消息传输出错时调用
     *
     * @param session
     * @param exception
     * @throws Exception
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("handleTransportError");
    }

    /**
     * 一个客户端连接断开时关闭
     *
     * @param session
     * @param closeStatus
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        System.out.println("afterConnectionClosed");

        //从保存的客户端集合中删除关闭的客户端
        String sessionID = session.getId();
        socketClients.remove(sessionID);
    }

    @Override
    public boolean supportsPartialMessages() {
        // TODO Auto-generated method stub
        return false;
    }

}