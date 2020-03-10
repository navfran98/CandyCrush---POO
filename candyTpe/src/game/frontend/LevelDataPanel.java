package game.frontend;

import game.backend.CandyGame;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class LevelDataPanel extends BorderPane {

	private Label levelDataLabel;

	public LevelDataPanel(CandyGame game) {
		String initialMessage = game.getCurrentState();
		setStyle("-fx-background-color: #5490ff");
		levelDataLabel = new Label(initialMessage);
		levelDataLabel.setAlignment(Pos.CENTER);
		levelDataLabel.setStyle("-fx-font-size: 24");
		setCenter(levelDataLabel);
	}

	public void updateScore(String text) {
		levelDataLabel.setText(text);
	}

}