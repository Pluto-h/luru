package com.luru.luru.service;

import com.luru.luru.entity.Task;

import java.util.List;

/**
 * @author 胡满意
 * @date 2019/10/23
 */
public interface TaskService {
    List<Task> selectAll();
    Task selectDetailed(int taskId);
}
