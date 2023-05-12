package exceptions;

public class WrongObjectType extends Exception{
    public WrongObjectType(){

    }

    public WrongObjectType(String string){
        super(string);
    }
}
