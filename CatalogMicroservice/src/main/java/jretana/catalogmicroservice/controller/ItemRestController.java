package jretana.catalogmicroservice.controller;

import jretana.catalogmicroservice.model.Item;
import jretana.catalogmicroservice.repositories.ItemJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/item")
public class ItemRestController {

    @Autowired
    ItemJpaRepository itemRepo;


    /////// GET
    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Item>> findAllItems() {
        List<Item> items = itemRepo.findAll();
        return ResponseEntity.ok(items);
    }

    @GetMapping(path = "/search/{searchText}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Item>> searchItems(@PathVariable(required = true) String searchText) {
        List<Item> items = itemRepo.findItemsByItemNameContainingOrDescriptionContaining(searchText, searchText);
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

    @GetMapping(path = "/{itemUUID}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Item> getItem(@PathVariable(required = true) UUID itemUUID) {
        Item item = itemRepo.findById(itemUUID).orElseThrow(() -> new NoSuchElementException());
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    /////// POST
    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public void createItem(@RequestBody Item item) {
        item.setItemUUID(UUID.randomUUID());
        itemRepo.save(item);
    }

    @PostMapping(path = "/additems")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBooks(@RequestBody List<Item> items) {
        for (Item item : items) {
            createItem(item);
        }
    }

    /////// PUT
    @PutMapping(path = "/{itemUUID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateItem(@PathVariable(required = true) UUID itemUUID, @RequestBody Item item) {
        if (!item.getItemUUID().equals(itemUUID)) {
            throw new RuntimeException("The two values did not match");
        }

        itemRepo.save(item);
    }

    /////// DELETE
    @DeleteMapping(path = "/{itemUUID}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteItem(@PathVariable(required = true) UUID itemUUID) {
        itemRepo.deleteById(itemUUID);
    }
}
