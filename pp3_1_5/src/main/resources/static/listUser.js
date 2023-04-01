const on = (element, event, selector, handler) => {
    element.addEventListener(event, e => {
        if (e.target.closest(selector)) {
            handler(e)
        }
    })
}

let temp = ''
function getAllUsers() {
    fetch('http://localhost:8080/admin/userList')
        .then((response) => response.json())
        .then((users) => {
            users.forEach(user => {
                temp += `
                  <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.surname}</td>
                        <td>${user.age}</td>
                        <td>${user.email}</td>
                        <td hidden>${user.password}</td>
                        <td>${user.role}</td>

                        <td>
                            <button type="button" data-userid="${user.id}" data-action="edit" class="btn btn-sm btn-success"
                            data-toggle="modal" data-target="modal" id="edit-user" data-id="${user.id}">Edit</button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-sm btn-danger" id="delete-user" data-action="delete"
                            data-id="${user.id}" data-target="modal">Delete</button>
                        </td>
                  </tr>
                `;
            })
            document.querySelector('#userList').innerHTML = temp
        })
    temp=''
}

function refresh() {
    let table = document.querySelector('#userList')
    while (table.rows.length > 0) {
        table.deleteRow(0)
    }
    setTimeout(getAllUsers, 100);

}
refresh()