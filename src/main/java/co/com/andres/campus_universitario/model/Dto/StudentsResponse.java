package co.com.andres.campus_universitario.model.Dto;



import co.com.andres.campus_universitario.model.shared.Role;


public record StudentsResponse(
        Long id,

        String name,

        String lastName,

        String phone,
     
        String addres,

        String gmail,

        Role role
         ) {

}
