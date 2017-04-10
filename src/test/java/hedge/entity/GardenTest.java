package hedge.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author andrew
 */
public class GardenTest {
    List<AppleTreeCoordinates> trees;
    Garden garden;
    
    public GardenTest() {
    }
    
    @Before
    public void setUp() {
        trees = new ArrayList<>();
        AppleTreeCoordinates tree1 = new AppleTreeCoordinates(1 ,2 ,3);
        AppleTreeCoordinates tree2 = new AppleTreeCoordinates(2 ,1 ,3);
        AppleTreeCoordinates tree3 = new AppleTreeCoordinates(1 ,4 ,1);
        AppleTreeCoordinates tree4 = new AppleTreeCoordinates(1 ,4 ,5);
        AppleTreeCoordinates tree5 = new AppleTreeCoordinates(3 ,5 ,4);
        AppleTreeCoordinates tree6 = new AppleTreeCoordinates(1 ,2 ,4);
        garden = new Garden();
        trees.add(tree1);
        trees.add(tree2);
        trees.add(tree3);
        trees.add(tree4);
        trees.add(tree5);
        trees.add(tree6);
        garden.setTrees(trees);
    }
    
    @Test
    public void sumOfAplesAcrossYlineTest() {
        assertEquals(garden.sumOfAplesAcrossYline(5, 5), 0);
        assertEquals(garden.sumOfAplesAcrossYline(1, 3), 3);
        assertEquals(garden.sumOfAplesAcrossYline(4, 1), 1);
        assertEquals(garden.sumOfAplesAcrossYline(1, 1), 1);
        assertEquals(garden.sumOfAplesAcrossYline(4, 1), 1);
    }
    
    @Test
    public void sumOfAplesAcrossXlineTest() {
        assertEquals(garden.sumOfAplesAcrossXline(5, 5), 0);
        assertEquals(garden.sumOfAplesAcrossXline(4, 5), 1);
        assertEquals(garden.sumOfAplesAcrossXline(4, 1), 2);
        assertEquals(garden.sumOfAplesAcrossXline(1, 1), 2);
        assertEquals(garden.sumOfAplesAcrossXline(5, 1), 3);
    }
}
