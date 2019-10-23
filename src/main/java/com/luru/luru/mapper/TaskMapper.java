package com.luru.luru.mapper;

import com.luru.luru.entity.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 胡满意
 * @date 2019/10/23
 */
@Mapper
public interface TaskMapper {
    List<Task> selectAll();
    Task selectDetailed(int taskId);
}
