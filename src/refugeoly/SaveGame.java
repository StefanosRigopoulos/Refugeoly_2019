package refugeoly;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SaveGame {
    
    public void saveGame(Refugee[] Refugees, int numPlayers){
        File game = new File("Saved Game");
        try {
            ObjectOutputStream svg = new ObjectOutputStream(new FileOutputStream(game));
            for (int i = 0; i < numPlayers; i++){
                svg.writeObject(Refugee[i]);
            }
            svg.close();
        }
        catch (FileNotFoundException e){
            e.getMessage();
        }
        catch (IOException e){
            e.getMessage();
        }
    }
}
