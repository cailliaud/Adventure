package fr.cailliaud.adventure.reader;

import fr.cailliaud.adventure.map.domain.area.Area;
import fr.cailliaud.adventure.map.domain.area.ClassicalArea;
import fr.cailliaud.adventure.map.domain.area.TreasureArea;
import fr.cailliaud.adventure.map.domain.area.UnreachableArea;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AreaType {

    MOUNTAIN("M", UnreachableArea.class),
    TREASURE("T", TreasureArea.class),
    PLAIN("P", ClassicalArea.class);

    private String key;
    private Class< ? extends Area> areaClass;

}
