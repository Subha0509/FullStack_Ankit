function validate(form) {
	let flag = true;
	document.getElementById("nameerr").innerHTML = "";
	document.getElementById("profileerr").innerHTML = "";
	document.getElementById("salaryerr").innerHTML = "";
	alert("Press Ok to Process The Request...");
	let name = form.name.value;
	let profile = form.profile.value;
	let salary = form.salary.value;
	if (name === "") {
		document.getElementById("nameerr").innerHTML = "Name Must Be Filed !";
		flag = false;
	}
	else if (name.length > 20) {
		document.getElementById("nameerr").innerHTML = "Name Must be With in 20 Character";
		flag = false;
	}
	if (profile === "") {
		document.getElementById("profileerr").innerHTML = "Profile Must Be Filed !";
		flag = false;
	}
	else if (profile.length > 20) {
		document.getElementById("profileerr").innerHTML = "Profile Must be With in 20 Character";
		flag = false;
	}
	if (salary === "") {
		document.getElementById("salaryerr").innerHTML = "Salary Must Be Filed !";
		flag = false;
	}
	else if (isNaN(salary)) {
		document.getElementById("salaryerr").innerHTML = "Salary Must Be A Numeric Value !";
	}
	else if (salary < 0 || salary > 200000) {
		document.getElementById("salaryerr").innerHTML = "Salary Must Be 1 Through 200000 !";
		flag = false;
	}
	form.vflag.value = "yes";
	
	return flag;

}