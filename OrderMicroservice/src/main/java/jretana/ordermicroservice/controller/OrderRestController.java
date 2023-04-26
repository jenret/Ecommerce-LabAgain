package jretana.ordermicroservice.controller;

import jretana.ordermicroservice.model.Order;
import jretana.ordermicroservice.repositories.OrderJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderRestController {

    @Autowired
    OrderJpaRepository orderRepo;

    /////// GET
    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Order>> findAllOrders() {
        List<Order> orders = orderRepo.findAll();
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }

    /////// POST
    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody Order order) {
        order.setOrderUUID(UUID.randomUUID());
        orderRepo.save(order);
    }

    /////// DELETE
    @DeleteMapping(path = "/{orderUUID}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteItem(@PathVariable(required = true) UUID orderUUID) {
        orderRepo.deleteById(orderUUID);
    }
}
