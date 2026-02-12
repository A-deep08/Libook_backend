package net.engineeringdigest.journalApp.Dto;

import lombok.*;

    @AllArgsConstructor
    @Data
    public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private String description;
    private String status;
}
