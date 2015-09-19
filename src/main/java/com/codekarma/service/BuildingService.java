package com.codekarma.service;
import java.util.List;
import java.util.Map;

import com.codekarma.domain.Building;
import com.codekarma.domain.Pair;
import com.codekarma.domain.Room;

public interface BuildingService {
	public void add(Building building);
	public void edit(Building building);
	public void delete(int id);
	
	public Building getDetail(int id);
	
	public List<Building> getAllList();
	
	public Map<String, String> getOptionList();
	
	public Building validateMember(Building building);
	
	public List< Pair<Integer, String> > Rooms(Integer buildingId);
}
