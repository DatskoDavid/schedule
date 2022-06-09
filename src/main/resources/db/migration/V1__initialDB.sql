-- auto-generated definition
create table students
(
    id             bigint not null
        primary key,
    address        varchar(255),
    name           varchar(255),
    specialization varchar(255),
    tel            varchar(255)
);

alter table students
    owner to postgres;

-- auto-generated definition
create table subgroups
(
    id                 bigint not null
        primary key,
    course             bigint,
    faculty            varchar(255),
    name               varchar(255),
    number_of_students bigint,
    students_id        bigint
        constraint fkfss1sy8g2tlafxhb692xtc1ao
            references students
);

alter table subgroups
    owner to postgres;

-- auto-generated definition
create table groups
(
    id              bigint not null
        primary key,
    number_of_group bigint,
    subgroups_id    bigint
        constraint fks5tvq7e1wjc9xhfsdbowltlbc
            references subgroups
);

alter table groups
    owner to postgres;

-- auto-generated definition
create table audiences
(
    id   bigint not null
        primary key,
    name varchar(255)
);

alter table audiences
    owner to postgres;

-- auto-generated definition
create table subjects
(
    id              bigint not null
        primary key,
    final_control   varchar(255),
    name            varchar(255),
    number_of_hours bigint
);

alter table subjects
    owner to postgres;

-- auto-generated definition
create table teachers
(
    id       bigint not null
        primary key,
    address  varchar(255),
    name     varchar(255),
    position varchar(255)
);

alter table teachers
    owner to postgres;

-- auto-generated definition
create table schedules
(
    id              bigint not null
        primary key,
    day_of_week     integer,
    lesson_number   bigint,
    number_of_week  bigint,
    start_of_lesson time,
    audiences_id    bigint
        constraint fkh3gbja8clhupjn6habylv5cns
            references audiences,
    groups_id       bigint
        constraint fkifsunav5icnri5yrxssov6bls
            references groups,
    subjects_id     bigint
        constraint fkermv5jb2nma6pn83u55s2klaq
            references subjects,
    teachers_id     bigint
        constraint fk9q5elc55jwjp2yuadi8yypsy0
            references teachers
);

alter table schedules
    owner to postgres;



