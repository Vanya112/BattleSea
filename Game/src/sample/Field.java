package sample;

import java.lang.*;

public abstract class Field  {
    //protected static Canvas canvas1;
    protected static int[][] map;
    protected static int[][] cells = new int[10][10];
    protected static int access = 0;
    protected static int[][] computerCells = new int[10][10];
    protected static int[][] computerMap;
    protected double[] coordinatesX = new double[10];
    protected double[] coordinates2X = new double[10];
    protected double[] coordinatesY = new double[10];
    protected int a = 200;
    protected int b = 100;

    public void setMap(){
        try{
            map = new int[10][10];
        }
        catch(OutOfMemoryError e){
            System.out.println("OutOfMemoryError");
        }
    }

    public void setAccess(int i){
        access = i;
    }

    public int getAccess(){
        return this.access;
    }

    public void show(){
        for (int i = 0; i < 10; i++) {
            System.out.println();
            for (int j = 0; j < 10; j++){
                System.out.print(computerMap[i][j] + "\t\t");
                System.out.print(' ');
            }
        }
    }

    public void initMap(){
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++){
                try{
                    map[i][j] = 0;
                    computerMap[i][j] = 0;
                    cells[i][j] = 0;
                    computerCells[i][j] = 0;
                }
                catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("ArrayIndexOutOfBoundsException");
                }
            }
    }

    public void showCells(){
        for (int i = 0; i < 10; i++) {
            System.out.println();
            for (int j = 0; j < 10; j++){
                System.out.print(cells[i][j] + "\t\t");
                System.out.print(' ');
            }
        }
    }

    public void showComputerCells(){
        for (int i = 0; i < 10; i++) {
            System.out.println();
            for (int j = 0; j < 10; j++){
                System.out.print(computerCells[i][j] + "\t\t");
                System.out.print(' ');
            }
        }
    }
}
