package top.kaoxing.myweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import top.kaoxing.myweb.pojo.message.Message;
import top.kaoxing.myweb.service.MessageRepository;
import top.kaoxing.myweb.service.TokenGenerator;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private TokenGenerator tokenGenerator;

    @GetMapping("")
    public String home() {
        return "redirect:/index.html";
    }

    // 提交留言
    @ResponseBody
    @PostMapping("/postMessage")
    public ResponseEntity<String> postMessage(@RequestBody Map<String, String> message) {
        Message newMessage = new Message();
        newMessage.setName(message.get("name"));
        newMessage.setEmail(message.get("email"));
        newMessage.setMessage(message.get("message"));
        messageRepository.save(newMessage);
        return ResponseEntity.status(200).body("Success");
    }

    // 获取所有留言
    @ResponseBody
    @GetMapping("/getAllMessages")
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

}