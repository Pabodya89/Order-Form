package com.example.demo.util.mappers;

import com.example.demo.dto.ItemDTO;

import java.util.List;

public class StandardResponse {
    private int code;
    private String message;
    private Object data;

    public StandardResponse(int code, String success, List<ItemDTO> itemDTOS) {
    }

    public StandardResponse(int code, String error, String message) {
    }
}
