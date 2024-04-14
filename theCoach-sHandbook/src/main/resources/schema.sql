DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS coach;
DROP TABLE IF EXISTS athlete;


--CREATE DATABASE handbook;
--USE handbook;
--
CREATE TABLE coach (
  id binary(16) PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  age SMALLINT(6) NOT NULL,
  gender VARCHAR(3) NOT NULL,
  role VARCHAR(50) NOT NULL,
  nationality VARCHAR(50) NOT NULL,
  date_added date NOT NULL,
  status VARCHAR(10) NOT NULL,
  years_of_experience SMALLINT(6) NOT NULL

);
CREATE TABLE athlete (
 first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  age SMALLINT(6) NOT NULL,
  gender VARCHAR(3) NOT NULL,
  role VARCHAR(50) NOT NULL,
  nationality VARCHAR(50) NOT NULL,
  date_added date NOT NULL,
  status VARCHAR(10) NOT NULL,
  sport VARCHAR(50) NOT NULL,
  jersey_number VARCHAR(50) NOT NULL,
  height DOUBLE(5,2) NOT NULL,
  weight DOUBLE(5,2) NOT NULL,
  availability VARCHAR(10) NOT NULL
);

