-- database.sql
CREATE DATABASE hospital_management;

USE hospital_management;

CREATE TABLE doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    specialty VARCHAR(100) NOT NULL
);

CREATE TABLE appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_name VARCHAR(100) NOT NULL,
    doctor_id INT,
    date DATE NOT NULL,
    time TIME NOT NULL,
    FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);

-- Insert sample data
INSERT INTO doctors (name, specialty) VALUES
('Dr. John Doe', 'Cardiology'),
('Dr. Jane Smith', 'Neurology');