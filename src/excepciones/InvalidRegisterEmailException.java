package excepciones;

public class InvalidRegisterEmailException extends Exception{

    public InvalidRegisterEmailException(String message){
        super(message);
    }
}
