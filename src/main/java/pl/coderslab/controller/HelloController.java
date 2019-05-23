package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalTime;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello/{firstName}/{lastName}")
    @ResponseBody
    public String hello(@PathVariable String firstName, @PathVariable String lastName) {
        return "Witaj " + firstName + " " + lastName;
    }

    @GetMapping("/helloView")
    public String helloView(Model model) {
        String color = "black";
        String backgroundColor = "white";
        LocalTime time = LocalTime.now();
        if (time.getHour() >= 20 || time.getHour() <= 8) {
            color = "white";
            backgroundColor = "black";
        }
        model.addAttribute("color", color);
        model.addAttribute("backgroundColor", backgroundColor);
        return "home";
    }


}
