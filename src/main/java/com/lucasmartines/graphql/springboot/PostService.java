package com.lucasmartines.graphql.springboot;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class PostService {
    Map<String, Post> posts = new HashMap<>();

    Collection<Post> createPost(String content) {
        Post post = new Post(String.valueOf(posts.size()), content);
        posts.put(post.id(), post);
        return posts.values();
    }

    Post getPostById(String id) {
        return posts.get(id);
    }
}
