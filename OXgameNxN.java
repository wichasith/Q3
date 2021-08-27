import java.util.Scanner ;
import java.lang.Math;

public class OXgameNxN {
    public static void main(String[] args) {
        System.out.println("welcome to Ox game NxN") ;
        Scanner NxN = new Scanner(System.in) ;
        System.out.print("what size NxN do you want(if 3x3 you should press 3) ====> ") ;
        int n = NxN.nextInt() ;
        String[][] board = new String[n][n];
        for(int i = 0 ; i < n ; i++ ){
            for(int j = 0 ; j < n ; j++ )
                board[i][j] = "[ ]" ;
        }
        String[][] board_show = new String[n][n];
        for(int i = 0 ; i < n ; i++ ){
            for(int j = 0 ; j < n ; j++ ){
                int num = i*n + j + 1 ;
                board_show[i][j] = "[" + num + "]" ;
        }
        }
        String player = "[O]" ;
        int turn = 0 ;
        boolean still_play = true ;
        display_board(board_show, n);
        display_board(board, n);
        while (still_play == true) {   
            System.out.println("this is" + player + "turn") ;
            Scanner scan = new Scanner(System.in) ;
            System.out.print("Press number 1-"+ n*n +" here ===> ") ;
            int new_position = scan.nextInt() ;
            for (int a = 1 ; a < n*n + 1 ; a++){
                if(a == new_position){
                    int position = new_position - 1 ;
                    int row = Math.floorDiv(position , n) ;
                    int column = position  % n ;
                    if (board[row][column] == "[ ]") {
                        add_position(row, column, player, board);
                    }
                    display_board(board_show, n);
                    System.out.println("") ;
                    display_board(board, n);
                    still_play = check_winner(board, player, still_play, turn, n) ;
                    System.out.println(still_play) ;
                    player = change_player(player) ;
                    turn ++ ;
            }
        }
        
    }
    }
    
    public static void display_board(String[][] position , int NxN) {
           
            for (int i = 0 ; i < NxN ; i ++){
                for (int j = 0 ; j < NxN ; j ++){
                    System.out.print(position[i][j]) ;
                }
            System.out.println("") ;
            }
        }
    

    public static boolean check_winner(String[][] default_board,String player,boolean still_play,int turn , int n){
        for (int i = 0 ; i < n ; i ++){
        if(i < n - 2 ){
        if ( default_board[i][i] == default_board[i][i+1] && default_board[i][i] == default_board[i][i+2] && default_board[i][i] != "[ ]" ) {
            System.out.println(player + "is winner ") ;
            still_play = false ;
        }
        else if ( default_board[i+1][i] == default_board[i+1][i+1] && default_board[i+1][i] == default_board[i+1][i+2] && default_board[i+1][i] != "[ ]" ) {
            System.out.println(player + "is winner ") ;
            still_play = false ;
        }
        else if (default_board[i+2][i] == default_board[i+2][i+1] && default_board[i+2][i] == default_board[i+2][i+2] && default_board[i+2][i] != "[ ]") {
            System.out.println(player + "is winner ") ;
            still_play = false ;
        }
        else if (default_board[i][i] == default_board[i+1][i] && default_board[i][i] == default_board[i+2][i] && default_board[i][i] != "[ ]") {
            System.out.println(player + "is winner ") ;
            still_play = false ;
        }
        else if (default_board[i][i+1] == default_board[i+1][i+1] && default_board[i][i+1] == default_board[i+2][i+1] && default_board[i][i+1] != "[ ]") {
            System.out.println(player + "is winner ") ;
            still_play = false ;
        }
        else if (default_board[i][i+2] == default_board[i+1][i+2] && default_board[i][i+2] == default_board[i+2][i+2] && default_board[i][i+2] != "[ ]") {
            System.out.println(player + "is winner ") ;
            still_play = false ;
        }
        else if (default_board[i][i] == default_board[i+1][i+1] && default_board[i][i] == default_board[i+2][i+2] && default_board[i][i] != "[ ]") {
            System.out.println(player + "is winner ") ;
            still_play = false ;
        }
        else if (default_board[i][i+2] == default_board[i+1][i+1] && default_board[i][i+2] == default_board[i+2][i] && default_board[i][i+2] != "[ ]") {
            System.out.println(player + "is winner ") ;
            still_play = false ;
        }
    }
    if ( turn == n*n - 1 && still_play == true ) {
        System.out.println("this game is tie") ;
        still_play = false  ;
    }
        }
        return still_play ;
    }





    public static String change_player(String player) {
        if ( player == "[O]" ){
            player = "[X]" ;
        }
        else if (player == "[X]" ){
            player = "[O]" ;
        }
        return player ;
    }

    public static void add_position(int row , int column ,String player,String[][] board){
            board[row][column] = player ;
        }


} 