package com.geek.domain;

/**
 * Created by Liuqi
 * Date: 2016/11/23.
 */
public class Article {
    private Integer id;
    private String title;
    private Double score;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public Double getScore() {
        return score;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
