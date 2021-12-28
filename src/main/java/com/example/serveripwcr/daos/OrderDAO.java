package com.example.serveripwcr.daos;

import com.example.serveripwcr.models.Order;
import com.example.serveripwcr.repositorys.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
public class OrderDAO {
    @Autowired
    private OrderRepository orderRepository;

    public OrderDAO(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAll() {
        ArrayList<Order> orders = (ArrayList<Order>) this.orderRepository.findAll();
        orders.sort(Comparator.comparingLong(Order::getId));
        return orders;
    }

    public Order getById(long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order with the id: " + id + "has not found");
        }
        return optionalOrder.get();
    }

    public Optional<Order> getByIdOptional(long id) {
        return orderRepository.findById(id);
    }

    public void deleteByOrderId(long orderId) {
        orderRepository.deleteById(orderId);
    }

    public Order addOrder(Order newOrder) {
        return orderRepository.save(newOrder);
    }
}
