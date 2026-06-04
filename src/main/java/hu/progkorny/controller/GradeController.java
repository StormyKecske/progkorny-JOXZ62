package hu.progkorny.controller;

import hu.progkorny.model.Grade;
import hu.progkorny.repository.GradeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    private final GradeRepository gradeRepository;

    public GradeController(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @GetMapping
    public List<Grade> getAll() {
        return gradeRepository.findAll();
    }

    @PostMapping
    public Grade create(@RequestBody Grade grade) {
        return gradeRepository.save(grade);
    }

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

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        if (!gradeRepository.existsById(id)) {
            throw new RuntimeException("Grade not found with id: " + id);
        }
        gradeRepository.deleteById(id);
    }
}
