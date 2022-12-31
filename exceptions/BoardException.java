package exceptions;

public class BoardException extends Exception{
    private static final long serialVersionUID = 1L;
    public BoardException(String message){
        super(message);
    }
}
