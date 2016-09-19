package ua.kiev.prog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageDAO messageDAO;

    @Transactional
    public void addMessage(Message message) {
        messageDAO.save(message);
    }

    @Transactional(readOnly = true)
    public List<Message> findByDate(Date from) {
        return messageDAO.findByDate(from);
    }
}
