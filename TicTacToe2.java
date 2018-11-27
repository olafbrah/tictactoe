package Homework;

import java.util.Random;

public class TicTacToe2 extends Board {

    public static void main(String[] args) {
        Board b = new Board();
        Random rand = new Random();
        
        b.displayBoard();

        System.out.println("Who first? (1)Computer (2)User: ");
        int choice = b.scan.nextInt();
        if(choice == 1){
            Point p = new Point(rand.nextInt(3), rand.nextInt(3));
            b.move(p, 1);
            b.displayBoard();
        }
        
        while (!b.isGameOver()) {
        	boolean valid =false;
        	Point userMove = null;
            System.out.println("Your move: ");
            while(valid == false) {
            	int x =b.scan.nextInt(); 
            	int y = b.scan.nextInt();
            	if(b.board[x][y]==1||b.board[x][y]==2) {
    	        	System.out.println("invalid move try again");
            	}
            	else {
            		valid =true;
            		userMove = new Point(x, y);
            	}
            }
            b.move(userMove, 2); //2 for O and O is the user
            b.displayBoard();
            if (b.isGameOver()) {
                break;
            } 
            b.callMinimax(0, 1);
            for (PointsAndScores pas : b.rootsChildrenScores) {
                System.out.println("Point: " + pas.point + " Score: " + pas.score);
            }
            b.move(b.returnBestMove(), 1);
            b.displayBoard();
        }
        if (b.hasXWon()) {
            System.out.println("Unfortunately, you lost!");
        } else if (b.hasOWon()) {
            System.out.println("You win! This is not going to get printed.");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
