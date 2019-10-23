package com.luru.luru.mapper;

import com.luru.luru.entity.Inform;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 胡满意
 * @date 2019/10/20
 */
@Mapper
public interface InformMapper {
    /**
     *@描述   获取一般通知
     *@参数  [informType]
     *@返回值  java.util.List<com.luru.luru.entity.Inform>
     *@创建人  胡满意
     *@创建时间  2019/10/21
     *@修改人和其它信息
     */
    List<Inform> selectOneInform(int informType);
    /**
     *@描述   获取公告通知
     *@参数  [informType]
     *@返回值  java.util.List<com.luru.luru.entity.Inform>
     *@创建人  胡满意
     *@创建时间  2019/10/21
     *@修改人和其它信息
     */
    List<Inform> selectTwoInform(int informType);
    /**
     *@描述   获取结算通知
     *@参数  [informType]
     *@返回值  java.util.List<com.luru.luru.entity.Inform>
     *@创建人  胡满意
     *@创建时间  2019/10/21
     *@修改人和其它信息
     */
    List<Inform> selectThreeInform(int informType);
    /**
     *@描述   查询通知具体信息
     *@参数  [informId]
     *@返回值  java.util.List<com.luru.luru.entity.Inform>
     *@创建人  胡满意
     *@创建时间  2019/10/21
     *@修改人和其它信息
     */
    Inform selectAllInform(int informId);
}
