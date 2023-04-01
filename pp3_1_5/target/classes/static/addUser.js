const tName = document.getElementById('nameAdd')
const tSurname = document.getElementById('surnameAdd')
const tAge = document.getElementById('ageAdd')
const tEmail = document.getElementById('emailAdd')
const tPassword = document.getElementById('passwordAdd')
const tRole = document.getElementById('roleAdd')
const tStatus = document.getElementById('statusAdd')


document.querySelector('#addUser').addEventListener('submit', (e) => { e.preventDefault()
    fetch('http://localhost:8080/admin/save', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            name: tName.value,
            surname: tSurname.value,
            age: tAge.value,
            email: tEmail.value,
            password: tPassword.value,
            role:  tRole.value,
            status: tStatus.value
            })
    }).then(() => location.assign('/admin/'))
})
