package it.unibo.mvc;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String nextString = null;
    private List<String> history = new ArrayList<>();

    @Override
    public void setNextString(String input){
        Objects.requireNonNull(input);
        this.nextString = input;
    }

    @Override
    public String getNextString() {
        return this.nextString;
    }

    @Override
    public List<String> getHistory() {
        return history;
    }

    @Override
    public void printString() {
        if(nextString != null){
            history.add(nextString);
            System.out.println(nextString);
            nextString = null;
        }else{
            throw new IllegalStateException("No string is set");
        }
    }

}
