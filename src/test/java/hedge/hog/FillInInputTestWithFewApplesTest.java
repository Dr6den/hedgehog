package hedge.hog;

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
public class FillInInputTestWithFewApplesTest {
    private final int xSizeOfField = 150;
    private final int ySizeOfField = 100;
    
    @Test
    public void inputTest() {
        List<String> lines = new ArrayList<>();
        try {
            Path currentRelativePath = Paths.get("src/main/resources/inputFewApples.txt");
            Files.deleteIfExists(currentRelativePath);           
            Files.createFile(currentRelativePath);
            lines = TextFileParser.fillTextFileWithRandomNumbers(lines, 100, xSizeOfField, ySizeOfField, 9);
            Files.write(currentRelativePath, lines);
        } catch (IOException ex) {
            Logger.getLogger(FillInInputTestWithFewApplesTest.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
