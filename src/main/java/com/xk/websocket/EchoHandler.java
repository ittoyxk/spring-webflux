package com.xk.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

/**
 * Created by hengxiaokang
 * Date:2018/9/19
 * Time:15:23
 */
@Component
public class EchoHandler implements WebSocketHandler
{
    @Override
    public Mono<Void> handle(WebSocketSession webSocketSession)
    {
        return webSocketSession.send(webSocketSession.receive().map(msg -> webSocketSession.textMessage("ECHO -> " + msg.getPayloadAsText())));
    }
}