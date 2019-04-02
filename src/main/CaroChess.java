package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;


public class CaroChess {

    public ImageIcon icon1 = new ImageIcon(getClass().getResource("/res/o.png"));
    public ImageIcon icon2 = new ImageIcon(getClass().getResource("/res/x.png"));
    public ImageIcon iWin = new ImageIcon(getClass().getResource("/res/winner.png"));
    public ImageIcon iLose = new ImageIcon(getClass().getResource("/res/lose.png"));
    public Image imageO = icon1.getImage();
    public Image imageX = icon2.getImage();
    public Image win = iWin.getImage();
    public Image lose = iLose.getImage();

    private boolean start;
    private int x, y;
    private int playerFlag;
    private int enemyFlag;
    
    
    private int fEnd;
    
    public static boolean comMove;
    public ChessBoard chessBoard;
    public EvalBoard eval;
    public int[][] arrBoard;
    private ArrayList<Point> listUndo = new ArrayList<>();

    private final Random rand;
    private static int maxDepth; //Độ sâu lớn nhất
    public static int maxMove = 3; //
    public int depth = 0; //Độ sâu
    public static final int SIZE = 25; // độ dài cạnh ô vuông caro
    public static final int INT_MAX = Integer.MAX_VALUE;

    public int[] DScore = new int[]{0, 1, 9, 81, 729};
    public int[] AScore = new int[]{0, 2, 18, 162, 1458};

    public String[] caseX = {"11", "101", "1112", "2111", "1011", "1101", "111", "11011", "10111", "11101", "11112", "21111", "1111", "11111"};
    public String[] caseO = {"22", "202", "2221", "1222", "2022", "2202", "222", "22022", "20222", "22202", "22221", "12222", "2222", "22222"};
    public int[] pointArr = {5, 5, 10, 10, 500, 500, 500, 600, 600, 600, 600, 600, 5000, 5000};

    public CaroChess(int depthMax) {
        comMove = true;
        chessBoard = new ChessBoard(20 , 20);
        arrBoard = new int[chessBoard.Row][chessBoard.Col];
        for (int i = 0; i < chessBoard.Row; i++) {
            for (int j = 0; j < chessBoard.Col; j++) {
                arrBoard[i][j] = 0;
            }
        }
        eval = new EvalBoard(chessBoard);
        resetBoard(eval);
        rand = new Random();
        maxDepth = depthMax;
    }

    public void drawChessBoard(Graphics g) {
        chessBoard.drawChessBoard(g);
    }

        public boolean playChess1(int mouseX, int mouseY, Graphics g) { 
        
        if (fEnd == 0 && playerFlag == 1) {            
            if (mouseX % SIZE == 0 || mouseY % SIZE == 0) {
                return false;
            }
            
            int row = mouseX / SIZE;
            int col = mouseY / SIZE;

            if (arrBoard[row][col] != 0) {
                return false;
            }

            if (arrBoard[row][col] == 0) {
                arrBoard[row][col] = 1;
                listUndo.add(new Point(row, col));
                chessBoard.drawChessMan(g, row * SIZE, col * SIZE, imageX);                
                if (checkWin(row, col) == 1) {
                    InterfaceGame.thoigian.stop();
                    g.drawImage(win, 0, 0, null);
                    fEnd = 1;                    
                    return true;
                }
                 //May di
                EvalChessBoard(2, eval, arrBoard);
                Point temp = new Point();
                long start = System.currentTimeMillis();
                temp = findMoveOfCom(playerFlag, arrBoard);
                x = temp.x;
                y = temp.y;
                arrBoard[x][y] = 2;
                listUndo.add(new Point(x, y));
                chessBoard.drawChessMan(g, x * 25, y * 25, imageO);
                
                if (checkWin(x, y) == 2) {
                    InterfaceGame.thoigian.stop();
                    g.drawImage(lose, 100, 100, null);
                    fEnd = 2;
                    return true;
                }
               comMove = true;
                return true;
            }
        }
        return false;
    }
    
