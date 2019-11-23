package com.wara.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wara.owner.dao.OwnerDao;
import com.wara.owner.dto.Owner;

@Controller
@RequestMapping("managerPage")
public class ManagerPageController {
	
	private OwnerDao ownerDao;
	
	@Autowired
	private void setOwnerDao(OwnerDao ownerDao) {
		this.ownerDao = ownerDao;
	}
	
	@GetMapping
	public String managerPage() {
		return "manager/managerPage";
	}
	
//	@GetMapping("/ownerList")
//	public String list(Model model) {
//		
//		List<Owner> owners = (List<Owner>) ownerDao.selectAll();
//		System.out.println("owners>>>>>>>>>>>>>>>>>" + owners.get(0).getOwner_id());
//		model.addAttribute("owners", owners);
//		
//		return "manager/ownerList";
//	}
	
	/* 가맹점 리스트 */
	@GetMapping("/ownerList")
	public String list(Model model) {
		
		List<Owner> owners = (List<Owner>) ownerDao.selectAll();
		System.out.println("owners>>>>>>>>>>>>>>>>>" + owners.get(0).getOwner_no());
		model.addAttribute("owners", owners);
		
		return "manager/ownerList";
	}
	
	/* 가맹점 승인 */
	@GetMapping("/approval")
	public String Refresh(Model model,@RequestParam(value="owner_no") Long owner_no) {
		ownerDao.updateLogincheck(owner_no);
		List<Owner> owners = ownerDao.selectByNo(owner_no);
		model.addAttribute("owners", owners);
		return "manager/ownerList";
	}
	
}
