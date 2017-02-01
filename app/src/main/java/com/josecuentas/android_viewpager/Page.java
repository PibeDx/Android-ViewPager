package com.josecuentas.android_viewpager;

import java.io.Serializable;

/**
 * Created by jcuentas on 30/01/17.
 */

public class Page implements Serializable {
    public static final String BUNDLE = ".page";

    private String title;
    private String message;

    public Page(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
