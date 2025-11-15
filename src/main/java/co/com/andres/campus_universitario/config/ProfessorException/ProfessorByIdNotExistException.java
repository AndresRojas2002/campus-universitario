package co.com.andres.campus_universitario.config.ProfessorException;

public class ProfessorByIdNotExistException extends RuntimeException{

    public ProfessorByIdNotExistException(String message){
        super(message);
    }
}
