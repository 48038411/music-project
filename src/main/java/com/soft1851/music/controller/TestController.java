package com.soft1851.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-04-04 15:59
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {
    @GetMapping("/home")
    public String music(Model model) {
        model.addAttribute("test","Hello");
        System.out.println("1242");
        return "home";
    }
}
