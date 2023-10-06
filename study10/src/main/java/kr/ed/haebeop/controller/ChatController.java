package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.ChatRoom;
import kr.ed.haebeop.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/chat/")
public class ChatController {

    private final ChatService service;

    @GetMapping("home")
    public String loadHome(Model model) {
        return "chat";
    }

    @PostMapping("createRoom")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String name) {
        return service.createRoom(name);
    }

    @GetMapping("allRoom")
    @ResponseBody
    public List<ChatRoom> findAllRooms() {
        return service.findAllRoom();
    }

}
