public class ManhattanDistance {
    public int findManhattan(int[][] startArr, int[][]goalArr)
    {
        //Variables for the position of puzzle pieces
        int x1 = 0;           //x-coordinate for initial puzzle piece
        int x2 = 0;           //x-coordinate for goal puzzle piece
        int y1 = 0;           //y-coordinate for initial puzzle piece
        int y2 = 0;           //y-coordinate for goal puzzle piece
        int distance = 0;     //total manhattan for all pieces

        for (int i = 0; i < startArr.length; i++) {
            for (int j = 0; j < startArr[i].length; j++) {

                if (startArr[i][j] == 0 || startArr[i][j] == goalArr[i][j])
                    distance += 0;

                else {
                    x1 = i;
                    y1 = j;

                    for (int a = 0; a < goalArr.length; a++) {
                        for (int b = 0; b < goalArr[i].length; b++) {
                            if (startArr[i][j] == goalArr[a][b]) {
                                x2 = a;
                                y2 = b;
                            }
                        }
                    }
                    distance += calcDis(x1,y1,x2,y2);
                }
            }
        }
        return distance;
    }

    public static int calcDis(int x1,int y1,int x2,int y2) {
        //Windy move costs for cardinal direction and the total cost of all moves
        int north = 1;
        int east = 1;
        int west = 1;
        int south = 1;
        int windyDistance = 0;

        //comparing rows
        if (x2 == x1)
            windyDistance += 0;

        else if (x2 > x1)
            windyDistance += south * (x2 - x1);

        else
            windyDistance += north * (x1 - x2);

        //comparing columns
        if (y2 == y1)
            windyDistance += 0;
        else if (y2 > y1)
            windyDistance += east * (y2 - y1);
        else
            windyDistance += west * (y1 - y2);

        return windyDistance;
    }
}