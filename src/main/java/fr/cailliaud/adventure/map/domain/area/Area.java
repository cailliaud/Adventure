package fr.cailliaud.adventure.map.domain.area;

import lombok.Getter;

@Getter
public abstract class Area {

    protected boolean isReachable;

    public Area(boolean isReachable) {
        this.isReachable = isReachable;
    }

    public abstract void visit();

    public abstract void leave();
}
