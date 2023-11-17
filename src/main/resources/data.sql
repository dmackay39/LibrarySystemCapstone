INSERT INTO address(id, house_number, street, country) VALUES (1, 25, 'Dwayne Drive', 'Scotland');
INSERT INTO phone_number(id, country_code, number) VALUES (1, 44, 756312910);
INSERT INTO author(id, name, address_id, email, phone_number_id) VALUES (1, 'Frank Herbert', 1, 'Frank@herbert.com', 1);
INSERT INTO book(id, author_id, title, genre) VALUES (1, 1, 'Dune', 'SCIFI');
INSERT INTO book(id, author_id, title, genre) VALUES (2, 1, 'Dune Messiah', 'SCIFI');
INSERT INTO movie(id, director, genre, title, rating) VALUES (1, 'Christopher Nolan', 'DRAMA','The Dark Knight', 4);