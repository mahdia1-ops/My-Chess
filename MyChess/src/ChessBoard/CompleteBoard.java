package ChessBoard;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.concurrent.atomic.AtomicInteger;

public class CompleteBoard extends Pane {
    public CompleteBoard() {
        //My button initilization
        GameBoard gameBoard = new GameBoard();
        Playbutton Buttons = new Playbutton();
        Settingsbutton Button = new Settingsbutton(gameBoard, gameBoard.getmyBoardsections());
        this.setStyle("-fx-background-color: white; ");

        Buttons.setPrefSize(100, 100);
        Button.setPrefSize(100,50);

        gameBoard.relocate(0,0);
        gameBoard.prefWidthProperty().bind(this.widthProperty().subtract(Buttons.widthProperty()));
        gameBoard.prefHeightProperty().bind(this.heightProperty());

        //Play Button
        Buttons.layoutXProperty().bind(this.widthProperty().subtract(Buttons.widthProperty()));
        Buttons.setLayoutY(0);

        //SettingsB utton
        Button.layoutXProperty().bind(Buttons.layoutXProperty());
        Button.layoutYProperty().bind(Buttons.layoutYProperty().add(100));

        this.getChildren().addAll(gameBoard,Button, Buttons);

    }
}