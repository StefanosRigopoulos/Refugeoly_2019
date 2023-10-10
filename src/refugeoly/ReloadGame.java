package refugeoly;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;

public class ReloadGame {
    
    public void reloadGame(Refugee[] Refugees){
        
        try {
            ObjectInputStream rlg = new ObjectInpurStream(new FileOutputStream(game));
        }
        catch (FileNotFoundException e){
            e.getMessage();
        }
    }
}
