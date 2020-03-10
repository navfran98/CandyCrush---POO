package game.frontend;

import game.backend.CandyGame;
import game.backend.level.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static javafx.geometry.Pos.CENTER;
import static javafx.geometry.Pos.CENTER_LEFT;

public class GameApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public void startLevel(Stage primaryStage, CandyGame game){
		CandyFrame frame = new CandyFrame(game);
		Scene scene = new Scene(frame);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void start(Stage primaryStage) {

		Font font = Font.font(30);

		// level 1 button
		Button level1Button = new Button();
		level1Button.setPrefSize(500, 50);
		level1Button.setStyle("-fx-border-color: #000000; -fx-background-color: #ff843e;-fx-border-width: 3px;");
		level1Button.setAlignment(CENTER_LEFT);
		level1Button.setText("Start Level 1: Score Level");
		level1Button.setFont(font);
		level1Button.setOnAction(event -> startLevel(primaryStage, new CandyGame(Level1.class)));

		// level 2 button
		Button level2Button = new Button();
		level2Button.setPrefSize(500, 50);
		level2Button.setStyle("-fx-border-color: #000000; -fx-background-color: #ff843e;-fx-border-width: 3px;");
		level2Button.setAlignment(CENTER_LEFT);
		level2Button.setText("Start Level 2: Fruit Level");
		level2Button.setFont(font);
		level2Button.setOnAction(event -> startLevel(primaryStage, new CandyGame(Level2.class)));

		// level 3 button
		Button level3Button = new Button();
		level3Button.setPrefSize(500, 50);
		level3Button.setStyle("-fx-border-color: #000000; -fx-background-color: #ff843e;-fx-border-width: 3px;");
		level3Button.setAlignment(CENTER_LEFT);
		level3Button.setText("Start Level 3: TimerBomb Level");
		level3Button.setFont(font);
		level3Button.setOnAction(event -> startLevel(primaryStage, new CandyGame(Level3.class)));

		// we chose a VBox layout
		VBox layout = new VBox();
		layout.setStyle("-fx-background-color: linear-gradient(to bottom, derive(cadetblue, 20%), cadetblue)");
		layout.setSpacing(20);
		layout.setAlignment(CENTER);
		layout.getChildren().addAll(level1Button, level2Button, level3Button);

		// scene
		Scene scene = new Scene(layout, 600, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Candy Crush Game");
		primaryStage.show();
	}

}
