package hedge.hog;


import hedge.entity.Garden;
import hedge.util.TextFileParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

/**
 *
 * @author andrew
 */
public class MainTest {
    
    public MainTest() {
    }
    
    @Test
    public void goTroughTheMostPollutedByApplesWayWithLoseCalculation() {
        try {
            Path currentRelativePath = Paths.get("src/main/resources/input.txt");
            Path resultPath = Paths.get("src/main/resources/outputWithCorrelation.txt");
            Files.deleteIfExists(resultPath);           
            Files.createFile(resultPath);
            
            List<String> lines = Files.readAllLines(currentRelativePath);
            TextFileParser parser = new TextFileParser();
            Garden garden = parser.parseTextFile(lines);
            
            List<String> output = new ArrayList<>();
            Hedgehog hog = new Hedgehog();            
            output.add("" + hog.goWithLoseCalculation(garden, 1, 1));
            Files.write(resultPath, output);
            System.out.println(output.parallelStream().map((String r) -> Integer.parseInt(r)).max(Integer::compare).get());
        } catch (IOException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void goTroughTheMostPollutedByApplesWay() {
        try {
            Path currentRelativePath = Paths.get("src/main/resources/input.txt");
            Path resultPath = Paths.get("src/main/resources/output.txt");
            Files.deleteIfExists(resultPath);           
            Files.createFile(resultPath);
            
            List<String> lines = Files.readAllLines(currentRelativePath);
            TextFileParser parser = new TextFileParser();
            Garden garden = parser.parseTextFile(lines);
            
            List<String> output = new ArrayList<>();
            Hedgehog hog = new Hedgehog();
            output.add("" + hog.go(garden, 1, 1));
            Files.write(resultPath, output);
            System.out.println(output.parallelStream().map((String r) -> Integer.parseInt(r)).max(Integer::compare).get());
        } catch (IOException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    *Tests for manyApples tree
    */
    
    //@Test
    public void goTroughTheMostPollutedByApplesWayWithLoseCalculation_MANYAPPLES() {
        try {
            Path currentRelativePath = Paths.get("src/main/resources/inputFewApples.txt");
            Path resultPath = Paths.get("src/main/resources/outputWithCorrelationMANYAPPLES.txt");
            Files.deleteIfExists(resultPath);           
            Files.createFile(resultPath);
            
            List<String> lines = Files.readAllLines(currentRelativePath);
            TextFileParser parser = new TextFileParser();
            Garden garden = parser.parseTextFile(lines);
            
            List<String> output = new ArrayList<>();
            Hedgehog hog = new Hedgehog();            
            output.add("" + hog.goWithLoseCalculation(garden, 1, 1));
            Files.write(resultPath, output);
            System.out.println(output.parallelStream().map((String r) -> Integer.parseInt(r)).max(Integer::compare).get());
        } catch (IOException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //@Test
    public void goTroughTheMostPollutedByApplesWay_MANYAPPLES() {
        try {
            Path currentRelativePath = Paths.get("src/main/resources/inputFewApples.txt");
            Path resultPath = Paths.get("src/main/resources/outputMANYAPPLES.txt");
            Files.deleteIfExists(resultPath);           
            Files.createFile(resultPath);
            
            List<String> lines = Files.readAllLines(currentRelativePath);
            TextFileParser parser = new TextFileParser();
            Garden garden = parser.parseTextFile(lines);
            
            List<String> output = new ArrayList<>();
            Hedgehog hog = new Hedgehog();
            output.add("" + hog.go(garden, 1, 1));
            Files.write(resultPath, output);
            System.out.println(output.parallelStream().map((String r) -> Integer.parseInt(r)).max(Integer::compare).get());
        } catch (IOException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //@Test
    public void randomWayTest() {
        try {
            Path currentRelativePath = Paths.get("src/main/resources/input.txt");
            Path resultPath = Paths.get("src/main/resources/output.txt");
            Files.deleteIfExists(resultPath);           
            Files.createFile(resultPath);
            
            List<String> lines = Files.readAllLines(currentRelativePath);
            TextFileParser parser = new TextFileParser();
            Garden garden = parser.parseTextFile(lines);
            
            List<String> output = new ArrayList<>();
            Hedgehog hog = new Hedgehog();
            for (int i = 1; i < 100000; i++) {
                output.add("" + hog.goRandom(garden, 1, 1));
            }
            Files.write(resultPath, output);
            System.out.println(output.parallelStream().map((String r) -> Integer.parseInt(r)).max(Integer::compare).get());
        } catch (IOException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
