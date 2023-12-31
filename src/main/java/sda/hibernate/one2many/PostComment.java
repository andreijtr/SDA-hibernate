package sda.hibernate.one2many;

import jakarta.persistence.*;

/**
 * Map PostComment class to 'post_comments' table as you did for UserEntity
 */

@Entity
@Table(name = "post_comments")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "comment")
    private String comment;

    public PostComment() {
    }

    public PostComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "PostComment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
