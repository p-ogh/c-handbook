--DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS coach;
DROP TABLE IF EXISTS exercise;
DROP TABLE IF EXISTS session_table;
DROP TABLE IF EXISTS athlete;
DROP TABLE IF EXISTS team;



--CREATE DATABASE handbook;
--USE handbook;
--
CREATE TABLE coach(
  id uuid PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  age SMALLINT NOT NULL,
  gender VARCHAR(3) NOT NULL,
  role VARCHAR(50) NOT NULL,
  nationality VARCHAR(50) NOT NULL,
  date_added DATE NOT NULL,
  status VARCHAR(10) NOT NULL,
  years_of_experience SMALLINT NOT NULL);

CREATE TABLE athlete(
  id uuid PRIMARY KEY,
 first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  age SMALLINT NOT NULL,
  gender VARCHAR(3) NOT NULL,
  role VARCHAR(50) NOT NULL,
  nationality VARCHAR(50) NOT NULL,
  date_added DATE NOT NULL,
  status VARCHAR(10) NOT NULL,
  jersey_number VARCHAR(50) NOT NULL,
  height DOUBLE PRECISION NOT NULL,
  weight DOUBLE PRECISION NOT NULL,
  availability VARCHAR(10) NOT NULL
);


CREATE TABLE session_table(
  id uuid PRIMARY KEY,
  athlete_id uuid NOT NULL,
  created DATE NOT NULL,
  notes VARCHAR,
  start_time TIMESTAMP NOT NULL,
  end_time TIMESTAMP NOT NULL,
  duration INT NOT NULL,
  max_heart_rate INT NOT NULL,
  calories_burned INT NOT NULL,
  rating SMALLINT NOT NULL,
  soreness_level SMALLINT NOT NULL,
  location VARCHAR(50) NOT NULL,
  FOREIGN KEY (athlete_id) REFERENCES athlete(id)
);

CREATE TABLE exercise(
  id uuid PRIMARY KEY,
  athlete_id uuid NOT NULL,
  created DATE NOT NULL,
  notes VARCHAR,
  session_id uuid NOT NULL,
  name VARCHAR NOT NULL,
  duration INT NOT NULL,
  reps INT NOT NULL,
  sets INT NOT NULL,
  FOREIGN KEY (athlete_id) REFERENCES athlete(id),
  FOREIGN KEY (session_id) REFERENCES session_table(id)
);

CREATE TABLE team(
  id uuid PRIMARY KEY,
  name VARCHAR NOT NULL,
  sport VARCHAR NOT NULL,
  status VARCHAR NOT NULL,
  created DATE NOT NULL

);

