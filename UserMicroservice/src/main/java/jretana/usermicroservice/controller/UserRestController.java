package jretana.usermicroservice.controller;

import jretana.usermicroservice.model.Card;
import jretana.usermicroservice.model.User;
import jretana.usermicroservice.repositories.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserJpaRepository usersRepo;

    /////// GET
    @GetMapping(path = "/{userUUID}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> searchUser(@PathVariable(required = true)UUID userUUID) {
        User user = usersRepo.findById(userUUID).orElseThrow(() -> new NoSuchElementException());
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    // ONLY FOR TESTING
    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<User>> searchUser() {
        List<User> users = usersRepo.findAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    /////// POST
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        user.setUserUUID(UUID.randomUUID());
        usersRepo.save(user);
    }

    /////// PUT
    @PutMapping(path = "/{userUUID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable(required = true) UUID userUUID, @RequestBody User user) {
        if (!user.getUserUUID().equals(userUUID)) {
            throw new RuntimeException("The two values did not match");
        }

        usersRepo.save(user);
    }

    @PutMapping("/card/{userUUID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addCardToUser(@PathVariable(required = true) UUID userUUID, @RequestBody Card card) {
        User user = usersRepo.findById(userUUID).orElseThrow(() -> new NoSuchElementException());
        card.setCardUUID(UUID.randomUUID());
        user.getPaymentCards().add(card);
        usersRepo.save(user);
    }

    @PutMapping("/cards/{userUUID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addCardsToUser(@PathVariable(required = true) UUID userUUID, @RequestBody List<Card> cards) {
        User user = usersRepo.findById(userUUID).orElseThrow(() -> new NoSuchElementException());
        for (Card card:cards) {
            card.setCardUUID(UUID.randomUUID());
            user.getPaymentCards().add(card);
        }
        usersRepo.save(user);
    }

    /////// DELETE
    @DeleteMapping(path = "/{userUUID}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable(required = true) UUID userUUID) {
        usersRepo.deleteById(userUUID);
    }
}
