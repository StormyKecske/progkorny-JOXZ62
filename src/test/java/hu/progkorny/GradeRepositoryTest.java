package hu.progkorny;

import hu.progkorny.model.Grade;
import hu.progkorny.model.Student;
import hu.progkorny.repository.GradeRepository;
import hu.progkorny.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class GradeRepositoryTest {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testCreateGrade() {
        // Arrange
        Student student = new Student("Teszt Elek");
        Student savedStudent = studentRepository.save(student);

        Grade grade = new Grade("Matematika", 5, savedStudent);

        // Act
        Grade savedGrade = gradeRepository.save(grade);

        // Assert
        assertThat(savedGrade.getId()).isNotNull();
        assertThat(savedGrade.getSubject()).isEqualTo("Matematika");
        assertThat(savedGrade.getValue()).isEqualTo(5);
        assertThat(savedGrade.getStudent().getId()).isEqualTo(savedStudent.getId());
    }
}
