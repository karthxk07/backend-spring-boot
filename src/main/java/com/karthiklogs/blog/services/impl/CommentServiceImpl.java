package com.karthiklogs.blog.services.impl;

import com.karthiklogs.blog.entities.Comment;
import com.karthiklogs.blog.entities.Post;
import com.karthiklogs.blog.exceptions.ResourceNotFoundException;
import com.karthiklogs.blog.repositories.CommentRespository;
import com.karthiklogs.blog.repositories.PostRepository;
import com.karthiklogs.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRespository commentRespository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Comment> getCommentsByPostId(Long postId) {

        List<Comment> comments = new ArrayList<>(commentRespository.getByPostId(postId));


        return comments;
    }

    @Override
    public Comment getCommentById(long postId, long commentId) {

        Post post =  postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "id", String.valueOf(postId)));

        Comment comment = commentRespository.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment", "id", String.valueOf(commentId)));

        if(!comment.getPost().getId().equals(post.getId())) throw new RuntimeException("comment does not belong to post");

        return comment;
    }

    @Override
    public Comment addComment(Long postId, Comment comment) {
            Post post = postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "id", String.valueOf(postId)));

            comment.setPost(post);

            return commentRespository.save(comment);
    }

    @Override
    public Comment updateComment(Long postId, Long commentId, Comment new_comment) {

        Post post = postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "id", String.valueOf(postId)));

        Comment comment = commentRespository.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment", "id", String.valueOf(commentId)));

        if(!comment.getPost().getId().equals(post.getId())) throw new RuntimeException("comment does not belong to the post");

        comment.setTitle(new_comment.getTitle());
        comment.setBody(new_comment.getBody());

        return commentRespository.save(comment);
    }

    @Override
    public void deleteComment(Long postId, Long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "id", String.valueOf(postId)));

        Comment comment = commentRespository.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment", "id", String.valueOf(commentId)));

        if(!comment.getPost().getId().equals(post.getId())) throw  new RuntimeException("comment does not belong to the post");


        commentRespository.deleteById(commentId);
    }
}
