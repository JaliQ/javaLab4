package ca.bc.bcit.comp2522.lab04;

/**
 * @author Nickolay Makarenko
 * @author Alex He
 * @version 1.0
 */
public class Biography extends Book {
    private Person subject;
    public Biography(String title, int yearPublished, Author author, Person subject) {
        super(title, yearPublished, author);
        checkSubject(subject);
        this.subject = subject;
    }

    private void checkSubject(Person subject){
        if (subject == null) {
            throw new IllegalArgumentException("Subject cannot be null");
        }
    }
    @Override
    public void display() {
        super.display();
        System.out.println("Subject:");
        subject.display();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        {
            return true;
        }
        if (obj == null ||
            getClass() != obj.getClass())
        {
            return false;
        }

        Biography biography = (Biography) obj;
        return subject.equals(biography.subject);
    }
}