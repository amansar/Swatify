package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.PublicActions.Post;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import spark.Request;
import spark.Response;

public class PostsController {

    //TODO return type? should be response or object?
    public static Post getPost(Request request, Response response) {
        int id = Integer.parseInt(request.params("id"));
        return HibernateUtil.getObjectById(Post.class, id);
    }

    public static Post createPost(Request request, Response response) {
        String content = request.params("content");
        int userId = Integer.parseInt(request.params("userId"));
        Post newPost = new Post(content, userId);
        HibernateUtil.saveObject(newPost);
        return newPost;
    }

    public static Post updatePost(Request request, Response response) {
        int id = Integer.parseInt(request.params("id"));
        String newContent = request.params("content");
        Post updatedPost = new Post();
        updatedPost.setContent(newContent);
        updatedPost.setId(id);
        HibernateUtil.updateObject( updatedPost );
        return updatedPost;
    }

    public static Post deletePost(Request request, Response response) {
        int id = Integer.parseInt(request.params("id"));
        //TODO how to delete using hibernate?
        return new Post();
    }
}