package com.delivery.model;

public class Order {
    private int id;
    private double lat;
    private double lon;
    private String priority;

    public Order() {}

    public int getId() { return id; }
    public double getLat() { return lat; }
    public double getLon() { return lon; }
    public String getPriority() { return priority; }

    public void setId(int id) { this.id = id; }
    public void setLat(double lat) { this.lat = lat; }
    public void setLon(double lon) { this.lon = lon; }
    public void setPriority(String priority) { this.priority = priority; }
}
