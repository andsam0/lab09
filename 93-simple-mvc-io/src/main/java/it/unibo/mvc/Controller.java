package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String HOME = System.getProperty("user.home");
    private static final String DEFAULT_FILE = "output.txt";
    private File dest = new File(HOME + System.getProperty("file.separator") + DEFAULT_FILE);
    
    public File getCurrentFile(){
        return dest;
    }
    
    public String getCurrentFilePath(){
        return dest.getPath();
    }

    public void save(String inputString){
        try(PrintStream ps = new PrintStream(dest, StandardCharsets.UTF_8)){
            ps.print(inputString);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void setCurrentFile(File newFile){
        dest = newFile;
    }


}
