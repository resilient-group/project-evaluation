package com.greatdreams.projectevaluation.dao;

import java.util.Set;

import com.greatdreams.projectevaluation.domain.Admin;

public interface AdminDao {
	
	public Set<Admin> selectAllAdmin();
	public Admin selectAdminById(int id);
	public String selectPasswordByName(String name);
	
	public void deleteAdminById(int id);
	
	public void insertAdmin(Admin admin);
	
	public void updateAdmin(Admin admin);
}
