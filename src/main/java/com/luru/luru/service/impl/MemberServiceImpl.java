package com.luru.luru.service.impl;

import com.luru.luru.entity.Member;
import com.luru.luru.mapper.MemberMapper;
import com.luru.luru.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author 胡满意
 * @date 2019/10/14
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Member selectMember(int memberId){
        return memberMapper.selectMember(memberId);
    }

    @Override
    public Member login(String memberEmail){
        return memberMapper.login(memberEmail);
    }

    @Override
    public Member person(int memberId){
        return memberMapper.person(memberId);
    }

    @Override
    public Boolean register(String memberEmail){
        if (memberMapper.register(memberEmail)==null){
            return true;
        }
        return false;
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int register1(String memberName,String memberEmail,String memberPassword){
        return memberMapper.register1(memberName,memberEmail,memberPassword);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateDetailed(int memberId,String memberName,int memberPhone){
        return memberMapper.updateDetailed(memberId,memberName,memberPhone);
    }
    @Override
    public int loginTime(Date memberLastLoginTime,String memberEmail){
        return memberMapper.loginTime(memberLastLoginTime,memberEmail);
    }
    @Override
    public List<Member> weekBalance(){
        return memberMapper.weekBalance();
    }
    @Override
    public List<Member> monthBalance(){
        return memberMapper.monthBalance();
    }
}
