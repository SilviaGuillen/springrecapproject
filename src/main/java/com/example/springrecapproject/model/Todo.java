package com.example.springrecapproject.model;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.With;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@RequiredArgsConstructor
@Document("Todo")
public class Todo {
        private final String id;
        @With
        private final String description;
        @With
        private final Status status;
        private final LocalDateTime timestamp;
}
