package com.luru.luru.service;

import com.luru.luru.entity.Inform;

import java.util.List;

/**
 * @author 胡满意
 * @date 2019/10/21
 */
public interface InformService {
    List<Inform> selectOneInform(int informType);
    List<Inform> selectTwoInform(int informType);
    List<Inform> selectThreeInform(int informType);
    Inform selectAllInform(int informId);
}
