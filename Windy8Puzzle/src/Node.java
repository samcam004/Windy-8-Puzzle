import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Node {

    ManhattanDistance md = new ManhattanDistance();

    private Node parentNode;
    private Hashtable<String, Node> expansion = new Hashtable<>();
    private int[][] state;
    private int manhattanDistance;
    private int gCost;
    private String path;

    private int n = 1;
    private int e = 1;
    private int w = 1;
    private int s = 1;

    public Node () {
    }

    public Node (int[][] startState) {
        this.state = startState;
        this.parentNode = null;
        this.manhattanDistance = 0;
        this.path = null;
        this.gCost = 0;
    }

    public void expansionNode (int step, int[][] endState) {
            if (this.state[0][0] == 0) {
                int[][] moveRight = new int[3][3];
                copyArray(moveRight, this.state);
                movePiece("right", moveRight, 0, 0);

                Node rightArr = new Node(moveRight);
                rightArr.parentNode = this;
                rightArr.state = moveRight;
                rightArr.manhattanDistance = md.findManhattan(moveRight, endState);
                rightArr.gCost = rightArr.parentNode.gCost + e;

                int[][] moveDown = new int[3][3];
                copyArray(moveDown, this.state);
                movePiece("down", moveDown, 0, 0);

                Node downArr = new Node(moveDown);
                downArr.parentNode = this;
                downArr.state = moveDown;
                downArr.manhattanDistance = md.findManhattan(moveDown, endState);
                downArr.gCost = downArr.parentNode.gCost + s;

                if (rightArr.manhattanDistance == 0) {
                    printArray(rightArr.state, step, rightArr.gCost, rightArr.manhattanDistance);
                } else if (downArr.manhattanDistance == 0) {
                    printArray(downArr.state, step, downArr.gCost, downArr.manhattanDistance);
                }
                else if (rightArr.manhattanDistance < downArr.manhattanDistance) {
                    System.out.println("M R");
                    printArray(rightArr.state, step, rightArr.gCost, rightArr.manhattanDistance);
                    rightArr.expansionNode(step + 1, endState);
                } else {
                    System.out.println("M D");
                    printArray(downArr.state, step, downArr.gCost, downArr.manhattanDistance);
                    downArr.expansionNode(step + 1, endState);
                }
            }
            else if (this.state[0][1] == 0) {
                int[][] moveRight = new int[3][3];
                copyArray(moveRight, this.state);
                movePiece("right", moveRight, 0, 1);

                Node rightArr = new Node(moveRight);
                rightArr.parentNode = this;
                rightArr.state = moveRight;
                rightArr.manhattanDistance = md.findManhattan(moveRight, endState);
                rightArr.gCost = rightArr.parentNode.gCost + e;


                int[][] moveLeft = new int[3][3];
                copyArray(moveLeft, this.state);
                movePiece("left", moveLeft, 0, 1);

                Node leftArr = new Node(moveLeft);
                leftArr.parentNode = this;
                leftArr.state = moveLeft;
                leftArr.manhattanDistance = md.findManhattan(moveLeft, endState);
                leftArr.gCost = leftArr.parentNode.gCost + w;

                int[][] moveDown = new int[3][3];
                copyArray(moveDown, this.state);
                movePiece("down", moveDown, 0, 1);

                Node downArr = new Node(moveDown);
                downArr.parentNode = this;
                downArr.state = moveDown;
                downArr.manhattanDistance = md.findManhattan(moveDown, endState);
                downArr.gCost = downArr.parentNode.gCost + s;

                if (rightArr.manhattanDistance == 0) {
                    printArray(rightArr.state, step, rightArr.gCost, rightArr.manhattanDistance);
                } else if (leftArr.manhattanDistance == 0) {
                    printArray(leftArr.state, step, leftArr.gCost, leftArr.manhattanDistance);
                } else if (downArr.manhattanDistance == 0) {
                    printArray(downArr.state, step, downArr.gCost, downArr.manhattanDistance);
                }
                else if (rightArr.manhattanDistance < downArr.manhattanDistance && rightArr.manhattanDistance < leftArr.manhattanDistance) {
                    System.out.println("M R");
                    printArray(rightArr.state, step, rightArr.gCost, rightArr.manhattanDistance);
                    rightArr.expansionNode(step + 1, endState);
                } else if (leftArr.manhattanDistance < downArr.manhattanDistance && leftArr.manhattanDistance < rightArr.manhattanDistance) {
                    System.out.println("M R");
                    printArray(leftArr.state, step, leftArr.gCost, leftArr.manhattanDistance);
                    leftArr.expansionNode(step + 1, endState);
                }else {
                    System.out.println("M D");
                    printArray(downArr.state, step, downArr.gCost, downArr.manhattanDistance);
                    downArr.expansionNode(step + 1, endState);
                }
            }
            else if (this.state[0][2] == 0) {
                int[][] moveLeft = new int[3][3];
                copyArray(moveLeft, this.state);
                movePiece("left", moveLeft, 0, 2);

                Node leftArr = new Node(moveLeft);
                leftArr.parentNode = this;
                leftArr.state = moveLeft;
                leftArr.manhattanDistance = md.findManhattan(moveLeft, endState);
                leftArr.gCost = leftArr.parentNode.gCost + w;

                int[][] moveDown = new int[3][3];
                copyArray(moveDown, this.state);
                movePiece("down", moveDown, 0, 2);

                Node downArr = new Node(moveDown);
                downArr.parentNode = this;
                downArr.state = moveDown;
                downArr.manhattanDistance = md.findManhattan(moveDown, endState);
                downArr.gCost = downArr.parentNode.gCost + s;

                if (leftArr.manhattanDistance == 0) {
                    printArray(leftArr.state, step, leftArr.gCost, leftArr.manhattanDistance);
                } else if (downArr.manhattanDistance == 0) {
                    printArray(downArr.state, step, downArr.gCost, downArr.manhattanDistance);
                }
                else if (leftArr.manhattanDistance < downArr.manhattanDistance) {
                    System.out.println("M R");
                    printArray(leftArr.state, step, leftArr.gCost, leftArr.manhattanDistance);
                    leftArr.expansionNode(step + 1, endState);
                }else {
                    System.out.println("M D");
                    printArray(downArr.state, step, downArr.gCost, downArr.manhattanDistance);
                    downArr.expansionNode(step + 1, endState);
                }
            }
            else if (this.state[1][0] == 0) {
                int[][] moveUp = new int[3][3];
                copyArray(moveUp, this.state);
                movePiece("up", moveUp, 1, 1);

                Node upArr = new Node(moveUp);
                upArr.parentNode = this;
                upArr.state = moveUp;
                upArr.manhattanDistance = md.findManhattan(moveUp, endState);
                upArr.gCost = upArr.parentNode.gCost + n;

                int[][] moveRight = new int[3][3];
                copyArray(moveRight, this.state);
                movePiece("right", moveRight, 1, 0);

                Node rightArr = new Node(moveRight);
                rightArr.parentNode = this;
                rightArr.state = moveRight;
                rightArr.manhattanDistance = md.findManhattan(moveRight, endState);
                rightArr.gCost = rightArr.parentNode.gCost + e;

                int[][] moveDown = new int[3][3];
                copyArray(moveDown, this.state);
                movePiece("down", moveDown, 1, 0);

                Node downArr = new Node(moveDown);
                downArr.parentNode = this;
                downArr.state = moveDown;
                downArr.manhattanDistance = md.findManhattan(moveDown, endState);
                downArr.gCost = downArr.parentNode.gCost + s;

                if (upArr.manhattanDistance == 0) {
                    printArray(upArr.state, step, upArr.gCost, upArr.manhattanDistance);
                } else if (rightArr.manhattanDistance == 0) {
                    printArray(rightArr.state, step, rightArr.gCost, rightArr.manhattanDistance);
                } else if (downArr.manhattanDistance == 0) {
                    printArray(downArr.state, step, downArr.gCost, downArr.manhattanDistance);
                }
                else if (upArr.manhattanDistance < downArr.manhattanDistance &&  upArr.manhattanDistance < rightArr.manhattanDistance) {
                    System.out.println("M U");
                    printArray(upArr.state, step, upArr.gCost, upArr.manhattanDistance);
                    upArr.expansionNode(step + 1,endState);
                } else if (rightArr.manhattanDistance < downArr.manhattanDistance && rightArr.manhattanDistance < upArr.manhattanDistance ) {
                    System.out.println("M R");
                    printArray(rightArr.state, step, rightArr.gCost, rightArr.manhattanDistance);
                    rightArr.expansionNode(step + 1, endState);
                } else {
                    System.out.println("M D");
                    printArray(downArr.state, step, downArr.gCost, downArr.manhattanDistance);
                    downArr.expansionNode(step + 1, endState);
                }
            }
            else if (this.state[1][1] == 0) {
                int[][] moveUp = new int[3][3];
                copyArray(moveUp, this.state);
                movePiece("up", moveUp, 1, 1);

                Node upArr = new Node(moveUp);
                upArr.parentNode = this;
                upArr.state = moveUp;
                upArr.manhattanDistance = md.findManhattan(moveUp, endState);
                upArr.gCost = upArr.parentNode.gCost + n;

                int[][] moveRight = new int[3][3];
                copyArray(moveRight, this.state);
                movePiece("right", moveRight, 1, 1);

                Node rightArr = new Node(moveRight);
                rightArr.parentNode = this;
                rightArr.state = moveRight;
                rightArr.manhattanDistance = md.findManhattan(moveRight, endState);
                rightArr.gCost = rightArr.parentNode.gCost + e;

                int[][] moveLeft = new int[3][3];
                copyArray(moveLeft, this.state);
                movePiece("left", moveLeft, 1, 1);

                Node leftArr = new Node(moveLeft);
                leftArr.parentNode = this;
                leftArr.state = moveLeft;
                leftArr.manhattanDistance = md.findManhattan(moveLeft, endState);
                leftArr.gCost = leftArr.parentNode.gCost + w;

                int[][] moveDown = new int[3][3];
                copyArray(moveDown, this.state);
                movePiece("down", moveDown, 1, 1);

                Node downArr = new Node(moveDown);
                downArr.parentNode = this;
                downArr.state = moveDown;
                downArr.manhattanDistance = md.findManhattan(moveDown, endState);
                downArr.gCost = downArr.parentNode.gCost + s;

                if (upArr.manhattanDistance == 0) {
                    printArray(upArr.state, step, upArr.gCost, upArr.manhattanDistance);
                } else if (rightArr.manhattanDistance == 0) {
                    printArray(rightArr.state, step, rightArr.gCost, rightArr.manhattanDistance);
                } else if (leftArr.manhattanDistance == 0) {
                    printArray(leftArr.state, step, leftArr.gCost, leftArr.manhattanDistance);
                } else if (downArr.manhattanDistance == 0) {
                    printArray(downArr.state, step, downArr.gCost, downArr.manhattanDistance);
                }
                else if (upArr.manhattanDistance < downArr.manhattanDistance && upArr.manhattanDistance < leftArr.manhattanDistance && upArr.manhattanDistance < rightArr.manhattanDistance) {
                    System.out.println("M U");
                    printArray(upArr.state, step, upArr.gCost, upArr.manhattanDistance);
                    upArr.expansionNode(step + 1,endState);
                } else if (rightArr.manhattanDistance < downArr.manhattanDistance && rightArr.manhattanDistance < upArr.manhattanDistance && rightArr.manhattanDistance < leftArr.manhattanDistance) {
                    System.out.println("M R");
                    printArray(rightArr.state, step, rightArr.gCost, rightArr.manhattanDistance);
                    rightArr.expansionNode(step + 1, endState);
                } else if (leftArr.manhattanDistance < downArr.manhattanDistance && leftArr.manhattanDistance < upArr.manhattanDistance && leftArr.manhattanDistance < rightArr.manhattanDistance) {
                    System.out.println("M R");
                    printArray(leftArr.state, step, leftArr.gCost, leftArr.manhattanDistance);
                    leftArr.expansionNode(step + 1, endState);
                }else {
                    System.out.println("M D");
                    printArray(downArr.state, step, downArr.gCost, downArr.manhattanDistance);
                    downArr.expansionNode(step + 1, endState);
                }
            }
            else if (this.state[1][2] == 0) {
                int[][] moveUp = new int[3][3];
                copyArray(moveUp, this.state);
                movePiece("up", moveUp, 1, 2);

                Node upArr = new Node(moveUp);
                upArr.parentNode = this;
                upArr.state = moveUp;
                upArr.manhattanDistance = md.findManhattan(moveUp, endState);
                upArr.gCost = upArr.parentNode.gCost + n;

                int[][] moveLeft = new int[3][3];
                copyArray(moveLeft, this.state);
                movePiece("left", moveLeft, 1, 2);

                Node leftArr = new Node(moveLeft);
                leftArr.parentNode = this;
                leftArr.state = moveLeft;
                leftArr.manhattanDistance = md.findManhattan(moveLeft, endState);
                leftArr.gCost = leftArr.parentNode.gCost + w;

                int[][] moveDown = new int[3][3];
                copyArray(moveDown, this.state);
                movePiece("down", moveDown, 1, 2);

                Node downArr = new Node(moveDown);
                downArr.parentNode = this;
                downArr.state = moveDown;
                downArr.manhattanDistance = md.findManhattan(moveDown, endState);
                downArr.gCost = downArr.parentNode.gCost + s;

                if (upArr.manhattanDistance == 0) {
                    printArray(upArr.state, step, upArr.gCost, upArr.manhattanDistance);
                } else if (leftArr.manhattanDistance == 0) {
                    printArray(leftArr.state, step, leftArr.gCost, leftArr.manhattanDistance);
                } else if (downArr.manhattanDistance == 0) {
                    printArray(downArr.state, step, downArr.gCost, downArr.manhattanDistance);
                }
                else if (upArr.manhattanDistance < downArr.manhattanDistance && upArr.manhattanDistance < leftArr.manhattanDistance) {
                    System.out.println("M U");
                    printArray(upArr.state, step, upArr.gCost, upArr.manhattanDistance);
                    upArr.expansionNode(step + 1,endState);
                } else if (leftArr.manhattanDistance < downArr.manhattanDistance && leftArr.manhattanDistance < upArr.manhattanDistance) {
                    System.out.println("M R");
                    printArray(leftArr.state, step, leftArr.gCost, leftArr.manhattanDistance);
                    leftArr.expansionNode(step + 1, endState);
                }else {
                    System.out.println("M D");
                    printArray(downArr.state, step, downArr.gCost, downArr.manhattanDistance);
                    downArr.expansionNode(step + 1, endState);
                }
            }
            else if (this.state[2][0] == 0) {
                int[][] moveUp = new int[3][3];
                copyArray(moveUp, this.state);
                movePiece("up", moveUp, 2, 0);

                Node upArr = new Node(moveUp);
                upArr.parentNode = this;
                upArr.state = moveUp;
                upArr.manhattanDistance = md.findManhattan(moveUp, endState);
                upArr.gCost = upArr.parentNode.gCost + n;

                int[][] moveRight = new int[3][3];
                copyArray(moveRight, this.state);
                movePiece("right", moveRight, 2, 0);

                Node rightArr = new Node(moveRight);
                rightArr.parentNode = this;
                rightArr.state = moveRight;
                rightArr.manhattanDistance = md.findManhattan(moveRight, endState);
                rightArr.gCost = rightArr.parentNode.gCost + e;

                if (upArr.manhattanDistance == 0) {
                    printArray(upArr.state, step, upArr.gCost, upArr.manhattanDistance);
                } else if (rightArr.manhattanDistance == 0) {
                    printArray(rightArr.state, step, rightArr.gCost, rightArr.manhattanDistance);
                }
                else if (upArr.manhattanDistance < rightArr.manhattanDistance) {
                    System.out.println("M U");
                    printArray(upArr.state, step, upArr.gCost, upArr.manhattanDistance);
                    upArr.expansionNode(step + 1,endState);
                } else {
                    System.out.println("M R");
                    printArray(rightArr.state, step, rightArr.gCost, rightArr.manhattanDistance);
                    rightArr.expansionNode(step + 1, endState);
                }
            }
            else if (this.state[2][1] == 0) {
                int[][] moveUp = new int[3][3];
                copyArray(moveUp, this.state);
                movePiece("up", moveUp, 2, 1);

                Node upArr = new Node(moveUp);
                upArr.parentNode = this;
                upArr.state = moveUp;
                upArr.manhattanDistance = md.findManhattan(moveUp, endState);
                upArr.gCost = upArr.parentNode.gCost + n;

                int[][] moveRight = new int[3][3];
                copyArray(moveRight, this.state);
                movePiece("right", moveRight, 2, 1);

                Node rightArr = new Node(moveRight);
                rightArr.parentNode = this;
                rightArr.state = moveRight;
                rightArr.manhattanDistance = md.findManhattan(moveRight, endState);
                rightArr.gCost = rightArr.parentNode.gCost + e;

                int[][] moveLeft = new int[3][3];
                copyArray(moveLeft, this.state);
                movePiece("left", moveLeft, 2, 1);

                Node leftArr = new Node(moveLeft);
                leftArr.parentNode = this;
                leftArr.state = moveLeft;
                leftArr.manhattanDistance = md.findManhattan(moveLeft, endState);
                leftArr.gCost = leftArr.parentNode.gCost + w;

                if (upArr.manhattanDistance == 0) {
                    printArray(upArr.state, step, upArr.gCost, upArr.manhattanDistance);
                } else if (rightArr.manhattanDistance == 0) {
                    printArray(rightArr.state, step, rightArr.gCost, rightArr.manhattanDistance);
                } else if (leftArr.manhattanDistance == 0) {
                    printArray(leftArr.state, step, leftArr.gCost, leftArr.manhattanDistance);
                }
                else if (upArr.manhattanDistance < leftArr.manhattanDistance && upArr.manhattanDistance < rightArr.manhattanDistance) {
                    System.out.println("M U");
                    printArray(upArr.state, step, upArr.gCost, upArr.manhattanDistance);
                    upArr.expansionNode(step + 1,endState);
                } else if (rightArr.manhattanDistance < upArr.manhattanDistance && rightArr.manhattanDistance < leftArr.manhattanDistance) {
                    System.out.println("M R");
                    printArray(rightArr.state, step, rightArr.gCost, rightArr.manhattanDistance);
                    rightArr.expansionNode(step + 1, endState);
                } else {
                    System.out.println("M R");
                    printArray(leftArr.state, step, leftArr.gCost, leftArr.manhattanDistance);
                    leftArr.expansionNode(step + 1, endState);
                }
            }
            else if (this.state[2][2] == 0) {
                int[][] moveUp = new int[3][3];
                copyArray(moveUp, this.state);
                movePiece("up", moveUp, 2, 2);

                Node upArr = new Node(moveUp);
                upArr.parentNode = this;
                upArr.state = moveUp;
                upArr.manhattanDistance = md.findManhattan(moveUp, endState);
                upArr.gCost = upArr.parentNode.gCost + n;

                int[][] moveLeft = new int[3][3];
                copyArray(moveLeft, this.state);
                movePiece("left", moveLeft, 2, 2);

                Node leftArr = new Node(moveLeft);
                leftArr.parentNode = this;
                leftArr.state = moveLeft;
                leftArr.manhattanDistance = md.findManhattan(moveLeft, endState);
                leftArr.gCost = leftArr.parentNode.gCost + w;
                if (upArr.manhattanDistance == 0) {
                    printArray(upArr.state, step, upArr.gCost, upArr.manhattanDistance);
                } else if (leftArr.manhattanDistance == 0) {
                    printArray(leftArr.state, step, leftArr.gCost, leftArr.manhattanDistance);
                }
                else if (upArr.manhattanDistance < leftArr.manhattanDistance) {
                    System.out.println("M U");
                    printArray(upArr.state, step, upArr.gCost, upArr.manhattanDistance);
                    upArr.expansionNode(step + 1,endState);
                } else {
                    System.out.println("M R");
                    printArray(leftArr.state, step, leftArr.gCost, leftArr.manhattanDistance);
                    leftArr.expansionNode(step + 1, endState);
                }
            }
    }
    //Takes the current array and copies information to the child node's array
    public static void copyArray(int[][] childArr, int[][] parentArr) {
        for (int i = 0; i < childArr.length; i++) {
            for (int j = 0; j < childArr.length; j++) {
                childArr[i][j] = parentArr[i][j];
            }
        }
    }
    //Prints array
    public void printArray(int[][] arr, int step, int moveCost,int manDis) {
        for (int i = 0; i < 3; i++) {
            System.out.println("| " + arr[i][0] + " " + arr[i][1] + " " + arr[i][2] + " |");
        }
        System.out.printf("|%d" + "\t|%d \t|\n", moveCost, manDis);
        System.out.println("|  #" + step + "\t|\n");
    }
    //Moves the '0' puzzle piece in a commanded direction
    public static void movePiece(String command,int[][] arr, int x, int y) {
        if (command == "up") {
            arr[x][y] = arr[x-1][y];
            arr[x-1][y] = 0;
        }
        else if (command == "down") {
            arr[x][y] = arr[x+1][y];
            arr[x+1][y] = 0;
        }
        else if (command == "left") {
            arr[x][y] = arr[x][y-1];
            arr[x][y-1] = 0;
        } else if (command == "right") {
            arr[x][y] = arr[x][y+1];
            arr[x][y+1] = 0;
        }
    }
}