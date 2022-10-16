insert into iteis.employees (id, uuid, username, first_name, last_name, password, email, role, create_time) values(1, "c6600bab-c3eb-49cc-9750-f01cc53d153e", "administrator", "Janek", "Niejawny", "$2a$10$J7Li9RfFv/RrQih4me9d1e1Fdx5WsWaAFTu2VldJD89xuKR.ZdjDq", "admin@iteis.com.pl", "ADMIN", "2022-10-16 11:59:30.255514");
insert into iteis.employees (id, uuid, username, first_name, last_name, password, email, role, create_time) values(2, "3db8f9b9-785f-438e-951b-7a7234b86205", "jankowalski", "Jan", "Kowalski", "$2a$10$J7Li9RfFv/RrQih4me9d1e1Fdx5WsWaAFTu2VldJD89xuKR.ZdjDq", "user@iteis.com.pl", "USER", "2022-10-16 11:59:30.255514");
insert into iteis.employees (id, uuid, username, first_name, last_name, password, email, role, create_time) values(3, "d0db568e-c79a-4385-9673-b3ca4d01b0d8", "mareknowak", "Marek", "Nowak", "$2a$10$J7Li9RfFv/RrQih4me9d1e1Fdx5WsWaAFTu2VldJD89xuKR.ZdjDq", "userrrrr@iteis.com.pl", "USER", "2022-10-16 11:59:30.255514");
insert into iteis.employees (id, uuid, username, first_name, last_name, password, email, role, create_time) values(4, "11d11aad-3e56-42a2-ac7d-9a6bb67fbc63", "paniksinski", "John", "Doe", "$2a$10$J7Li9RfFv/RrQih4me9d1e1Fdx5WsWaAFTu2VldJD89xuKR.ZdjDq", "anonymous@iteis.com.pl", "USER", "2022-10-16 11:59:30.255514");
-- administrator 12345678

insert into iteis.mobiles (id, manufacturer, model, employee_id) values (1, "Sony", "Xperia 10 mini", 1);
insert into iteis.mobiles (id, manufacturer, model, employee_id) values (2, "Xiaomi", "Mi Note 11", 1);
insert into iteis.mobiles (id, manufacturer, model, employee_id) values (3, "Huawei", "P30 Pro", 2);
insert into iteis.mobiles (id, manufacturer, model, employee_id) values (4, "Poco", "X3", 3);
insert into iteis.mobiles (id, manufacturer, model, employee_id) values (5, "Samsung", "A53 5G", 2);
insert into iteis.mobiles (id, manufacturer, model, employee_id) values (6, "iPhone", "13 pro", 3);
insert into iteis.mobiles (id, manufacturer, model, employee_id) values (7, "ZTE", "Blade 3", 4);

insert into iteis.printers (id, manufacturer, model, employee_id) values (1, "Kyocera", "TaskAlfa 3051ci", 1);
insert into iteis.printers (id, manufacturer, model, employee_id) values (2, "Sharp", "MX-3550DN", 2);
insert into iteis.printers (id, manufacturer, model, employee_id) values (3, "HP", "Deskjet P1010", 1);
insert into iteis.printers (id, manufacturer, model, employee_id) values (4, "HP", "LaserJet M401DN", 3);
insert into iteis.printers (id, manufacturer, model, employee_id) values (5, "Brother", "J105W", 4);
insert into iteis.printers (id, manufacturer, model, employee_id) values (6, "Brother", "SmartInk 3", 1);
insert into iteis.printers (id, manufacturer, model, employee_id) values (7, "Epson", "AccuLaser 1000", 2);

insert into iteis.computers (id, ram, disk, disk_capacity,  office_key, office_version, operating_system, os_key, processor, employee_id) values (1, "16GB", "Seagate SSD", "1TB", "123-123-123", "Pro 2016 VL", "Windows 11", "DFFGC-FGFDFG-SFR-GSGDF", "Intel Core i5-10300", 1);
insert into iteis.computers (id, ram, disk, disk_capacity,  office_key, office_version, operating_system, os_key, processor, employee_id) values (2, "16GB", "Barracuda SSD", "256GB", "123-123-123", "Pro 2016 VL", "Windows 10", "DFFGC-FGFDFG-SFR-GSGDF", "Intel Core i5-10300", 2);
insert into iteis.computers (id, ram, disk, disk_capacity,  office_key, office_version, operating_system, os_key, processor, employee_id) values (3, "16GB", "WD SDD", "2TB", null, "Libre Office", "Linux Manjaro", "DFFGC-FGFDFG-SFR-GSGDF", "AMD Ryzen 5 5600H", 1);
insert into iteis.computers (id, ram, disk, disk_capacity,  office_key, office_version, operating_system, os_key, processor, employee_id) values (4, "16GB", "Apple SSD", "512GB", "123-123-123", "Pro 2021 VL", "MacOS Monterey", "DFFGC-FGFDFG-SFR-GSGDF", "Apple M1", 3);
insert into iteis.computers (id, ram, disk, disk_capacity,  office_key, office_version, operating_system, os_key, processor, employee_id) values (5, "16GB", "Seagate SSD", "1TB", "123-123-123", "Pro 2013 VL", "Windows 8.1", "DFFGC-FGFDFG-SFR-GSGDF", "Intel Core i3-12300", 4);