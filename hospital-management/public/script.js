// public/script.js
document.addEventListener('DOMContentLoaded', () => {
    const doctorList = document.getElementById('doctor-list');
    const doctorSelect = document.getElementById('doctor-select');
    const appointmentForm = document.getElementById('appointment-form');

    // Fetch doctors from the server
    fetch('http://localhost:3000/api/doctors')
        .then(response => response.json())
        .then(data => {
            data.forEach(doctor => {
                // Create list item for each doctor
                const li = document.createElement('li');
                li.textContent = `${doctor.name} - ${doctor.specialty}`;
                doctorList.appendChild(li);

                // Create option for the select dropdown
                const option = document.createElement('option');
                option.value = doctor.id;
                option.textContent = doctor.name;
                doctorSelect.appendChild(option);
            });
        })
        .catch(error => {
            console.error('Error fetching doctors:', error);
        });

    // Handle appointment form submission
    appointmentForm.addEventListener('submit', (event) => {
        event.preventDefault(); // Prevent the default form submission

        const patientName = document.getElementById('patient-name').value;
        const doctorId = doctorSelect.value;
        const date = document.getElementById('appointment-date').value;
        const time = document.getElementById('appointment-time').value;

        // Create appointment object
        const appointmentData = {
            patientName,
            doctorId,
            date,
            time
        };

        // Send POST request to book an appointment
        fetch('http://localhost:3000/api/appointments', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(appointmentData)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            // Clear the form fields
            appointmentForm.reset();
            alert('Appointment booked successfully!');
            console.log('Appointment data:', data);
        })
        .catch(error => {
            console.error('Error booking appointment:', error);
            alert('Failed to book appointment. Please try again.');
        });
    });
});