    public boolean playChess2(int mouseX, int mouseY, Graphics g) {
        if (fEnd == 0 && playerFlag == 1) {
            if (mouseX % SIZE == 0 || mouseY % SIZE == 0) {
                return false;
            }

            int row = mouseX / SIZE;
            int col = mouseY / SIZE;

            if (arrBoard[row][col] != 0) {
                return false;
            }

            if (arrBoard[row][col] == 0) {
                arrBoard[row][col] = 1;
                listUndo.add(new Point(row, col));
                chessBoard.drawChessMan(g, row * SIZE, col * SIZE, imageX);
                playerFlag = 2;
                if (checkWin(row, col) == 1) {
                    InterfaceGame.thoigian.stop();
                    g.drawImage(win, 0, 0, null);
                    fEnd = 1;
                    return true;
                }                 
                long start = System.currentTimeMillis();                              
                return true;
            }
            
        }
        if (fEnd == 0 && playerFlag == 2) {
            if (mouseX % SIZE == 0 || mouseY % SIZE == 0) {
                return false;
            }

            int row = mouseX / SIZE;
            int col = mouseY / SIZE;

            if (arrBoard[row][col] != 0) {
                return false;
            }

            if (arrBoard[row][col] == 0) {
                arrBoard[row][col] = 2;
                listUndo.add(new Point(row, col));
                chessBoard.drawChessMan(g, row * SIZE, col * SIZE, imageO);
                playerFlag = 1;
                if (checkWin(row, col) == 2) {
                    InterfaceGame.thoigian.stop();
                    g.drawImage(win, 0, 0, null);
                    fEnd = 2;
                    return true;
                }                       
                return true;
            }
        }
        return false;
    }

    public void repaintChessMan(Graphics g) {
        for (Point point : listUndo) {
            if (arrBoard[point.x][point.y] == 1) {
                chessBoard.drawChessMan(g, point.x * CaroChess.SIZE, point.y * CaroChess.SIZE , imageX);
            } else if (arrBoard[point.x][point.y] == 2) {
                chessBoard.drawChessMan(g, point.x * CaroChess.SIZE , point.y * CaroChess.SIZE, imageO);
            }
        }
    }

    public void playerVsCom(Graphics g) {
        start = true;
        listUndo = new ArrayList<Point>();
        drawChessBoard(g);
        x = rand.nextInt(3);
        y = rand.nextInt(3);
        arrBoard[x + 7][y + 7] = 2;
        listUndo.add(new Point(x + 7, y + 7));
        chessBoard.drawChessMan(g, (x + 7) * SIZE, (y + 7) * SIZE, imageO);
        playerFlag = 1;
        fEnd = 0;
    }
    
    public void playerVsPlayer(Graphics g) {
        start = true;
        listUndo = new ArrayList<Point>();
        drawChessBoard(g);                               
        playerFlag = 1;
        fEnd = 0;
    }

    private void resetBoard(EvalBoard e) {
        for (int r = 0; r < chessBoard.Row; r++) {
            for (int c = 0; c < chessBoard.Col; c++) {
                eval.eBoard[r][c] = 0;
            }
        }
    }

