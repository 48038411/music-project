package com.soft1851.music.controller;

import com.soft1851.music.dto.UserDto;
import com.soft1851.music.entity.User;
import com.soft1851.music.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-04-04 11:33
 */
//返回json视图的注释
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    //Service层建议返回Result类，方便前端查看状态
    @Resource
    private UserService userService;
    //前端使用POST方式提交，用PostMapping
    @PostMapping(value = "/sendSms")
    //Object是返回类型，建议用Result，如果该方法有多个参数用，分割，现在这个方法需要的参数是mobile，手机号
    public Object SendSms( @RequestParam(value = "mobile") String mobile, HttpServletRequest request, HttpServletResponse resp){
        //生成随机验证码的方法
        HttpSession hs = request.getSession();
        hs.setAttribute("code",生成的验证码);
        //使用发送验证码方法
        if (("OK").equals(发送验证码的方法返回的状态是否ok)){
            return "发送成功";
        }else {
            //然后前端可以根据返回的字符串信息，判断验证码是否发送成功
            return "发送失败"
        }
    }
    @PostMapping(value = "/sign-in")
    public void SignIn(@RequestParam UserDto userDto, HttpServletRequest request){
        //可能需要重新建一个UserDto类，里面是往数据库新增用户的参数，手机号，密码，验证码，这样这边就可以获取到用户输入的验证码
        //前端会把用户输入的验证码存到code里面传过来
        String userCode  = user.getCode();
        HttpSession hs = request.getSession();
        String code = (String) hs.getAttribute("code");
        if (code.equalsIgnoreCase(userCode)){
            //执行注册方法
        }
    }
}
