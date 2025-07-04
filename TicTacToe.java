import java.util.*;

public class TicTacToe {
    static ArrayList<Integer> playerposition = new ArrayList<Integer>();
    static ArrayList<Integer> cpuposition = new ArrayList<Integer>();

    public static void main(String[] args) {
        char[][] gameboard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your placement (1-9): ");
            int pos = scan.nextInt();
            while (playerposition.contains(pos) || cpuposition.contains(pos)) {
                System.out.println("Position taken! Enter a correct position:");
                pos = scan.nextInt();
            }

            placepiece(gameboard, pos, "player");

            String result = checkWinner();
            if (!result.equals("")) {
                printGameBoard(gameboard);
                System.out.println(result);
                break;
            }

            Random rand = new Random();
            int cpupos;
            do {
                cpupos = rand.nextInt(9) + 1;
            } while (playerposition.contains(cpupos) || cpuposition.contains(cpupos));

            placepiece(gameboard, cpupos, "cpu");

            printGameBoard(gameboard);

            result = checkWinner();
            if (!result.equals("")) {
                System.out.println(result);
                break;
            }
        }

        scan.close();
    }

    public static void printGameBoard(char[][] gameboard) {
        for (char[] row : gameboard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placepiece(char[][] gameboard, int pos, String user) {
        char symbol = 'X';
        if (user.equals("cpu")) {
            symbol = 'O';
            cpuposition.add(pos);
        } else {
            playerposition.add(pos);
        }

        switch (pos) {
            case 1 :
                gameboard[0][0] = symbol;
                break;
            case 2 :
                gameboard[0][2] = symbol;
                break;
            case 3 :
                gameboard[0][4] = symbol;
                break;
            case 4 :
                gameboard[2][0] = symbol;
                break;
            case 5 :
                gameboard[2][2] = symbol;
                break;
            case 6 :
                gameboard[2][4] = symbol;
                break;
            case 7 :
                gameboard[4][0] = symbol;
                break;
            case 8 :
                gameboard[4][2] = symbol;
                break;
            case 9 :
                gameboard[4][4] = symbol;
                break;
        }
    }

    public static String checkWinner() {
        List<List<Integer>> winning = new ArrayList<>();
        winning.add(Arrays.asList(1, 2, 3));
        winning.add(Arrays.asList(4, 5, 6));
        winning.add(Arrays.asList(7, 8, 9));
        winning.add(Arrays.asList(1, 4, 7));
        winning.add(Arrays.asList(2, 5, 8));
        winning.add(Arrays.asList(3, 6, 9));
        winning.add(Arrays.asList(1, 5, 9));
        winning.add(Arrays.asList(3, 5, 7));

        for (List<Integer> l : winning) {
            if (playerposition.containsAll(l)) {
                return " Player wins!";
            } else if (cpuposition.containsAll(l)) {
                return " CPU wins!";
            }
        }

        if (playerposition.size() + cpuposition.size() == 9) {
            return " It's a tie!";
        }

        return "";
    }
}




