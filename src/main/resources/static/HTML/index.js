const url = 'http://localhost:8282/warehouses';

let allWarehouses = []

//LISTENER called on index page load
document.addEventListener('DOMContentLoaded', ()=>{
    
    let xhr = new XMLHttpRequest()

    xhr.onreadystatechange = () =>{
    
        if (xhr.readyState === 4){
        let warehouses = JSON.parse(xhr.responseText)

        warehouses.forEach(newWarehouse => {
            addMovieToTable(newWarehouse)
        });
         }
    
    }

    xhr.open('GET', url)
    xhr.send()


})


//FUNCTION to add each movie to warehouses table
function addMovieToTable(newWarehouse){
    let tr = document.createElement ('tr')
    let id = document.createElement ('td')
    let name = document.createElement ('td')
    let location = document.createElement ('td')
    let capacity = document.createElement ('td')
    let saveBtn = document.createElement ('td')
    let deleteBtn = document.createElement ('td')

    id.innerText = newWarehouse.id
    name.innerText = newWarehouse.name
    location.innerText = newWarehouse.location
    capacity.innerText = newWarehouse.maxCapacity
    saveBtn.innerHTML = `<button class="btn btn-info" id="edit-button" onclick="activateEditModal(${newWarehouse.id})"> EDIT </button>`
    deleteBtn.innerHTML = `<button class="btn btn-danger" id="delete-button" onclick="activateDeleteModal(${newWarehouse.id})"> DELETE </button>`

    tr.appendChild(id)
    tr.appendChild(name)
    tr.appendChild(location)
    tr.appendChild(capacity)
    tr.appendChild(saveBtn)
    tr.appendChild(deleteBtn)

    document.getElementById('warehouses-table-body').appendChild(tr)

    allWarehouses.push(newWarehouse)

}

//EDIT and DELETE button functions once activated
function activateEditModal(WarehouseId){

}

function activateDeleteModal(WarehouseId){

}