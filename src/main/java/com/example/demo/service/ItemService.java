package com.example.demo.service;

import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.paginated.PaginatedResponseItemDTO;
import com.example.demo.dto.request.RequestSaveItemDTO;

import javax.validation.constraints.Max;
import java.util.List;

public interface ItemService {
    void addItem(RequestSaveItemDTO itemDTO);

    List<ItemDTO> getItemByName(String itemName);

    List<ItemDTO> getAllItems();

    PaginatedResponseItemDTO getAllItemsActive(int page, @Max(50) int size, @Max(50) boolean activeState);

    PaginatedResponseItemDTO getAllActiveItemsPaginated(int page, @Max(50) int size, boolean activeState);
}
