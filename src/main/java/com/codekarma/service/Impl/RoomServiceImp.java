package com.codekarma.service.Impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codekarma.domain.Building;
import com.codekarma.domain.Room;
import com.codekarma.repository.BuildingRepository;
import com.codekarma.repository.RoomRepository;
import com.codekarma.service.RoomService;

@Service
@Transactional
public class RoomServiceImp implements RoomService {

	@Autowired
	RoomRepository roomRepository;
	@Autowired
	BuildingRepository buildingRepository;
	
	@Override
	public void add(Room room) {
//		Building b = buildingRepository.findOne(room.getBuilding().getId());
//		if(b == null){
//			b = new Building();
//			b.setName("");
//			b.setLstRoomInBuilding(new ArrayList<Room>());
//		}
//		b.getLstRoomInBuilding().add(room);
		roomRepository.save(room);
	}
	
	@Override
	public void edit(Room room) {
		// TODO Auto-generated method stub
		roomRepository.save(room);
	}
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		roomRepository.delete(id);
	}
	@Override
	public Room getDetail(int id) {
		// TODO Auto-generated method stub
		return roomRepository.findOne(id);
	}
	
	@Override
	public List<Room> getAllList() {
		// TODO Auto-generated method stub
		return (List<Room>)roomRepository.findAll();
	}
	
}
