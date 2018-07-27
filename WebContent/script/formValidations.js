function resetErrors() {
	document.getElementById("locIdErr").innerHTML = '';
	document.getElementById("locNameErr").innerHTML = '';
	document.getElementById("locTypeErr").innerHTML = '';
}

function validateLocInput() {
	var exp = /^[1-9][0-9]{0,6}$/;
	var exp2 = /^[A-Za-z]{1,5}$/;
	resetErrors();
	if (!(document.locForm.locId.value.match(exp))) {
		// alert("Please Enter Some Id");
		document.getElementById("locIdErr").innerHTML = ' * Please Enter Valid Id(only numarics min-1,max-7)';
		return false;
	} else if (!(document.locForm.locName.value.match(exp2))) {
		document.getElementById("locNameErr").innerHTML = ' * Please Enter Valid Name';
		return false;
	} else if (document.locForm.locType[0].checked == false
			&& document.locForm.locType[1].checked == false) {
		document.getElementById("locTypeErr").innerHTML = ' * Please choose one type';
		return false;
	}
	return true;
}

function resetVenErrs() {
	document.getElementById("venMailErr").innerHTML = '';
	document.getElementById("venLocErr").innerHTML = '';
}

function validateVenInput() {
	var exp = /^[A-Za-z0-9\.\_\-]+\@[a-z]*\.[a-z]{2,3}$/;
	resetVenErrs();
	if (!(document.venForm.venMail.value.match(exp))) {
		document.getElementById("venMailErr").innerHTML = 'Invalid Email';
		return false;
	} else if (document.getElementById("locIdType").value == "-1") {
		document.getElementById("venLocErr").innerHTML = 'select any one location';
		return false;
	}
	return true;
}
