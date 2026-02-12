package net.engineeringdigest.journalApp.Dto;

import lombok.Data;

@Data
public class BookRequest {

    private String title;
    private String author;
    private String description;
    private String status;
}
