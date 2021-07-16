
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