package hedge.entity;

import java.util.List;

/**
 *
 * @author andrew
 */
public class Garden {
    private int xTerritoryMetres;
    private int yTerritoryMetres;
    private List<AppleTreeCoordinates> trees;

    public int getxTerritoryMetres() {
        return xTerritoryMetres;
    }

    public void setxTerritoryMetres(int xTerritoryMetres) {
        this.xTerritoryMetres = xTerritoryMetres;
    }

    public int getyTerritoryMetres() {
        return yTerritoryMetres;
    }

    public void setyTerritoryMetres(int yTerritoryMetres) {
        this.yTerritoryMetres = yTerritoryMetres;
    }

    public List<AppleTreeCoordinates> getTrees() {
        return trees;
    }

    public void setTrees(List<AppleTreeCoordinates> trees) {
        this.trees = trees;
    }
    
    public int sumOfAplesAcrossYline(int x, int y) {
        int sum = 0;
        sum = this.trees.stream().filter((AppleTreeCoordinates t) -> {return ((t.getX() == x && t.getY() >= y));})
                .map(AppleTreeCoordinates::getNumberOfApples)
                .reduce(0, (prevNumOfApples, currNumOfApples) -> prevNumOfApples + currNumOfApples);
        return sum;
    }
    
    public int sumOfAplesAcrossXline(int x, int y) {
        int sum = 0;
        sum = this.trees.stream().filter((AppleTreeCoordinates t) -> {return ((t.getX() >= x && t.getY() == y));})
                .map(AppleTreeCoordinates::getNumberOfApples)
                .reduce(0, (prevNumOfApples, currNumOfApples) -> prevNumOfApples + currNumOfApples);
        return sum;
    }
    
    public int getApplesFromDefinedPoint(int x, int y) {
        int sum = 0;
        sum = this.trees.stream().filter((AppleTreeCoordinates t) -> {return ((t.getX() == x && t.getY() == y));})
                .map(AppleTreeCoordinates::getNumberOfApples)
                .reduce(0, (prevNumOfApples, currNumOfApples) -> prevNumOfApples + currNumOfApples);
        return sum;
    }
    
    public int probabilityLoseApplesAfterDefinedStepsRight(int x, int y, int borderX) {
        final int steps;
        if (borderX > 12) {
            steps = (int) Math.floor((borderX - x) / 4);
        } else {
            steps = 3;
        }
        
        int currentSum = this.trees.parallelStream()
                .filter((AppleTreeCoordinates t) -> {return ((t.getX() >= x  && t.getY() >= y));})
                .map(AppleTreeCoordinates::getNumberOfApples)
                .reduce(0, (prevNumOfApples, currNumOfApples) -> prevNumOfApples + currNumOfApples);
        
        int sumAfterStepsToTheRight = this.trees.parallelStream()
                .filter((AppleTreeCoordinates t) -> {return ((t.getX() >= x + steps  && t.getY() >= y));})
                .map(AppleTreeCoordinates::getNumberOfApples)
                .reduce(0, (prevNumOfApples, currNumOfApples) -> prevNumOfApples + currNumOfApples);
        return currentSum - sumAfterStepsToTheRight;
    }
    
    public int probabilityLoseApplesAfterDefinedStepsDown(int x, int y, int borderY) {
        final int steps;
        if (borderY > 12) {
            steps = (int) Math.floor((borderY - y) / 4);
        } else {
            steps = 3;
        }
        
        int currentSum = this.trees.parallelStream()
                .filter((AppleTreeCoordinates t) -> {return ((t.getX() >= x  && t.getY() >= y));})
                .map(AppleTreeCoordinates::getNumberOfApples)
                .reduce(0, (prevNumOfApples, currNumOfApples) -> prevNumOfApples + currNumOfApples);
        
        int sumAfterStepsToTheRight = this.trees.parallelStream()
                .filter((AppleTreeCoordinates t) -> {return ((t.getX() >= x  && t.getY() >= y + steps));})
                .map(AppleTreeCoordinates::getNumberOfApples)
                .reduce(0, (prevNumOfApples, currNumOfApples) -> prevNumOfApples + currNumOfApples);
        return currentSum - sumAfterStepsToTheRight;
    }
    
    /**
     * 
     * @param x
     * @param y
     * @param borderX
     * @param borderY
     * @return advice: 0 - no advice, 1 advice to the right, -1 advice to the down
     */
    public byte adviceAccordingToTheLosePossibility(int x, int y, int borderX, int borderY) {
        int losesByX = probabilityLoseApplesAfterDefinedStepsRight(x, y, borderX);
        int losesByY = probabilityLoseApplesAfterDefinedStepsDown(x, y, borderY);
        if (losesByY == 0) return 0;
        double correlationLoses = (double) losesByX/losesByY; 
        if (correlationLoses > 0.7 && correlationLoses < 1.5) {
            return 0;
        } else if (correlationLoses > 1.4) {
            return -1;
        } else {
            return 1;
        }
    }
}
