package net.engineeringdigest.journalApp.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String author;

    private String description;

    private String status; // READING / COMPLETED

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

