package com.example.demo.entity;


import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_description")
    private String taskDescription;

    @Column(name = "task_group")
    private String taskGroup;

    @Column(name = "task_status")
    private String taskStatus;

    @Column(name = "assignee")
    private String assignee;

    @Column(name = "time_spend_on_task")
    private String timeSpent;

    @Column(name = "sub_task")
    private String subTask;

    public Task() {
    }

    public Task(String taskName, String taskDescription, String taskGroup, String taskStatus, String assignee, String timeSpent, String subTask) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskGroup = taskGroup;
        this.taskStatus = taskStatus;
        this.assignee = assignee;
        this.timeSpent = timeSpent;
        this.subTask = subTask;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(String taskGroup) {
        this.taskGroup = taskGroup;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(String timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getSubTask() {
        return subTask;
    }

    public void setSubTask(String subTask) {
        this.subTask = subTask;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskGroup='" + taskGroup + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", assignee='" + assignee + '\'' +
                ", timeSpent='" + timeSpent + '\'' +
                ", subTask='" + subTask + '\'' +
                '}';
    }
}
