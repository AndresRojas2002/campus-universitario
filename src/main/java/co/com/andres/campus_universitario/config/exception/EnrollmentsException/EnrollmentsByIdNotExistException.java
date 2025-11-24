package co.com.andres.campus_universitario.config.exception.EnrollmentsException;

public class EnrollmentsByIdNotExistException  extends RuntimeException {
    public EnrollmentsByIdNotExistException(String message) {
        super(message);
    }
    
}
