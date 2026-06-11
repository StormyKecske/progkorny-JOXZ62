package hu.progkorny.controller;

import hu.progkorny.model.Grade;
import hu.progkorny.repository.GradeRepository;
import hu.progkorny.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;

    public GradeController(GradeRepository gradeRepository, StudentRepository studentRepository) {
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
    }

    // GET – összes jegy
    @GetMapping
    public List<Grade> getAll() {
        return gradeRepository.findAll();
    }

    // GET – egy jegy ID alapján
    @GetMapping("/{id}")
    public Grade getById(@PathVariable Long id) {
        return gradeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grade not found with id: " + id));
    }

    // POST – új jegy létrehozása
    @PostMapping
    public Grade create(@RequestBody Grade grade) {
        return gradeRepository.save(grade);
    }

    // PUT – meglévő jegy módosítása
    @PutMapping("/{id}")
    public Grade update(@PathVariable Long id, @RequestBody Grade updatedGrade) {
        return gradeRepository.findById(id)
                .map(grade -> {
                    grade.setSubject(updatedGrade.getSubject());
                    grade.setValue(updatedGrade.getValue());
                    grade.setStudent(updatedGrade.getStudent());
                    return gradeRepository.save(grade);
                })
                .orElseThrow(() -> new RuntimeException("Grade not found with id: " + id));
    }

    // DELETE – jegy törlése
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        if (!gradeRepository.existsById(id)) {
            throw new RuntimeException("Grade not found with id: " + id);
        }
        gradeRepository.deleteById(id);
    }
}
