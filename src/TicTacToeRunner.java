import java.util.Scanner;

public class TicTacToeRunner {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        char p = 'X';
        TicTacToeClass ttt = new TicTacToeClass();
        int r, c;

        while (!(ttt.isWinner('X') || ttt.isWinner('O') || ttt.isFull())) {
            ttt.displayBoard();
            System.out.print("'" + p + "', Enter your desired spot to place your token in format row number (space) column number: ");
            r = keyboard.nextInt();   //John used replacing characters in string - converting string into character using replaceAll method and then converted back to integer
            c = keyboard.nextInt();

            while (ttt.isValid(r, c) == false || ttt.playerAt(r, c) != ' ') {
                if (ttt.isValid(r, c) == false)
                    System.out.println("That is not a valid location. Try again.");
                else if (ttt.playerAt(r, c) != ' ')
                    System.out.println("That location is already full. Try again.");

                System.out.print("Enter your desired spot to place your token in format row number (space) column number: ");
                r = keyboard.nextInt();
                c = keyboard.nextInt();  //replace input
            }

            ttt.playMove(p, r, c);

            if (p == 'X')
                p = 'O';
            else
                p = 'X';

        }

        ttt.displayBoard();

        if (ttt.isWinner('X'))
            System.out.println("X is the winner!");
        if (ttt.isWinner('O'))
            System.out.println("O is the winner!");
        if (ttt.isCat())
            System.out.println("The game is a tie.");
 
            keyboard.close();
        }
        
}
