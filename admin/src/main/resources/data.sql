insert into usluga (id, naziv, cena, opis) values (1,'spa', 20, 'Topconma');
insert into usluga (id, naziv, cena, opis) values (2,'spazz', 20, 'Topconma');
insert into usluga (id, naziv, cena, opis) values (3,'spacx', 20, 'Topconma');
insert into usluga (id, naziv, cena, opis) values (4,'spaqew', 20, 'Topconma');

INSERT INTO user (id, username, password, ime, prezime, email, enabled, last_password_reset_date, status) VALUES (1, 'user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Marko', 'Markovic', 'user@example.com', true, '2017-10-01 21:58:58', 'ACTIVE');
INSERT INTO user (id, username, password, ime, prezime, email, enabled, last_password_reset_date, status) VALUES (2, 'admin', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Nikola', 'Nikolic', 'admin@example.com', true, '2017-10-01 18:57:58', 'ACTIVE');
INSERT INTO AUTHORITY (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO AUTHORITY (id, name) VALUES (2, 'ROLE_ADMIN');
INSERT INTO AUTHORITY (id, name) VALUES (3, 'ROLE_AGENT');


INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 2);

insert into komentar(odobren, tekst, korisnik_id ) values ( false, 'Mars',1);
insert into komentar(odobren, tekst, korisnik_id ) values ( false, 'Mdasdasars',1);
insert into komentar(odobren, tekst, korisnik_id ) values ( false, 'asd',1);
insert into komentar(odobren, tekst, korisnik_id ) values ( true, 'Msadars',1);
insert into komentar(odobren, tekst, korisnik_id ) values ( true, 'Mdasars',2);
insert into komentar(odobren, tekst, korisnik_id ) values ( false, 'Maasrs',2);

insert into category(naziv, vrednost) values ('FIVE STAR',5);
insert into category(naziv, vrednost) values ('FOUR STAR',4);
insert into category(naziv, vrednost) values ('THREE STAR',3);
insert into category(naziv, vrednost) values ('TWO STAR',2);
insert into category(naziv, vrednost) values ('ONE STAR',1);
insert into category(naziv, vrednost) values ('UNCATEGORIZED',0);

insert into accomodation_type(id,naziv) values (1,'hotel');
insert into accomodation_type(id,naziv) values (2,'apartman');

