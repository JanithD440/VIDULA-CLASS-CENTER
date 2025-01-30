document.addEventListener("DOMContentLoaded", function () {
    loadAllStudents();

    document.getElementById("registrationForm").addEventListener("submit", function (event) {
        event.preventDefault();
        addStudent();
    });
});

const API_URL = "http://localhost:8080/api/v2/student"; // Update API URL if needed

// Load all students
function loadAllStudents() {
    fetch(API_URL)
        .then(response => response.json())
        .then(data => {
            const tableBody = document.querySelector("#viewModal tbody");
            tableBody.innerHTML = "";
            data.forEach(student => {
                const row = `
                    <tr>
                        <td>${student.studentID}</td>
                        <td>${student.studentName}</td>
                        <td>${student.studentAddress}</td>
                        <td>${student.gender}</td>
                        <td>${student.subject}</td>
                        <td>${student.grade}</td>
                    </tr>`;
                tableBody.innerHTML += row;
            });
        })
        .catch(error => console.error("Error fetching students:", error));
}

// Add a new student
function addStudent() {
    const student = {
        studentID: document.getElementById("studentID").value,
        studentName: document.getElementById("studentName").value,
        studentAddress: document.getElementById("studentAddress").value,
        gender: document.getElementById("studentGender").value,
        subject: document.getElementById("studentSubject").value,
        grade: document.getElementById("studentGrade").value
    };

    fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(student)
    })
    .then(response => response.json())
    .then(() => {
        alert("Student added successfully!");
        loadAllStudents();
    })
    .catch(error => console.error("Error adding student:", error));
}

// View student details by ID
function viewStudentDetails() {
    const studentID = document.getElementById("searchStudent").value.trim();

    if (!studentID) {
        alert("Please enter a Student ID.");
        return;
    }

    fetch(`${API_URL}/${studentID}`)
        .then(response => {
            if (!response.ok) throw new Error("Student not found");
            return response.json();
        })
        .then(student => {
            document.getElementById("studentID").value = student.studentID;
            document.getElementById("studentName").value = student.studentName;
            document.getElementById("studentAddress").value = student.studentAddress;
            document.getElementById("studentGender").value = student.gender;
            document.getElementById("studentSubject").value = student.subject;
            document.getElementById("studentGrade").value = student.grade;
        })
        .catch(error => {
            console.error("Error fetching student details:", error);
            alert("Student not found! Please check the ID and try again.");
        });
}

// Update student details
function updateStudent() {
    const studentID = document.getElementById("studentID").value;
    const student = {
        studentName: document.getElementById("studentName").value,
        studentAddress: document.getElementById("studentAddress").value,
        gender: document.getElementById("studentGender").value,
        subject: document.getElementById("studentSubject").value,
        grade: document.getElementById("studentGrade").value
    };

    fetch(`${API_URL}/${studentID}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(student)
    })
    .then(response => response.json())
    .then(() => {
        alert("Student updated successfully!");
        loadAllStudents();
    })
    .catch(error => console.error("Error updating student:", error));
}

// Delete student by ID
function deleteStudent() {
    const studentID = document.getElementById("studentID").value;

    fetch(`${API_URL}/${studentID}`, { method: "DELETE" })
    .then(() => {
        alert("Student deleted successfully!");
        loadAllStudents();
    })
    .catch(error => console.error("Error deleting student:", error));
}
