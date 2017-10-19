var searchMethod="";
var myUsers = new Array();


function signin() {
	var user = {};
	user.userName = document.getElementById("signInUsername").value;
	user.password = document.getElementById("signInPassword").value;
	document.getElementById("signInUsername").value = "";
	document.getElementById("signInPassword").value = "";
	var userJson = JSON.stringify(user);
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			temp = JSON.parse(this.responseText);
			sessionStorage.userName = temp.userName;
			sessionStorage.password=temp.password;
			window.location.href = "userpage.html";
		} else if (this.readyState == 4 && this.status == 403) {
			alert("Username or Password Wrong");
		}
	};
	xhttp.open("POST", "http://localhost:85/PhoneBook/api/user/items/signin", true);
	
	xhttp.setRequestHeader('Content-type', 'application/json');
	xhttp.send(userJson);
}


function signup() {
	var user = {};
	user.userName = document.getElementById("signUpUsername").value;
	user.password = document.getElementById("signUpPassword").value;
	document.getElementById("signUpUsername").value = "";
	document.getElementById("signUpPassword").value = "";
	var userJson = JSON.stringify(user);
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 204) {
			alert("Done!");
		} else if (this.readyState == 4 && this.status == 403) {
			alert("Choose Another UserName");
		}
	};
	xhttp.open("POST", "http://localhost:85/PhoneBook/api/user/items/signup", true);
	xhttp.setRequestHeader('Content-type', 'application/json');
	xhttp.send(userJson);
}




function check() {
	if (sessionStorage.userName === null || sessionStorage.getItem("userName") === null) {
		console.log(sessionStorage.userName);
		window.location.href = ("index.html");
	}
}


function initPage() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var user = JSON.parse(this.responseText);
			for (var feature of user.role.features) {
				if (feature.feature != "editRoles") {
					document.getElementById("controls").innerHTML += "<button type='button' class='btn btn-default' onclick=\"" + feature.feature + "()\">" + feature.feature + "</button>";
					} 
				}
			document.getElementById("controls").innerHTML +="<button class='btn btn-danger' onclick='signout()'>signOut</button>"
		} else if (this.readyState == 4 && this.status == 403) {
			window.location.href = ("index.html");
		}
	};
	xhttp.open("GET", "http://localhost:85/PhoneBook/api/user/items/" + sessionStorage.getItem("userName"), true);
	xhttp.withCredentials = true;
	console.log(sessionStorage.getItem("userName"));
	xhttp.setRequestHeader('Authorization', make_base_auth(sessionStorage.getItem("userName"), sessionStorage.getItem("password")));
	xhttp.send();
}


function make_base_auth(user, password) {
  var tok = user + ':' + password;
  var hash = btoa(tok);
  return "Basic " + hash;
}


function createContacts() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("view").innerHTML = this.responseText;
			document.getElementById("elements").innerHTML = "";
		}
	};
	xhttp.open("GET", "createcontact.html", true);
	xhttp.send();

}

function getContactSearchBar(){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("view").innerHTML = this.responseText;
		}
	};
	xhttp.open("GET", "contactsearchbar.html", true);
	
	xhttp.send();
}


function seeContacts() {
	document.getElementById("elements").innerHTML = "";
	searchMethod="simple";
	getContactSearchBar();
}



function getAllContacts() {
	document.getElementById("elements").innerHTML = "";
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var contacts = JSON.parse(this.responseText);
			for (var i = 1; i <= contacts.length; i++) {
				document.getElementById("elements").innerHTML += "<div class='form-group row'><div class='col-md-2'><label class='form-control'>" + contacts[i - 1].firstName + "</label></div><div class='col-md-2'><label class='form-control'>" + contacts[i - 1].lastName + "</label></div><div class='col-md-3'><label class='form-control'>" + contacts[i - 1].email + "</label></div><div class='col-md-2'><label class='form-control'>" + contacts[i - 1].mobileNumber + "</label></div><div class='col-md-2'><label class='form-control'>" + contacts[i - 1].homeNumber + "</label></div></div>";
			}
		}
	};
	xhttp.open("GET", "http://localhost:85/PhoneBook/api/contact/items/", true);
	xhttp.withCredentials = true;
	xhttp.setRequestHeader("Authorization", 'Basic ' + btoa(sessionStorage.getItem("userName")+":"+sessionStorage.getItem("password")));
	xhttp.send();
}

