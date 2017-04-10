package hedge.hog;

import hedge.entity.Garden;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andrew
 */
public class Hedgehog {
    public int goWithLoseCalculation(Garden garden, int startPointX, int startPointY) {
        int numberOfApples = 0;
        try {
            Path path = Paths.get("src/main/resources/logPathCorrelation.txt");
            Files.deleteIfExists(path);
            Files.createFile(path);
            List<String> lines = new ArrayList<>();
            
            int x = startPointX;
            int y = startPointY;
            int xBorder = garden.getxTerritoryMetres();
            int yBorder = garden.getyTerritoryMetres();
            boolean goToTheRight = false;
            while (x != xBorder || y != yBorder) {
                numberOfApples = numberOfApples + garden.getApplesFromDefinedPoint(x, y);
                byte advice = garden.adviceAccordingToTheLosePossibility(x, y, xBorder, yBorder);
                switch (advice) {
                    case 0:  goToTheRight = whetherGoToTheRightOrGoToTheDown(garden, x, y, xBorder, yBorder);
                    break;
                    case 1:  goToTheRight = true;
                    break;
                    case -1: goToTheRight = false;
                }
                if (goToTheRight && x < xBorder) {
                    x++;
                } else if (y < yBorder) {
                    y++;
                }
                lines.add(x + " " + y);
            }
            Files.write(path, lines);
        } catch (IOException ex) {
            Logger.getLogger(Hedgehog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numberOfApples;
    }
    
    public int go(Garden garden, int startPointX, int startPointY) {
        int numberOfApples = 0;
        try {
            Path path = Paths.get("src/main/resources/logPath.txt");
            Files.deleteIfExists(path);
            Files.createFile(path);
            List<String> lines = new ArrayList<>();
            
            int x = startPointX;
            int y = startPointY;
            int xBorder = garden.getxTerritoryMetres();
            int yBorder = garden.getyTerritoryMetres();
            while (x != xBorder || y != yBorder) {
                numberOfApples = numberOfApples + garden.getApplesFromDefinedPoint(x, y);
                boolean goToTheRight = whetherGoToTheRightOrGoToTheDown(garden, x, y, xBorder, yBorder);
                if (goToTheRight && x < xBorder) {
                    x++;
                } else if (y < yBorder) {
                    y++;
                }
                lines.add(x + " " + y);
            }
            Files.write(path, lines);
        } catch (IOException ex) {
            Logger.getLogger(Hedgehog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numberOfApples;
    }
    
    /**
     * 
     * @param garden
     * @param x
     * @param y
     * @return true if hedgehog have to go to the right, false if hedgehog have to go to the down
     */
    private boolean whetherGoToTheRightOrGoToTheDown(Garden garden, int x, int y, int borderX, int borderY) {
        int xSum = garden.sumOfAplesAcrossXline(x, y);
        int ySum =  garden.sumOfAplesAcrossYline(x, y);
        if (xSum == ySum) {
            if (x == borderX) {
                return false;
            } else if (y == borderY) {
                return true;
            }
            return whetherGoToTheRightOrGoToTheDown(garden, x + 1, y + 1, borderX, borderY);
        } else {
            return xSum > ySum;
        }
    }
    
    public int goRandom(Garden garden, int startPointX, int startPointY) {
        int numberOfApples = 0;
        int x = startPointX;
        int y = startPointY;
        Random rand = new Random();
        while (x < garden.getxTerritoryMetres() || y < garden.getyTerritoryMetres()) {
            numberOfApples = numberOfApples + garden.getApplesFromDefinedPoint(x, y);
            boolean goToTheRight = rand.nextBoolean();
            if (goToTheRight && x < garden.getxTerritoryMetres()) {
                x++;
            } else if (y < garden.getyTerritoryMetres()) {
                y++;
            }
        }
        return numberOfApples;
    }

}
