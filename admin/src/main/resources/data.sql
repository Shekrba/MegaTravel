insert into usluga (id, naziv, cena, opis) values (1,'spa', 20, 'Topconma');
insert into usluga (id, naziv, cena, opis) values (2,'spazz', 20, 'Topconma');
insert into usluga (id, naziv, cena, opis) values (3,'spacx', 20, 'Topconma');
insert into usluga (id, naziv, cena, opis) values (4,'spaqew', 20, 'Topconma');

insert into user (ime, prezime, email, role , status) values  ('Nikola', 'Mandic', 'mandaaaa96@yahoo.com', 'ADMIN', 'PENDING');
insert into user (ime, prezime, email, role , status) values  ('Petar', 'Mandic', 'mandaaaa96@yahoo.com', 'USER', 'PENDING');
insert into user (ime, prezime, email, role , status) values  ('Simo', 'Mandic', 'mandaaaa96@yahoo.com', 'AGENT', 'PENDING');
insert into user (ime, prezime, email, role , status) values  ('DJURO', 'Mandic', 'mandaaaa96@yahoo.com', 'USER', 'PENDING');
insert into user (ime, prezime, email, role , status) values  ('TOMKET', 'Mandic', 'mandaaaa96@yahoo.com', 'AGENT', 'PENDING');
insert into user (ime, prezime, email, role , status) values  ('AAAA', 'Mandic', 'mandaaaa96@yahoo.com', 'AGENT', 'ACTIVE');


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