var promedioParalelos = document.getElementById("promedioParalelos");

var promedioEstudiantes = document.getElementById("promedioEstudiantes");

Chart.defaults.global.defaultFontFamily = "Lato";
Chart.defaults.global.defaultFontSize = 18;
//var puntajess = [[${puntaje}]];

//----------------------
//Promedio por paralelos
var puntaje = document.getElementById("puntaje").value;
var paralelo = document.getElementById("paralelo").value;
//arreglos de data
let arrayPuntaje = puntaje.split(";").map(Number);
let arrayParalelo = paralelo.split(";");
//-------------------

//------------------------
//Promedio por estudiantes
var numEstudiantes = document.getElementById("numEstudiantes").value;
var promedio = document.getElementById("promedio").value;
//arreglos de data
let arrayNumEstudiantes = numEstudiantes.split(";");
let arrayPromedio = promedio.split(";");
//-------------------

var chartOptions = {
	scales : {
		xAxes : [ {
			barPercentage : 0.3
		} ],

		yAxes : [ {
			ticks : {
				//iniciar en 0 el eje y
				beginAtZero : true
			}
		} ],
	},
	elements : {
		rectangle : {
			borderSkipped : 'bottom',
		}
	}
};

//----------------------
//Promedio por paralelos
var promedioData = {
	label : 'Promedio por paralelo',

	data : arrayPuntaje,
	backgroundColor : [ 'rgba(0, 99, 132, 0.6)', 'rgba(30, 99, 132, 0.6)',
			'rgba(60, 99, 132, 0.6)', 'rgba(90, 99, 132, 0.6)',
			'rgba(120, 99, 132, 0.6)', 'rgba(150, 99, 132, 0.6)',
			'rgba(180, 99, 132, 0.6)', 'rgba(210, 99, 132, 0.6)',
			'rgba(240, 99, 132, 0.6)' ],
	borderColor : [ 'rgba(0, 99, 132, 1)', 'rgba(30, 99, 132, 1)',
			'rgba(60, 99, 132, 1)', 'rgba(90, 99, 132, 1)',
			'rgba(120, 99, 132, 1)', 'rgba(150, 99, 132, 1)',
			'rgba(180, 99, 132, 1)', 'rgba(210, 99, 132, 1)',
			'rgba(240, 99, 132, 1)' ],
	borderWidth : 2,
	hoverBorderWidth : 0
};

var barChart = new Chart(promedioParalelos, {
	type : 'bar',
	data : {
		labels : arrayParalelo,
		datasets : [ promedioData ],
	},
	options : chartOptions
});
//------------------------

//------------------------
//Promedio por estudiantes
var promedioEst = {
	label : 'Estudiantes por promedio',

	data : arrayPromedio,
	borderColor : [ 'rgba(0, 99, 132, 1)', 'rgba(30, 99, 132, 1)',
			'rgba(60, 99, 132, 1)', 'rgba(90, 99, 132, 1)',
			'rgba(120, 99, 132, 1)', 'rgba(150, 99, 132, 1)',
			'rgba(180, 99, 132, 1)', 'rgba(210, 99, 132, 1)',
			'rgba(240, 99, 132, 1)' ],
	borderWidth : 2,
	hoverBorderWidth : 0
};

var lineChart = new Chart(promedioEstudiantes, {
	type : 'line',
	data : {
		labels : arrayNumEstudiantes,
		datasets : [ promedioEst ],
	},
	options: {
        scales: {
            yAxes: [{
                stacked: true
            }]
        }
    }
});
