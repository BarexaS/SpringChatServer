package ua.kiev.prog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public ResponseEntity<Void> login(HttpServletResponse resp) throws IOException {
        resp.getOutputStream().print("Hallo!");
        return new ResponseEntity<Void>(HttpStatus.I_AM_A_TEAPOT);
    }

    @RequestMapping(value = "/singup", method = RequestMethod.POST)
    public ResponseEntity<Void> singup(@RequestParam("login") String login,@RequestParam("password") String pass) {
        CustomUser newUser = new CustomUser(login, pass, UserRole.USER);
        userService.addUser(newUser);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
