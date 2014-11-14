package com.greatdreams.projectevaluation.persistence;
/**
 * 与AdminMapper.xml名称要一直
 * 负责mybatis操作Admin对象
 */
import java.util.Set;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.greatdreams.projectevaluation.domain.Admin;
@Repository
public interface AdminMapper {
	public Set<Admin> selectAllAdmin();
	public Admin selectAdminById(int id);
	public String selectPasswordByName(String name);
	
	public void deleteAdminById(int id);
	
	public void insertAdmin(Admin admin);
	
	public void updateAdmin(Admin admin);
}
