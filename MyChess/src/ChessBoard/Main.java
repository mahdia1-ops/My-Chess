package ChessBoard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        CompleteBoard completeBoard = new CompleteBoard();
        Scene scene = new Scene(completeBoard,800, 600);
        stage.setTitle("Chess Board");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}