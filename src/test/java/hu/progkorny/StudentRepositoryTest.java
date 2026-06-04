package hu.progkorny;

import hu.progkorny.model.Student;
import hu.progkorny.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testCreateStudent() {
        // Arrange
        Student student = new Student("Teszt Elek");

        // Act
        Student saved = studentRepository.save(student);

        // Assert
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getName()).isEqualTo("Teszt Elek");
    }
}
