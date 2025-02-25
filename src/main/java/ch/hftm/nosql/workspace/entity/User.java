package ch.hftm.nosql.workspace.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import java.time.Instant;

@MongoEntity(collection = "users")
public class User extends PanacheMongoEntity {
    public String name;
    public String email;
    public Instant createdAt = Instant.now();

    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
