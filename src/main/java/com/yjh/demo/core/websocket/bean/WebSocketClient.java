package com.yjh.demo.core.websocket.bean;

import org.springframework.web.socket.WebSocketSession;

/**
 * Created by YJH on 2016/4/10 0010.
 */
public class WebSocketClient {

    private WebSocketSession socketSession;
    private String clientIp;

    public WebSocketSession getSocketSession() {
        return socketSession;
    }

    public void setSocketSession(WebSocketSession socketSession) {
        this.socketSession = socketSession;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

}
