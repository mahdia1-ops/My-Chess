package ChessBoard;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class  RulesXPeices  {
    private GridPane mygameBoard;
    private StackPane[][] Sections;
    public RulesXPeices(GridPane mygameBoard, StackPane[][] Sections) {
        ChessRules chessRules = new ChessRules();
        this.mygameBoard = mygameBoard;
        this.Sections = Sections;
        AtomicReference<Node> thisNode = new AtomicReference<>();
        AtomicInteger y = new AtomicInteger();
        AtomicInteger x = new AtomicInteger();
        this.mygameBoard.setOnMouseClicked(event -> {

            int fy;
            int fx;
            Node thingin = (Node) event.getTarget();
            if (!(thingin instanceof StackPane)){
                thingin = thingin.getParent();
            }
            if (thisNode.get() == null) {
                x.set(GridPane.getColumnIndex(thingin));
                y.set(GridPane.getRowIndex(thingin));
                thisNode.set(thingin);

            } else {

                fx = GridPane.getColumnIndex(thingin);
                fy = GridPane.getRowIndex(thingin);

                Node section = Sections[x.get()][y.get()].getChildren().get(0);
                ZaChessPeizes peiceinpeices = (ZaChessPeizes) section;
                peiceinpeices.getPeicetype();
                boolean amIpossible;
                     if (peiceinpeices.getPeicetype().equals("Pawn")) {
                        amIpossible = chessRules.rulesforzepawn(peiceinpeices.getAmIreich(), Sections,  y.get(), x.get(), fy, fx);
                    } else if(peiceinpeices.getPeicetype().equals("Queen")) {
                        amIpossible = chessRules.rulesforQueen( y.get(), x.get(), fy, fx);
                    } else if(peiceinpeices.getPeicetype().equals("Bishop")) {
                        amIpossible = chessRules.rulesforBishop(Sections, y.get(), x.get(), fy, fx);
                    } else if(peiceinpeices.getPeicetype().equals("Knight")) {
                        amIpossible = chessRules.rulesforknight( y.get(), x.get(), fy, fx);
                    } else if (peiceinpeices.getPeicetype().equals("Rook")) {
                        amIpossible = chessRules.rulesforRook( y.get(), x.get(), fy, fx);
                    } else {
                         amIpossible = chessRules.rulesforKing(y.get(), x.get(), fy, fx);
                     }

                     if (amIpossible ) {
                             Sections[x.get()][y.get()].getChildren().clear();
                             Sections[fx][fy].getChildren().clear();
                             Sections[fx][fy].getChildren().add(section);
                     }
                thisNode.set(null);
            }

        });
    }
}