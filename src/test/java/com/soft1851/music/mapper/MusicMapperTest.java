package com.soft1851.music.mapper;

import com.soft1851.music.entity.Music;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class MusicMapperTest {
    @Resource
    private MusicMapper musicMapper;
    @Test
    public void selectAll() {
        List<Music> music = musicMapper.selectAll();
        System.out.println(music);
    }
}