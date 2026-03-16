package com.karthiklogs.blog.controllers;

import com.karthiklogs.blog.entities.Post;
import com.karthiklogs.blog.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/posts")
@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPost(){
        List<Post> res=  postService.getAllPosts();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
        Post res =  postService.getPostById(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity<Post> addPost(@Valid @RequestBody Post post){
        Post res = postService.addPost(post);
        return new ResponseEntity<Post>(res, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post){
        Post res  = postService.updatePostById(id,post);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

}
