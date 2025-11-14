package co.com.andres.campus_universitario.model.entity;

import co.com.andres.campus_universitario.model.shared.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Professors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column 
    private String phone;

    @Column 
    private String addres;

    @Column (unique = true, nullable = false)
    private String gmail;

    @Column (unique = true, nullable = false)
    private String password;

    @Column (nullable = false)
    private Role role;

}


