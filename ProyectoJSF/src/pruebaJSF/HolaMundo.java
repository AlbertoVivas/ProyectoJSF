package pruebaJSF;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class HolaMundo {
	

	private String nombre;
	private int numero;
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	public HolaMundo()
	{
		nombre="Ignacio";
	}

	public String getNombre() {
		
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int longuitud()
	{
		return this.nombre.length();
	}
	
	public void mostrar(){
		this.numero++;
	
	}

}
