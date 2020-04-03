package com.soft1851.music.mapper;

import com.soft1851.music.entity.User;
import com.soft1851.music.entity.UserMusic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class UserMusicMapperTest {
    @Resource
    private UserMusicMapper userMusicMapper;
    @Test
    public void likeMusic() {
        UserMusic userMusic = UserMusic.builder()
                .id(2)
                .musicId(1)
                .userId(1)
                .build();
        userMusicMapper.likeMusic(userMusic);
    }

    @Test
    public void batchDelete() {
        List<Integer> idList = new ArrayList<>();
        for (int i=0;i<10;i++){
            idList.add(1+i);
        }
        System.out.println(userMusicMapper.batchDelete(idList));
    }
    @Test
    public void batchInsert() {
        List<UserMusic>userMusics = new ArrayList<>();
        for (int i = 0;i<10;i++){
            UserMusic userMusic = UserMusic.builder()
                    .id(1+i)
                    .musicId(1)
                    .userId(1)
                    .build();
            userMusics.add(userMusic);
        }
        System.out.println(userMusicMapper.batchInsert(userMusics));
    }
}