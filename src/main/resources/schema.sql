CREATE TABLE IF NOT EXISTS book_details (
    uuid INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(225),
    description VARCHAR(225),
    price INT,
    author VARCHAR(225),
    genre VARCHAR(225),
    PRIMARY KEY (uuid)
);