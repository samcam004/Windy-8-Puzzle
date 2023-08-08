import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        int[][] initialState = {{0,2,3},{1,4,5},{8,7,6}};
        int[][] goalState = {{0,2,3},{1,8,4},{7,6,5}};

        /*
        int[][] initialState ={{0,2,3},{1,4,5}, {6,7,8}};
        int[][] goalState = {{1,2,3},{0,4,5},{6,7,8}};
        */
        ManhattanDistance md = new ManhattanDistance();
        Node exp = new Node(initialState);

        printStart(initialState,goalState);
        System.out.println("|0\t|" + md.findManhattan(initialState, goalState) + "\t|");
        System.out.println("|  #1 \t|\n");

        exp.expansionNode(2, goalState);
    }

    public static void printStart(int[][] start, int[][] goal) {
        System.out.println("Initial\t\tGoal");
        for (int i = 0; i < 3; i++)
        System.out.println("| " + start[i][0] + " " + start[i][1] + " " + start[i][2] + " | \t| " + goal[i][0] + " " + goal [i][1] + " " + goal[i][2] + " |");

    }
}
