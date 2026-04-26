package ChessBoard;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


public class GameBoard extends GridPane {
    public StackPane[][] Sections;

    public GameBoard() {
        String[] typeofPece = {"Rook","Knight","Bishop","Queen", "King", "Bishop", "Knight","Rook"};



        this.isResizable();
        this.setAlignment(Pos.CENTER);
        this.setHgap(0);
        this.setVgap(0);
        this.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, null, null)));

        Sections = new StackPane[8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j <8; j++){
                StackPane section = new StackPane();
                section.setPrefSize(120,120);

                if ((i + j) % 2 == 0){
                    section.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
                    this.add(section, i, j);
                } else {
                    section.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, null, null)));
                    this.add(section, i, j);
                }
                Sections[i][j] = section;
            }
        }
        for (int i = 0; i < 8; i++){
            ZaChessPeizes blackpeices = new ZaChessPeizes(false,typeofPece[i]);
            Sections[i][0].getChildren().add(blackpeices);
        }
        for (int i = 0; i < 8; i++){
            ZaChessPeizes blackpawns = new ZaChessPeizes(false,"Pawn");
            Sections[i][1].getChildren().add(blackpawns);
        }
        for (int i = 0; i < 8; i++){
            ZaChessPeizes whitepawns = new ZaChessPeizes(true,"Pawn");
            Sections[i][6].getChildren().add(whitepawns);
        }
        for (int i = 0; i < 8; i++){
            ZaChessPeizes whitepeices = new ZaChessPeizes(true,typeofPece[i]);
            Sections[i][7].getChildren().add(whitepeices);
        }
        RulesXPeices rules = new RulesXPeices(this, Sections);
    }
    public StackPane[][] getmyBoardsections() {
        return Sections;
    }
 }
