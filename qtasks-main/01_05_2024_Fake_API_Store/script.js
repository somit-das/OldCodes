let root = document.querySelector(".root");
let url = fetch("https://fakestoreapi.com/products");
console.log(url);

let obj = url.then((resp)=>{
    return resp.json();
})

console.log(obj);
obj.then((arr)=>{
    arr.map((products)=>{
        // console.log(products.id);
        // console.log(products.title);
        // console.log(products.price);
        let {id,title,price,description,category,image,rating} = products;
        root.innerHTML += `
            <div class=MainContainer>
                <img src=${image} clsss=image>
                <div class=contain>
                    <div class=title> ${title}</div>
                    <div class=id> ${id}</div> 
                    <div class=descript> ${description}</div> 
                    <div class=category> ${category}</div> 
                    
                    <div class=ratingprice>
                        <div class=price><strong>Price</strong>    ₹${Math.trunc(
                          price * 84
                        )}</div> 
                        <div class=rating>
                             <div class=ratingrate>Rate: ${rating.rate}⭐</div>
                             <div class=ratingcount>No :${rating.count}</div>   
                        </div> 
                    </div> 
                </div>
            </div>
            `;
    })
})



/*
   "id": 1,
    "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
    "price": 109.95,
    "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
    "category": "men's clothing",
    "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
    "rating": {
      "rate": 3.9,
      "count": 120
    }
*/
