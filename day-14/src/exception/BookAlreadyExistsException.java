package exception;

public class BookAlreadyExistsException extends LibraryException{
    public BookAlreadyExistsException(String message)
    {
        super(message);
    }
}
