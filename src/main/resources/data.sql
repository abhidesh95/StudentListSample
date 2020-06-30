DROP TABLE IF EXISTS students;

CREATE TABLE students (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  city VARCHAR(250) DEFAULT NULL
);

INSERT INTO students (first_name, last_name, city) VALUES
  ('Sachin', 'Pawar', 'Pune'),
  ('Kaushik', 'Patil', 'Mumbai'),
  ('Anup', 'Kumar', 'Delhi');