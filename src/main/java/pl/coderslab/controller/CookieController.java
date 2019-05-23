package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

    @GetMapping("/setcookie/{value1}/{value2}")
    @ResponseBody
    public String setCookie(@PathVariable String value1, @PathVariable String value2, HttpServletResponse response) {
        Cookie cookie1 = new Cookie("cookie1", value1);
        Cookie cookie2 = new Cookie("cookie2", value2);
        cookie1.setPath("/");
        cookie2.setPath("/");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        return "Cookies added";
    }

    @GetMapping("/getcookies")
    @ResponseBody
    public String getCookies(@CookieValue("cookie1") String value1, @CookieValue("cookie2") String value2) {
        return "cookie1 = " + value1 + ", cookie2 = " + value2;
    }

    @GetMapping("/getcookies2")
    @ResponseBody
    public String getCookies(HttpServletRequest request) {
        Cookie cookie1 = WebUtils.getCookie(request, "cookie1");
        Cookie cookie2 = WebUtils.getCookie(request, "cookie2");
        return "cookie1 = " + cookie1.getValue() + ", cookie2 = " + cookie2.getValue();
    }
}
