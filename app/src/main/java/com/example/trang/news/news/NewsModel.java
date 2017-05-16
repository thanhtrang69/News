package com.example.trang.news.news;

/**
 * Created by Trang on 5/12/2017.
 */

public class NewsModel {
    private String titel;
    private String link;
    private String urlImage;

    public NewsModel(String titel, String link, String urlImage) {
        this.titel = titel;
        this.link = link;
        this.urlImage = urlImage;
    }

    public NewsModel() {
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
