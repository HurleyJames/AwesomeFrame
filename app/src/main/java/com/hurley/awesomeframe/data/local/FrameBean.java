package com.hurley.awesomeframe.data.local;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-11 13:47
 *      github  : https://github.com/HurleyJames
 *      desc    : 框架item实体类
 * </pre>
 */
public class FrameBean {

    private String name;
    private String author;
    private String detail;

    public FrameBean() {

    }

    public FrameBean(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public FrameBean(String name, String author, String detail) {
        this.name = name;
        this.author = author;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
