package com.example.demo.service.impl;
import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.paginated.PaginatedResponseItemDTO;
import com.example.demo.dto.request.RequestSaveItemDTO;
import com.example.demo.entity.Item;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repo.ItemRepo;
import com.example.demo.service.ItemService;
import com.example.demo.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public void addItem(RequestSaveItemDTO requestSaveItemDTO) {
        Item item = itemMapper.requestDtoToEntity(requestSaveItemDTO);
        item.setActiveState(false);
        if(!itemRepo.existsById(item.getItemId()))
        {
            itemRepo.save(item);
        }
    }

    @Override
    public List<ItemDTO> getItemByName(String itemName) {
        List<Item>items = itemRepo.findAllByItemNameIs(itemName);
        List<ItemDTO>itemDTOS = itemMapper.entityListtoDtoList(items);
        return itemDTOS;
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepo.findAllByActiveStateIs(false);
       if(items.size() > 0)
       {
           List<ItemDTO> itemDTOS = itemMapper.entityListtoDtoList(items);
           return itemDTOS;
       }
       else
       {
           throw new NotFoundException("no data found");
       }
    }

    public int countAllItems() {
        int count = itemRepo.countAllByActiveStateEquals(true);
        return count;
    }

    @Override
    public PaginatedResponseItemDTO getAllItemsActive(int page, int size, boolean activeState) {
        Page<Item> getAllItemsByPaginated = itemRepo.findAll(PageRequest.of(page,size));
//       if(/*items.getSize*/() < 1)
//        {
//            throw new NotFoundException("noo");
//        }
//        List<ItemDTO> itemDTOS = itemMapper.pageToList(items);

//        int count = itemRepo.countAllByActiveStateEquals(activeState);

//        PaginatedResponseItemDTO paginatedResponseItemDTO = new PaginatedResponseItemDTO(itemDTOS, count);

        return new PaginatedResponseItemDTO(
                itemMapper.pageToList(getAllItemsByPaginated),
                itemRepo.count()
        );
    }

    @Override
    public PaginatedResponseItemDTO getAllActiveItemsPaginated(int page, int size, boolean activeState) {
        Page<Item> getAllActiveItemsPaginated = itemRepo.findAllByActiveStateEquals(activeState, PageRequest.of(page,size));

        return new PaginatedResponseItemDTO(
                itemMapper.pageToList(getAllActiveItemsPaginated),
                itemRepo.countAllByActiveStateEquals(activeState)
        );

    }


}
