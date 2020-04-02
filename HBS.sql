CREATE SCHEMA `hotelbookingsystem` ;
CREATE TABLE `hotelbookingsystem`.`rooms` (
  `room_type` VARCHAR(45) NOT NULL,
  `roomID` INT(11) NOT NULL,
  `noofrooms` INT(11) NULL,
  `capacity` INT(11) NULL,
  PRIMARY KEY (`room_type`));
Insert into hotelbookingsystem.rooms values ('ST','1','1','1');
Insert into hotelbookingsystem.rooms values ('DT','2','1','1');
Insert into hotelbookingsystem.rooms values ('LT','3','1','1');
  CREATE TABLE `hotelbookingsystem`.`details` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `mobile` VARCHAR(45) NULL,
  PRIMARY KEY (`username`));
  CREATE TABLE `hotelbookingsystem`.`reservations` (
  `username` VARCHAR(45) NOT NULL,
  `roomtype` VARCHAR(45) NOT NULL,
  `noofguests` INT(11) NOT NULL,
  `arrivaldate` DATE NULL,
  `departuredate` DATE NULL,
FOREIGN KEY (username) REFERENCES details(username));
CREATE TABLE `hotelbookingsystem`.`admin_cred` (
  `admin_username` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  `admin_password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`admin_username`));
Insert into hotelbookingsystem.admin_cred Values ('admin','adminname','admin');