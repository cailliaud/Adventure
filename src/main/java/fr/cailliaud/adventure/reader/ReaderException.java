package fr.cailliaud.adventure.reader;

public class ReaderException extends RuntimeException {

    public ReaderException(String message){
        super(message);
    }

    public ReaderException(String message, Throwable throwable){
        super(message,throwable);
    }
}