    private void EvalChessBoard(int player, EvalBoard eBoard, int[][] boardArr) {
        int rw, cl, ePC, eHuman;
        resetBoard(eBoard);
        //Danh gia theo hang
        for (rw = 0; rw < chessBoard.Row; rw++) {
            for (cl = 0; cl < chessBoard.Col - 4; cl++) {
                ePC = 0;
                eHuman = 0;
                for (int i = 0; i < 5; i++) {
                    if (boardArr[rw][cl + i] == 1) {
                        eHuman++;
                    }
                    if (boardArr[rw][cl + i] == 2) {
                        ePC++;
                    }
                }
                if (eHuman * ePC == 0 && eHuman != ePC) {
                    for (int i = 0; i < 5; i++) {
                        if (boardArr[rw][cl + i] == 0) {
                            if (eHuman == 0) {
                                if (player == 1) {
                                    eBoard.eBoard[rw][cl + i] += DScore[ePC];
                                } else {
                                    eBoard.eBoard[rw][cl + i] += AScore[ePC];
                                }
                            }
                            if (ePC == 0) {
                                if (player == 2) {
                                    eBoard.eBoard[rw][cl + i] += DScore[eHuman];
                                } else {
                                    eBoard.eBoard[rw][cl + i] += AScore[eHuman];
                                }
                            }
                            if (eHuman == 4 || ePC == 4) {
                                eBoard.eBoard[rw][cl + i] *= 2;
                            }
                        }
                    }
                }
            }
        }
        //Danh gia theo cot
        for (cl = 0; cl < chessBoard.Col; cl++) {
            for (rw = 0; rw < chessBoard.Row - 4; rw++) {
                ePC = 0;
                eHuman = 0;
                for (int i = 0; i < 5; i++) {
                    if (boardArr[rw + i][cl] == 1) {
                        eHuman++;
                    }
                    if (boardArr[rw + i][cl] == 2) {
                        ePC++;
                    }
                }
                if (eHuman * ePC == 0 && eHuman != ePC) {
                    for (int i = 0; i < 5; i++) {
                        if (boardArr[rw + i][cl] == 0) {
                            if (eHuman == 0) {
                                if (player == 1) {
                                    eBoard.eBoard[rw + i][cl] += DScore[ePC];
                                } else {
                                    eBoard.eBoard[rw + i][cl] += AScore[ePC];
                                }
                            }
                            if (ePC == 0) {
                                if (player == 2) {
                                    eBoard.eBoard[rw + i][cl] += DScore[eHuman];
                                } else {
                                    eBoard.eBoard[rw + i][cl] += AScore[eHuman];
                                }
                            }
                            if (eHuman == 4 || ePC == 4) {
                                eBoard.eBoard[rw + i][cl] *= 2;
                            }
                        }
                    }

                }
            }
        }
        //Danh gia duong cheo xuoi
        for (cl = 0; cl < chessBoard.Col - 4; cl++) {
            for (rw = 0; rw < chessBoard.Row - 4; rw++) {
                ePC = 0;
                eHuman = 0;
                for (int i = 0; i < 5; i++) {
                    if (boardArr[rw + i][cl + i] == 1) {
                        eHuman++;
                    }
                    if (boardArr[rw + i][cl + i] == 2) {
                        ePC++;
                    }
                }
                if (eHuman * ePC == 0 && eHuman != ePC) {
                    for (int i = 0; i < 5; i++) {
                        if (boardArr[rw + i][cl + i] == 0) {
                            if (eHuman == 0) {
                                if (player == 1) {
                                    eBoard.eBoard[rw + i][cl + i] += DScore[ePC];
                                } else {
                                    eBoard.eBoard[rw + i][cl + i] += AScore[ePC];
                                }
                            }
                            if (ePC == 0) {
                                if (player == 2) {
                                    eBoard.eBoard[rw + i][cl + i] += DScore[eHuman];
                                } else {
                                    eBoard.eBoard[rw + i][cl + i] += AScore[eHuman];
                                }
                            }
                            if (eHuman == 4 || ePC == 4) {
                                eBoard.eBoard[rw + i][cl + i] *= 2;
                            }
                        }
                    }
                }
            }
        }
        //Danh gia duong cheo nguoc
        for (rw = 4; rw < chessBoard.Row; rw++) {
            for (cl = 0; cl < chessBoard.Col - 4; cl++) {
                ePC = 0;
                eHuman = 0;
                for (int i = 0; i < 5; i++) {
                    if (boardArr[rw - i][cl + i] == 1) {
                        eHuman++;
                    }
                    if (boardArr[rw - i][cl + i] == 2) {
                        ePC++;
                    }
                }
                if (eHuman * ePC == 0 && eHuman != ePC) {
                    for (int i = 0; i < 5; i++) {
                        if (boardArr[rw - i][cl + i] == 0) {
                            if (eHuman == 0) {
                                if (player == 1) {
                                    eBoard.eBoard[rw - i][cl + i] += DScore[ePC];
                                } else {
                                    eBoard.eBoard[rw - i][cl + i] += AScore[ePC];
                                }
                            }
                            if (ePC == 0) {
                                if (player == 2) {
                                    eBoard.eBoard[rw - i][cl + i] += DScore[eHuman];
                                } else {
                                    eBoard.eBoard[rw - i][cl + i] += AScore[eHuman];
                                }
                            }
                            if (eHuman == 4 || ePC == 4) {
                                eBoard.eBoard[rw - i][cl + i] *= 2;
                            }
                        }
                    }

                }
            }
        }
    }

