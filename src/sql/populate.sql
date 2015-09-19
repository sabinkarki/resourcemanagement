use resourcemanagement;
insert into role (id, name) values (1, 'ADMIN');
insert into role (id, name) values (2, 'USER');

insert into member(Email, Password, Username, role_id, address, dob, gender, name)
values ('sabin.karki@gmail.com', '$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', 'admin', 1, '4TH ST 1000N FAIRFIELD, IA, 52557', '1987-12-27', 'M', 'System Admin');
insert into member(Email, Password, Username, role_id, address, dob, gender, name)
values ('sabin.karki@gmail.com', '$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', 'guest', 2, '4TH ST 1000N FAIRFIELD, IA, 52557', '1987-12-27', 'M', 'Sabin Karki');

insert into building(id, description, name) values (1, 'College Building', 'Verill Hall');
insert into building(id, description, name) values (2, 'College Building', 'Derby Hall');
insert into building(id, description, name) values (3, 'College Building', 'BLD-143');
insert into building(id, description, name) values (4, 'College Building', 'BLD-144');

insert into room(id, description, name, status, Building_Id) values(1, 'Study-room', 'Study-Room', 'AVAILABLE', 4);
insert into room(id, description, name, status, Building_Id) values(2, 'Personal-room', 'RM-305', 'AVAILABLE', 3);
insert into room(id, description, name, status, Building_Id) values(3, 'Class Room', '115', 'AVAILABLE', 1);
insert into room(id, description, name, status, Building_Id) values(4, 'Administrative Room', 'A23', 'AVAILABLE', 1);
insert into room(id, description, name, status, Building_Id) values(5, 'Conference Hall', 'Conference-Room', 'AVAILABLE', 2);


insert into category(id, attr, name) value(1, 101, 'Electronics');
insert into category(id, attr, name) value(2, 101, 'Food');
insert into category(id, attr, name) value(3, 101, 'Furniture');
insert into category(id, attr, name) value(4, 101, 'Stationary');
insert into category(id, attr, name) value(5, 101, 'Electrical');

