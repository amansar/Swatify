package edu.swarthmore.cs.cs71.swatify.models;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class DiscussionsTest {
    @Test
    public void createDiscussion() throws Exception {
        Discussion newDiscussion = new Discussion("Test Discussion", 1, "testUser1");
        Assert.assertEquals("Test Discussion", newDiscussion.getTitle());
        Assert.assertEquals(1, newDiscussion.getUserId());
    }

    @Test
    public void changeTitle() throws Exception {
        Discussion newDiscussion = new Discussion("Test Discussion 2", 3, "testUser2");
        Assert.assertEquals("Test Discussion 2", newDiscussion.getTitle());
        newDiscussion.setTitle("updated");
        Assert.assertEquals("updated", newDiscussion.getTitle());
    }

//    @Test
//    public void addingPosts() throws Exception {
//        Discussion newDiscussion = new Discussion("Test Discussion 3", 4);
//        Post newPost = new Post("new post", 1);
//        Post newPost2 = new Post("new post 2", 2);
//
//        newDiscussion.addPost(newPost);
//        newDiscussion.addPost(newPost2);
//
//        List<Post> testPostList = newDiscussion.getPosts();
//
//        Assert.assertEquals(newPost, testPostList.get(0));
//        Assert.assertEquals(newPost2, testPostList.get(1));
//
//    }
}
