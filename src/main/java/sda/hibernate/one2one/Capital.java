package sda.hibernate.one2one;

/**
 * Map Capital class to 'capitals' table as you did for UserEntity
 * For mapping one-to-one relationship:
 *  - declare a variable of type Country
 *  - annotate it with @OneToOne(mappedBy = "capital", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
 *  - 'mappedBy' attribute tells Hibernate that Country is the owning side of the relationship (only Country changes will be propagated to db)
 *
 * Great job! You successfully map a one-to-one relationship between two Java classes. Now lets put Hibernate on work!
 */

public class Capital {

}
