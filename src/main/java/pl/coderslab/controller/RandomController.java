package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomController {

    @GetMapping(value = "/showNumber", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String showRandom() {
        Random random = new Random();
        int number = random.nextInt(101);
        return "Wylosowano liczbę: " + number;
    }

    @GetMapping(value = "/random/{min}/{max}", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String random(@PathVariable int min, @PathVariable int max) {
        Random random = new Random();
        int number = random.nextInt(max - min + 1) + min;
        return " Użytkownik podał wartość: " + min + " i " + max + ". Wylosowano liczbę: " + number;
    }
}
