package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

@Controller
public class FreeTimeController {

    @GetMapping(value = "/timeOfWeek", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String timeOfWeek() {
        LocalDateTime now = LocalDateTime.of(2019, 5, 23, 18, 00);
        if (now.getDayOfWeek() == SATURDAY || now.getDayOfWeek() == SUNDAY) {
            return "Wolne";
        } else if (now.getHour() > 9 && now.getHour() < 17) {
            return "Pracuje, nie dzwoń";
        } else {
            return "Po pracy";
        }
    }
}
