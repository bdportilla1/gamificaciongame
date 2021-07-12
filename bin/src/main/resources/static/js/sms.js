
//Establecer tiempo de cierre de alert
setTimeout(function() {
       $('#sms').fadeOut('fast');
}, 4000);

//Modificar usuario
function inputValue() {
	valor = document.getElementById("pass").value;
	if (valor == "") {
		$("#pass").val('123');
	}
}

//Modificar usuario modal
function inputValueModal() {
		valor = document.getElementById("contrasenia").value
		if(valor==""){
			$('#contrasenia').val("123")
		}
			  
	
}