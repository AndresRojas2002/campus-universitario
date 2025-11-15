package co.com.andres.campus_universitario.config.exception.StudentsException;

public class StudentsByIdNotExistException extends RuntimeException {

    public StudentsByIdNotExistException(String message) {
        super(message);

    }

}
