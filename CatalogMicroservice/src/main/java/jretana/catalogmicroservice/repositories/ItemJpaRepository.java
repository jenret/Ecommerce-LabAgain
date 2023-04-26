package jretana.catalogmicroservice.repositories;

import jretana.catalogmicroservice.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemJpaRepository extends MongoRepository<Item, UUID> {

    List<Item> findItemsByItemNameOrDescription(String s, String s2);

    List<Item> findItemsByItemNameContainingOrDescriptionContaining(String s, String s2);
}
