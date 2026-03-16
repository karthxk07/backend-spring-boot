package com.karthiklogs.blog.services;

import com.karthiklogs.blog.entities.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentsByPostId(Long postId);
    Comment getCommentById(long postId, long commentId);
    Comment addComment(Long postId, Comment comment);
    Comment updateComment(Long postId, Long commentId, Comment comment);
    void deleteComment(Long postId, Long commentId);
}
