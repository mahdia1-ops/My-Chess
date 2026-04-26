package ChessBoard;

import javafx.animation.ScaleTransition;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.util.concurrent.atomic.AtomicInteger;

public class Settingsbutton extends Button {

    private GridPane myBoard;
    private StackPane[][] myBoardsections;

    public Settingsbutton(GridPane myBoard, StackPane[][] myBoardsections) {
        this.setText("Settings");
        //Font where is also not working?
        this.setStyle("-fx-background-color: aqua; " +
                "-fx-border-color: blue; " +
                "-fx-border-width: 2; " +
                "-fx-border-radius: 5;" +
                "-fx-text-fill: black;" +
                "-fx-font-size: 15;" +
                "-fx-font-family: Roboto;" +
                "fx-font-weight: bold");

        ScaleTransition buttonGrow = new ScaleTransition(Duration.millis(500), this);
        buttonGrow.setToX(1.25);
        buttonGrow.setToY(1.25);
        ScaleTransition buttonShrink = new ScaleTransition(Duration.millis(100),this);
        buttonShrink.setToX(1.0);
        buttonShrink.setToY(1.0);

        this.setOnMouseEntered(e -> {
            buttonGrow.playFromStart();
        });
        this.setOnMouseExited(e -> {
            buttonShrink.playFromStart();
        });
        this.myBoard = myBoard;
        this.myBoardsections = myBoardsections;

        AtomicInteger rotale = new AtomicInteger();
        this.setOnMouseClicked(e -> {
            if (rotale.get() == 0){
                myBoard.setRotate(180);
                rotale.incrementAndGet();
            } else {
                myBoard.setRotate(0);
                rotale.set(0);

            }
            if (myBoard.getRotate() == 180){
                for(int i = 0; i < 8; i++){
                    for(int j = 0; j < 8; j++){
                        myBoardsections[i][j].setRotate(180);
                    }
                }
            } else {
                for(int i = 0; i < 8; i++){
                    for(int j = 0; j < 8; j++){
                        myBoardsections[i][j].setRotate(0);
                    }
                }
            }

        });

    }
}