package sda.hibernate.one2many;

/**
 * Map Post class to 'posts' table as you did for UserEntity
 * For mapping one-to-many relationship:
 *  - declare a variable that holds a list of PostComments and initialize it with an empty list
 *  - annotate it with @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
 *  - annotate it with @JoinColumn(name = "post_id")
 *
 * Great job! You successfully map a one-to-many database relationship between two Java classes. Now lets put Hibernate on work!
 */

/**
 * Bidirectional (secondly):
 *  - declare a variable that holds a list of PostComments and initialize it with an empty list
 *  - annotate it with @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
 *  - add 2 utility methods that keeps both sides of the association in sink:
 *      - addComment - add to collection and set 'this' as parent
 *      - removeComment - remove from collection and set 'null' as parent
 */


public class Post {

}
