package ChessBoard;


import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class ZaChessPeizes extends Rectangle {
    private boolean amIreich;
    private String peicetype;

    public ZaChessPeizes(boolean backorwhite, String typeofpeice) {
        Image path1 = new Image("White Chess pawn.png");
        Image path2 = new Image("Black Chess pawn.png");
        Image path3 = new Image("Black Bishop.png");
        Image path4 = new Image("Black Rook.png");
        Image path5 = new Image("Black Queen.png");
        Image path6 = new Image("Black King.png");
        Image path7 = new Image("Black Knight.png");
        Image path8 = new Image("White Bishop.png");
        Image path9 = new Image("White Rook.png");
        Image path10 = new Image("White Queen.png");
        Image path11 = new Image("White King.png");
        Image path12 = new Image("White Knight.png");

        this.amIreich = backorwhite;
        this.peicetype = typeofpeice;
        this.setWidth(50);
        this.setHeight(50);

            //(Change picture after you do all the basicas this is for me to rmr)
            /*If I were to make this a separate stackpane that I probably could
            have made a separate file in which I used a series of shapes to create
            multiple shapes and objects*/
        if (this.peicetype.equals("Pawn")) {
            if(this.amIreich == true) {
                this.setFill(new ImagePattern(path1));
            } else {
                this.setFill(new ImagePattern(path2));
            }

        } else if (this.peicetype.equals("Bishop")) {
            if(this.amIreich == true) {
                this.setFill(new ImagePattern(path8));
            } else {
                this.setFill(new ImagePattern(path3));
            }
        }else if (this.peicetype.equals("Knight")) {
            if(this.amIreich == true) {
                this.setFill(new ImagePattern(path12));
            } else {
                this.setFill(new ImagePattern(path7));
            }
        } else if (this.peicetype.equals("Queen")) {
            if(this.amIreich == true) {
                this.setFill(new ImagePattern(path10));
            } else {
                this.setFill(new ImagePattern(path5));
            }
        } else if  (this.peicetype.equals("King")) {
            if(this.amIreich == true) {
                this.setFill(new ImagePattern(path11));
            } else {
                this.setFill(new ImagePattern(path6));
            }
        } else if (this.peicetype.equals("Rook")) {
            if(this.amIreich == true) {
                this.setFill(new ImagePattern(path9));
            } else {
                this.setFill(new ImagePattern(path4));
            }
        } else {
            System.out.println("THi saint gonna work bud");
        }

    }
    public boolean getAmIreich() {
        return this.amIreich;
    }
    public String getPeicetype() {
        return this.peicetype;
    }
}