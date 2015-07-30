package pruebaJSF;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.ws.Action;

import hibernateAll.empleadoHibernateDAO.EmpleadoHibernateDAO;
import interfaces.interfaceRecuperable.Recuperable;
import servicios.Empleados.EmployeesServices;
import servicios.departamentos.DepartmentsServices;
import tablas_Clases.Departments;
import tablas_Clases.Employees;

@ManagedBean
@RequestScoped
public class EmpleadoBean {
	
	
	private List<Employees> lista;
	private int id;
	private Employees empleado;
	
	//@Action
	public void recuperarEmpleados(int id){
		List<Employees> listaEmpleadosPorDepartamentos = null;
		DepartmentsServices servicioDepartamentos = new DepartmentsServices();
		listaEmpleadosPorDepartamentos = servicioDepartamentos.obtenerEmpleadosPorDepartamento(id);
		//log.trace(listaDepartamentos);
		//int i = Integer.parseInt("eer");
		System.out.println(listaEmpleadosPorDepartamentos);
		this.lista = listaEmpleadosPorDepartamentos;
	}
	
	public EmpleadoBean() {
		super();
	}

	//@Action
	public void buscarEmpleado() throws ClassNotFoundException, SQLException{
		EmployeesServices es = new EmployeesServices();
		Recuperable objetoDao = new EmpleadoHibernateDAO();
		es.setRecuperable(objetoDao);
		this.empleado = (Employees) es.leerEmpleadoServices(this.id);	
	}

	public EmpleadoBean(List<Employees> lista, int id, Employees empleado) {
		super();
		this.lista = lista;
		this.id = id;
		this.empleado = empleado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public List<Employees> getLista() {
		return lista;
	}

	public void setLista(List<Employees> lista) {
		this.lista = lista;
	}
	public Employees getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Employees empleado) {
		this.empleado = empleado;
	}

}
