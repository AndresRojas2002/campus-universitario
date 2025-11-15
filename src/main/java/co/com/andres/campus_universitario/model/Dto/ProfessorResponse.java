package co.com.andres.campus_universitario.model.Dto;

import co.com.andres.campus_universitario.model.shared.Role;

public record ProfessorResponse(
        Long id,
        
        String lastName,

        String phone,

        String addres,

        String email,

        Role role) {

}