function editContacts() {
	document.getElementById("elements").innerHTML = "";
	searchMethod="editable";
	getContactSearchBar();
}

function editableSearchContacts(){
	document.getElementById("elements").innerHTML = "";
	console.log("editable search called");
	var str = "fname=" + document.getElementById("fname").value;
	str += "&lname=" + document.getElementById("lname").value;
	str += "&email=" + document.getElementById("email").value;
	str += "&mnumber=" + document.getElementById("mnumber").value;
	str += "&hnumber=" + document.getElementById("hnumber").value;
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var contacts = JSON.parse(this.responseText);
			for (var i = 0; i < contacts.length; i++) {

				document.getElementById("elements").innerHTML += "" +

					"<div class='form-group row'>" +
					"<div class='col-md-1'>" +
					"<Label name='contactId' class='form-control'  >" + contacts[i].id + "</label>" +
					"</div>" +
					"<div class='col-md-1'>" +
					"<Input type='text' placeholder='First Name' name='contactFirst' class='form-control' value='" + contacts[i].firstName + "'>" +
					"</div>" +
					"<div class='col-md-1'>" +
					"<Input type='text' placeholder='Last Name' name='contactLast' class='form-control' value='" + contacts[i].lastName + "'>" +
					"</div>" +
					"<div class='col-md-2'>" +
					"<Input type='email' placeholder='Email' name='contactMail' class='form-control' value='" + contacts[i].email + "'>" +
					"</div>" +
					"<div class='col-md-2'>" +
					"<Input type='text' placeholder='Mobile Number' name='contactMnumber' class='form-control' value='" + contacts[i].mobileNumber + "'>" +
					"</div>" +
					"<div class='col-md-2'>" +
					"<Input type='text' placeholder='Home Number' name='contactHnumber' class='form-control' value='" + contacts[i].homeNumber + "'>" +
					"</div>" +
					"<div class='col-md-2'>" +
					"<button class='btn btn-danger' onclick=\"deleteContact('" + (i) + "')\"+>Delete</button>" +
					"<button class='btn btn-info' onclick=\"updateContact(" + (i) + ")\"+>Update</button>" +
					"</div>" +
					"</div>";

			}
		}
	};
	xhttp.open("GET", "http://localhost:85/PhoneBook/api/contact/items/search?"+str, true);
	xhttp.withCredentials = true;
	xhttp.setRequestHeader("Authorization", 'Basic ' + btoa(sessionStorage.getItem("userName")+":"+sessionStorage.getItem("password")));
	xhttp.send();
}


function simpleSearchContacts(){
	document.getElementById("elements").innerHTML = "";
	console.log("simple search called");
	var str = "fname=" + document.getElementById("fname").value;
	str += "&lname=" + document.getElementById("lname").value;
	str += "&email=" + document.getElementById("email").value;
	str += "&mnumber=" + document.getElementById("mnumber").value;
	str += "&hnumber=" + document.getElementById("hnumber").value;

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var contacts = JSON.parse(this.responseText);
			for (var i = 1; i <= contacts.length; i++) {

				document.getElementById("elements").innerHTML += "<div class='form-group row'><div class='col-md-2'><label class='form-control'>" + contacts[i - 1].firstName + "</label></div><div class='col-md-2'><label class='form-control'>" + contacts[i - 1].lastName + "</label></div><div class='col-md-3'><label class='form-control'>" + contacts[i - 1].email + "</label></div><div class='col-md-2'><label class='form-control'>" + contacts[i - 1].mobileNumber + "</label></div><div class='col-md-2'><label class='form-control'>" + contacts[i - 1].homeNumber + "</label></div></div>";
			}
		}
	};
	xhttp.open("GET", "http://localhost:85/PhoneBook/api/contact/items/search?" + str, true);
	xhttp.withCredentials = true;
	xhttp.setRequestHeader("Authorization", 'Basic ' + btoa(sessionStorage.getItem("userName")+":"+sessionStorage.getItem("password")));
	xhttp.send();
}