    private int EvalDangerous(int[][] b) {
        int n = chessBoard.Row;
        String s = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s += b[i][j];
            }
            s += ";";
            for (int j = 0; j < n; j++) {
                s += b[j][i];
            }
            s += ";";

        }
        for (int i = 0; i < n - 4; i++) {
            for (int j = 0; j < n - i; j++) {
                s += b[j][i + j];
            }
            s += ";";
        }
        for (int i = n - 5; i > 0; i--) {
            for (int j = 0; j < n - i; j++) {
                s += b[i + j][j];
            }
            s += ";";
        }
        for (int i = 4; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                s += b[i - j][j];
            }
            s += ";";
        }
        for (int i = n - 5; i > 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                s += b[j][i + n - j - 1];
            }
            s += ";\n";
        }
        Pattern pattern1, pattern2;
        int diem = 0;
        for (int i = 0; i < caseO.length; i++) {
            pattern1 = Pattern.compile(caseX[i]);
            pattern2 = Pattern.compile(caseO[i]);
            Matcher m1 = pattern1.matcher(s);
            Matcher m2 = pattern2.matcher(s);
            int count1 = 0;
            int count2 = 0;
            while (m1.find()) {
                count1++;
            }
            while (m2.find()) {
                count2++;
            }
            diem += pointArr[i] * count2;
            diem -= pointArr[i] * count1;
        }
        System.out.println("Diem: " + diem);
        return diem;
    }

    private Point getMaxPoint() {
        ArrayList<Point> list = new ArrayList<>();
        int t = -INT_MAX;
        for (int i = 0; i < chessBoard.Row; i++) {
            for (int j = 0; j < chessBoard.Col; j++) {
                if (t < eval.eBoard[i][j]) {
                    t = eval.eBoard[i][j];
                    list.clear();
                    list.add(new Point(i, j));
                } else if (t == eval.eBoard[i][j]) {
                    list.add(new Point(i, j));
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            eval.eBoard[list.get(i).x][list.get(i).y] = 0;
        }
        int x = rand.nextInt(list.size());
        return list.get(x);
    }

    public Point findMoveOfCom(int player, int[][] arr) {
        int n = chessBoard.Row;
        int[][] b = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(arr[i], 0, b[i], 0, n);
        }
        playerFlag = player;
        EvalChessBoard(2, eval, b);
        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < maxMove; i++) {
            list.add(getMaxPoint());
        }
        int maxp = -INT_MAX;
        ArrayList<Point> ListChoose = new ArrayList<>();
        for (Point list1 : list) {
            b[list1.x][list1.y] = playerFlag;
            int t = minVal(b, -INT_MAX, INT_MAX, 0);
            if (maxp < t) {
                maxp = t;
                ListChoose.clear();
                ListChoose.add(list1);
            } else if (maxp == t) {
                ListChoose.add(list1);
            }
            b[list1.x][list1.y] = 0;
        }
        int x = rand.nextInt(ListChoose.size());
        return ListChoose.get(x);
    }

    private int maxVal(int[][] arrBoard, int alpha, int beta, int depth) {
        int val = EvalDangerous(arrBoard);
        if (depth >= maxDepth || Math.abs(val) > 5000) {
            return val;
        }
        EvalChessBoard(2, eval, arrBoard);
        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < maxMove; i++) {
            list.add(getMaxPoint());
        }
        for (Point list1 : list) {
            arrBoard[list1.x][list1.y] = 2;
            alpha = Math.max(alpha, minVal(arrBoard, alpha, beta, depth + 1));
            arrBoard[list1.x][list1.y] = 0;
            if (alpha > beta) {
                break;
            }
        }
        return alpha;
    }

    private int minVal(int[][] arrBoard, int alpha, int beta, int depth) {
        int val = EvalDangerous(arrBoard);
        if (depth >= maxDepth || Math.abs(val) > 5000) {
            return val;
        }
        EvalChessBoard(1, eval, arrBoard);
        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < maxMove; i++) {
            list.add(getMaxPoint());
        }
        for (Point list1 : list) {
            arrBoard[list1.x][list1.y] = 1;
            beta = Math.min(beta, maxVal(arrBoard, alpha, beta, depth + 1));
            arrBoard[list1.x][list1.y] = 0;
            if (alpha >= beta) {
                break;
            }
        }
        return beta;
    }

    private int checkWin(int cl, int rw) {
        int r = 0, c = 0;
        int i;
        boolean human, pc;
        //Check hàng ngang
        while (c < chessBoard.Col - 5) {
            human = true;
            pc = true;
            for (i = 0; i < 5; i++) {
                if (arrBoard[cl][c + i] != 1) {
                    human = false;
                }
                if (arrBoard[cl][c + i] != 2) {
                    pc = false;
                }
            }
            if (human) {
                return 1;
            }
            if (pc) {
                return 2;
            }
            c++;
        }
        //Check hàng dọc
        while (r < chessBoard.Row - 5) {
            human = true;
            pc = true;
            for (i = 0; i < 5; i++) {
                if (arrBoard[r + i][rw] != 1) {
                    human = false;
                }
                if (arrBoard[r + i][rw] != 2) {
                    pc = false;
                }
            }
            if (human) {
                return 1;
            }
            if (pc) {
                return 2;
            }
            r++;
        }
        //Check duong cheo xuoi
        r = rw;
        c = cl;
        while (r > 0 && c > 0) {
            r--;
            c--;
        }
        while (r <= chessBoard.Row - 5 && c <= chessBoard.Col - 5) {
            human = true;
            pc = true;
            for (i = 0; i < 5; i++) {
                if (arrBoard[c + i][r + i] != 1) {
                    human = false;
                }
                if (arrBoard[c + i][r + i] != 2) {
                    pc = false;
                }
            }
            if (human) {
                return 1;
            }
            if (pc) {
                return 2;
            }
            r++;
            c++;
        }
        //Check duong cheo nguoc
        r = rw;
        c = cl;
        while (r < chessBoard.Row - 1 && c > 0) {
            r++;
            c--;
        }
        while (r >= 4 && c <= chessBoard.Col - 5) {
            human = true;
            pc = true;
            for (i = 0; i < 5; i++) {
                if (arrBoard[r - i][c + i] != 1) {
                    human = false;
                }
                if (arrBoard[r - i][c + i] != 2) {
                    pc = false;
                }
            }
            if (human) {
                return 1;
            }
            if (pc) {
                return 2;
            }
            r--;
            c++;
        }
        return 0;
    }

    public void newGame(Graphics g) {
        start = true;
        for (int i = 0; i < listUndo.size(); i++) {
            listUndo.remove(i);
        }

        for (int i = 0; i < chessBoard.Row; i++) {
            for (int j = 0; j < chessBoard.Col; j++) {
                if (arrBoard[i][j] != 0) {
                    arrBoard[i][j] = 0;
                }
            }
        }
        if (fEnd == 1) {
            playerFlag = 2;
        } else {
            playerFlag = 1;
        }
        if (playerFlag == 2) {
            x = rand.nextInt(3);
            y = rand.nextInt(3);
            arrBoard[x + 7][y + 7] = 2;
            listUndo.add(new Point(x + 7, y + 7));
            chessBoard.drawChessMan(g, (x + 7) * SIZE, (y + 7) * SIZE, imageO);
            playerFlag = 1;
        }
        fEnd = 0;
    }

    public void undoGame(Graphics g) {
        int leg = listUndo.size();
        if (leg > 1) {
            Point p = listUndo.get(leg - 1);
            listUndo.remove(listUndo.size() - 1);
            arrBoard[p.x][p.y] = 0;
            repaintChessMan(g);
            if (listUndo.size() > 0) {
                p = listUndo.get(listUndo.size() - 1);
                listUndo.remove(listUndo.size() - 1);
                arrBoard[p.x][p.y] = 0;
                repaintChessMan(g);
            }
            fEnd = 0;
        }
    }

    public boolean isStart() {
        return start;
    }
    public static boolean isComMove(){
        return comMove;
    }
}
