// Sample data for hospitals
const hospitals = [
    { name: "City Hospital", city: "New York", contact: "123-456-7890" },
    { name: "Green Valley Clinic", city: "Los Angeles", contact: "987-654-3210" },
    { name: "Ocean View Medical", city: "Miami", contact: "456-789-1234" },
    { name: "Mountain Care Center", city: "Denver", contact: "321-654-9870" },
    { name: "Sunrise Hospital", city: "San Francisco", contact: "555-555-5555" },
];

// Populate the hospital list
const hospitalList = document.getElementById("hospitalList");

function displayHospitals(data) {
    hospitalList.innerHTML = ""; // Clear existing data
    data.forEach(hospital => {
        const hospitalCard = document.createElement("div");
        hospitalCard.className = "hospitalCard";
        hospitalCard.innerHTML = `
            <h2>${hospital.name}</h2>
            <p>${hospital.city}</p>
            <p class="contact">${hospital.contact}</p>
        `;
        hospitalList.appendChild(hospitalCard);
    });
}

// Filter hospitals based on search input
function filterHospitals() {
    const query = document.getElementById("searchBar").value.toLowerCase();
    const filteredHospitals = hospitals.filter(hospital =>
        hospital.name.toLowerCase().includes(query) || 
        hospital.city.toLowerCase().includes(query)
    );
    displayHospitals(filteredHospitals);
}

// Initial display of hospitals
displayHospitals(hospitals);
