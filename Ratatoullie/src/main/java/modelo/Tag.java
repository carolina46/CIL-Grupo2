package modelo;

/**
 * Represents a label that describes the contents of the dish or menu.
 * @author CIL-Grupo2
 */


public class Tag {
	
	private String nombre;
	
	
	public Tag(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public String getNombre() { return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
}
