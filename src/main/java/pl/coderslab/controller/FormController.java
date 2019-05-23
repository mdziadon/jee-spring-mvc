package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/first")
public class FormController {

    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @PostMapping("/form")
    @ResponseBody
    public String form(@RequestParam String paramName) {
        return "paramName=" + paramName;
    }
}
