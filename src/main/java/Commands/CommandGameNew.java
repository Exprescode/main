package Commands;

import Exceptions.FarmioFatalException;
import Farmio.Farmer;
import Farmio.Farmio;
import Farmio.Level;
import Farmio.Storage;
import Exceptions.FarmioException;
import FrontEnd.Simulation;
import FrontEnd.Ui;

public class CommandGameNew extends Command {
    @Override
    public void execute(Farmio farmio) throws FarmioException, FarmioFatalException {
        Ui ui = farmio.getUi();
        Storage storage = farmio.getStorage();
        farmio.setFarmer(new Farmer());
        Level level = new Level(storage.getLevel(1.6), farmio.getFarmer());
        farmio.setLevel(level);
        farmio.getSimulation().animate("GameNew", 0 , true);
        ui.typeWriter("New Game Created! Starting tutorial...");
        int frameId = 0;
        for(String narrative: level.getNarratives()){
            ui.getInput();
            farmio.getSimulation().animate(level.getPath(), frameId++);
            ui.typeWriter(narrative);
        }
        farmio.setStage(Farmio.Stage.TASK_ADD);
    }
}