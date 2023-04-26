package jretana.ordermicroservice.repositories;

import jretana.ordermicroservice.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderJpaRepository extends MongoRepository<Order, UUID> {
}
