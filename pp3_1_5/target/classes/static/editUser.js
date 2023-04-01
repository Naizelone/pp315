on(document, 'click', '#edit-user', e => {
    const userInfo = e.target.parentNode.parentNode
    document.querySelector('#idEdit').value = userInfo.children[0].innerHTML
    document.getElementById('nameEdit').value = userInfo.children[1].innerHTML
    document.getElementById('surnameEdit').value = userInfo.children[2].innerHTML
    document.getElementById('ageEdit').value = userInfo.children[3].innerHTML
    document.getElementById('emailEdit').value = userInfo.children[4].innerHTML
    document.getElementById('passwordEdit').value = userInfo.children[5].innerHTML
    document.getElementById('roleEdit').value = userInfo.children[6].innerHTML
    document.getElementById('statusEdit').value = userInfo.children[7].innerHTML
    $('#editUser').modal('show')
})

document.querySelector('#editUser').addEventListener('submit', e => { e.preventDefault()
    fetch('http://localhost:8080/admin/edit', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            id: document.getElementById('idEdit').value,
            name: document.getElementById('nameEdit').value,
            surname: document.getElementById('surnameEdit').value,
            email: document.getElementById('emailEdit').value,
            age: document.getElementById('ageEdit').value,
            password: document.getElementById('passwordEdit').value,
            role: document.getElementById('roleEdit').value,
            status: document.getElementById('statusEdit').value})
    }).then()
    $('#editUser').modal('hide')
    refresh()
})