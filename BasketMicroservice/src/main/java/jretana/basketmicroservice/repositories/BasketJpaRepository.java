package jretana.basketmicroservice.repositories;

import jretana.basketmicroservice.model.Basket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BasketJpaRepository extends MongoRepository<Basket, UUID> {

}
