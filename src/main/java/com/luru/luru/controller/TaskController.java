package com.luru.luru.controller;

import com.luru.luru.entity.Task;
import com.luru.luru.service.TaskService;
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
 * @date 2019/10/23
 */
@EnableAutoConfiguration
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    /**
     *@描述   查询所有任务
     *@参数  []
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/10/23
     *@修改人和其它信息
     */
    @GetMapping("/task")
    @UserLoginToken
    public Map<String,Object> task(){
        Map<String,Object> result = new HashMap<>();
        try {
            List<Task> taskList = taskService.selectAll();
            result.put("taskList",taskList);
            result.put("state","success");
            result.put("message","任务查询成功");
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.put("state","error");
            result.put("message","任务查询失败");
            return result;
        }
    }

    /**
     *@描述   查询任务详情
     *@参数  [taskId]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/10/23
     *@修改人和其它信息
     */
    @GetMapping("/task/{taskId}")
    @UserLoginToken
    public Map<String,Object> taskDetailed(@PathVariable("taskId") int taskId){
        Map<String,Object> result = new HashMap<>();
        try {
            Task task = taskService.selectDetailed(taskId);
            result.put("task",task);
            result.put("state","success");
            result.put("message","任务详情查询成功");
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.put("state","error");
            result.put("message","任务详情查询失败");
            return result;
        }
    }
}
