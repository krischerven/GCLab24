<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/darkly/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<br><br>
<div class="container" style="border: 3px solid white;">
<div class="row">
<div class="col">
<h2>Coffee Shop</h2>
<h3><em>Please fill out the form below to place an order.</em></h3>
<br>
<h4><strong>Product List</strong></h4>
<ol>
	<li>Black Coffee: $2.99
		&thinsp;
		(<a href="#" onclick="addShoppingListItem('Black Coffee', 2.99, 1);">Add 1</a>)
		(<a href="#" onclick="addShoppingListItem('Black Coffee', 2.99, 2);">Add 2</a>)
		(<a href="#" onclick="addShoppingListItem('Black Coffee', 2.99, true);">Add Many</a>)
	</li>
	<li>Cappuccino: $4.99
		&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;
		(<a href="#" onclick="addShoppingListItem('Cappuccino', 4.99, 1);">Add 1</a>)
		(<a href="#" onclick="addShoppingListItem('Cappuccino', 4.99, 2);">Add 2</a>)
		(<a href="#" onclick="addShoppingListItem('Cappuccino', 4.99, true);">Add Many</a>)
	</li>
	<li>Green Tea: $3.99
		&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;
		(<a href="#" onclick="addShoppingListItem('Green Tea', 3.99, 1);">Add 1</a>)
		(<a href="#" onclick="addShoppingListItem('Green Tea', 3.99, 2);">Add 2</a>)
		(<a href="#" onclick="addShoppingListItem('Green Tea', 3.99, true);">Add Many</a>)
	</li>
	<li>Chai Tea: $4.50
		&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;
		(<a href="#" onclick="addShoppingListItem('Chai Tea', 4.50, 1);">Add 1</a>)
		(<a href="#" onclick="addShoppingListItem('Chai Tea', 4.50, 2);">Add 2</a>)
		(<a href="#" onclick="addShoppingListItem('Chai Tea', 4.50, true);">Add Many</a>)
	</li>
	<li>Croissant: $6.50
		&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;
		(<a href="#" onclick="addShoppingListItem('Croissant', 6.50, 1);">Add 1</a>)
		(<a href="#" onclick="addShoppingListItem('Croissant', 6.50, 2);">Add 2</a>)
		(<a href="#" onclick="addShoppingListItem('Croissant', 6.50, true);">Add Many</a>)
	</li>
</ol>
</div>
</div>
<div class="row">
	<div class="col">
		<h4><strong>Customer Info</strong></h4>
		<form>
		First Name:<input type="text" id="name1" name="name1" style="margin-left: 48px" value=""><br>
		Last Name:<input type="text" id="name2" name="name2" style="margin-left: 50px" value=""><br>
		<br>
		<button type="button" class="btn btn-primary" onclick="finishPurchase();" style="color: #B3CBDD; margin-left: 50px">Check Out</button>
		<br>
		</form>
	</div>
	<div class="col">
		<h4><strong>Your Cart</strong></h4>
		<em id="empty_cart">The cart is empty</em>
		<ul id="cart">
		</ul>
	</div>
</div>
<!--${grant}-->
&nbsp;&nbsp;<h5 id="purchase"></h5>
</div>
<script>

let cost = 0
const items = {}
const prices = {}
const amount = {}
const each = {}

function addShoppingListItem(name, price, amt) {

	if (amt === true) {
		amt = parseInt(prompt("Please enter the number", "1"), 10) || 1
	}

	if (!(name in items)) {
		items[name] = 0
	}

	items[name] += amt
	prices[name] = price

	if (items[name] > 1) {
		amount[name] = (" x"+items[name])
	} else {
		amount[name] = ""
	}

	if (items[name] > 1) {
		each[name] = " each"
	} else {
		each[name] = ""
	}

	cost += (price*amt*1.06)
	document.getElementById("empty_cart").innerText = ""
	node = document.getElementById("cart")
	while (node.firstChild) {
	    node.removeChild(node.firstChild)
	}
	for (const key in items) {
		const tmp = document.createElement("li")
		node.appendChild(tmp)
		tmp.innerHTML = key+" x"+items[key]
	}

}

function finishPurchase() {
	if (document.getElementById("name1").value == "") {
		document.getElementById("purchase").style.color = "#C13232"
		document.getElementById("purchase").innerText = "Error: please enter a first name!"
	} else if (document.getElementById("name2").value == "") {
		document.getElementById("purchase").style.color = "#C13232"
		document.getElementById("purchase").innerText = "Error: please enter a last name!"
	} else if (Object.keys(items).length == 0) {
		document.getElementById("purchase").style.color = "#C13232"
		document.getElementById("purchase").innerText = "Error: please select at least one item!"
	} else {
		document.getElementById("purchase").style.color = "inherit"
		document.getElementById("purchase").innerText = "Thank you for your purchase, " + (document.getElementById("name1").value+" "+
			document.getElementById("name2").value)+ ". Your total is $" + cost.toFixed(2) + ":\n"
		for (const name in items) {
			document.getElementById("purchase").innerText += ("\n"+name+amount[name]+": " + "$"+prices[name].toFixed(2) + each[name])
		}
		document.getElementById("purchase").innerText += "\nSales Tax: +6%"
	}
}

</script>
</body>
<footer>
${footer}
</footer>
</html>