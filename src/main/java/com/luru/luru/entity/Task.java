package com.luru.luru.entity;

/**
 * @author 胡满意
 * @date 2019/10/17
 */
public class Task {
    int taskId;
    String taskName;
    String taskType;
    String taskTime;
    int taskNumber;
    String taskSalary;
    String taskCourse;
    String taskIntroduction;
    String taskReceive;
    String taskStart;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(String taskTime) {
        this.taskTime = taskTime;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getTaskSalary() {
        return taskSalary;
    }

    public void setTaskSalary(String taskSalary) {
        this.taskSalary = taskSalary;
    }

    public String getTaskCourse() {
        return taskCourse;
    }

    public void setTaskCourse(String taskCourse) {
        this.taskCourse = taskCourse;
    }

    public String getTaskIntroduction() {
        return taskIntroduction;
    }

    public void setTaskIntroduction(String taskIntroduction) {
        this.taskIntroduction = taskIntroduction;
    }

    public String getTaskReceive() {
        return taskReceive;
    }

    public void setTaskReceive(String taskReceive) {
        this.taskReceive = taskReceive;
    }

    public String getTaskStart() {
        return taskStart;
    }

    public void setTaskStart(String taskStart) {
        this.taskStart = taskStart;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", taskType='" + taskType + '\'' +
                ", taskTime='" + taskTime + '\'' +
                ", taskNumber=" + taskNumber +
                ", taskSalary='" + taskSalary + '\'' +
                ", taskCourse='" + taskCourse + '\'' +
                ", taskIntroduction='" + taskIntroduction + '\'' +
                ", taskReceive='" + taskReceive + '\'' +
                ", taskStart='" + taskStart + '\'' +
                '}';
    }
}
