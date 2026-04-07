package excepciones;

public class InvalidLoginUserException extends Exception{

    public InvalidLoginUserException(String message){
        super(message);
    }
}
