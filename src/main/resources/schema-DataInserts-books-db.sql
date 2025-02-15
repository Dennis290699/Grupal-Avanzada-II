-- Inserts de ejemplo para la tabla autor
INSERT INTO autor (nombre, apellido, fecha_nacimiento, nacionalidad) VALUES ('Gabriel', 'GarciaMarquez', '1927-03-06', 'Colombian');
INSERT INTO autor (nombre, apellido, fecha_nacimiento, nacionalidad) VALUES ('Isabel', 'Allende', '1942-08-02', 'Chilean');
INSERT INTO autor (nombre, apellido, fecha_nacimiento, nacionalidad) VALUES ('JK', 'Rowling', '1965-07-31', 'British');
INSERT INTO autor (nombre, apellido, fecha_nacimiento, nacionalidad) VALUES ('George', 'Orwell', '1903-06-25', 'British');
INSERT INTO autor (nombre, apellido, fecha_nacimiento, nacionalidad) VALUES ('Ernest', 'Hemingway', '1899-07-21', 'American');
INSERT INTO autor (nombre, apellido, fecha_nacimiento, nacionalidad) VALUES ('Jane', 'Austen', '1775-12-16', 'British');
INSERT INTO autor (nombre, apellido, fecha_nacimiento, nacionalidad) VALUES ('Mark', 'Twain', '1835-11-30', 'American');
INSERT INTO autor (nombre, apellido, fecha_nacimiento, nacionalidad) VALUES ('Charles', 'Dickens', '1812-02-07', 'British');
INSERT INTO autor (nombre, apellido, fecha_nacimiento, nacionalidad) VALUES ('F Scott', 'Fitzgerald', '1896-09-24', 'American');
INSERT INTO autor (nombre, apellido, fecha_nacimiento, nacionalidad) VALUES ('Leo', 'Tolstoy', '1828-09-09', 'Russian');

-- Inserts para la tabla libro

-- Libros de Gabriel Garcia Marquez (autor_id = 1)
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('Cien años de soledad', 'ISBN001', 1967, 19.99, 1);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('El amor en los tiempos del cólera', 'ISBN002', 1985, 18.50, 1);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('Memoria de mis putas tristes', 'ISBN003', 2004, 22.00, 1);

-- Libros de Isabel Allende (autor_id = 2)
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('La casa de los espíritus', 'ISBN004', 1982, 15.50, 2);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('Eva Luna', 'ISBN005', 1987, 16.75, 2);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('De amor y de sombra', 'ISBN006', 1984, 17.25, 2);

-- Libros de JK Rowling (autor_id = 3)
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('Harry Potter and the Philosopher''s Stone', 'ISBN007', 1997, 25.00, 3);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('Harry Potter and the Chamber of Secrets', 'ISBN008', 1998, 26.50, 3);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('Harry Potter and the Prisoner of Azkaban', 'ISBN009', 1999, 27.75, 3);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('Harry Potter and the Goblet of Fire', 'ISBN010', 2000, 28.00, 3);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('Harry Potter and the Order of the Phoenix', 'ISBN011', 2003, 29.00, 3);

-- Libros de George Orwell (autor_id = 4)
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('1984', 'ISBN012', 1949, 12.00, 4);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('Animal Farm', 'ISBN013', 1945, 10.00, 4);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('Homage to Catalonia', 'ISBN014', 1938, 13.50, 4);

-- Libros de Ernest Hemingway (autor_id = 5)
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('The Old Man and the Sea', 'ISBN015', 1952, 15.00, 5);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('For Whom the Bell Tolls', 'ISBN016', 1940, 16.50, 5);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('A Farewell to Arms', 'ISBN017', 1929, 14.75, 5);

-- Libros de Jane Austen (autor_id = 6)
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('Pride and Prejudice', 'ISBN018', 1813, 11.00, 6);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('Sense and Sensibility', 'ISBN019', 1811, 10.50, 6);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('Emma', 'ISBN020', 1815, 9.50, 6);

-- Libros de Mark Twain (autor_id = 7)
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('The Adventures of Tom Sawyer', 'ISBN021', 1876, 12.75, 7);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('Adventures of Huckleberry Finn', 'ISBN022', 1884, 13.25, 7);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('A Connecticut Yankee in King Arthur''s Court', 'ISBN023', 1889, 14.00, 7);

-- Libros de Charles Dickens (autor_id = 8)
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('Great Expectations', 'ISBN024', 1861, 13.00, 8);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('A Tale of Two Cities', 'ISBN025', 1859, 12.50, 8);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('Oliver Twist', 'ISBN026', 1839, 11.75, 8);

-- Libros de F Scott Fitzgerald (autor_id = 9)
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('The Great Gatsby', 'ISBN027', 1925, 15.00, 9);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('Tender Is the Night', 'ISBN028', 1934, 14.50, 9);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('This Side of Paradise', 'ISBN029', 1920, 13.25, 9);

-- Libros de Leo Tolstoy (autor_id = 10)
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('War and Peace', 'ISBN030', 1869, 20.00, 10);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('Anna Karenina', 'ISBN031', 1877, 18.75, 10);
INSERT INTO libro (titulo, isbn, ano_publicacion, precio, autor_id) VALUES ('The Death of Ivan Ilyich', 'ISBN032', 1886, 16.00, 10);
