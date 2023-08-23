
-- Make the DB
CREATE DATABASE UserBooks; 
USE UserBooks; 

-- The Table for the Users. 
CREATE TABLE `Users`(
    `ID` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `User Email` VARCHAR(255) NOT NULL,
    `User Name` VARCHAR(255) NOT NULL,
    `Name` LONGTEXT NOT NULL,
    `Password` VARCHAR(255) NOT NULL
);

-- Make sure the User Email and User Name are unique
ALTER TABLE
    `Users` ADD UNIQUE `users_user email_unique`(`User Email`);
ALTER TABLE
    `Users` ADD UNIQUE `users_user name_unique`(`User Name`);

-- The Table for the Books
CREATE TABLE `Books`(
    `Author Name` LONGTEXT NOT NULL,
    `Book Title` LONGTEXT NOT NULL,
    `Page Count` BIGINT NOT NULL,
    `Times Read` BIGINT NOT NULL,
    `ID` BIGINT NOT NULL
);

-- The User's ID field will reference 1 or more books. 
ALTER TABLE
    `Books` ADD CONSTRAINT `books_id_foreign` FOREIGN KEY(`ID`) REFERENCES `Users`(`ID`);
