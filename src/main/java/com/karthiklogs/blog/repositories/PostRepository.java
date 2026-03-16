package com.karthiklogs.blog.repositories;

import com.karthiklogs.blog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
