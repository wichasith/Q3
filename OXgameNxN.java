import java.util.Scanner ;
import java.lang.Math;

public class OXgameNxN {
    public static void main(String[] args) {
        System.out.println("welcome to Ox game NxN") ;
        Scanner NxN = new Scanner(System.in) ;
        System.out.print("what size NxN do you want(3,4,5) ====> ") ;
        int n = NxN.nextInt() ;
        String[][] board = new String[n][n];
        for(int i = 0 ; i < n ; i++ ){
            for(int j = 0 ; j < n ; j++ )
                board[i][j] = "   " ;
        }
        String player = " O " ;
        int turn = 0 ;
        boolean still_play = true ;
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
                    if (board[row][column] == "   ") {
                        add_position(row, column, player, board);
                    }
                    display_board(board, n);
                    still_play = check_winner(board, player, still_play, turn, n) ;
                    player = change_player(player) ;
                    turn ++ ;
            }
        }
    }
    }
    
    public static void display_board(String[][] position , int NxN) {
        if(NxN == 3){
            System.out.println(position[2][0] + "|" + position[2][1] + "|" + position[2][2]) ;
            System.out.println("-----------") ;
            System.out.println(position[1][0] + "|" + position[1][1] + "|" + position[1][2]) ;
            System.out.println("-----------") ;
            System.out.println(position[0][0] + "|" + position[0][1] + "|" + position[0][2]) ;
        }
        if(NxN == 4){
            System.out.println(position[3][0] + "|" + position[3][1] + "|" + position[3][2] + "|" + position[3][3]) ;
            System.out.println("---------------") ;
            System.out.println(position[2][0] + "|" + position[2][1] + "|" + position[2][2] + "|" + position[2][3]) ;
            System.out.println("---------------") ;
            System.out.println(position[1][0] + "|" + position[1][1] + "|" + position[1][2] + "|" + position[1][3]) ;
            System.out.println("---------------") ;
            System.out.println(position[0][0] + "|" + position[0][1] + "|" + position[0][2] + "|" + position[0][3]) ;
        }
        if(NxN == 5){
            System.out.println(position[4][0] + "|" + position[4][1] + "|" + position[4][2] + "|" + position[4][3] + "|" + position[4][4]) ;
            System.out.println("-------------------") ;
            System.out.println(position[3][0] + "|" + position[3][1] + "|" + position[3][2] + "|" + position[3][3] + "|" + position[3][4]) ;
            System.out.println("-------------------") ;
            System.out.println(position[2][0] + "|" + position[2][1] + "|" + position[2][2] + "|" + position[2][3] + "|" + position[2][4]) ;
            System.out.println("-------------------") ;
            System.out.println(position[1][0] + "|" + position[1][1] + "|" + position[1][2] + "|" + position[1][3] + "|" + position[1][4]) ;
            System.out.println("-------------------") ;
            System.out.println(position[0][0] + "|" + position[0][1] + "|" + position[0][2] + "|" + position[0][3] + "|" + position[0][4]) ;
        }
    }

    public static boolean check_winner(String[][] default_board,String player,boolean still_play,int turn , int n){
        for (int i = 0 ; i < n ; i ++){
        if(i < n - 2 ){
        if ( default_board[i][i] == default_board[i][i+1] && default_board[i][i] == default_board[i][i+2] && default_board[i][i] != "   " ) {
            System.out.println(player + "is winner ") ;
            still_play = false ;
        }
        else if ( default_board[i+1][i] == default_board[i+1][i+1] && default_board[i+1][i] == default_board[i+1][i+2] && default_board[i+1][i] != "   " ) {
            System.out.println(player + "is winner ") ;
            still_play = false ;
        }
        else if (default_board[i+2][i] == default_board[i+2][i+1] && default_board[i+2][i] == default_board[i+2][i+2] && default_board[i+2][i] != "   ") {
            System.out.println(player + "is winner ") ;
            still_play = false ;
        }
        else if (default_board[i][i] == default_board[i+1][i] && default_board[i][i] == default_board[i+2][i] && default_board[i][i] != "   ") {
            System.out.println(player + "is winner ") ;
            still_play = false ;
        }
        else if (default_board[i][i+1] == default_board[i+1][i+1] && default_board[i][i+1] == default_board[i+2][i+1] && default_board[i][i+1] != "   ") {
            System.out.println(player + "is winner ") ;
            still_play = false ;
        }
        else if (default_board[i][i+2] == default_board[i+1][i+2] && default_board[i][i+2] == default_board[i+2][i+2] && default_board[i][i+2] != "   ") {
            System.out.println(player + "is winner ") ;
            still_play = false ;
        }
        else if (default_board[i][i] == default_board[i+1][i+1] && default_board[i][i] == default_board[i+2][i+2] && default_board[i][i] != "   ") {
            System.out.println(player + "is winner ") ;
            still_play = false ;
        }
        else if (default_board[i][i+2] == default_board[i+1][i+1] && default_board[i][i+2] == default_board[i+2][i] && default_board[i][i+2] != "   ") {
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
        if ( player == " O " ){
            player = " X " ;
        }
        else if (player == " X " ){
            player = " O " ;
        }
        return player ;
    }

    public static void add_position(int row , int column ,String player,String[][] board){
            board[row][column] = player ;
        }


} 