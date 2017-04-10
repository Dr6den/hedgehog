package hedge.util;

import hedge.entity.AppleTreeCoordinates;
import hedge.entity.Garden;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author andrew
 */
public class TextFileParserTest {
    List<String> lines;
    
    public TextFileParserTest() {
    }
    
    @Before
    public void setUp() {
        lines = new ArrayList();
        lines.add("15 10");
        lines.add("1 2 3");
        lines.add("4 5 6");
        lines.add("10 11 12");
    }
    
    @Test
    public void parseTextFileTest() {
        TextFileParser parser = new TextFileParser();
        Garden garden = parser.parseTextFile(lines);
        
        assertNotNull(garden);
        assertEquals(garden.getxTerritoryMetres(), 15);
        assertEquals(garden.getyTerritoryMetres(), 10);
        
        List<AppleTreeCoordinates> coord = garden.getTrees();
        
        assertNotNull(coord);
        assertEquals(coord.get(0).getNumberOfApples(), 1);
        assertEquals(coord.get(0).getX(), 2);
        assertEquals(coord.get(0).getY(), 3);
        assertEquals(coord.get(1).getX(), 5);
        assertEquals(coord.get(2).getNumberOfApples(), 10);
        assertEquals(coord.get(2).getX(), 11);
        assertEquals(coord.get(2).getY(), 12);
    }
}
