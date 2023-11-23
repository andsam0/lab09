package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    public String getNextString();
    
    public void setNextString(String input);

    public List<String> getHistory();

    public void printString();
}
