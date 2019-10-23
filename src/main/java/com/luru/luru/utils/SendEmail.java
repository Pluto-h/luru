package com.luru.luru.utils;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;

/**
 * @author 胡满意
 * @date 2019/10/23
 */
@Service
public class SendEmail {
    public boolean sendEmail(String emailAddress,String code){
        try {
            HtmlEmail email = new HtmlEmail();
            email.setHostName("smtp.qq.com");
            //需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
            email.setCharset("UTF-8");
            email.addTo(emailAddress);
            // 收件地址

            email.setFrom("1933430420@qq.com", "日照幻影工作室");
            //此处填邮箱地址和用户名,用户名可以任意填写

            email.setAuthentication("1933430420@qq.com", "mzecjhytckhkcfge");

            email.setSubject("日照幻影工作室验证码");
            //此处填写邮件名，邮件名可任意填写
            email.setMsg("尊敬的用户您好,您本次注册的验证码是:" + code);
            //此处填写邮件内容

            email.send();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
