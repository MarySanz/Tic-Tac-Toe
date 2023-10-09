//import java.io.*;
import java.util.*;

public class Tictactoe{
   
    public static void main(String[] args) {
        Gameboard B= new Gameboard();

   

        char win='N', turn='X';
        Scanner sc = new Scanner(System.in);
        
        while(win=='N' ){
            System.out.println("Turn for player "+turn);
            System.out.print("Enter row and column : ");
            int row=sc.nextInt();
            int col=sc.nextInt();
            if(!B.placeMark(row, col, turn)) continue;
            win=B.checker();
            if(win==turn){
                System.out.println(turn +"  wins the game........");
                System.out.println("-------------------");
                break;
            }
            if(B.checkDraw()){
                System.out.println("Game Over !!");
                System.out.println(" It's a Draw");
                System.out.println("--------------------");
                break;
            }
            B.display();
            if(turn=='X') turn='O';
            else turn='X';


        }
    }

    
}



class Gameboard{
    char[][] board;
    Gameboard(){
        board= new char[3][3];
        init();
        
    }

    public void init(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                board[i][j]=' ';
            }
        }
    }

    public void display(){
        for (int i=0; i<3; i++){
            System.out.println("-------------");
            System.out.print("| ");
            for (int j=0; j<3; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            
        }
        System.out.println("-------------");
    } 

    public char checker(){
        //To check rows
        char temp;
        
        for ( int i=0; i<3; i++){

            temp = board[0][i];
            if(temp==' ') continue;
            int flag=1;
            int j=1;
            for (; j<3; j++){
                if(temp != board[j][i]){
                    flag=0;                   
                }
            }
            if(flag == 1){
                return board[j][i];
            }
        }

        //To check columns

        for (int i=0; i<3; i++){
            temp = board[i][0];
            if(temp==' ') continue;
            int flag=1;
            int j=1;
            for (; j<3; j++){
                if(temp != board[i][j]){
                    flag=0;                   
                }
            }
            if(flag == 1){
                return temp;
            }
        }

        //To check Diagonals
        if((board[0][0]==board[1][1] && board[1][1]==board[2][2]) && board[0][0]!=' '){
            return board[0][0];
        }
        if(board[0][2]==board[1][1] && board[1][1]==board[2][0] && board[0][2]!=' '){
            return board[0][2];
        }
        return 'N';
    }


    public boolean placeMark( int row, int col, char mark){
        if(row>=0 && row<3 && col>=0 && col<3 && board[row][col]==' '){
            this.board[row][col] = mark;
            return true; 
        }
        else{
            System.out.println("Invalid Input!!!");
            return false;
        }    
    }

    public boolean checkDraw(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }
}

