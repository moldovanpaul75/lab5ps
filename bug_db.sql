DROP DATABASE IF EXISTS bug;
CREATE DATABASE IF NOT EXISTS bug;
USE bug;

CREATE TABLE IF NOT EXISTS employee(
employeeNo INT NOT NULL AUTO_INCREMENT,
firstName VARCHAR(30) NOT NULL,
lastName VARCHAR(30) NOT NULL,
PRIMARY KEY(employeeNo));
        
CREATE TABLE IF NOT EXISTS product(
productNo INT NOT NULL AUTO_INCREMENT,
productName VARCHAR(30) NOT NULL,
productDetails TEXT,
PRIMARY KEY(productNo));

CREATE TABLE IF NOT EXISTS bug(
bugNo INT NOT NULL AUTO_INCREMENT,
productNo INT NOT NULL,
employeeNo INT NOT NULL,
bugDescription TEXT,
fixDescription TEXT,
dateRaised DATETIME NOT NULL,
dateClosed DATETIME NULL,
FOREIGN KEY (employeeNo) REFERENCES employee(employeeNo),
FOREIGN KEY (productNo) REFERENCES product(productNo),
PRIMARY KEY(bugNo)
);

CREATE TABLE IF NOT EXISTS bug_status(
bugNo INT NOT NULL,
bugStatus VARCHAR(500),
bugPriority VARCHAR(50),
FOREIGN KEY (bugNo) REFERENCES bug(bugNo)
);

CREATE TABLE IF NOT EXISTS bug_comments(
bugNo INT NOT NULL,
employeeNo INT NOT NULL,
comm TEXT,
FOREIGN KEY (bugNo) REFERENCES bug(bugNo),
FOREIGN KEY (employeeNo) REFERENCES employee(employeeNo)
);


CREATE TABLE IF NOT EXISTS tags(
tagNo INT NOT NULL AUTO_INCREMENT,
tagName VARCHAR(50),
tagDescription TEXT,
PRIMARY KEY(tagNo)
);


CREATE TABLE IF NOT EXISTS add_tag(
bugNo INT NOT NULL,
tagNo INT NOT NULL,
FOREIGN KEY (bugNo) REFERENCES bug(bugNo),
FOREIGN KEY (tagNo) REFERENCES tags(tagNo)
);


INSERT INTO bug.product(productName, productDetails) VALUES("product1", "product1"),("product2", "product2");
INSERT INTO bug.employee(firstName, lastName) VALUES("Mircea", "Peia"), ("Paul", "Moldovan");
INSERT INTO bug.tags(tagName, tagDescription) VALUES ("tag1", "tag1"), ("tag2", "tag2");