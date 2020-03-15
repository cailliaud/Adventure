package fr.cailliaud.adventure.map.domain.area;

public class ClassicalArea extends Area {
    public ClassicalArea() {
        super(true);
    }

    @Override
    public void visit() {
        this.isReachable = false;
    }

    @Override
    public void leave() {
        this.isReachable = true;
    }
}
