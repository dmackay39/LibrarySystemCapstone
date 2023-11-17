INSERT INTO address(id, house_number, street, country) VALUES (1, 25, 'Richmond Road', 'USA');
INSERT INTO phone_number(id, country_code, number) VALUES (1, 44, 759242710);
INSERT INTO author(id, name, address_id, email, phone_number_id) VALUES (1, 'Robert C Martin', 1, 'Robert@clean.com', 1);
INSERT INTO book(id, author_id, title, genre) VALUES (1, 1, 'Clean Code', 'COMPSCI');
INSERT INTO book(id, author_id, title, genre) VALUES (2, 1, 'Clean Architecture', 'COMPSCI');
INSERT INTO movie(id, director, genre, title, rating) VALUES (1, 'Stanley Kubrick', 'SCIFI','2001:A Space Oddysey', 3);