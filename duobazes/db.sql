create table customer
(
    id         int auto_increment
        primary key,
    first_name varchar(50) not null,
    last_name  varchar(50) not null,
    email      varchar(50) not null
);

create table doctor
(
    id             int auto_increment
        primary key,
    first_name     varchar(55) not null,
    last_name      varchar(55) not null,
    specialization varchar(55) not null,
    cabinet        varchar(20) not null
);

create table employee
(
    id         int auto_increment
        primary key,
    first_name varchar(55) not null,
    last_name  varchar(55) not null,
    email      varchar(55) not null
);

create table instructor_detail
(
    id              int auto_increment
        primary key,
    youtube_channel varchar(128) null,
    hobby           varchar(45)  null
)
    charset = latin1;

create table instructor
(
    id                   int auto_increment
        primary key,
    first_name           varchar(45) null,
    last_name            varchar(45) null,
    email                varchar(45) null,
    instructor_detail_id int         null,
    constraint FK_DETAIL
        foreign key (instructor_detail_id) references instructor_detail (id)
)
    charset = latin1;

create table course
(
    id            int auto_increment
        primary key,
    title         varchar(128) null,
    instructor_id int          null,
    constraint TITLE_UNIQUE
        unique (title),
    constraint FK_INSTRUCTOR
        foreign key (instructor_id) references instructor (id)
)
    charset = latin1;

create index FK_INSTRUCTOR_idx
    on course (instructor_id);

create index FK_DETAIL_idx
    on instructor (instructor_detail_id);

create table review
(
    id        int auto_increment
        primary key,
    comment   varchar(256) null,
    course_id int          null,
    constraint FK_COURSE
        foreign key (course_id) references course (id)
)
    charset = latin1;

create index FK_COURSE_ID_idx
    on review (course_id);

create table sb_airport
(
    biz_id   int auto_increment
        primary key,
    biz_name varchar(50) not null,
    address  varchar(50) not null,
    city     varchar(50) not null
);

create table student
(
    id         int auto_increment
        primary key,
    first_name varchar(45) not null,
    last_name  varchar(45) not null,
    email      varchar(45) not null
);

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

create table users
(
    username varchar(50) not null
        primary key,
    password varchar(68) not null,
    enabled  tinyint(1)  not null
)
    charset = latin1;

create table authorities
(
    username  varchar(50) not null,
    authority varchar(50) not null,
    constraint authorities_idx_1
        unique (username, authority),
    constraint authorities_ibfk_1
        foreign key (username) references users (username)
)
    charset = latin1;


