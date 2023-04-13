package com.userpanel.userpanel.util.exception;

public class FileException extends RuntimeException {
    public FileException() {
        super("Folder for storing file not found");
    }
}
