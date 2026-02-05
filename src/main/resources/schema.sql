CREATE TABLE category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    publication_year INT NOT NULL,
    isbn VARCHAR(255),
    price DECIMAL(10,2) NOT NULL,
    category_id BIGINT,
    FOREIGN KEY (category_id) REFERENCES category(id)
);