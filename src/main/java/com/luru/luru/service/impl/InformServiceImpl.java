package com.luru.luru.service.impl;

import com.luru.luru.entity.Inform;
import com.luru.luru.mapper.InformMapper;
import com.luru.luru.service.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 胡满意
 * @date 2019/10/21
 */
@Service
public class InformServiceImpl implements InformService {
    @Autowired
    private InformMapper informMapper;

    @Override
    public List<Inform> selectOneInform(int informType){
        return informMapper.selectOneInform(informType);
    }
    @Override
    public List<Inform> selectTwoInform(int informType){
        return informMapper.selectTwoInform(informType);
    }
    @Override
    public List<Inform> selectThreeInform(int informType){
        return informMapper.selectThreeInform(informType);
    }
    @Override
    public Inform selectAllInform(int informId){
        return informMapper.selectAllInform(informId);
    }
}
