-- Inserts de ejemplo para la tabla authors
INSERT INTO authors (name, lastName, borthDate, nacionality) VALUES ('Gabriel', 'GarciaMarquez', '1927-03-06', 'Colombian');
INSERT INTO authors (name, lastName, borthDate, nacionality) VALUES ('Isabel', 'Allende', '1942-08-02', 'Chilean');
INSERT INTO authors (name, lastName, borthDate, nacionality) VALUES ('JK', 'Rowling', '1965-07-31', 'British');
INSERT INTO authors (name, lastName, borthDate, nacionality) VALUES ('George', 'Orwell', '1903-06-25', 'British');
INSERT INTO authors (name, lastName, borthDate, nacionality) VALUES ('Ernest', 'Hemingway', '1899-07-21', 'American');
INSERT INTO authors (name, lastName, borthDate, nacionality) VALUES ('Jane', 'Austen', '1775-12-16', 'British');
INSERT INTO authors (name, lastName, borthDate, nacionality) VALUES ('Mark', 'Twain', '1835-11-30', 'American');
INSERT INTO authors (name, lastName, borthDate, nacionality) VALUES ('Charles', 'Dickens', '1812-02-07', 'British');
INSERT INTO authors (name, lastName, borthDate, nacionality) VALUES ('F Scott', 'Fitzgerald', '1896-09-24', 'American');
INSERT INTO authors (name, lastName, borthDate, nacionality) VALUES ('Leo', 'Tolstoy', '1828-09-09', 'Russian');

-- Inserts para la tabla books

-- Libros de Gabriel Garcia Marquez (author_id = 1)
INSERT INTO books (title, publication_year, price, author_id) VALUES ('Cien anos de soledad', 1967, 19.99, 1);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('El amor en los tiempos del colera', 1985, 18.50, 1);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('Memoria de mis putas tristes', 2004, 22.00, 1);

-- Libros de Isabel Allende (author_id = 2)
INSERT INTO books (title, publication_year, price, author_id) VALUES ('La casa de los espiritus', 1982, 15.50, 2);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('Eva Luna', 1987, 16.75, 2);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('De amor y de sombra', 1984, 17.25, 2);

-- Libros de JK Rowling (author_id = 3)
INSERT INTO books (title, publication_year, price, author_id) VALUES ('Harry Potter and the Philosophers Stone', 1997, 25.00, 3);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('Harry Potter and the Chamber of Secrets', 1998, 26.50, 3);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('Harry Potter and the Prisoner of Azkaban', 1999, 27.75, 3);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('Harry Potter and the Goblet of Fire', 2000, 28.00, 3);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('Harry Potter and the Order of the Phoenix', 2003, 29.00, 3);

-- Libros de George Orwell (author_id = 4)
INSERT INTO books (title, publication_year, price, author_id) VALUES ('1984', 1949, 12.00, 4);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('Animal Farm', 1945, 10.00, 4);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('Homage to Catalonia', 1938, 13.50, 4);

-- Libros de Ernest Hemingway (author_id = 5)
INSERT INTO books (title, publication_year, price, author_id) VALUES ('The Old Man and the Sea', 1952, 15.00, 5);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('For Whom the Bell Tolls', 1940, 16.50, 5);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('A Farewell to Arms', 1929, 14.75, 5);

-- Libros de Jane Austen (author_id = 6)
INSERT INTO books (title, publication_year, price, author_id) VALUES ('Pride and Prejudice', 1813, 11.00, 6);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('Sense and Sensibility', 1811, 10.50, 6);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('Emma', 1815, 9.50, 6);

-- Libros de Mark Twain (author_id = 7)
INSERT INTO books (title, publication_year, price, author_id) VALUES ('The Adventures of Tom Sawyer', 1876, 12.75, 7);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('Adventures of Huckleberry Finn', 1884, 13.25, 7);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('A Connecticut Yankee in King Arthurs Court', 1889, 14.00, 7);

-- Libros de Charles Dickens (author_id = 8)
INSERT INTO books (title, publication_year, price, author_id) VALUES ('Great Expectations', 1861, 13.00, 8);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('A Tale of Two Cities', 1859, 12.50, 8);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('Oliver Twist', 1839, 11.75, 8);

-- Libros de F Scott Fitzgerald (author_id = 9)
INSERT INTO books (title, publication_year, price, author_id) VALUES ('The Great Gatsby', 1925, 15.00, 9);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('Tender Is the Night', 1934, 14.50, 9);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('This Side of Paradise', 1920, 13.25, 9);

-- Libros de Leo Tolstoy (author_id = 10)
INSERT INTO books (title, publication_year, price, author_id) VALUES ('War and Peace', 1869, 20.00, 10);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('Anna Karenina', 1877, 18.75, 10);
INSERT INTO books (title, publication_year, price, author_id) VALUES ('The Death of Ivan Ilyich', 1886, 16.00, 10);