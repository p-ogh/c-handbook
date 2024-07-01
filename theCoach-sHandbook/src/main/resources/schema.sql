--DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS coach;
DROP TABLE IF EXISTS season;
DROP TABLE IF EXISTS performance_data;
DROP TABLE IF EXISTS exercise;
DROP TABLE IF EXISTS match_session;
DROP TABLE IF EXISTS training_session;
DROP TABLE IF EXISTS practice_session;
DROP TABLE IF EXISTS session_table;
DROP TABLE IF EXISTS athlete;
DROP TABLE IF EXISTS team;








--CREATE DATABASE handbook;
--USE handbook;
--

CREATE TABLE team(
  id uuid PRIMARY KEY,
  name VARCHAR NOT NULL,
  sport VARCHAR NOT NULL,
  status VARCHAR NOT NULL,
  created DATE NOT NULL,
  seasons uuid[]
);

CREATE TABLE coach(
  id uuid PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  team_id uuid NOT NULL,
  age SMALLINT NOT NULL,
  gender VARCHAR(3) NOT NULL,
  role VARCHAR(50) NOT NULL,
  seasons uuid[],
  date_added DATE NOT NULL,
  status VARCHAR(10) NOT NULL,
  years_of_experience SMALLINT NOT NULL,
   FOREIGN KEY (team_id) REFERENCES team(id)
);

CREATE TABLE athlete(
  id uuid PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  team_id uuid NOT NULL,
  age SMALLINT NOT NULL,
  gender VARCHAR(3) NOT NULL,
  role VARCHAR(50) NOT NULL,
  seasons uuid[],
  date_added DATE NOT NULL,
  status VARCHAR(10) NOT NULL,
  jersey_number VARCHAR(50) NOT NULL,
  height DOUBLE PRECISION NOT NULL,
  weight DOUBLE PRECISION NOT NULL,
  availability VARCHAR(10) NOT NULL,
  FOREIGN KEY (team_id) REFERENCES team(id)
);


CREATE TABLE session_table(
  id uuid PRIMARY KEY,
  created DATE NOT NULL,
  team_id uuid NOT NULL,
  notes VARCHAR,
  start TIMESTAMP,
  end_time TIMESTAMP,
  duration INT,
  rating SMALLINT,
  location VARCHAR(50),
  status VARCHAR,
  team_session bool NOT NULL,
  participants uuid[],
  session_type VARCHAR,
  FOREIGN KEY (team_id) REFERENCES team(id)
);



CREATE TABLE season(
  id uuid PRIMARY KEY,
  name VARCHAR NOT NULL,
  team_id uuid NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  status VARCHAR NOT NULL
  );

CREATE TABLE match_session(
  id uuid PRIMARY KEY,
  opponent VARCHAR,
  home bool,
  team_score INT,
  opponent_score INT
);

CREATE TABLE training_session(
  id uuid PRIMARY KEY,
  exercises uuid[]

);

CREATE TABLE practice_session(
  id uuid PRIMARY KEY,
  focus VARCHAR NOT NULL

);


CREATE TABLE exercise(
  id uuid PRIMARY KEY,
  name VARCHAR NOT NULL,
  duration INT,
  reps INT,
  sets INT
);

CREATE TABLE performance_data(
   id uuid PRIMARY KEY,
   created DATE NOT NULL,
   team_id uuid NOT NULL,
   notes VARCHAR,
   session_id uuid NOT NULL,
   session_type VARCHAR,
   athlete_id uuid NOT NULL,
   rating INT NOT NULL,
   FOREIGN KEY (session_id) REFERENCES session_table(id) ON DELETE CASCADE

    )



