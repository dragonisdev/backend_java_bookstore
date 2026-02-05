-- Insert sample categories
INSERT INTO category (name) VALUES ('Sci-fi');
INSERT INTO category (name) VALUES ('Thriller');
INSERT INTO category (name) VALUES ('Horror');

-- Insert sample books
INSERT INTO book (title, author, publication_year, isbn, price, category_id) VALUES
('The Great Gatsby', 'F. Scott Fitzgerald', 1925, '978-0-7432-7356-5', 10.99, 1),
('To Kill a Mockingbird', 'Harper Lee', 1960, '978-0-06-112008-4', 12.99, 1),
('Sapiens', 'Yuval Noah Harari', 2011, '978-0-06-231609-7', 15.99, 2),
('Dune', 'Frank Herbert', 1965, '978-0-441-17271-9', 14.99, 3);