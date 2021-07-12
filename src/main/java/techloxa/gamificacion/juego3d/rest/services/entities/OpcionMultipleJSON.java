package techloxa.gamificacion.juego3d.rest.services.entities;

public class OpcionMultipleJSON extends PreguntaJSON {
	
	private String res1;
	private String res2;
	private String res3;
	private String res4;
	private String resCorrecta;
	private String retroalimentacion;

	
	public OpcionMultipleJSON(String res1, String res2, String res3, String res4, String resCorrecta,
			String retroalimentacion) {
		super();
		this.res1 = res1;
		this.res2 = res2;
		this.res3 = res3;
		this.res4 = res4;
		this.resCorrecta = resCorrecta;
		this.retroalimentacion = retroalimentacion;

	}
	public OpcionMultipleJSON() {
	}
	public String getRes1() {
		return res1;
	}
	public String getRes2() {
		return res2;
	}
	public String getRes3() {
		return res3;
	}
	public String getRes4() {
		return res4;
	}
	public String getResCorrecta() {
		return resCorrecta;
	}
	public String getRetroalimentacion() {
		return retroalimentacion;
	}
	public void setRes1(String res1) {
		this.res1 = res1;
	}
	public void setRes2(String res2) {
		this.res2 = res2;
	}
	public void setRes3(String res3) {
		this.res3 = res3;
	}
	public void setRes4(String res4) {
		this.res4 = res4;
	}
	public void setResCorrecta(String resCorrecta) {
		this.resCorrecta = resCorrecta;
	}
	public void setRetroalimentacion(String retroalimentacion) {
		this.retroalimentacion = retroalimentacion;
	}
	
}
