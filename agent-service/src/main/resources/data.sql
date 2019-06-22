insert into usluga (id, naziv, cena, opis) values (1,'Spa', 20, 'For bath.');
insert into usluga (id, naziv, cena, opis) values (2,'WIFI', 5, 'Internet.');
insert into usluga (id, naziv, cena, opis) values (3,'Breakfast', 10, 'For eat.');
insert into usluga (id, naziv, cena, opis) values (4,'Parking', 15, 'Parking');
insert into usluga (id, naziv, cena, opis) values (5,'Polu Pansion', 40, 'Polu Pansion.');
insert into usluga (id, naziv, cena, opis) values (6,'Pansion', 80, 'Pansion.');
insert into usluga (id, naziv, cena, opis) values (7,'All inclusive', 120, 'All inclusive.');
insert into usluga (id, naziv, cena, opis) values (8,'Allowed pets', 15, 'Allowed pets.');
insert into usluga (id, naziv, cena, opis) values (9,'TV', 5, 'TV');
insert into usluga (id, naziv, cena, opis) values (10,'Kitchen', 10, 'Kitchen.');
insert into usluga (id, naziv, cena, opis) values (11,'Private bath', 20, 'Private bath');

insert into category(naziv, vrednost) values ('FIVE STAR',5);
insert into category(naziv, vrednost) values ('FOUR STAR',4);
insert into category(naziv, vrednost) values ('THREE STAR',3);
insert into category(naziv, vrednost) values ('TWO STAR',2);
insert into category(naziv, vrednost) values ('ONE STAR',1);

insert into accomodation_type(id,naziv) values (1,'hotel');
insert into accomodation_type(id,naziv) values (2,'apartman');
insert into accomodation_type(id,naziv) values (3,'bed&breakfast');

insert into category_service(category_id, service_id) values (1,1);
insert into category_service(category_id, service_id) values (1,3);
insert into category_service(category_id, service_id) values (1,4);
insert into category_service(category_id, service_id) values (1,5);
insert into category_service(category_id, service_id) values (1,6);
insert into category_service(category_id, service_id) values (1,10);
insert into category_service(category_id, service_id) values (1,11);
insert into category_service(category_id, service_id) values (1,2);

insert into category_service(category_id, service_id) values (2,1);
insert into category_service(category_id, service_id) values (2,3);
insert into category_service(category_id, service_id) values (2,4);
insert into category_service(category_id, service_id) values (2,5);

insert into category_service(category_id, service_id) values (3,2);
insert into category_service(category_id, service_id) values (3,7);
insert into category_service(category_id, service_id) values (3,8);
insert into category_service(category_id, service_id) values (3,4);

insert into category_service(category_id, service_id) values (4,1);
insert into category_service(category_id, service_id) values (4,7);
insert into category_service(category_id, service_id) values (4,6);
insert into category_service(category_id, service_id) values (4,11);

insert into category_service(category_id, service_id) values (5,11);
insert into category_service(category_id, service_id) values (5,3);
insert into category_service(category_id, service_id) values (5,2);
insert into category_service(category_id, service_id) values (5,1);


insert into adresa(id,broj,latitude,longitude,mesto,pos_broj,ulica) values (1,20,2.2,3.3,'Novi Sad','21000','Polgar Andrasa');
insert into adresa(id,broj,latitude,longitude,mesto,pos_broj,ulica) values (2,13,2.2,3.3,'Novi Sad','21000','Trifuna Dimica');

insert into smestaj(id,naziv,opis,period_otkaza,accomodation_type_id,adresa_id) values (1,'Hotel Park','Super hotel',10,1,1);
insert into smestaj(id,naziv,opis,period_otkaza,accomodation_type_id,adresa_id) values (2,'Hotel Prezident','Super hotel',10,1,2);

insert services_smestaj(smestaj_id,service_id) values (1,10);
insert services_smestaj(smestaj_id,service_id) values (1,11);
insert services_smestaj(smestaj_id,service_id) values (1,2);
insert services_smestaj(smestaj_id,service_id) values (1,5);
insert services_smestaj(smestaj_id,service_id) values (1,4);
insert services_smestaj(smestaj_id,service_id) values (1,3);
insert services_smestaj(smestaj_id,service_id) values (1,2);

insert services_smestaj(smestaj_id,service_id) values (2,2);
insert services_smestaj(smestaj_id,service_id) values (2,1);
insert services_smestaj(smestaj_id,service_id) values (2,3);
insert services_smestaj(smestaj_id,service_id) values (2,7);
insert services_smestaj(smestaj_id,service_id) values (2,8);
insert services_smestaj(smestaj_id,service_id) values (2,9);
insert services_smestaj(smestaj_id,service_id) values (2,10);














