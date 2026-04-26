package ChessBoard;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;

//For this entire section I kinda messed up and js know that x is actually y and y is actually x
public class ChessRules {
    StackPane[][] sixtyfour;
    int yposition;
    int xposition;
    int futureyposition;
    int futurexposition;
    int whitefirstrank = 6;
    int blackfirstrank = 1;

    public boolean rulesforzepawn(Boolean blackorwhite, StackPane[][] sixtyfour, int ypos, int xpos, int fypos, int fxpos) {
        boolean onFirstRank;
        boolean ColStaysSame;
        boolean upOneY;
        boolean upTwoY;
        boolean finalDis;
        boolean inBetweenSquare;
        boolean DiagonalX;
        boolean DiagonalY;
        boolean enemyExists;
        if (blackorwhite) {
            onFirstRank = this.whitefirstrank == ypos;
            ColStaysSame = fxpos - xpos == 0;
            upOneY = ypos - fypos == 1;
            upTwoY = ypos - fypos == 2;
            finalDis = sixtyfour[fxpos][fypos].getChildren().isEmpty();
            inBetweenSquare = sixtyfour[xpos][ypos - 1].getChildren().isEmpty();
            DiagonalX = fxpos - xpos == -1 || fxpos - xpos == 1;
            DiagonalY = ypos - fypos == 1;
            enemyExists = !sixtyfour[fxpos][fypos].getChildren().isEmpty();
        } else {//Change to Black logic
            onFirstRank = this.blackfirstrank == ypos;
            ColStaysSame = fxpos - xpos == 0;
            upOneY = ypos - fypos == -1;
            upTwoY = ypos - fypos == -2;
            finalDis = sixtyfour[fxpos][fypos].getChildren().isEmpty();
            inBetweenSquare = sixtyfour[xpos][ypos + 1].getChildren().isEmpty();
            DiagonalX = fxpos - xpos == -1 || fxpos - xpos == 1;
            DiagonalY = ypos - fypos == -1;
            enemyExists = !sixtyfour[fxpos][fypos].getChildren().isEmpty();
        }
        if (ColStaysSame) {
            if (upOneY && finalDis) {
                return true;
            } else if (upTwoY && finalDis && inBetweenSquare && onFirstRank) {
                return true;
            } else {
                return false;
            }
        } else if (DiagonalX && DiagonalY && enemyExists) {
            return true;
        } else {
            return false;
        }
    }


    public boolean rulesforknight(int ypos, int xpos, int fypos, int fxpos) {
        int diff = ypos - fypos;
        int scddiff = fxpos - xpos;
        return ((diff == -2 || diff == 2) && (scddiff == 1 || scddiff == -1)) || ((diff == -1 || diff == 1) && (scddiff == -2 || scddiff == 2)) || (diff == 0 && scddiff == 0);
    }

    public boolean rulesforBishop(StackPane[][] sixtyfour, int ypos, int xpos, int fypos, int fxpos) {
        int lineargo = fxpos - xpos;
        int lineargo2 = fypos - ypos;
        if( Math.abs(lineargo) == Math.abs(lineargo2) ){
            if (Integer.signum(lineargo) == -1) {
                for (int i = 0; i < xpos - fxpos; i++) {
                    if (!sixtyfour[fxpos - i][fypos - i].getChildren().isEmpty()) {
                        return false;
                    } else if (fxpos - i == xpos + 1 && fypos - i == ypos + 1){
                        return true;
                    }
                }
            } else if (Integer.signum(lineargo) == 1) {
                for (int i = 0; i < xpos - fxpos; i++) {
                    if (!sixtyfour[fxpos + i][fypos + i].getChildren().isEmpty()) {
                        return false;
                    } else if (fxpos + i == xpos - 1 && fypos + i == ypos - 1) {
                        return true;
                    }


                }
            } else {
                return false;
            }
        } else {
            return false;
        }

        return false;
    }

    public boolean rulesforRook(int ypos, int xpos, int fypos, int fxpos) {
        if ( (fxpos == xpos) || (fypos == ypos)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean rulesforQueen(int ypos, int xpos, int fypos, int fxpos) {
        this.yposition = ypos;
        this.xposition = xpos;
        this.futureyposition = fypos;
        this.futurexposition = fxpos;
        int diff = this.yposition - this.futureyposition;
        int scddiff = this.futurexposition - this.xposition;
        int lineargo = this.futurexposition - this.xposition;
        int lineargo2 = this.futureyposition - this.yposition;
        if ((diff == 0 && scddiff == 0) || (Math.abs(lineargo) == Math.abs(lineargo2)) || (this.xposition == this.futurexposition) || (this.yposition == this.futureyposition)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean rulesforKing(int ypos, int xpos, int fypos, int fxpos) {
        this.yposition = ypos;
        this.xposition = xpos;
        this.futureyposition = fypos;
        this.futurexposition = fxpos;
        int diff = this.yposition - this.futureyposition;
        int scddiff = this.futurexposition - this.xposition;
        if ((diff >= -1 && diff <= 1) && (scddiff >= -1 && scddiff <= 1)) {
            return true;
        } else {
            return false;
        }
    }
}