function searchContacts(i) {
	if(searchMethod=="simple"){
		simpleSearchContacts();
	}
	if(searchMethod=="editable"){
		editableSearchContacts();
	}
}



function searchUsers() {
	myUsers.splice(0, myUsers.length);
	document.getElementById("elements").innerHTML = "";
	console.log("search called");
	var str = "uName=" + document.getElementById("uName").value;
	str += "&roleName=" + document.getElementById("roleName").value;

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var users = JSON.parse(this.responseText);
			for (var i = 1; i <= users.length; i++) {

				myUsers.push(users[i - 1]);
				document.getElementById("elements").innerHTML += "" +

					"<div class='form-group row'>" +
					"<div class='col-md-6'>" +
					"<label class='form-control'>" + users[i - 1].userName + "</label>" +
					"</div>" +
					"<div class='col-md-2'>" +
					"<Input type='text' name='role' class='form-control' value='" + users[i - 1].role.name + "'>" +
					"</div>" +
					"<div class='col-md-2'>" +
					"<button class='btn btn-danger' onclick=\"deleteUser('" + users[i - 1].userName + "')\"+>Delete</button>" +
					"<button class='btn btn-info' onclick=\"updateUser(" + (i - 1) + ")\"+>Update</button>" +
					"</div>" +
					"</div>";

			}
		}
	};
	xhttp.open("GET", "http://localhost:85/PhoneBook/api/user/items/search?" + str, true);
	xhttp.withCredentials = true;
	xhttp.setRequestHeader("Authorization", 'Basic ' + btoa(sessionStorage.getItem("userName")+":"+sessionStorage.getItem("password")));
	xhttp.send();
}


function signout() {
	sessionStorage.removeItem("userName");
	window.location.href = ("index.html");
}

function clearContactInputs() {
	document.getElementById("fname").value = "";
	document.getElementById("lname").value = "";
	document.getElementById("email").value = "";
	document.getElementById("mnumber").value = "";
	document.getElementById("hnumber").value = "";
}

function clearUserInputs() {
	document.getElementById("uName").value = "";
	document.getElementById("roleName").value = "";

}

function addContact() {
	var contact = {};
	contact.firstName = document.getElementById("fname").value;
	contact.lastName = document.getElementById("lname").value;
	contact.email = document.getElementById("email").value;
	contact.mobileNumber = document.getElementById("mnumber").value;
	contact.homeNumber = document.getElementById("hnumber").value;
	document.getElementById("fname").value="";
	document.getElementById("lname").value="";
	document.getElementById("email").value="";
	document.getElementById("mnumber").value="";
	document.getElementById("hnumber").value="";

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 204) {
			getAllContacts();
		}
	};
	xhttp.open("POST", "http://localhost:85/PhoneBook/api/contact/items/", true);
	xhttp.setRequestHeader('Content-type', 'application/json');
	xhttp.withCredentials = true;
	xhttp.setRequestHeader("Authorization", 'Basic ' + btoa(sessionStorage.getItem("userName")+":"+sessionStorage.getItem("password")));
	xhttp.send(JSON.stringify(contact));


}




function editUsers() {
	getAllUsers();
	console.log("function called");
	document.getElementById("view").innerHTML = "";
	document.getElementById("elements").innerHTML = "";
	var xhttp1 = new XMLHttpRequest();
	xhttp1.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			
			document.getElementById("view").innerHTML=this.responseText;

			}
		
	};
	xhttp1.open("GET", "usersearchbar.html", true);
	xhttp1.send();
	
	
}

function getAllUsers(){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var users = JSON.parse(this.responseText);
			for (var i = 1; i <= users.length; i++) {

				myUsers.push(users[i - 1]);
				document.getElementById("elements").innerHTML += "" +

					"<div class='form-group row'>" +
					"<div class='col-md-6'>" +
					"<label class='form-control'>" + users[i - 1].userName + "</label>" +
					"</div>" +
					"<div class='col-md-2'>" +
					"<Input type='text' name='role' class='form-control' value='" + users[i - 1].role.name + "'>" +
					"</div>" +
					"<div class='col-md-2'>" +
					"<button class='btn btn-danger' onclick=\"deleteUser('" + users[i - 1].userName + "')\"+>Delete</button>" +
					"<button class='btn btn-info' onclick=\"updateUser(" + (i - 1) + ")\"+>Update</button>" +
					"</div>" +
					"</div>";

			}
		}
	};
	xhttp.open("GET", "http://localhost:85/PhoneBook/api/user/items/", true);
	xhttp.withCredentials = true;
	xhttp.setRequestHeader("Authorization", 'Basic ' + btoa(sessionStorage.getItem("userName")+":"+sessionStorage.getItem("password")));
	xhttp.send();
}


