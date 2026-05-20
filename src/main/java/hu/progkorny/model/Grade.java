package hu.progkorny.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    @Column(name = "grade_value")
    private int value;

    @ManyToOne
    @JsonIgnore
    private Student student;

    public Grade() {
    }

    public Grade(String subject, int value, Student student) {
        this.subject = subject;
        this.value = value;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public int getValue() {
        return value;
    }

    public Student getStudent() {
        return student;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
