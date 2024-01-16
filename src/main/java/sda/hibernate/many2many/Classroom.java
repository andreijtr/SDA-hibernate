package sda.hibernate.many2many;

/**
 * Map Classroom class to 'classrooms' table as you did for UserEntity
 * For mapping many-to-many relationship:
 *  - declare a variable that holds a list of Trainers and initialize it with an empty list
 *  - annotate it with @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) - why do you think we omitted the CascadeType.REMOVE ?
 *  - annotate it with
 *      @JoinTable(name = "classroom_trainer",
 *         joinColumns = @JoinColumn(name = "classroom_id"),
 *         inverseJoinColumns = @JoinColumn(name = "trainer_id")
 *     )
 * - as this is whe owner of the relationship, we have to make 2 methods that keep relationship in sync (as we did for one-to-many)
 * - create a method 'addTrainer' that receive as parameter a Trainer and add it to trainers list declared above, and also add 'this' in trainer's classrooms
 * - create a method 'removeTrainer' that receive as parameter a Trainer and remove it from trainers list declared above, and also remove 'this' from trainer's classrooms
 *
 * Great job! You successfully map a many-to-many database relationship between two Java classes. Now lets put Hibernate on work!
 */

public class Classroom {

}
