package com.luru.luru.controller;

import com.luru.luru.entity.Inform;
import com.luru.luru.service.InformService;
import com.luru.luru.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 胡满意
 * @date 2019/10/21
 */
@EnableAutoConfiguration
@RestController
public class InformController {
    @Autowired
    private InformService informService;

    /**
     *@描述   获取通知，1为一般通知，2为公告通知，3为结算通知
     *@参数  [informType]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/10/21
     *@修改人和其它信息
     */
    @GetMapping("/inform")
    @UserLoginToken
    public Map<String,Object> selectInform(int informType){
        Map<String,Object> result = new HashMap<>();
        List<Inform> informList;
        try {
            if (informType==1){
                informList = informService.selectOneInform(informType);
            }else if (informType==2){
                informList = informService.selectTwoInform(informType);
            }else {
                informList = informService.selectThreeInform(informType);
            }
            result.put("informList",informList);
            result.put("state","success");
            result.put("message","通知获取成功");
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.put("state","error");
            result.put("message","通知获取失败");
            return result;
        }
    }

    /**
     *@描述   获取通知具体信息
     *@参数  [informId]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/10/21
     *@修改人和其它信息
     */
    @GetMapping("/inform/{informId}")
    @UserLoginToken
    public Map<String,Object> selectAllInform(@PathVariable("informId") int informId){
        Map<String,Object> result = new HashMap<>();
        try {
            Inform inform = informService.selectAllInform(informId);
            result.put("inform",inform);
            result.put("state","success");
            result.put("message","通知信息获取成功");
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.put("state","error");
            result.put("message","通知信息获取失败");
            return result;
        }
    }
}
