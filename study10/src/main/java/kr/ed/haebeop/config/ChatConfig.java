package kr.ed.haebeop.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class ChatConfig implements WebSocketConfigurer {

    // WebSocketHandler에 관한 생성자 추가
    private final WebSocketHandler webSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // endpoint 설정 : /chat
        // 이를 통해서 ws://localhost:8081/ws/chat 으로 요청이 들어오면 websocket 통신을 시작
        registry.addHandler(webSocketHandler, "/ws/chat").setAllowedOrigins("*");
    }
}
