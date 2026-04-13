package com.delivery.service;

import com.delivery.model.Order;
import com.delivery.model.Route;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoutingService {

    public Route optimizeRoute(List<Order> orders) {

        List<Order> prime = new ArrayList<>();
        List<Order> normal = new ArrayList<>();

        for (Order o : orders) {
            if ("PRIME".equals(o.getPriority())) prime.add(o);
            else normal.add(o);
        }

        List<Order> result = new ArrayList<>();
        result.addAll(nearestNeighbor(prime));
        result.addAll(nearestNeighbor(normal));

        double distance = calculateDistance(result);
        return new Route(result, distance);
    }

    private List<Order> nearestNeighbor(List<Order> orders) {
        List<Order> route = new ArrayList<>();
        if (orders.isEmpty()) return route;

        Set<Order> visited = new HashSet<>();
        Order current = orders.get(0);

        route.add(current);
        visited.add(current);

        while (visited.size() < orders.size()) {
            Order next = null;
            double min = Double.MAX_VALUE;

            for (Order o : orders) {
                if (!visited.contains(o)) {
                    double d = dist(current, o);
                    if (d < min) {
                        min = d;
                        next = o;
                    }
                }
            }

            route.add(next);
            visited.add(next);
            current = next;
        }

        return route;
    }

    private double dist(Order a, Order b) {
        return Math.sqrt(
            Math.pow(a.getLat() - b.getLat(), 2) +
            Math.pow(a.getLon() - b.getLon(), 2)
        );
    }

    private double calculateDistance(List<Order> route) {
        double total = 0;
        for (int i = 1; i < route.size(); i++) {
            total += dist(route.get(i - 1), route.get(i));
        }
        return total;
    }
}
