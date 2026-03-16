package com.karthiklogs.blog.controllers;


import com.karthiklogs.blog.entities.Comment;
import com.karthiklogs.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/posts")
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/{postId}/comments")
    public ResponseEntity<List<Comment>> getAllCommentsByPostId(@PathVariable Long postId){
        List<Comment> comments = commentService.getCommentsByPostId(postId);

        System.out.println("here"   +comments);
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long postId, @PathVariable Long commentId){
        Comment comment = commentService.getCommentById(postId,commentId);
        return ResponseEntity.ok(comment);
    }

    @PostMapping("/{postId}/comments")
    public ResponseEntity<Comment> addComment(@PathVariable Long postId,@RequestBody Comment comment){
        Comment res = commentService.addComment(postId,comment);
        return new ResponseEntity<Comment>(res, HttpStatus.CREATED);
    }

    @PutMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long postId, @PathVariable Long commentId, @RequestBody Comment comment){
        Comment res = commentService.updateComment(postId,commentId,comment);

        return  new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long postId, @PathVariable Long commentId){
        commentService.deleteComment(postId,commentId);

        return ResponseEntity.noContent().build();
    }
}
