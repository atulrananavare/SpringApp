package com.java.sp.dao;

import java.util.List;

import com.java.sp.entitites.EmployeeEn;

public interface EmployeeDao {
	public String insertEmployeeRecord(EmployeeEn emp);
	public List<EmployeeEn> fetchListOfEmps();
}
