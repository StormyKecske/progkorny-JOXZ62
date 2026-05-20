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
}
