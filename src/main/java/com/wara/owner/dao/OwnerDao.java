package com.wara.owner.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wara.owner.dto.Owner;

@Component
public interface OwnerDao {
	
	Owner selectById(String owner_id);
	
	void insert(Owner owner);
	
	List<Owner> selectByNo(Long owner_no);
	
	List<Owner> selectAll();
	
	void updateLogincheck(Long owner_no);
	
}
