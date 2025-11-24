package co.com.andres.campus_universitario.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.andres.campus_universitario.model.Dto.ProfessorRequest;
import co.com.andres.campus_universitario.service.ProfessorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/professors")
@RequiredArgsConstructor
public class ProfessorController {

     private final ProfessorService professorService;

    @PostMapping("/create")
    public void createProfessor(@Valid @RequestBody ProfessorRequest professorRequest) {
        professorService.createProfessor(professorRequest);
    }

    @PutMapping("/update/{id}")
    public void updateProfessor(@PathVariable Long id, @Valid @RequestBody ProfessorRequest professorRequest) {
        professorService.updateProfessor(id, professorRequest );
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        professorService.deleteById(id);
    }
    @GetMapping("/get/{id}")
    public void getById(@PathVariable Long id) {
        professorService.getById(id);
    }

    @GetMapping("/getAll")
    public void getAllProfessors() {
        professorService.getAllProfessor();
    }

    @GetMapping("/email/{email}")
    public void getByEmail(@PathVariable String email) {
        professorService.getByEmail(email);
    }
    @GetMapping("/search/{text}")
    public void getByNameOrLastName(@PathVariable String text) {
        professorService.getByNameOrLastName(text);
    }
    
}
