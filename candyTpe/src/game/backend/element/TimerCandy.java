package game.backend.element;

public class TimerCandy extends Candy {

    private int timer;

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getTimer() {
        return timer;
    }

    public void decrementTimer(){
        timer--;
    }

    @Override
    public String visualRepresentation(){
        return String.valueOf(timer);
    }

    public TimerCandy(CandyColor color, int timer) {
        super(color);
        this.timer = timer;
    }

    public TimerCandy(CandyColor color){
        super(color);
    }

    public TimerCandy(){
        super();
    }

    @Override
    public String getKey(){
        return "TIMER-" + super.getKey();
    }

    @Override
    public String getFullKey(){
        return "TIMER-" + super.getFullKey();
    }

    @Override
    public boolean isSpecial(){
        return true;
    }
}
