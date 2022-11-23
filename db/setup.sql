CREATE DATABASE memorygame;

USE memorygame;

CREATE TABLE accounts (
    account_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    player_name VARCHAR(15) UNIQUE NOT NULL,
    password VARCHAR(72) NOT NULL,
    date_of_birth DATE NOT NULL
);

CREATE TABLE scores (
    score_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    score INTEGER NOT NULL,
    account_id INTEGER,
    FOREIGN KEY(account_id) REFERENCES accounts(account_id)
);
