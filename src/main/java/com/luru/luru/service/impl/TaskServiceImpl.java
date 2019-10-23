package com.luru.luru.service.impl;

import com.luru.luru.entity.Task;
import com.luru.luru.mapper.TaskMapper;
import com.luru.luru.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 胡满意
 * @date 2019/10/23
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;
    @Override
    public List<Task> selectAll(){
        return taskMapper.selectAll();
    }
    @Override
    public Task selectDetailed(int taskId){
        return taskMapper.selectDetailed(taskId);
    }
}
