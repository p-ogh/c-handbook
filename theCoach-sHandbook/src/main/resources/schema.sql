DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS coach;
DROP TABLE IF EXISTS run_session;
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
  id binary(16) PRIMARY KEY,
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

CREATE TABLE run_session (
  id binary(16) PRIMARY KEY,
  athlete_id binary(16) NOT NULL,
  created date NOT NULL,
  scheduled_date_time date NOT NULL,
  actual_date_time date NOT NULL,
  duration_minutes int(10) NOT NULL,
  calories_burned int(10) NOT NULL,
  intensity_level VARCHAR(6) NOT NULL,
  max_heart_rate int(3) NOT NULL,
  training_focus VARCHAR(50) NOT NULL,
  perceived_effort int(3) NOT NULL,
  session_rating int NOT NULL,
  soreness_level int(3) NOT NULL,
  completed TINYINT NOT NULL,
  location VARCHAR(50) NOT NULL,
  session_notes VARCHAR(100) NOT NULL,
  distance_kms int(3) NOT NULL,
  equipment_used VARCHAR(10) NOT NULL,
  km_per_lap int(3) NOT NULL,
  laps_completed int(3) NOT NULL,
  avg_speed DOUBLE(3,2) NOT NULL,
  FOREIGN KEY (athlete_id) REFERENCES athlete(id)
);

