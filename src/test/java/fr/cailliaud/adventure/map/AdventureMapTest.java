package fr.cailliaud.adventure.map;

import fr.cailliaud.adventure.map.domain.Position;
import fr.cailliaud.adventure.map.domain.area.ClassicalArea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AdventureMapTest {

    @Test
    public void default_structure_should_contans_only_classical_area(){
        // -- Given
        AdventureMap.Builder builder = new AdventureMap.Builder();


        // -- When
        AdventureMap map = builder.withLength(4).withWidth(4).build();

        // -- Then
        for(int i=0; i<4; i++){
            for(int j = 0; j<4; j++){
                Assertions.assertTrue(map.getStructure()[i][j] instanceof ClassicalArea);
            }
        }
    }

    @Test
    public void get_area_should_return_null_if_out_of_bound(){
        // -- Given
        AdventureMap.Builder builder = new AdventureMap.Builder();
        AdventureMap map = builder.withLength(4).withWidth(4).build();

        // -- When
        Assertions.assertAll(
                () -> Assertions.assertNull( map.getArea(new Position(5,3))),
                () -> Assertions.assertNull( map.getArea(new Position(3,5)))
        );

    }

    @Test
    public void get_area_should_return_area_if_correct_values(){
        // -- Given
        AdventureMap.Builder builder = new AdventureMap.Builder();
        AdventureMap map = builder.withLength(4).withWidth(4).build();

        // -- When
        Assertions.assertAll(
                () -> Assertions.assertNotNull(map.getArea(new Position(3,3))),
                () -> Assertions.assertNotNull( map.getArea(new Position(3,0))),
                () -> Assertions.assertNotNull( map.getArea(new Position(0,3))),
                () -> Assertions.assertNotNull( map.getArea(new Position(0,0)))
        );

    }


}