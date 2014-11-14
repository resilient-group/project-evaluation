package com.greatdreams.projectevaluation.dao.imp;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greatdreams.projectevaluation.dao.AdminDao;
import com.greatdreams.projectevaluation.domain.Admin;
import com.greatdreams.projectevaluation.persistence.AdminMapper;


@Service("adminService")
@Repository
@Transactional
public class AdminDaoImp implements AdminDao {
	@Autowired
	private AdminMapper adminMapper;
	
	public Set<Admin> selectAllAdmin(){
		Set<Admin> allAdmin = adminMapper.selectAllAdmin();
		return allAdmin;
	}
	public Admin selectAdminById(int id){
		return adminMapper.selectAdminById(id);
	}
	
	public String selectPasswordByName(String name){
		return adminMapper.selectPasswordByName(name);
	}
	
	public void deleteAdminById(int id){
		adminMapper.deleteAdminById(id);
	}
	
	public void insertAdmin(Admin admin){
		adminMapper.insertAdmin(admin);
	}
	
	public void updateAdmin(Admin admin){
		adminMapper.updateAdmin(admin);
	}
}
