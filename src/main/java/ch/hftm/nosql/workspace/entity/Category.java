package ch.hftm.nosql.workspace.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "categories")
public class Category extends PanacheMongoEntity {
    public String name;
    public String description;

    public Category() {}

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
