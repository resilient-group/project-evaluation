package com.greatdreams.projectevaluation.domain;

import org.springframework.stereotype.Repository;

/**
 * 新闻管理员
 * @author buildhappy
 *创建数据库表
	create table admin(
		id int primary key auto_increment,
		name varchar(15),
		password varchar(10)
	);
	insert into admin(id,name,password) values(1,'buildahppy','123');
	insert into admin(id,name,password) values(2,'Jack','123');
	insert into admin(name,password) values('Jone','123');
 */
@Repository
public class Admin {
	private int id;
	private String name;
	private String password;
	public Admin(){
		
	}
	public Admin(int id , String name , String password){
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString(){
		return "admin-name:" + this.name + ". password:" + this.password;
	}
	
}
