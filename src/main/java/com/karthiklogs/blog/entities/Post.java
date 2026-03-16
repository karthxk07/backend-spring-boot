package com.karthiklogs.blog.entities;


import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "posts"
)
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    //id
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    //title
    @NotEmpty(message = "title cannot be empty")
    @Size(min = 2, message = "title cannot be less than 2 characters")
    @Nonnull
    private String title;
    //description
    @NotEmpty(message = "description cannot be empty")
    @Size(min = 10, message = "description cannot be less than 10 characters")
    @Nonnull
    private String description;
    //content
    @NotEmpty(message = "content cannot be empty")
    @Size(min = 10, message = "content cannot be less than 10 characters")
    @Nonnull
    private String content;
    //comments
    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Comment> comments = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Nonnull
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nonnull String title) {
        this.title = title;
    }

    @Nonnull
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nonnull String description) {
        this.description = description;
    }

    @Nonnull
    public String getContent() {
        return content;
    }

    public void setContent(@Nonnull String content) {
        this.content = content;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
