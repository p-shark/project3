package com.wara.manager.dao;


import org.springframework.stereotype.Component;
import com.wara.manager.dto.Manager;

@Component
public interface ManagerDao {
	
	Manager selectById(String mgr_id);
	
	
}
