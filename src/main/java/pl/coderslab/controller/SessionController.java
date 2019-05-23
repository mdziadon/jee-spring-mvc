package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class SessionController {

    @GetMapping("/session")
    @ResponseBody
    public String session(HttpSession session) {
        LocalDate date = (LocalDate) session.getAttribute("loginStart");
        if (date != null) {
            return date.toString();
        }
        session.setAttribute("loginStart", LocalDate.now());
        return "Brak";
    }
}
