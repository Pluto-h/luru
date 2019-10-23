package com.luru.luru.controller;

import com.auth0.jwt.JWT;
import com.luru.luru.entity.Member;
import com.luru.luru.service.MemberService;
import com.luru.luru.utils.SendEmail;
import com.luru.luru.utils.TokenUtil;
import com.luru.luru.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author 胡满意
 * @date 2019/10/14
 */
@EnableAutoConfiguration
@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private SendEmail sendEmail;

    /**
     *@描述   用户注册
     *@参数  [memberName, memberEmail, memberPassword, verificationCode, httpSession]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/10/23
     *@修改人和其它信息
     */
    @PostMapping("/register")
    public Map<String,Object> register(String memberName,String memberEmail,String memberPassword,String verificationCode,HttpSession httpSession){
        Map<String,Object> result = new HashMap<>();
        System.out.println(memberEmail);
        if (memberService.register(memberEmail)){
            if (Pattern.matches("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$",memberEmail)){
                if (Pattern.matches("^[a-zA-Z0-9]{6,13}$",memberPassword)){
                    System.out.println(verificationCode);
                    System.out.println(httpSession.getAttribute("verificationCode"));
                    if (verificationCode.equals(httpSession.getAttribute("verificationCode"))){
                        if (memberService.register1(memberName,memberEmail,memberPassword)>0){
                            result.put("state","success");
                            result.put("message","注册成功");
                            return result;
                        }
                        result.put("state","error");
                        result.put("message","注册失败");
                        return result;
                    }
                    result.put("state","error");
                    result.put("message","验证码错误");
                    return result;
                }
                result.put("state","error");
                result.put("message","密码不能有特殊符号且长度在6-13");
                return result;
            }
            result.put("state","error");
            result.put("message","邮箱错误");
            return result;
        }
        result.put("state","error");
        result.put("message","邮箱已存在");
        return result;
    }
    /**
     *@描述   登录
     *@参数  [member]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/10/22
     *@修改人和其它信息
     */
    @GetMapping("/member/login")
    public Map<String,Object> login(Member member){
        HashMap<String,Object> result = new HashMap<>();
        try {
            Member member1 = memberService.login(member.getMemberEmail());
            if (member1.getMemberPassword().equals(member.getMemberPassword())){
                System.out.println("登陆成功");
                String token = tokenUtil.getToken(member1);
                Date date = new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
                sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
                memberService.loginTime(sdf.parse(sdf.format(date)),member.getMemberEmail());
                result.put("token",token);
                result.put("state","success");
                result.put("message","登陆成功");
                return result;
            }
            result.put("state","error");
            result.put("message","用户名或密码错误");
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.put("state","error");
            result.put("message","登录失败");
            return result;
        }
    }

    /**
     *@描述   获取验证码
     *@参数  [memberEamil, httpSession]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/10/23
     *@修改人和其它信息
     */
    @GetMapping("/verificationCode")
    public Map<String,Object> verificationCode(String memberEmail, HttpSession httpSession){
        Map<String,Object> result = new HashMap<>();
        int verificationCode = (int)(100000+Math.random()*(999999-100000+1));
        httpSession.setAttribute("verificationCode",String.valueOf(verificationCode));
        if (sendEmail.sendEmail(memberEmail,String.valueOf(verificationCode))){
            result.put("state","success");
            result.put("message","验证码发送成功");
            return result;
        }
        result.put("state","error");
        result.put("message","验证码发送失败");
        return result;
    }

    /**
     *@描述   获取个人信息
     *@参数  [httpServletRequest]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/10/22
     *@修改人和其它信息
     */
    @GetMapping("/person")
    @UserLoginToken
    public Map<String,Object> person(HttpServletRequest httpServletRequest){
        Map<String,Object> result = new HashMap<>();
        String token = httpServletRequest.getHeader("token");
        String memberId = JWT.decode(token).getAudience().get(0);
        try {
            Member member = memberService.person(Integer.parseInt(memberId));
            System.out.println(member);
            result.put("member",member);
            result.put("state","success");
            result.put("message","获取个人信息成功");
            return result;
        }catch (Exception e){
            result.put("state","error");
            result.put("message","获取个人信息失败");
            return result;
        }
    }
    /**
     *@描述   修改个人资料
     *@参数  [memberName, memberPhone, httpServletRequest]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/10/23
     *@修改人和其它信息
     */
    @PutMapping("/person")
    @UserLoginToken
    public Map<String,Object> updatePerson(String memberName,int memberPhone,HttpServletRequest httpServletRequest){
        Map<String,Object> result = new HashMap<>();
        String token = httpServletRequest.getHeader("token");
        String memberId = JWT.decode(token).getAudience().get(0);
        try {
            if (memberService.updateDetailed(Integer.parseInt(memberId),memberName,memberPhone)>0){
                result.put("state","success");
                result.put("message","修改个人信息成功");
                return result;
            }
            result.put("state","error");
            result.put("message","修改个人信息失败");
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.put("state","error");
            result.put("message","修改个人信息失败");
            return result;
        }
    }
    /**
     *@描述   查询周排行
     *@参数  []
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/10/23
     *@修改人和其它信息
     */
    @GetMapping("/weekBalance")
    @UserLoginToken
    public Map<String,Object> weekBalance(){
        Map<String,Object> result = new HashMap<>();
        try {
            List<Member> memberList = memberService.weekBalance();
            result.put("memberList",memberList);
            result.put("state","success");
            result.put("message","周排行查询成功");
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.put("state","error");
            result.put("message","周排行查询失败");
            return result;
        }
    }
    /**
     *@描述   查询月排行
     *@参数  []
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/10/23
     *@修改人和其它信息
     */
    @GetMapping("/monthBalance")
    @UserLoginToken
    public Map<String,Object> monthBalance(){
        Map<String,Object> result = new HashMap<>();
        try {
            List<Member> memberList = memberService.monthBalance();
            result.put("memberList",memberList);
            result.put("state","success");
            result.put("message","月排行查询成功");
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.put("state","error");
            result.put("message","月排行查询失败");
            return result;
        }
    }
}
