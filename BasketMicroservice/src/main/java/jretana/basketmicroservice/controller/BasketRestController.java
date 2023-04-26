package jretana.basketmicroservice.controller;

import jretana.basketmicroservice.model.Basket;
import jretana.basketmicroservice.model.Item;
import jretana.basketmicroservice.repositories.BasketJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/basket")
public class BasketRestController {

    @Autowired
    BasketJpaRepository basketRepo;

    /////// GET
    @GetMapping(path = "/{basketId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Basket> getBasket(@PathVariable UUID basketId) {

        Basket basket = basketRepo.findById(basketId).orElseThrow(() -> new NoSuchElementException());
        return new ResponseEntity<Basket>(basket, HttpStatus.OK);
    }

    /////// POST
    @PostMapping(path = "/{basketId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Basket> addSingleItemToBasket(@PathVariable String basketId, @RequestBody Item item) {
        Basket basket = null;

        if ("new".equals(basketId)) {
            basket = new Basket(UUID.randomUUID());
        }
        else {
            basket = basketRepo.findById(UUID.fromString(basketId)).orElseThrow(() -> new NoSuchElementException());
        }

        basket.getItems().add(item);

        basketRepo.save(basket);

        return new ResponseEntity<Basket>(basket, HttpStatus.CREATED);
    }

    @PostMapping(path = "/additems/{basketId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Basket> addItemsToBasket(@PathVariable String basketId, @RequestBody List<Item> items) {
        Basket basket = null;

        if ("new".equals(basketId)) {
            basket = new Basket(UUID.randomUUID());
        }
        else {
            basket = basketRepo.findById(UUID.fromString(basketId)).orElseThrow(() -> new NoSuchElementException());
        }

        basket.getItems().addAll(items);

        basketRepo.save(basket);

        return new ResponseEntity<Basket>(basket, HttpStatus.CREATED);
    }

    /////// DELETE
    @DeleteMapping(path = "/{basketId}/{itemUUID}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteItemFromBasketById(@PathVariable UUID basketId, @PathVariable UUID itemUUID) {
        Basket basket = basketRepo.findById(basketId).orElseThrow(() -> new NoSuchElementException());
        basket.setItems(basket.getItems().stream().filter(i -> !i.getItemUUID().equals(itemUUID)).collect(Collectors.toList()));
        basketRepo.save(basket);
    }

    @DeleteMapping(path = "/{basketId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBasket(@PathVariable UUID basketId) {
        basketRepo.deleteById(basketId);
    }
}
