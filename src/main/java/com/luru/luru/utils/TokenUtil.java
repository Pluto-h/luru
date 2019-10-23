package com.luru.luru.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.luru.luru.entity.Member;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author  胡满意
 * @date  2019/10/14
 */
@Service
public class TokenUtil {
    public String getToken(Member member){
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;
        Date end = new Date(currentTime);
        String token = JWT.create().withAudience(String.valueOf(member.getMemberId())).withIssuedAt(start).withExpiresAt(end).sign(Algorithm.HMAC256(member.getMemberPassword()));
        return token;
    }
}
