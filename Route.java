package com.delivery.model;

import java.util.List;

public class Route {
    private List<Order> stops;
    private double totalDistance;

    public Route(List<Order> stops, double totalDistance) {
        this.stops = stops;
        this.totalDistance = totalDistance;
    }

    public List<Order> getStops() { return stops; }
    public double getTotalDistance() { return totalDistance; }
}
