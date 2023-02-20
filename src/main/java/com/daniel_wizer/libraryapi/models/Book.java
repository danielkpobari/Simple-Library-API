package com.daniel_wizer.libraryapi.models;

import com.daniel_wizer.libraryapi.models.audit.DateAudit;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "book")
public class Book extends DateAudit {

    @Column(name = "book_title", nullable = false)
    @NotBlank(message = "Book title cannot be empty")
    private String bookTitle;

    @Column(name = "book_author", nullable = false)
    @NotBlank(message = "Book author cannot be empty")
    private String bookAuthor;

    @Column(nullable = false)
    @Min(value = 0, message = "Quantity cannot be less than 0")
    private Integer quantity;

    @ManyToOne
    private BookCategory category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Book book = (Book) o;
        return Objects.equals(getId(), book.getId());
    }
    @Override
    public int hashCode() {
        return 0;
    }
}
