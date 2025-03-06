import java.util.Scanner;
public class TicTacToeCode
{
    public static void main(String[] args){
        char[][] board = new char[3][3];
        //initilize the board: 
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = '-';
            }
        }
        //drawBoard(board);
        Scanner in = new Scanner(System.in);
        System.out.println("Let's play Tic-Tac-Toe!");
        System.out.println("Hey Player 1! What's your name?");
        String p1 = in.nextLine();
        System.out.println("Hey Player 2! What's your name");
        String p2 = in.nextLine();
        boolean player1 = true;
        boolean gameEnded = false;
        while (!gameEnded){
            drawBoard(board);
            if(player1){
                System.out.println(p1 + " It's your turn X");
                
            }
            else{
                System.out.println(p2 + " It's your turn 0");
                
            }
            char c = '-';
            if(player1){
               c = 'x';
            }
            else{
               c = '0';
            }
            int row = 0;
            int col = 0;
            while(true){
                System.out.println("Enter the row number(0,1,or 2)");
                row = in.nextInt();
                System.out.println("Enter the column number(0,1,or 2)");
                col = in.nextInt();
                if(row < 0 || col < 0 || row > 2 || col > 2){
                    System.out.println("This number is off-limits! Try again.");
                }
                else if(board[row][col] != '-'){
                    System.out.println("This position is full, try again.");
                } else{
                    break;
                }
            }
            board[row][col] = c;
            if(playerHasWon(board) == 'x'){
                System.out.println(p1+ " has won!");
                gameEnded = true;
            }
            else if(playerHasWon(board) == '0'){
                System.out.println(p2 + " has won!");
                gameEnded = true;
            } else{
                if(boardIsFull(board)){
                    System.out.println("It is a tie!");
                    gameEnded = true;
                }
                else{
                    player1 = !player1;
                }
            }
            
        }
        drawBoard(board);
    }
    public static void drawBoard(char[][] board){
        System.out.println("board");
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
        
    }
    public static char playerHasWon(char[][] board){
        for(int i = 0; i < 3; i++){
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-'){
                return board[i][0];
            }
        }
        for(int j = 0; j < 3; j++){
            if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-'){
                return board[0][j];
            }
        }
         if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-'){
            return board[0][0];   
    }
        if(board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-'){
            return board[2][0];
        }
        return ' ';
    }
    public static boolean boardIsFull(char[][] board){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == '-'){
                    return false;
                }
            }
        }
        
        return true;
    }
}
