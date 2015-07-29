package pruebaJSF;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import servicios.departamentos.DepartmentsServices;
import tablas_Clases.Departments;
import tablas_Clases.Employees;

@ManagedBean
@RequestScoped
public class EmpleadoBean {
	
	private List<Employees> lista;

	public List<Employees> getLista() {
		return lista;
	}

	public void setLista(List<Employees> lista) {
		this.lista = lista;
	}
	
	@PostConstruct
	public void recuperarEmpleados(int id){
		List<Employees> listaEmpleadosPorDepartamentos = null;
		DepartmentsServices servicioDepartamentos = new DepartmentsServices();
		listaEmpleadosPorDepartamentos = servicioDepartamentos.obtenerEmpleadosPorDepartamento(id);
		//log.trace(listaDepartamentos);
		//int i = Integer.parseInt("eer");
		System.out.println(listaEmpleadosPorDepartamentos);
		this.lista = listaEmpleadosPorDepartamentos;
	}
	

	

}
