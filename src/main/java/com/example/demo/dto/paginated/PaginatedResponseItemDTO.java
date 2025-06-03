package com.example.demo.dto.paginated;

import com.example.demo.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDTO {
    private List<ItemDTO> list;
    private long dataCount;

//    public PaginatedResponseItemDTO(List<ItemDTO> itemDTOS, long count) {
//    }

}
