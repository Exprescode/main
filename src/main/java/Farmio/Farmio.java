package Farmio;

import Commands.Command;
import FarmioExceptions.FarmioException;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Farmio {
    private Storage storage;
    private Farmer farmer;
    private Ui ui;
    private Level level;
    private boolean isExit;
    private Stage stage;

    private Farmio() {
        this.storage = new Storage();
        this.ui = new Ui(storage);
        stage = Stage.WELCOME;
        isExit = false;
    }

    private void run() {
        ui.showWelcome();
        Command command;
        while(!isExit){
            try {
                command = Parser.parse(ui.getInput(), stage);
                //command.execute(this);
            } catch (FarmioException e) {
                ui.showWarning(e.getMessage());
            }
        }
        ui.showExit();
//        displayWelcome();
//        displayMenu();
//        this.parser = new Farmio.Parser(ui, storage, farmer);
//        boolean isExit = false;
//        while(!isExit) {
//            //introduce the problem, and show the tutorial, and show the conditions and the possible tasks and gets the user input
//            loadLevel(farmer);
//            //create the new task, and add to the tasklist or do whatever
//            isExit = getUserActions(farmer, ui, parser);
//            if (isExit) {
//                break;
//            }
//            farmer.startDay();
//            try {
//                Farmio.Storage.storeFarmer(farmer);
//            } catch (IOException e) {
//                ui.showError("Unsuccessful game save.");
//                ui.showInfo("No gave save was done.");
//            }
//            checkObjectives(farmer);
//        }
    }

    public static void main(String[] args) {    //TODO - configure both OS
        new Farmio().run();
    }

    public static enum Stage {
        WELCOME, MENU_START, TASK_ADD
    }

    public Storage getStorage() {
        return storage;
    }

    public Ui getUi() {
        return ui;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public Stage getStage() {
        return stage;
    }

    public Level getLevel(){
        return level;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void setLevel(Level level){
        this.level = level;
    }

    public void setExit(){
        this.isExit = true;
    }

//    public boolean getUserActions(Farmer farmer, Ui ui, Parser parser) {
//        boolean isStart = false;
//        boolean isExit = false;
//        while (!isStart && !isExit) {
//            String fullCommand = ui.getInput();
//            try {
//                Command c = Parser.parse(fullCommand);
//                c.execute();
//                isStart =  c.getIsStart();
//                isExit = c.getIsExit();
//            } catch (FarmioException e) {
//                e.getMessage();
//            }
//        }
//        return isExit;
//    }

//    private void loadLevel(Farmer farmer) {
//        switch (farmer.level) {
//            case 1:
//                //in the future, will be simulating instead of just showing static message
//                displayArt("level1");
//                break;
//            /*
//            case 2:
//                displayArt("level2");
//                break;
//            case 3:
//                displayArt("level3");
//                break;
//            case 4:
//                displayArt("level4");
//                break;
//             */
//        }
//        ui.getEnter();
//    }

//    private void checkObjectives(Farmer farmer) {
//        //in future, end of day will also do other stuff like making the plant grow etc
//        ui.show("End of Day!");
//        ui.getEnter();
//    }
}