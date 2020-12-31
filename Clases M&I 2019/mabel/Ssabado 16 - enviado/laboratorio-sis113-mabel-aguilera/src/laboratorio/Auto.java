// clase auto, para ecribir en el archivo .bin un objeto de este tipo
package laboratorio;
import java.io.Serializable;
public class Auto  implements Serializable{
	private String ci;
	private String nombre;
	private String placa;
	
	public Auto(String ci, String nombre, String placa) {
		this.ci 	= ci;
		this.nombre = nombre;
		this.placa 	= placa;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
	
}
