package ch.hftm.nosql.workspace.entity;

import java.time.Instant;

public class Comment {
    public String userId;
    public String comment;
    public Instant createdAt = Instant.now();

    public Comment() {}

    public Comment(String userId, String comment) {
        this.userId = userId;
        this.comment = comment;
    }
}
