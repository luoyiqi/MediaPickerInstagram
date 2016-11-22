package com.octopepper.mediapickerinstagram.commons.models;

/*
 * Created by Guillaume on 21/11/2016.
 */

import java.io.File;

public class Session {

    private static Session sInstance = null;
    private File mFileToUpload;

    private Session() {
    }

    public static Session getInstance() {
        if (sInstance == null) {
            sInstance = new Session();
        }
        return sInstance;
    }

    public File getFileToUpload() {
        return mFileToUpload;
    }

    public void setFileToUpload(File fileToUpload) {
        mFileToUpload = fileToUpload;
    }

}