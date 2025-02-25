package ch.hftm.nosql.workspace.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import java.time.LocalDate;
import java.util.List;

@MongoEntity(collection = "tasks")
public class Task extends PanacheMongoEntity {
    public String title;
    public String description;
    public LocalDate dueDate;
    public String priority; // Low, Medium, High
    public String status;   // Pending, In Progress, Completed
    public String userId;
    public String categoryId;
    public List<Comment> comments; // Embedded Comments

    public Task() {}

    public Task(String title, String description, LocalDate dueDate, String priority, String status, String userId, String categoryId, List<Comment> comments) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
        this.userId = userId;
        this.categoryId = categoryId;
        this.comments = comments;
    }
}
