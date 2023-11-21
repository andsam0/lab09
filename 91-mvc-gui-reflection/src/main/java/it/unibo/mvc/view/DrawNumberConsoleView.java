package it.unibo.mvc.view;

import java.io.*;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberConsoleView implements DrawNumberView{

    private DrawNumberController controller;

    public void insertNumber() throws IOException{
        System.out.println("Insert a number: ");

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));){
            String input = reader.readLine();
            try{
                if(input.equals("e")){
                    controller.quit();
                }
                controller.newAttempt(Integer.parseInt(input));
            }catch (NumberFormatException exception) {
                System.out.println("An integer please..");
                insertNumber();
            }
        }
    }
    
    @Override
    public void setController(DrawNumberController observer) {
        this.controller = observer;
    }

    @Override
    public void start(){
        System.out.println("The game is started!\nType 'e' exit the game");
        try {
            insertNumber();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void result(DrawResult res) {
         switch (res) {
            case YOURS_HIGH, YOURS_LOW -> {
                System.out.println(res.getDescription());
                try {
                    insertNumber();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            case YOU_WON -> System.out.println(res.getDescription());
            case YOU_LOST -> System.out.println(res.getDescription());
            default -> throw new IllegalStateException("Unknown game state");
        }
        controller.resetGame();
    }
    
}
