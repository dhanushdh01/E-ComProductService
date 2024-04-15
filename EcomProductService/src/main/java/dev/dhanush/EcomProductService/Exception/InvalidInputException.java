package dev.dhanush.EcomProductService.Exception;

public class InvalidInputException extends  RuntimeException{
    public InvalidInputException(String message){
        super(message);
    }
}
