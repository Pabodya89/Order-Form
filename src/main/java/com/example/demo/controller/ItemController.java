package com.example.demo.controller;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.paginated.PaginatedResponseItemDTO;
import com.example.demo.dto.request.RequestSaveItemDTO;
import com.example.demo.service.ItemService;
import com.example.demo.util.mappers.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    //create the save data
    @PostMapping(path = "/save")
    public String saveItem(@RequestBody RequestSaveItemDTO itemDTO) {
        itemService.addItem(itemDTO);
        return "saved";
    }

    @GetMapping(path = "/get-by-name",
            params = "name")
    public List<ItemDTO> getItemById(@RequestParam(value = "name") String ItemName) {
        List<ItemDTO> itemDTO;
        itemDTO = itemService.getItemByName(ItemName);
        return itemDTO;
    }

    @GetMapping(path = {"get-all-item"})
    public ResponseEntity<StandardResponse> getAllItems()
    {
        List<ItemDTO> itemDTOS = itemService.getAllItems();
//        ResponseEntity<StandardResponse> m  = new ResponseEntity<StandardResponse>(
//                new StandardResponse(200, "Success", itemDTOS), HttpStatus.OK
//        );
//        return m;
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",itemDTOS),
                HttpStatus.OK
        );
    }

    @GetMapping(path = {"get-all-item-active"}, params = {"page","size","activeState"})
    public ResponseEntity<StandardResponse> getAllItemsActive(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size,
            @RequestParam(value = "activeState") @Max(50) boolean activeState
    )
    {
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getAllItemsActive(page,size,activeState);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success", paginatedResponseItemDTO),
                HttpStatus.OK
        );
    }

    @GetMapping(path = {"get-all-active-item-paginated"}, params = {"page","size","activeState"})
    public ResponseEntity<StandardResponse> getAllActiveItemsPaginated(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size,
            @RequestParam(value = "activeState") boolean activeState
    )
    {
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getAllActiveItemsPaginated(page,size,activeState);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success", paginatedResponseItemDTO),
                HttpStatus.OK
        );
    }
}
