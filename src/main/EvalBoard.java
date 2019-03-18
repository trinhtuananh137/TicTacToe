package main;

public class EvalBoard {
       
        public int height, width;
        public int[][] eBoard;
        public EvalBoard(){
            height = 0;
            width = 0;
        }
        public EvalBoard(ChessBoard board)
        {
            height = board.Row;
            width = board.Col;
            eBoard = new int[board.Row][board.Col];
        }
}
