package com.example.demo.util.mappers;

import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.request.RequestSaveItemDTO;
import com.example.demo.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item requestDtoToEntity(RequestSaveItemDTO requestSaveItemDTO);
    List<ItemDTO> entityListtoDtoList(List<Item>items);
    List<ItemDTO> pageToList(Page<Item> items);
}
