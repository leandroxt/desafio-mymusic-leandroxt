package br.com.ciandt.playlist.Exceptions;

public class NotFoundException extends Exception {
    public NotFoundException() {
        super();
    }

    public NotFoundException(String error) {
        super(error);
    }

    public NotFoundException(String error, Throwable err) {
        super(error, err);
    }
}
