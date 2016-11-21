package com.octopepper.mediapickerinstagram.commons.models;

/*
 * Created by Guillaume on 21/11/2016.
 */

public class Post extends Resource {

    private String fileName;
    private String filePath;
    private String message;
    private Author author;

    public Post() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}