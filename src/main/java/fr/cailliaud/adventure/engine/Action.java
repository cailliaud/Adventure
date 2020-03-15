package fr.cailliaud.adventure.engine;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Action {
    GO_FORWARD("A"),
    TURN_LEFT("L"),
    TURN_RIGHT("R");


    private String key;

}
