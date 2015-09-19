package com.codekarma.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codekarma.domain.Item;
import com.codekarma.domain.Member;
import com.codekarma.domain.ResourceRequest;
import com.codekarma.domain.ResourceStatus;
import com.codekarma.domain.Transaction;
import com.codekarma.domain.TranscationStatus;
import com.codekarma.exception.InvalidOperationException;
import com.codekarma.repository.ItemsRepository;
import com.codekarma.repository.MemberRepositoryImp2;
import com.codekarma.repository.RequestRepository;
import com.codekarma.repository.TransactionRepository;
import com.codekarma.service.ResourcesService;

@Service
@Transactional
public class ResourceServiceImpl implements ResourcesService {

	@Autowired
	ItemsRepository itemsRepository;
//	@Autowired
//	CategoryRepository categoryRepository;
//	@Autowired
//	BuildingRepository buildingRepository;
//	@Autowired
//	RoomRepository roomRepository;
	
	@Autowired
	RequestRepository requestRepository;
	@Autowired
	MemberRepositoryImp2 memberRepository;
	@Autowired
	TransactionRepository transactionRepository;

	public Item addNewItem(Item item) {
		// updating categories
//		Category category;
//		if (item.getCategoryItem().getId() != -10) {
//			category = categoryRepository.findOne(item.getCategoryItem()
//					.getId());
//		} else {
//			category = categoryRepository.getCategoryByName(item
//					.getCategoryItem().getName());
//		}
//		if (category == null) {
//			category = new Category();
//			category.setName(item.getCategoryItem().getName());
//			category.setLstCategoryItems(new ArrayList<Item>());
//		}
//		category.getLstCategoryItems().add(item);
//		item.setCategoryItem(category);
//
//		//updating room
//		Building building = buildingRepository.findByBuildingName(item.getRoomItem().getBuilding().getName());
//		Room room = roomRepository.findByRoomName(item.getRoomItem().getName());
//		if(building == null){
//			building = new Building();
//			building.setName(item.getRoomItem().getBuilding().getName());
//			building.setLstRoomInBuilding(new ArrayList<Room> ());
//			building.setDescription("   ");
//		}
//		if(room == null){
//			room = new Room();
//			room.setName(item.getRoomItem().getName());
//			room.setLstItemsInRoom(new ArrayList<Item>());
//			room.setLstMemberInRoom(new ArrayList<Member>());
//			room.setLstTranscationRoom(new ArrayList<Transaction>());
//			room.setStatus(ResourceStatus.AVAILABLE);
//		}
//		room.setBuilding(building);
//		if(!building.getLstRoomInBuilding().contains(room)){
//			building.getLstRoomInBuilding().add(room);
//		}
//		room.getLstItemsInRoom().add(item);
//		
		return itemsRepository.save(item);
	}

	@Override
	public List<Item> getItems(int numberOfItems) {
		
		Iterable<Item> items = itemsRepository.findAll();
		List<Item> lstItem = new ArrayList<Item>();
		for(Item i: items){
			if(lstItem.size() > numberOfItems){
				break;
			}
			lstItem.add(i);
		}
		return lstItem;
	}

	@Override
	public Item getById(Long id) {
		return itemsRepository.findOne(id);
	}

	@Override
	public ResourceRequest addNewRequest(Long itemId,String username) {
		ResourceRequest previousRequest = requestRepository.findByItemId(itemId);
		if(previousRequest != null){
			throw new InvalidOperationException("", "The resource was already requested (may be by other user).");
		}
		ResourceRequest request = new ResourceRequest();
		Item item = itemsRepository.findOne(itemId);
		request.setItem(item);
		request.setRequestdate(new Date());
		Member member = memberRepository.getMemberByUsername(username);
		request.setMember(member);
		ResourceRequest saved = requestRepository.save(request);
		return saved;
	}

	@Override
	public List<ResourceRequest> getResourceRequests() {
		List<ResourceRequest> requests = new ArrayList<ResourceRequest>();
		for(ResourceRequest r:  requestRepository.findAll()){
			requests.add(r);
		}
		return requests;
	}

	@PreAuthorize(value="hasRole('ADMIN')")
	public void grantRequestForRequestId(Integer requestId) {
		ResourceRequest request  = requestRepository.findOne(requestId);
		Member member = request.getMember();
		Item item = request.getItem();
		
		Transaction transaction = new Transaction();
		transaction.setAssignDate(new Date());
		transaction.setTransactionStatus(TranscationStatus.ACTIVE);
		//transactionRepository.save(transaction);
		
		transaction.setItemTranscation(item);
		transaction.setMemberTranscation(member);
		transaction.setRoomTanscation(null);
		
		item.setStatus(ResourceStatus.OCCUPIED);
		item.setMemberItem(member);
		item.getLstTranscationItem().add(transaction);
		
		member.getLstMemberItems().add(item);
		member.getLstTranscationMember().add(transaction);		
		
		transactionRepository.save(transaction);
		itemsRepository.save(item);
		memberRepository.save(member);
		requestRepository.delete(request);
	}

	@PreAuthorize(value="hasRole('ADMIN')")
	public void discardRequestForRequestId(Integer requestId) {
		requestRepository.delete(requestId);
	}

}
