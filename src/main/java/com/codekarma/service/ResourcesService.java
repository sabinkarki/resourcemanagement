package com.codekarma.service;

import java.util.List;

import com.codekarma.domain.Item;
import com.codekarma.domain.ResourceRequest;

public interface ResourcesService {

	Item addNewItem(Item item);

	List<Item> getItems(int numberOfItems);

	Item getById(Long id);

	ResourceRequest addNewRequest(Long itemId, String username);

	List<ResourceRequest> getResourceRequests();

	void grantRequestForRequestId(Integer requestId);

	void discardRequestForRequestId(Integer requestId);

}
