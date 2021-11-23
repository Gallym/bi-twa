 

alter table if exists reservation
    drop constraint if exists FK88wnbnbicbov1opjx6wqbjrya;
     

alter table if exists reservation
    drop constraint if exists FK8yue855t7oyfdr5e2pu58y1sj;
     

alter table if exists reservation
    drop constraint if exists FKtjenp99y7a3qer7ud5jb8d6ta;
     

alter table if exists room
    drop constraint if exists FKgnw6vun0pp8786kog4kgounls;
     

alter table if exists room
    drop constraint if exists FKtbbcuk502whiqiojgbf2pmoxm;
     

alter table if exists room
    drop constraint if exists FK4hw9ufqfsvk15xwbjxtpl32ya;
     

alter table if exists room
    drop constraint if exists FKi0omjhyfx6r4bksmye1emdgu5;
     

alter table if exists user_entity
    drop constraint if exists FK5j7ulxjp8jdo7elbrueopgb6o;
     

alter table if exists user_entity
    drop constraint if exists FKjlkholi02hcd1l2lqiow76sav;
     

alter table if exists user_role
    drop constraint if exists FK4k3elffkfjvub027jod66o490;
     

drop table if exists building cascade;
     

drop table if exists group_entity cascade;
     

drop table if exists reservation cascade;


drop table if exists room cascade;
     

drop table if exists user_entity cascade;
     

drop table if exists user_role cascade;
     

drop sequence if exists hibernate_sequence;
      create sequence hibernate_sequence start 1 increment 1;
     

create table building (
                          id_building int8 not null,
                          address varchar(255) not null,
                          primary key (id_building)
);
     

create table group_entity (
                              id_group int8 not null,
                              name varchar(255) not null,
                              primary key (id_group)
);
     

create table reservation (
                             id_reservation int8 not null,
                             approved boolean not null,
                             r_date date not null,
                             id_user int8 not null,
                             id_room int8 not null,
                             primary key (id_reservation)
);
     

create table room (
                      id_room int8 not null,
                      name varchar(255) not null,
                      id_building int8 not null,
                      id_group int8,
                      id_user int8,
                      primary key (id_room)
);
     

create table user_entity (
                             id_user int8 not null,
                             active boolean not null,
                             email varchar(255) not null,
                             name varchar(255) not null,
                             password varchar(60) not null,
                             phone varchar(255),
                             surname varchar(255) not null,
                             id_room int8,
                             primary key (id_user)
);
     

create table user_role (
                           id_user int8 not null,
                           roles varchar(255)
);
     

alter table if exists reservation
    add constraint FK88wnbnbicbov1opjx6wqbjrya
        foreign key (id_user)
            references user_entity;
     

alter table if exists reservation
    add constraint FK8yue855t7oyfdr5e2pu58y1sj
        foreign key (id_room)
            references room;
     

alter table if exists reservation
    add constraint FKtjenp99y7a3qer7ud5jb8d6ta
        foreign key (id_reservation)
            references user_entity;
     

alter table if exists room
    add constraint FKgnw6vun0pp8786kog4kgounls
        foreign key (id_building)
            references building;
     

alter table if exists room
    add constraint FKtbbcuk502whiqiojgbf2pmoxm
        foreign key (id_group)
            references group_entity;
     

alter table if exists room
    add constraint FK4hw9ufqfsvk15xwbjxtpl32ya
        foreign key (id_user)
            references user_entity;
     

alter table if exists room
    add constraint FKi0omjhyfx6r4bksmye1emdgu5
        foreign key (id_room)
            references user_entity;
     

alter table if exists user_entity
    add constraint FK5j7ulxjp8jdo7elbrueopgb6o
        foreign key (id_room)
            references room;
     

alter table if exists user_entity
    add constraint FKjlkholi02hcd1l2lqiow76sav
        foreign key (id_user)
            references room;
     

alter table if exists user_role
    add constraint FK4k3elffkfjvub027jod66o490
        foreign key (id_user)
            references user_entity;