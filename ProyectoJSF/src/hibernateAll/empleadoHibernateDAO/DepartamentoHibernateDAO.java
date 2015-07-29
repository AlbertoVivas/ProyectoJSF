package hibernateAll.empleadoHibernateDAO;

import hibernateAll.sesion.manager.SesionManager;

import java.util.List;



import tablas_Clases.Departments;
import tablas_Clases.Employees;
import org.hibernate.Session;
public class DepartamentoHibernateDAO {

	
	public List<Departments> obtenerDepartamentos(){
		Session sesion = SesionManager.getSesion();
		List<Departments> lista = sesion.createSQLQuery("SELECT * FROM DEPARTMENTS").addEntity(Departments.class).list();
		sesion.close();
		return lista;
	}

	/**
	 * @param id
	 * @return
	 */
	public List<Employees> obtenerEmpleadosPorDepartamento(int id) {
		Session sesion = SesionManager.getSesion();
		List<Employees> lista = sesion.createSQLQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID="+id).addEntity(Employees.class).list();
		sesion.close();
		return lista;
	}
	
	
}
