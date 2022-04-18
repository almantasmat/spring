create table task
(
    id                 int auto_increment
        primary key,
    task_name          varchar(50) not null,
    task_description   varchar(90) not null,
    task_group         varchar(50) not null,
    task_status        varchar(50) not null,
    assignee           varchar(50) not null,
    time_spend_on_task varchar(50) not null,
    sub_task           varchar(70) null
);