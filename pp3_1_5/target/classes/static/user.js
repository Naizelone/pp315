fetch('http://localhost:8080/user/api')
    .then(res => res.json())
    .then(data => {
        document.querySelector('#userInfo').innerHTML = `
                               <td>${data.id}</td>
                               <td>${data.name}</td>
                               <td>${data.surname}</td>
                               <td>${data.age}</td>
                               <td>${data.email}</td>
                               <td>${data.role}</td>`
    }
)
