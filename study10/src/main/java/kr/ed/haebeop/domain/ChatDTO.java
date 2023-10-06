package kr.ed.haebeop.domain;

import lombok.Data;

@Data
public class ChatDTO {
    public enum MessageType {
        // 메시지 타입 : 입장, 채팅
        ENTER, TALK
    }

    private MessageType type;           // 메시지 타입
    private String roomId;              // 방 번호
    private String sender;              // 채팅을 보낸 사람
    private String message;             // 메시지
    private String time;                // 채팅 발송 시간
    
}
