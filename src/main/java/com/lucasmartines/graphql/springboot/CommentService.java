package com.lucasmartines.graphql.springboot;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class CommentService {
    Map<String, Comment> comments = new HashMap<>();

    Collection<Comment> createComment(String content, String postId) {
        Comment post = new Comment(String.valueOf(comments.size()), content, postId);
        comments.put(post.id(), post);
        return comments.values();
    }

    Comment getCommentById(String id) {
        return comments.get(id);
    }

    public Collection<Comment> getCommentsByPostId(String postId) {
        return comments.values().stream().filter(comment -> comment.postId().equals(postId)).toList();
    }
}
