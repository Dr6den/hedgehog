package hedge.util;

import hedge.entity.AppleTreeCoordinates;
import hedge.entity.Garden;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author andrew
 */
public class TextFileParser {
    public Garden parseTextFile(List<String> lines) {        
        Garden garden = new Garden();
        String[] gardenSize = lines.get(0).split(" ");
        garden.setxTerritoryMetres(Integer.parseInt(gardenSize[0]));
        garden.setyTerritoryMetres(Integer.parseInt(gardenSize[1]));
        lines.remove(0);
        
        List<AppleTreeCoordinates> splittedLines = lines.stream().map((String p) -> {
            String[] coords = p.split(" ");
            AppleTreeCoordinates tree = new AppleTreeCoordinates(Integer.parseInt(coords[0]),
                    Integer.parseInt(coords[1]), Integer.parseInt(coords[2]));
            return tree;
        }).collect(Collectors.toList());

        garden.setTrees(splittedLines);
        return garden;
    }
    
    public static List<String> fillTextFileWithRandomNumbers(List<String> lines,
            int numberOfTreePosition, int xSizeOfField, int ySizeOfField, int maxNumApplesUnderTheTree) {
        int startValue = 1;
        lines.add(xSizeOfField + " " + ySizeOfField);
        
        Random random = new Random();
        for (int i = 0; i < numberOfTreePosition; i++) {
            StringBuilder line = new StringBuilder();
            line.append(startValue+ random.nextInt(maxNumApplesUnderTheTree));
            line.append(" ");
            line.append(startValue + random.nextInt(xSizeOfField));
            line.append(" ");
            line.append(startValue + random.nextInt(ySizeOfField));
            lines.add(line.toString());
        }
        return lines;
    }
}
