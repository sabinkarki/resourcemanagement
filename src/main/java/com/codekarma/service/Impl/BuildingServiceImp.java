package com.codekarma.service.Impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codekarma.domain.Building;
import com.codekarma.domain.Pair;
import com.codekarma.domain.Role;
import com.codekarma.domain.Room;
import com.codekarma.repository.BuildingRepository;
import com.codekarma.repository.MemberRepositoryImp2;
import com.codekarma.repository.RoleRopository2;
import com.codekarma.service.BuildingService;
import com.codekarma.service.MemberService;

@Service
@Transactional
public class BuildingServiceImp implements BuildingService {

	@Autowired
	BuildingRepository buildingRepository;
	
	@Override
	public void add(Building building) {
		// TODO Auto-generated method stub
		buildingRepository.save(building);
	}
	
	
	@Override
	public void edit(Building building) {
		// TODO Auto-generated method stub
		buildingRepository.save(building);
	}
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		buildingRepository.delete(id);
	}
	@Override
	public Building getDetail(int id) {
		// TODO Auto-generated method stub
		return buildingRepository.findOne(id);
	}
	
	@Override
	public List<Building> getAllList() {
		// TODO Auto-generated method stub
		return (List<Building>)buildingRepository.findAll();
	}
	@Override
	public Map<String, String> getOptionList()
	{
		Map<String, String> map = new HashMap();//
		for(Building building: getAllList()){
		    map.put(""+building.getId(), building.getName());
		}
		return map;
	}
	@Override
	public Building validateMember(Building building) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List< Pair<Integer, String> > Rooms(Integer buildingId) {
		List< Pair<Integer, String>> rooms = new ArrayList< Pair<Integer,String>>();
		Building b = buildingRepository.findOne(buildingId);
		if(b != null){
			for(Room r: b.getLstRoomInBuilding()){
				rooms.add(new Pair(r.getId(), r.getName()));
			}
		}
		return rooms;
	}

}
