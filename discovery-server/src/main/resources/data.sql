INSERT INTO user (id, username, password, ime, prezime, email, enabled, last_password_reset_date, status) VALUES (1, 'user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Marko', 'Markovic', 'user@example.com', true, '2017-10-01 21:58:58', 'ACTIVE');
INSERT INTO user (id, username, password, ime, prezime, email, enabled, last_password_reset_date, status) VALUES (2, 'admin', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Nikola', 'Nikolic', 'admin@example.com', true, '2017-10-01 18:57:58', 'ACTIVE');
INSERT INTO user (id, username, password, ime, prezime, email, enabled, last_password_reset_date, status) VALUES (3, 'agent', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Petar', 'Petrovic', 'agent@example.com', true, '2017-10-01 18:57:58', 'ACTIVE');
INSERT INTO AUTHORITY (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO AUTHORITY (id, name) VALUES (2, 'ROLE_ADMIN');
INSERT INTO AUTHORITY (id, name) VALUES (3, 'ROLE_AGENT');


INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 2);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (3, 3);


INSERT INTO category VALUES (1,'5 STAR',5),(2,'4 STAR',4),(3,'3 STAR',3),(4,'2 STAR',2),(5,'1 STAR ',1),(6,'UNCATEGORIZED',0);

INSERT INTO accomodation_type VALUES (1,'hotel');

