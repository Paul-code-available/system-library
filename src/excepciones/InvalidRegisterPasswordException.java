package excepciones;

public class InvalidRegisterPasswordException extends Exception{

    public InvalidRegisterPasswordException(String message){
        super(message);
    }
}
