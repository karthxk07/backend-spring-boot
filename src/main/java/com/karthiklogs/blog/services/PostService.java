package com.karthiklogs.blog.services;

import com.karthiklogs.blog.entities.Comment;
import com.karthiklogs.blog.entities.Post;
import com.karthiklogs.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(Long id);
    Post addPost(Post post);
    Post updatePostById(Long id, Post post);
    void deletePost(Long id);


}
