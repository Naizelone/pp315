let userId = null

on(document, 'click', '#delete-user', e => {
    const userInfo = e.target.parentNode.parentNode
    document.getElementById('id-del').value = userInfo.children[0].innerHTML
    document.getElementById('name-del').value = userInfo.children[1].innerHTML
    document.getElementById('surname-del').value = userInfo.children[2].innerHTML
    document.getElementById('age-del').value = userInfo.children[3].innerHTML
    document.getElementById('email-del').value = userInfo.children[4].innerHTML
    document.getElementById('role-del').value = userInfo.children[5].innerHTML
    document.getElementById('status-del').value = userInfo.children[6].innerHTML
    userId = userInfo.children[0].innerHTML
    $("#deleteUser").modal("show")
})

document.querySelector('#deleteUser').addEventListener('submit', (e) => { e.preventDefault()
    e.stopPropagation()
    fetch('http://localhost:8080/admin/delete/' + userId, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        }
    }).then()
    $("#deleteUser").modal("hide")
    refresh()
})
