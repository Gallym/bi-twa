-- BUILDINGS --
insert into building (id_building, address) values (1, 'Thakurova 9');

-- GROUP --
-- insert into group_entity (id_group, name) values (1, 'T9');

-- ROOMS --
insert into room (id_room, name, building_id_building) values (1, 'T301', 1);
insert into room (id_room, name, building_id_building) values (2, 'T302', 1);
insert into room (id_room, name, building_id_building) values (3, 'T303', 1);
insert into room (id_room, name, building_id_building) values (4, 'T304', 1);
--insert into room (id_room, name, id_building, id_user) values (1, 'T301', 1, 1);


-- USERS --
insert into user_entity (id_user, email, name, password, phone, surname, active)
    values (1, 'dosmagal@cvut.cz', 'Galymzhan', 'root', '774563132', 'Dosmagambet', true);
insert into user_entity (id_user, email, name, password, phone, surname, active)
    values (2, 'user1@cvut.cz', 'Obi-Wan', 'root', '774563132', 'Kenobi', true);
insert into user_entity (id_user, email, name, password, phone, surname, active)
    values (3, 'user2@cvut.cz', 'Qui Gon', 'root', '774563132', 'Jinn', true);
insert into user_entity (id_user, email, name, password, phone, surname, active)
    values (4, 'user4@cvut.cz', 'Anakin', 'root', '774563132', 'Skywalker', true);
insert into user_entity (id_user, email, name, password, phone, surname, active)
    values (5, 'user5@cvut.cz', 'Leia', 'root', '774563132', 'Organa', true);
insert into user_entity (id_user, email, name, password, phone, surname, active)
    values (6, 'user6@cvut.cz', 'Padme', 'root', '774563132', 'Amidala', true);
insert into user_entity (id_user, email, name, password, phone, surname, active)
    values (7, 'user7@cvut.cz', 'Padme', 'root', '774563132', 'Amidala', true);
insert into user_entity (id_user, email, name, password, phone, surname, active)
    values (8, 'user8@cvut.cz', 'Padme', 'root', '774563132', 'Amidala', true);


insert into user_occupies_rooms (fk_user, fk_room) values ( 1, 1 );
insert into user_occupies_rooms (fk_user, fk_room) values ( 1, 2 );
insert into user_occupies_rooms (fk_user, fk_room) values ( 2, 1 );
insert into user_occupies_rooms (fk_user, fk_room) values ( 3, 1 );
insert into user_occupies_rooms (fk_user, fk_room) values ( 4, 1 );

-- insert into users (username, enabled, email, name, password, phone, surname, id_authority)
--         values ('dosmagal', true, 'dosmagal@cvut.cz', 'Galymzhan', 'root', '774563132', 'Dosmagambet', 6);

-- ROLES --
insert into user_role (id_user, roles) values ( 1, 'ADMIN' );
insert into user_role (id_user, roles) values ( 2, 'USER' );
insert into user_role (id_user, roles) values ( 3, 'ROOM_MANAGER' );
insert into user_role (id_user, roles) values ( 4, 'GROUP_MANAGER' );
insert into user_role (id_user, roles) values ( 5, 'USER' );
insert into user_role (id_user, roles) values ( 6, 'USER' );
insert into user_role (id_user, roles) values ( 7, 'GROUP_MEMBER' );
insert into user_role (id_user, roles) values ( 8, 'GROUP_MEMBER' );

-- -- ROOMS --
-- insert into room (id_room, name, id_building, id_user) values (1, 'T301', 1, 1);
-- insert into room (id_room, name, id_building, id_user) values (1, 'T302', 1, 2);
-- insert into room (id_room, name, id_building, id_user) values (1, 'T302', 1, 5);
-- insert into room (id_room, name, id_building, id_user) values (1, 'T302', 1, 6);
-- insert into room (id_room, name, id_user) values (2, 'T302', 2);
-- insert into room (id_room, name, id_user) values (3, 'T303', 3);

-- RESERVATIONS --
insert into reservation (id_reservation, r_date, approved, room_id_room, attendee_id_user)
   values ( 1, TO_DATE('01-01-2021', 'DD-MM-YYYY'), false, 1, 1);
-- insert into reservation (id_reservation, r_date, approved, id_room, id_user)
--     values ( 2, TO_DATE('02-01-2021', 'DD-MM-YYYY'), false, 1, 2 );
-- insert into reservation (id_reservation, r_date, approved, id_room, id_user)
--     values ( 3, TO_DATE('03-01-2021', 'DD-MM-YYYY'), false, 1, 2 );
-- insert into reservation (id_reservation, r_date, approved, id_room, id_user)
--     values ( 4, TO_DATE('04-01-2021', 'DD-MM-YYYY'), false, 1, 5 );
-- insert into reservation (id_reservation, r_date, approved, id_room, id_user)
--     values ( 5, TO_DATE('05-01-2021', 'DD-MM-YYYY'), false, 1, 6 );
-- insert into reservation (id_reservation, r_date, approved, id_room, id_user)
--     values ( 6, TO_DATE('06-01-2021', 'DD-MM-YYYY'), true, 1, 2 );
-- insert into reservation (id_reservation, r_date, approved, id_room, id_user)
--     values ( 7, TO_DATE('07-01-2021', 'DD-MM-YYYY'), true, 1, 5 );
-- insert into reservation (id_reservation, r_date, approved, id_room, id_user)
--     values ( 8, TO_DATE('08-01-2021', 'DD-MM-YYYY'), true, 1, 6 );
-- insert into reservation (id_reservation, r_date, approved, id_room, id_user)
--     values ( 9, TO_DATE('09-01-2021', 'DD-MM-YYYY'), true, 1, 7 );