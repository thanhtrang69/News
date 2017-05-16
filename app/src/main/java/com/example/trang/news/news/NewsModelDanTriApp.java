package com.example.trang.news.news;

/**
 * Created by Trang on 5/12/2017.
 */

public class NewsModelDanTriApp {
    private String titelSport;
    private String linkSport;
    private String urlImageSport;

    public NewsModelDanTriApp(String titelSport, String linkSport, String urlImageSport) {
        this.titelSport = titelSport;
        this.linkSport = linkSport;
        this.urlImageSport = urlImageSport;
    }

    public NewsModelDanTriApp() {
    }

    public String getTitelSport() {
        return titelSport;
    }

    public void setTitelSport(String titelSport) {
        this.titelSport = titelSport;
    }

    public String getLinkSport() {
        return linkSport;
    }

    public void setLinkSport(String linkSport) {
        this.linkSport = linkSport;
    }

    public String getUrlImageSport() {
        return urlImageSport;
    }

    public void setUrlImageSport(String urlImageSport) {
        this.urlImageSport = urlImageSport;
    }
}
