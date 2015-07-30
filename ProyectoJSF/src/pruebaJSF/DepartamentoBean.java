package pruebaJSF;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.Action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import servicios.departamentos.DepartmentsServices;
import tablas_Clases.Departments;
import tablas_Clases.Employees;

@ManagedBean
//@RequestScoped//se crea el objeto y se destruye con cada carga de pagina
@SessionScoped //se crea y se destruye en cada sesion, asi no se llama mil veces y carga mil veces
public class DepartamentoBean {

	private List<Departments> lista;
	private List<Employees> listaEmpleados;
	private int id;
	
	@PostConstruct //para que la informacion que necesita la vista ya este
	public void recuperarDepartamentos(){
		List<Departments> listaDepartamentos = null;
		DepartmentsServices servicioDepartamentos = new DepartmentsServices();
		listaDepartamentos = servicioDepartamentos.obtenerDepartamentos();
		//log.trace(listaDepartamentos);
		//int i = Integer.parseInt("eer");
		System.out.println(listaDepartamentos);
		this.lista = listaDepartamentos;
	}
	
	public void recuperarEmpleadosPorDepartamento(){
		DepartmentsServices servicioDepartamentos = new DepartmentsServices();
		listaEmpleados=servicioDepartamentos.obtenerEmpleadosPorDepartamento(id);
	}

	public List<Departments> getLista() {
		return lista;
	}

	public void setLista(List<Departments> lista) {
		this.lista = lista;
	}

	public List<Employees> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Employees> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DepartamentoBean(List<Departments> lista, List<Employees> listaEmpleados, int id) {
		super();
		this.lista = lista;
		this.listaEmpleados = listaEmpleados;
		this.id = id;
	}

	public DepartamentoBean() {
		super();
	}
	

	
	
	
	
	
}
