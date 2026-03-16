package com.karthiklogs.blog.services.impl;

import com.karthiklogs.blog.entities.Post;
import com.karthiklogs.blog.exceptions.ResourceNotFoundException;
import com.karthiklogs.blog.repositories.PostRepository;
import com.karthiklogs.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;


    @Override
    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>(postRepository.findAll());
        return posts;
    }

    @Override
    public Post getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "id", String.valueOf(id)));
        return post;
    }

    @Override
    public Post addPost(Post post) {
        Post res = postRepository.save(post);
        return res;
    }

    @Override
    public Post updatePostById(Long id, Post newPost) {
        Post post = getPostById(id);

        post.setTitle(newPost.getTitle());
        post.setDescription(newPost.getDescription());
        post.setContent(newPost.getContent());

        return postRepository.save(post);

    }

    @Override
    public void deletePost(Long id) {
        Post post =getPostById(id);
        postRepository.delete(post);
    }
}
