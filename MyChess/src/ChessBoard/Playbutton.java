package ChessBoard;


import javafx.animation.ScaleTransition;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class Playbutton extends Button {
    public Playbutton(){
        this.setText("Play Chess");
        //Fonts not working?
        this.setStyle("-fx-background-color: pink; " +
                "-fx-border-color: #e74c3c; " +
                "-fx-border-width: 1; " +
                "-fx-border-radius: 5;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 15;" +
                "-fx-font-family: Inter;" +
                "fx-font-weight: bold");

        ScaleTransition buttonGrow = new ScaleTransition(Duration.millis(500), this);
        buttonGrow.setToX(1.25);
        buttonGrow.setToY(1.25);
        ScaleTransition buttonShrink = new ScaleTransition(Duration.millis(100),this);
        buttonShrink.setToX(1.0);
        buttonShrink.setToY(1.0);

        Backbtn backbtn = new Backbtn();
        PlayervsPlayerbtn onevsbtn = new PlayervsPlayerbtn();
        PlayervsBot botbtn = new PlayervsBot();
        this.getChildren().addAll(backbtn,onevsbtn,botbtn);

        this.setOnMouseEntered(e -> {
            buttonGrow.playFromStart();
        });
        this.setOnMouseExited(e -> {
            buttonShrink.playFromStart();
        });
        this.setOnMousePressed(e -> {
            backbtn.setVisible(true);
            onevsbtn.setVisible(true);
            botbtn.setVisible(true);
        });

    }
}
