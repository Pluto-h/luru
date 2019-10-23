package com.luru.luru.mapper;

import com.luru.luru.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @author 胡满意
 * @date 2019/10/14
 */
@Mapper
public interface MemberMapper {
    Member selectMember(int memberId);
    Member login(String memberEmail);
    Member person(int memberId);
    Member register(String memberEmail);
    int register1(String memberName,String memberEmail,String memberPassword);
    int updateDetailed(int memberId,String memberName,int memberPhone);
    int loginTime(Date memberLastLoginTime,String memberEmail);
    List<Member> weekBalance();
    List<Member> monthBalance();
}
