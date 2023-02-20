package com.daniel_wizer.libraryapi.models;

import com.daniel_wizer.libraryapi.models.audit.DateAudit;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book_category")
public class BookCategory extends DateAudit {

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Category cannot be empty")
    @Size(min = 3, message = "Category name cannot be less than 3 characters")
    private String category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BookCategory that = (BookCategory) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
