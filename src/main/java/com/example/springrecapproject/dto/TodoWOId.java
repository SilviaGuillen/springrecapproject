package com.example.springrecapproject.dto;


import com.example.springrecapproject.model.Status;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TodoWOId {
    private final String description;
    private final Status status;
}