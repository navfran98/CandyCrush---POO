package game.backend.level;

import game.backend.GameState;
import game.backend.element.Cherry;
import game.backend.element.Fruit;
import game.backend.element.Hazelnut;
import game.backend.element.Nothing;

public class Level2 extends Level {

    // if more fruits are desired, they should be added here
    private static final int NUMBER_OF_FRUITS = 2;
    private static final int FIRST_FRUIT_ROW = 3;
    private static final int FIRST_FRUIT_COLUMN = 3;
    private static final int SECOND_FRUIT_ROW = 6;
    private static final int SECOND_FRUIT_COLUMN = 6;

    private static final int MAX_MOVES = 30;

    @Override
    protected GameState newState() {
        return new Level2State(MAX_MOVES);
    }

    @Override
    protected void setSpecialElements(){
        g[FIRST_FRUIT_ROW][FIRST_FRUIT_COLUMN].setContent(new Cherry());
        g[SECOND_FRUIT_ROW][SECOND_FRUIT_COLUMN].setContent(new Hazelnut());
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean ret;
        if (ret = super.tryMove(i1, j1, i2, j2)) {
            state().addMove();
        }
        return ret;
    }

    private class Level2State extends GameState {

        private long maxMoves;

        @Override
        public String getCurrentState(){
            if(!gameOver()){
                return "Moves left: " + (maxMoves - getMoves()) + "  Fruits left: " + (NUMBER_OF_FRUITS - getSpecialElementsRemoved());
            }
            return super.getCurrentState();
        }

        public Level2State(int maxMoves) {
            this.maxMoves = maxMoves;
        }

        public boolean gameOver() {
            return playerWon() || getMoves() >= maxMoves;
        }

        public boolean playerWon() {
            int bottomRow = g.length-1;
            for (int i = 0; i < g.length && getSpecialElementsRemoved() != NUMBER_OF_FRUITS; i++) {
                if(g[bottomRow][i].getContent() instanceof Fruit){
                    addSpecialElementRemoved();
                    g[bottomRow][i].setContent(new Nothing());
                    fallElements();
                }
            }
            return getSpecialElementsRemoved() == NUMBER_OF_FRUITS;
        }
    }

}
