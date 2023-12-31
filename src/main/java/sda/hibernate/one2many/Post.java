package sda.hibernate.one2many;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * - [PREZENTARE] prima data fa unidirectional, prezinta le adnotarile si ce inseamna EAGER vs LAZY
 * - doar aici exista o referinta catre Copii
 */

/**
 * Map Post class to 'posts' table as you did for UserEntity
 * For mapping one-to-many relationship:
 *  - declare a variable that holds a list of PostComments and initialize it with an empty list
 *  - annotate it with @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
 *  - annotate it with @JoinColumn(name = "post_id")
 *
 * Great job! You successfully map a one-to-many database relationship between two Java classes. Now lets put Hibernate on work!
 */

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "content")
    private String content;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private List<PostComment> comments = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<PostComment> getComments() {
        return comments;
    }

    public void setComments(List<PostComment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", comments=" + comments +
                '}';
    }
}
