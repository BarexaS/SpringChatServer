package ua.kiev.prog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
public class ChatController {
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody Message message) {
        messageService.addMessage(message);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/get")
    public List<Message> get(@RequestParam long from) {
        List<Message> messages = messageService.findByDate(new Date(from));
        return messages;
    }
}
