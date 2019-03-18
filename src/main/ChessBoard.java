package main;

import java.awt.Graphics;
import java.awt.Image;


public class ChessBoard {

    public int Row; // So dong
    public int Col; // So cot

    public ChessBoard() {
        this.Row = 0;
        this.Col = 0;
    }

    public ChessBoard(int numberRow, int Col) {
        this.Row = numberRow;
        this.Col = Col;
    }

    // Ve ban co

    public void drawChessBoard(Graphics g) {
        for (int i = 0; i <= Row; i++) {
            g.drawLine(i * CaroChess.SIZE, 0, i * CaroChess.SIZE, Row * CaroChess.SIZE);
        }
        for (int j = 0; j <= Col; j++) {    
            g.drawLine(0, j * CaroChess.SIZE, Col * CaroChess.SIZE, j * CaroChess.SIZE);
        }
    }

    // Ve quan co

    public void drawChessMan(Graphics g, int row, int col, Image image) {
        g.drawImage(image, row, col, CaroChess.SIZE, CaroChess.SIZE, null);
    }
}
