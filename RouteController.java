package com.delivery.controller;

import com.delivery.model.Order;
import com.delivery.model.Route;
import com.delivery.service.RoutingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/route")
@CrossOrigin
public class RouteController {

    private final RoutingService service;

    public RouteController(RoutingService service) {
        this.service = service;
    }

    @PostMapping
    public Route optimize(@RequestBody List<Order> orders) {
        return service.optimizeRoute(orders);
    }
}
