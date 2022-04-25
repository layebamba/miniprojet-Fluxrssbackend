package com.example.springrss.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Item {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)

@Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "pubdate")
    private Date pubdate;

    @Column(name = "description")
    private String description;

    @Column(name = "guid")
    private String guid;

    @Column(name = "link")
    private String link;

    @Column(name = "content")
    private String content;

    @Column(name = "credit")
    private String credit;

    public Item() {
    }

    public Item(String title,
                Date pubdate,
                String description,
                String guid,
                String link,
                String content,
                String credit) {
        this.title = title;
        this.pubdate = pubdate;
        this.description = description;
        this.guid = guid;
        this.link = link;
        this.content = content;
        this.credit = credit;
    }

    public Item(String title,
                Date pubdate,
                String description, String guid, String link, String credit) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pubDate=" + pubdate +
                ", description='" + description + '\'' +
                ", guid='" + guid + '\'' +
                ", link='" + link + '\'' +
                ", content='" + content + '\'' +
                ", credit='" + credit + '\'' +
                '}';
    }
}
