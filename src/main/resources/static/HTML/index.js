//Backend Controller CRUD URLs
const allWarehousesURL = 'http://localhost:8282/warehouses'
const allProductsURL = 'http://localhost:8282/products';

//Warehouse and product lists to return
let allWarehouses = []
let allProducts = []

//LISTENER called on index page load/reload, loads all warehouses AND products
document.addEventListener('DOMContentLoaded', ()=>{
    
    let warehousesXhr = new XMLHttpRequest()
    let productsXhr = new XMLHttpRequest()

    //Load warehouses into table
    warehousesXhr.onreadystatechange = () =>{
        if (warehousesXhr.readyState === 4){
        let warehouses = JSON.parse(warehousesXhr.responseText)

        warehouses.forEach(newWarehouse => {
            addWarehouseToTable(newWarehouse)
        });
         }
    }

    warehousesXhr.open('GET', allWarehousesURL)
    warehousesXhr.send()


    //Load products into table
    productsXhr.onreadystatechange = () =>{
        if (productsXhr.readyState === 4){
        let products = JSON.parse(productsXhr.responseText)

        products.forEach(newProduct => {
            addProductToTable(newProduct)
        });
         }
    }

    productsXhr.open('GET', allProductsURL)
    productsXhr.send()
})


//FUNCTION to add each warehouse to warehouses table
function addWarehouseToTable(newWarehouse){
    let tr = document.createElement ('tr')
    let name = document.createElement ('td')
    let location = document.createElement ('td')
    let capacity = document.createElement ('td')
    let saveBtn = document.createElement ('td')
    let deleteBtn = document.createElement ('td')

    name.innerText = newWarehouse.name
    location.innerText = newWarehouse.location
    capacity.innerText = newWarehouse.maxCapacity
    saveBtn.innerHTML = `<button class="btn btn-info" id="warehouse-edit-button" onclick="activateWarehouseEdit(${newWarehouse.warehouseId})"> EDIT </button>`
    deleteBtn.innerHTML = `<button class="btn btn-danger" id="warehouse-delete-button" onclick="activateWarehouseDelete(${newWarehouse.warehouseId})"> DELETE </button>`

    tr.appendChild(name)
    tr.appendChild(location)
    tr.appendChild(capacity)
    tr.appendChild(saveBtn)
    tr.appendChild(deleteBtn)

    document.getElementById('warehouses-table-body').appendChild(tr)

    allWarehouses.push(newWarehouse)
}

//FUNCTION to add each product to products table
function addProductToTable(newProduct){
    let tr = document.createElement ('tr')
    let name = document.createElement ('td')
    let sku = document.createElement ('td')
    let quantity = document.createElement ('td')
    let description = document.createElement ('td')
    let editBtn = document.createElement ('td')
    let deleteBtn = document.createElement ('td')

    name.innerText = newProduct.name
    sku.innerText = newProduct.sku
    quantity.innerText = newProduct.quantity
    description.innerText = newProduct.description
    editBtn.innerHTML = `<button class="btn btn-info" id="product-edit-button" onclick="activateProductEdit(${newProduct.productId}, this)"> EDIT </button>`
    deleteBtn.innerHTML = `<button class="btn btn-danger" id="product-delete-button" onclick="activateProductDelete(${newProduct.productId}, this)"> DELETE </button>`

    tr.appendChild(name)
    tr.appendChild(sku)
    tr.appendChild(quantity)
    tr.appendChild(description)
    tr.appendChild(editBtn)
    tr.appendChild(deleteBtn)

    document.getElementById('products-table-body').appendChild(tr)

    allProducts.push(newProduct)
}


function activateWarehouseEdit(){

}

function activateProductEdit(){

}


//DELETE button function for warehouse
function activateWarehouseDelete(WarehouseId){

}

//DELETE button function for product
function activateProductDelete(productId, button) {
    if (!confirm("Are you sure you want to delete this product?")) {
        return;
    }
        
    fetch(`http://localhost:8282/products/delete/${productId}`, {
        method: 'DELETE'
    })

    .then(response => {
        if (response.ok) {
            const row = button.closest('tr');
            row.remove();
            allProducts = allProducts.filter(p => p.productId !== productId);
        } else {
            alert("Failed to delete the product.");
        }
    })

    .catch(error => {
        console.error("Error deleting product:", error);
        alert("An error occurred while deleting the product.");
    });
}



