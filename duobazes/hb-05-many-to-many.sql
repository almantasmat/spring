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

create table student
(
    id         int auto_increment
        primary key,
    first_name varchar(45) null,
    last_name  varchar(45) null,
    email      varchar(45) null
)
    charset = latin1;

create table course_student
(
    course_id  int not null,
    student_id int not null,
    primary key (course_id, student_id),
    constraint FK_COURSE_05
        foreign key (course_id) references course (id),
    constraint FK_STUDENT
        foreign key (student_id) references student (id)
)
    charset = latin1;

create index FK_STUDENT_idx
    on course_student (student_id);


