package fr.cailliaud.adventure.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    @Test
    void readFile() throws URISyntaxException {
        //-- Given
        Path testFile = Path.of(this.getClass().getClassLoader().getResource("map.example").toURI());

        List<String> expectedLines = Arrays.asList(
                "C - 3 - 4",
                "M - 1 - 1",
                "M - 2 - 2",
                "T - 0 - 3 - 2",
                "T - 1 - 3 - 1"
        );

        //-- When
        FileReader reader =  new FileReader(testFile);

        //-- Then

    }
}