function deleteUser(user) {
	alert(user);
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 204) {
			myUsers.splice(0, myUsers.length - 1);
			alert("User deleted");
			editUsers();

		} else if (this.readyState == 4 && this.status == 403) {
			alert("cant be deleted");
		}
	};
	xhttp.open("DELETE", "http://localhost:85/PhoneBook/api/user/items/" + user, true);
	xhttp.withCredentials = true;
	xhttp.setRequestHeader("Authorization", 'Basic ' + btoa(sessionStorage.getItem("userName")+":"+sessionStorage.getItem("password")));
	xhttp.send();
}




function updateUser(i) {
	user = myUsers[i];
	console.log(document.getElementsByName("role")[i].value);

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {

			user.role = JSON.parse(this.responseText);
			console.log(user);
			var xhttp1 = new XMLHttpRequest();
			xhttp1.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 204) {
					alert("User updated");

				} else if (this.readyState == 4 && this.status == 403) {
					alert("cant assign this role!!");
				}
			};
			xhttp1.open("PUT", "http://localhost:85/PhoneBook/api/user/items/", true);
			xhttp1.setRequestHeader('Content-type', 'application/json');
			xhttp1.withCredentials = true;
			xhttp1.setRequestHeader("Authorization", 'Basic ' + btoa(sessionStorage.getItem("userName")+":"+sessionStorage.getItem("password")));
			xhttp1.send(JSON.stringify(user));


		} else if (this.readyState == 4 && this.status == 204) {
			alert("Invalid Role");
		}
	};
	xhttp.open("GET", "http://localhost:85/PhoneBook/api/role/items/" + document.getElementsByName("role")[i].value, true);
	xhttp.withCredentials = true;
	xhttp.setRequestHeader("Authorization", 'Basic ' + btoa(sessionStorage.getItem("userName")+":"+sessionStorage.getItem("password")));
	xhttp.send();


}



function deleteContact(i) {
	console.log(document.getElementsByName("contactId")[i]);
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 204) {
			alert("Contact deleted");
			editContacts();

		} else if (this.readyState == 4 && this.status == 403) {
			alert("cant be deleted");
		}
	};
	xhttp.open("DELETE", "http://localhost:85/PhoneBook/api/contact/items/" + document.getElementsByName("contactId")[i].textContent, true);
	xhttp.withCredentials = true;
	xhttp.setRequestHeader("Authorization", 'Basic ' + btoa(sessionStorage.getItem("userName")+":"+sessionStorage.getItem("password")));
	xhttp.send();
}



function updateContact(i) {
	var contact = {};
	contact.id = document.getElementsByName("contactId")[i].textContent;
	contact.firstName = document.getElementsByName("contactFirst")[i].value;
	contact.lastName = document.getElementsByName("contactLast")[i].value;
	contact.email = document.getElementsByName("contactMail")[i].value;
	contact.mobileNumber = document.getElementsByName("contactMnumber")[i].value;
	contact.homeNumber = document.getElementsByName("contactHnumber")[i].value;
	console.log(contact);

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 204) {

			alert("Contact updated");
			editContacts();


		} else if (this.readyState == 4 && this.status == 403) {
			alert("Cant update");
		}
	};
	xhttp.open("PUT", "http://localhost:85/PhoneBook/api/contact/items/", true);
	xhttp.setRequestHeader("Content-type", "application/json");
	xhttp.withCredentials = true;
	xhttp.setRequestHeader("Authorization", 'Basic ' + btoa(sessionStorage.getItem("userName")+":"+sessionStorage.getItem("password")));
	xhttp.send(JSON.stringify(contact));


}