package fr.cailliaud.adventure;

import fr.cailliaud.adventure.map.Orientation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrientationTest {

    @Test
    void next() {

        // -- Given
        Orientation west = Orientation.WEST;
        Orientation expected= Orientation.NORTH;

        // -- When
        Orientation actual = west.next();

        // -- Then
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void previous() {


        // -- Given
        Orientation west = Orientation.NORTH;
        Orientation expected= Orientation.WEST;

        // -- When
        Orientation actual = west.previous();

        // -- Then
        Assertions.assertEquals(expected,actual);
    }
}