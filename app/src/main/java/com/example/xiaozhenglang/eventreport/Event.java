package com.example.xiaozhenglang.eventreport;

/**
 * Created by xiaozhenglang on 4/25/18.
 */

public class Event {
    private String title;
    private String address;
    private String description;

    public Event(String title, String address, String description) {
        this.title = title;
        this.address = address;
        this.description = description;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAddress() {
        return this.address;
    }

    public String getDescription() {
        return this.description;
    }

}
