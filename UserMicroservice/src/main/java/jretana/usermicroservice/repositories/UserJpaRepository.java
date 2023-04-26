package jretana.usermicroservice.repositories;

import jretana.usermicroservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserJpaRepository extends MongoRepository<User, UUID> {
}
