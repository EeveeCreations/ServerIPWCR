package nl.ipwcr.server.controllers;

import nl.ipwcr.server.daos.OrderDAO;
import nl.ipwcr.server.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://eeveecreations.github.io",
        "https://one-piece-shop-ipwcr-jpwbr.ondigitalocean.app/"})

@RequestMapping("/order")
@RestController
public class OrderController {
    @Autowired
    public final OrderDAO orderDAO;

    public OrderController(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @GetMapping(value = "/all")
    public List<Order> getAllCategories() {
        return orderDAO.getAll();
    }

    @GetMapping(value = "/{id}")
    public Order getOrder(@PathVariable final Long id) {
        return orderDAO.getById(id);
    }

    @PutMapping(value = "/{id}")
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

    @PutMapping(value = "/new")
    public Order addOrder(@RequestBody Order newOrder) {
        return orderDAO.addOrder(newOrder);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderDAO.deleteByOrderId(id);
    }

}
