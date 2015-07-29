package servicios.departamentos;

import hibernateAll.empleadoHibernateDAO.DepartamentoHibernateDAO;

import java.util.List;

import tablas_Clases.Departments;
import tablas_Clases.Employees;

public class DepartmentsServices {

	
	public List<Departments> obtenerDepartamentos(){
				
		DepartamentoHibernateDAO departamentoDao = new DepartamentoHibernateDAO();
		List<Departments> lista = departamentoDao.obtenerDepartamentos();
		return lista;
	}

	/**
	 * @param id
	 * @return
	 */
	public List<Employees> obtenerEmpleadosPorDepartamento(int id) {
		DepartamentoHibernateDAO departamentoDao = new DepartamentoHibernateDAO();
		List<Employees> lista = departamentoDao.obtenerEmpleadosPorDepartamento(id);
		return lista;
	}
}
