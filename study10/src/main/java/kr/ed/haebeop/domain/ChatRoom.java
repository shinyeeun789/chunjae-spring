package kr.ed.haebeop.domain;

import kr.ed.haebeop.service.ChatService;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

@Data
public class ChatRoom {
    private String roomId;      // 채팅방 아이디
    private String name;        // 채팅방 이름
    private Set<WebSocketSession> sessions = new HashSet<>();

    @Builder
    public ChatRoom(String roomId, String name) {
        this.roomId = roomId;
        this.name = name;
    }

    public void handleAction(WebSocketSession session, ChatDTO message, ChatService service) {
        // message에 담긴 타입을 확인
        // 이때 message에서 getType으로 가져온 내용이 ChatDTO의 열거형인 MessageType 안에 있는 ENTER과 동일한 값이라면
        if (message.getType().equals(ChatDTO.MessageType.ENTER)) {
            // sessions에 넘어온 session을 담고,
            sessions.add(session);
            
            // message에는 입장하였다는 메시지를 띄움
            message.setMessage(message.getSender() + " 님이 입장하셨습니다.");
            sendMessage(message, service);
        } else if (message.getTime().equals(ChatDTO.MessageType.TALK)) {
            message.setMessage(message.getMessage());
            sendMessage(message, service);
        }
    }

    public <T> void sendMessage(T message, ChatService service) {
        sessions.parallelStream().forEach(session -> service.sendMessage(session, message));
    }
}
