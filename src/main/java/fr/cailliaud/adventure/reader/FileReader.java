package fr.cailliaud.adventure.reader;

import fr.cailliaud.adventure.map.domain.Position;
import fr.cailliaud.adventure.map.domain.area.Area;
import fr.cailliaud.adventure.player.Adventurer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader  implements GameInitParams{

    private final List<String> lines;


    public FileReader(Path filePath){
        lines = readFile(filePath);

    }

    private List<String> readFile(Path filePath) throws ReaderException {
        try (Stream<String> stream = Files.lines(filePath)) {
            return stream
                    .filter(line -> !line.startsWith("#"))
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new ReaderException("Cannot read input file",e);
        }

    }

    @Override
    public Adventurer getAdventurer() {

        return null;
    }

    @Override
    public int getMapLength() {
        return 0;
    }

    @Override
    public int getMapWidth() {
        return 0;
    }

    @Override
    public Map<Position, Area> getAreas() {
        return null;
    }
}
