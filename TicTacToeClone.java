import java.util.*;
public class TicTacToeClone {
    static ArrayList<Integer> playersposition=new ArrayList<Integer>();
    static ArrayList<Integer> cpuposition=new ArrayList<Integer>();
    public static void main(String[] args){
        char[][] gameboard={{' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '}};
        printboard(gameboard);
        Scanner scan=new Scanner(System.in);
        while(true){
            System.out.println("enter the position between (1-9):");
            int pos=scan.nextInt();
            if(pos>9 || pos<1){
                System.out.println("INCORRECT POSITION");
            }
            while(playersposition.contains(pos) || cpuposition.contains(pos)){
                System.out.println("this position is already occupied!!!");
                pos=scan.nextInt();
            }
            playersposition.add(pos);
            symbol(pos,gameboard,"PLAYER");
            Random rand=new Random();
            int cpupos;
            do{
                cpupos=rand.nextInt(9)+1;
            }while (playersposition.contains(cpupos) || cpuposition.contains(cpupos));
            cpuposition.add(cpupos);
            symbol(cpupos,gameboard,"CPU");
            printboard(gameboard);
            String result = finalcheck();
            if (!result.equalsIgnoreCase(" ")) {
                System.out.println(result);
                break;
            }
        }

    }
    public static void printboard(char[][] game){
        for(char[] row : game){
            for(char col : row){
                System.out.print(col);
            }
            System.out.println();
        }
    }
    public static void symbol(int pos,char[][] gameboard,String user){
        char mark=' ';
        if(user.equals("PLAYER")){
            mark='X';
        }
        else{
            mark='O';
        }
        switch(pos){
            case 1:
                gameboard[0][0]=mark;
                break;
            case 2:
                gameboard[0][2]=mark;
                break;
            case 3:
                gameboard[0][4]=mark;
                break;
            case 4:
                gameboard[2][0]=mark;
                break;
            case 5:
                gameboard[2][2]=mark;
                break;
            case 6:
                gameboard[2][4]=mark;
                break;
            case 7:
                gameboard[4][0]=mark;
                break;
            case 8:
                gameboard[4][2]=mark;
                break;
            case 9:
                gameboard[4][4]=mark;
                break;
            default:
                break;
        }

    }
    public static String finalcheck(){
        List<List<Integer>> win = new ArrayList<>();
        win.add(Arrays.asList(1,2,3));
        win.add(Arrays.asList(4,5,6));
        win.add(Arrays.asList(7,8,9));
        win.add(Arrays.asList(1,4,7));
        win.add(Arrays.asList(2,5,8));
        win.add(Arrays.asList(3,6,9));
        win.add(Arrays.asList(1,5,9));
        win.add(Arrays.asList(3,5,7));
        if(playersposition.containsAll(win)){
            return "PLAYER WON!!!!!! :)";
        }
        else if (cpuposition.containsAll(win)) {
            return "CPU WINSS  :( :(";
        }
        else if(playersposition.size() +cpuposition.size() == 9){
            return "###TIE###";
        }
        return " ";
    }
}
