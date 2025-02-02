// server.js
const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const mysql = require('mysql2');

const app = express();
const PORT = 3000;

app.use(cors());
app.use(bodyParser.json());

// MySQL connection
const connection = mysql.createConnection({
    host: 'localhost',
    user: 'root', // replace with your MySQL username
    password: 'Likhit@2005', // replace with your MySQL password
    database: 'hospital_management'
});

connection.connect(err => {
    if (err) throw err;
    console.log('Connected to MySQL database.');
});

// Get list of doctors
app.get('/api/doctors', (req, res) => {
    connection.query('SELECT * FROM doctors', (err, results) => {
        if (err) throw err;
        res.json(results);
    });
});

// Book an appointment
app.post('/api/appointments', (req, res) => {
    const { patientName, doctorId, date, time } = req.body;
    const newAppointment = { patient_name: patientName, doctor_id: doctorId, date, time };
    connection.query('INSERT INTO appointments SET ?', newAppointment, (err, results) => {
        if (err) throw err;
        res.status(201).json({ id: results.insertId, ...newAppointment });
    });
});

// Start the server
app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});