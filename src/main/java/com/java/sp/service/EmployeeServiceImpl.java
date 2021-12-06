package com.java.sp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.java.sp.beans.Employee;
import com.java.sp.dao.EmployeeDaoimpl;
import com.java.sp.entitites.EmployeeEn;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDaoimpl employeeDao;
	
	public String addEmployee(Employee bean) {
		//Employee empEntity = new Employee(emp.getEmpId(),emp.getEmpName(),emp.getEmpAge(),emp.getEmpSalary(),emp.getEmpGender());
		return employeeDao.insertEmployeeRecord(beanToEntity(bean));
	}

	private EmployeeEn beanToEntity(Employee bean) {
		EmployeeEn entity = new EmployeeEn();
		entity.setCity(bean.getEmpCity());
		entity.setEmpAge(bean.getEmpAge());
		entity.setEmpGender(bean.getEmpGender());
		entity.setEmpName(bean.getEmpName());
		entity.setEmpSalary(bean.getEmpSalary());
		String hobbies = "";
		for (String hob : bean.getEmpHobbies()) {
			hobbies = hobbies+","+hob;
		}
		entity.setHobbies(hobbies);
		String skills = "";
		for (String skl : bean.getEmpSkills()) {
			skills = skills+","+skl;
		}
		entity.setSkills(skills);
		return entity;
	}

	@Override
	public List<Employee> listEmps() {
		// TODO Auto-generated method stub
		List<EmployeeEn> entities =  employeeDao.fetchListOfEmps();
		return entitiesToBean(entities);
	}

	private List<Employee> entitiesToBean(List<EmployeeEn> entities) {
		List<Employee> beans = new ArrayList<Employee>();
		
		
		
		
		for (EmployeeEn entity : entities) {
			Employee bean = new Employee(entity.getEmpId(),
					entity.getEmpName(),
					entity.getEmpAge(),
					entity.getEmpSalary(),
					entity.getEmpGender(),
					entity.getSkills().split(","),
					entity.getCity(),
					entity.getHobbies().split(","));
			beans.add(bean);
		}
		return beans;
	}
	
}
