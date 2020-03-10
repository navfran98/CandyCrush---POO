package game.backend.element;

public abstract class Fruit extends Element {

    @Override
    public boolean isExplodable(){
        return false;
    }

    @Override
    public boolean isMovable() {
        return true;
    }

    @Override
    public String getKey() {
        return "FRUIT";
    }

    @Override
    public boolean isSpecial(){
        return true;
    }
}
