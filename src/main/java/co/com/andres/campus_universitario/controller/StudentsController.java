package co.com.andres.campus_universitario.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.andres.campus_universitario.model.Dto.StudentsRequest;
import co.com.andres.campus_universitario.service.StudentsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentsController {

    private final StudentsService studentsService;

    @PostMapping("/create")
    public void createStudents(@Valid @RequestBody StudentsRequest studentsRequest) {
        studentsService.createStudents(studentsRequest);
    }

    @PutMapping("/update/{id}")
    public void updateStudents(@PathVariable Long id, @Valid @RequestBody StudentsRequest studentsRequest) {
        studentsService.updateStudents(id, studentsRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudents(@PathVariable Long id) {
        studentsService.deleteById(id);
    }
    @GetMapping("/get/{id}")
    public void getById(@PathVariable Long id) {
        studentsService.getById(id);
    }

    @GetMapping("/getAll")
    public void getAllStudents() {
        studentsService.getAllStudents();
    }

    @GetMapping("/email/{email}")
    public void getByEmail(@PathVariable String email) {
        studentsService.getByEmail(email);
    }
    @GetMapping("/search/{text}")
    public void getByNameOrLastName(@PathVariable String text) {
        studentsService.getByNameOrLastName(text);
    }
}
