-- Created the User Table for the DB.
CREATE TABLE IF NOT EXISTS Users (
	UserID INT AUTO_INCREMENT NOT NULL,
	Email VARCHAR(255) NOT NULL UNIQUE, 
	Name TEXT NOT NULL, 
	UName VARCHAR(255) NOT NULL, 
	Pass TEXT NOT NULL,
	PRIMARY KEY(UserID)

); 

-- Created the Books Table for the DB. 
CREATE TABLE IF NOT EXISTS Books(
	OwnerID INT DEFAULT 0,
	Author TEXT NOT NULL, 
	Title  TEXT NOT NULL, 
	PageCt  INT NOT NULL,
	Times   INT NOT NULL, 
	
	-- This key relates the Users to the books that they own. 
	CONSTRAINT 
		FOREIGN KEY (OwnerID) REFERENCES Users(UserID) 
		ON DELETE CASCADE

); 


INSERT INTO Books(Author, Title, PageCt, Times)
VALUES (
	'Plato', 
	'The Republic', 
	350,
	2
); 
