/**
 * 
 */

function validate() {
	var phone_num = document.getElementById("phone").value.replace(/\D/g,'').trim();
	if (document.getElementById("name1").value.length < 3) {
		alert("First name is too short; please enter at least 3 chars.");
		document.getElementById("name1").focus();
		return false;
	} else if (document.getElementById("name2").value.length < 3) {
		alert("Last name is too short; please enter at least 3 chars.");
		document.getElementById("name2").focus();
		return false;
	} else if (document.getElementById("city").value.length < 4) {
		alert("City is too short; please enter at least 4 chars.");
		document.getElementById("city").focus();
		return false;
	} else if (document.getElementById("city").value[0].toUpperCase() != document.getElementById("city").value[0]) {
		alert("City must start with a capital letter.");
		document.getElementById("city").focus();
		return false;
	} else if (document.getElementById("address").value.length < 5) {
		alert("Address is too short; please enter at least 5 chars.");
		document.getElementById("address").focus();
		return false;
	} else if (document.getElementById("address").value.split(" ").length < 2) {
		alert("Address must have at least 2 parts; it only has one.");
		document.getElementById("address").focus();
		return false;
	} else if (phone_num.length !== 10 || Number(phone_num) != phone_num) {
		alert("Invalid phone number format.");
		document.getElementById("phone").focus();
		return false;
	} else if (!document.getElementById("email").value.includes("@")) {
		alert("Invalid email address ; needs an @ sign.");
		document.getElementById("email").focus();
		return false;
	} else if (!document.getElementById("email").value.includes(".")) {
		alert("Invalid email address ; needs a domain name.");
		document.getElementById("email").focus();
		return false;
	} else {
		return true;
	}
}