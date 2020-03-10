package game.backend.level;

import game.backend.GameState;
import game.backend.element.*;

public class Level3 extends Level {

    // if more Timer Candy are desired, they should be added here
    private static final int NUMBER_OF_TIMER_CANDY = 3;

    // first Timer Candy PURPLE-COLOR
    private static final int FIRST_TIMER_CANDY__ROW = 1;
    private static final int FIRST_TIMER_CANDY__COLUMN = 1;
    private int firstTimer = 25;
    private TimerCandy candy1 = new TimerCandy(CandyColor.PURPLE, firstTimer);

    // second Timer Candy BLUE-COLOR
    private static final int SECOND_TIMER_CANDY__ROW = 3;
    private static final int SECOND_TIMER_CANDY_COLUMN = 3;
    private int secondTimer = 20;
    private TimerCandy candy2 = new TimerCandy(CandyColor.BLUE, secondTimer);

    // third Timer Candy RED-COLOR
    private static final int THIRD_TIMER_CANDY_ROW = 6;
    private static final int THIRD_TIMER_CANDY_COLUMN = 6;
    private int thirdTimer = 15;
    private TimerCandy candy3 = new TimerCandy(CandyColor.RED, thirdTimer);

    private int minTimer = obtainMinTimer();

    @Override
    public GameState newState(){
        return new Level3State();
    }

    @Override
    protected void setSpecialElements(){
        g[FIRST_TIMER_CANDY__ROW][FIRST_TIMER_CANDY__COLUMN].setContent(candy1);
        g[SECOND_TIMER_CANDY__ROW][SECOND_TIMER_CANDY_COLUMN].setContent(candy2);
        g[THIRD_TIMER_CANDY_ROW][THIRD_TIMER_CANDY_COLUMN].setContent(candy3);

        /* the rest of the method takes care of the cases in which, at the moment of setting a special element,
           it should be deleted because it formed a figure */
        if(tryRemove( g[FIRST_TIMER_CANDY__ROW][FIRST_TIMER_CANDY__COLUMN] ) != null){
            candy1.setTimer(-1);
        }
        if(tryRemove( g[SECOND_TIMER_CANDY__ROW][SECOND_TIMER_CANDY_COLUMN] ) != null){
            candy2.setTimer(-1);
        }
        if(tryRemove( g[THIRD_TIMER_CANDY_ROW][THIRD_TIMER_CANDY_COLUMN] ) != null){
            candy3.setTimer(-1);
        }
        fallElements();
        minTimer = obtainMinTimer();
    }

    private int obtainMinTimer(){
        int min;
        int aux1=candy1.getTimer();
        int aux2=candy2.getTimer();
        int aux3=candy3.getTimer();
        if(aux1>=0 && aux2>=0){
            min=(aux1<aux2)?aux1:aux2;
            if(aux3>=0 && min>aux3){
                min=aux3;
            }
        }
        else if(aux1<0 && aux2>=0){
            if(aux3>=0){
                min=(aux2 < aux3)? aux2 : aux3;
            }
            else{
                min=aux2;
            }
        }
        else if(aux1>=0 && aux2<0){
            if(aux3>=0){
                min=(aux1 < aux3)? aux1 : aux3;
            }
            else{
                min=aux1;
            }
        }
        else{
            if(aux3>=0){
                min=aux3;
            }
            else{
                min=-1;
            }
        }
        return min;
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2){
        boolean ret;
        if (ret = super.tryMove(i1, j1, i2, j2)) {
            candy1.decrementTimer();
            candy2.decrementTimer();
            candy3.decrementTimer();
            minTimer=obtainMinTimer();
        }
        return ret;
    }

    @Override
    public void removeSpecialElements(Element e) {
        String time = e.visualRepresentation();
        if(time!=null) {
            if (time.equals(String.valueOf(candy1.getTimer()))) {
                candy1.setTimer(-1);
            } else if (time.equals(String.valueOf(candy2.getTimer()))) {
                candy2.setTimer(-1);
            } else if (time.equals(String.valueOf(candy3.getTimer()))) {
                candy3.setTimer(-1);
            }
        }
    }

    private class Level3State extends GameState{

        @Override
        public String getCurrentState() {
            if(!gameOver()){
                return "Moves left : " + minTimer;
            }
            return super.getCurrentState();
        }

        @Override
        public boolean gameOver() {
            return playerWon() || minTimer < 1;
        }

        @Override
        public boolean playerWon() {
            return getSpecialElementsRemoved() == NUMBER_OF_TIMER_CANDY;
        }
    }

}
