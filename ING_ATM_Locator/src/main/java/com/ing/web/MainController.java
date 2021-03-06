package com.ing.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    public static final String LOGIN_ERROR_ATTRIBUTE = "loginError";
    public static final String LOGIN_PAGE = "login";
    public static final String PUBLIC_INDEX_PAGE = "public/index";
    public static final String USER_INDEX_PAGE = "user/index";
    public static final String INDEX_PAGE = "index";

    @GetMapping("/")
    public String root() {
        return "redirect:/" + INDEX_PAGE;
    }

    @GetMapping("/index")
    public String index() {
        return INDEX_PAGE;
    }

    @GetMapping("/user/index")
    public String userIndex() {
        return USER_INDEX_PAGE;
    }

    @GetMapping("/public/index")
    public String publicIndex() {
        return PUBLIC_INDEX_PAGE;
    }

    @GetMapping(value = "/login")
    public String login() {
        return LOGIN_PAGE;
    }

    @GetMapping("/login-error")
    public String loginError(final Model model) {
        model.addAttribute(LOGIN_ERROR_ATTRIBUTE, true);
        return LOGIN_PAGE;
    }

}
