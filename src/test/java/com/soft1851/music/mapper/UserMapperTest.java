package com.soft1851.music.mapper;

import com.soft1851.music.entity.Music;
import com.soft1851.music.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;
    @Resource
    private MusicMapper musicMapper;

    @Test
    public void findByUserName() {
        if (userMapper.findByUserName("小小").getPassword().equals("11")){
            System.out.println("登录成功");
        }

    }

    @Test
    public void addUser() {
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
        Date date = new Date();// 获取当前时间

        String pwd = BCrypt.hashpw("22",BCrypt.gensalt());
        User user = User.builder()
                .id(null)
                .name("花花2")
                .password(pwd)
                .salt(BCrypt.gensalt())
                .email("111@qq.com")
                .phoneNumber("114")
                .status(1)
                .binding(1)
                .credits(0)
                .createTime(date)
                .lastLoginTime(date)
                .build();
//        盐值修改后的密码
        System.out.println(user.getPassword());
//        盐值
        System.out.println(BCrypt.gensalt());
        userMapper.addUser(user);
    }

    @Test
    public void getMusicById() {
        User user = userMapper.getMusicById(1);
        System.out.println(user.getName()+","+user.getId());
        System.out.println("*******************");
        List<Music> musics = user.getMusics();
        musics.forEach(music -> {
            System.out.println(
                    music.getId()
                    +","+music.getName()
                    +","+music.getAuthor()
                    +","+music.getImg()
            );
        });
    }
}