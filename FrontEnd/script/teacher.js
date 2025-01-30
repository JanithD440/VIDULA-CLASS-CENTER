document.addEventListener("DOMContentLoaded", function () {
    loadAllTeachers();
    
    document.getElementById("teacherRegistrationForm").addEventListener("submit", function (event) {
        event.preventDefault();
        addTeacher();
    });
});

const API_URL = "http://localhost:8080/api/v2/teacher";

function loadAllTeachers() {
    fetch(API_URL)
        .then(response => response.json())
        .then(data => {
            const tableBody = document.querySelector("#viewModal tbody");
            tableBody.innerHTML = "";
            data.forEach(teacher => {
                const row = `
                    <tr>
                        <td>${teacher.id}</td>
                        <td>${teacher.name}</td>
                        <td>${teacher.address}</td>
                        <td>${teacher.age}</td>
                        <td>${teacher.gender}</td>
                        <td>${teacher.subject}</td>
                        <td>${teacher.contact}</td>
                    </tr>`;
                tableBody.innerHTML += row;
            });
        })
        .catch(error => console.error("Error fetching teachers:", error));
}

function addTeacher() {
    const teacher = {
        id: document.getElementById("teacherID").value,
        name: document.getElementById("teacherName").value,
        address: document.getElementById("teacherAddress").value,
        age: document.getElementById("teacherAge").value,
        gender: document.getElementById("teacherGender").value,
        subject: document.getElementById("teacherSubject").value,
        contact: document.getElementById("teacherContact").value
    };

    fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(teacher)
    })
    .then(response => response.json())
    .then(() => {
        alert("Teacher added successfully!");
        loadAllTeachers();
    })
    .catch(error => console.error("Error adding teacher:", error));
}

function viewTeacherDetails() {
    const teacherID = document.getElementById("viewTeacherID").value.trim();

    if (!teacherID) {
        alert("Please enter a Teacher ID.");
        return;
    }

    fetch(`${API_URL}/${teacherID}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Teacher not found");
            }
            return response.json();
        })
        .then(teacher => {
            // Fill the form fields with retrieved data
            document.getElementById("teacherID").value = teacher.id;
            document.getElementById("teacherName").value = teacher.name;
            document.getElementById("teacherAddress").value = teacher.address;
            document.getElementById("teacherAge").value = teacher.age;
            document.getElementById("teacherGender").value = teacher.gender;
            document.getElementById("teacherSubject").value = teacher.subject;
            document.getElementById("teacherContact").value = teacher.contact;
        })
        .catch(error => {
            console.error("Error fetching teacher details:", error);
            alert("Teacher not found! Please check the ID and try again.");
        });
}

function updateTeacher() {
    const teacherID = document.getElementById("teacherID").value;
    const teacher = {
        name: document.getElementById("teacherName").value,
        address: document.getElementById("teacherAddress").value,
        age: document.getElementById("teacherAge").value,
        gender: document.getElementById("teacherGender").value,
        subject: document.getElementById("teacherSubject").value,
        contact: document.getElementById("teacherContact").value
    };

    fetch(`${API_URL}/${teacherID}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(teacher)
    })
    .then(response => response.json())
    .then(() => {
        alert("Teacher updated successfully!");
        loadAllTeachers();
    })
    .catch(error => console.error("Error updating teacher:", error));
}

function deleteTeacher() {
    const teacherID = document.getElementById("teacherID").value;

    fetch(`${API_URL}/${teacherID}`, { method: "DELETE" })
    .then(() => {
        alert("Teacher deleted successfully!");
        loadAllTeachers();
    })
    .catch(error => console.error("Error deleting teacher:", error));
}
