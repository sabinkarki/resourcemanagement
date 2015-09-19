package com.codekarma.service;
import java.util.List;

import com.codekarma.domain.Room;

public interface RoomService {
	public void add(Room room);
	public void edit(Room room);
	public void delete(int id);
	
	public Room getDetail(int id);
	
	public List<Room> getAllList();
	
}
