package com.java.sp.service;

import java.util.List;

import com.java.sp.beans.Employee;

public interface EmployeeService {
	public String addEmployee(Employee emp);
	public List<Employee> listEmps();
}
