package com.soft1851.music.controller;

import com.soft1851.music.service.MusicService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-04-04 16:23
 */
@RestController
@RequestMapping(value = "/api/music")
public class MusicController {
    @Resource
    private MusicService musicService;
    //查询所有音乐
    @GetMapping(value = "/all")
    public String musicAll(Model model){
        model.addAttribute("allMusic",musicService.selectAll());
        return "music";
    }
}
