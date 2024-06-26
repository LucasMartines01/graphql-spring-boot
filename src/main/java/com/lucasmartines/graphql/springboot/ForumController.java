package com.lucasmartines.graphql.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class ForumController {

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    //@SchemaMapping(typeName = "Query", value = "getPostById")
    @QueryMapping
    public Post getPostById(@Argument String id) {
        return postService.getPostById(id);
    }

    @MutationMapping
    public Collection<Post> createPost(@Argument String content) {
        return postService.createPost(content);
    }

    @MutationMapping
    public Collection<Comment> createComment(@Argument String content,@Argument String postId) {
        return commentService.createComment(content, postId);
    }

    @SchemaMapping
    public Collection<Comment> getCommentsByPostId(Post post) {
        return commentService.getCommentsByPostId(post.id());
    }
}
