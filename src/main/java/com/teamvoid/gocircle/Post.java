package com.teamvoid.gocircle;

import java.sql.Blob;

public class Post {
    private String postID;
    private String content;
    private String Username;
    private Blob blob;

    public Post(String postID, String content, String username, Blob blob) {
        this.postID = postID;
        this.content = content;
        Username = username;
        this.blob = blob;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public Blob getBlob() {
        return blob;
    }

    public void setBlob(Blob blob) {
        this.blob = blob;
    }
}
