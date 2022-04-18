package com.spring.boot.craftsoft.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "task")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "task_name")
    private String taskName;

    @NotNull
    @Column(name = "task_description")
    private String taskDescription;

    @NotNull
    @Column(name = "task_group")
    private String taskGroup;

    @NotNull
    @Column(name = "task_status")
    private String taskStatus;

    @NotNull
    @Column(name = "assignee")
    private String assignee;

    @NotNull
    @Column(name = "time_spend_on_task")
    private String timeSpent;

    @Column(name = "sub_task")
    private String subTask;

}
