package nl.ipwcr.server.controllers;

import nl.ipwcr.server.daos.OrderDAO;
import nl.ipwcr.server.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OrderController {
    @Autowired
    public final OrderDAO orderDAO;

    public OrderController(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @GetMapping(value = "/order/all")
    public List<Order> getAllCategories() {
        return orderDAO.getAll();
    }

    @GetMapping(value = "/order/{id}")
    public Order getOrder(@PathVariable final Long id) {
        return orderDAO.getById(id);
    }

    @PutMapping(value = "/order/{id}")
    public Order editOrder(@RequestBody Order editOrder, @PathVariable Long id) throws Exception {

        return orderDAO.getByIdOptional(id)
                .map(order -> {
                    order.setCart(editOrder.getCart());
                    order.setCompleted(editOrder.isCompleted());
                    return orderDAO.addOrder(order);
                })
                .orElseThrow(() -> new Exception(
                        "No order found with id " + id + "\""));
    }

    @PutMapping(value = "/order")
    public Order addOrder(@RequestBody Order newOrder) {
        return orderDAO.addOrder(newOrder);
    }

    @DeleteMapping("/order/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderDAO.deleteByOrderId(id);
    }

}
