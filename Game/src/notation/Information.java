package notation;

import sample.Field;
import sample.Game;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class Information {
    protected Hashtable<Integer, String> notation = new Hashtable<Integer,String>();
    protected Hashtable<String, Double> pointX = new Hashtable<String, Double>();
    protected Hashtable<String, Double> pointY = new Hashtable<String, Double>();
    protected Hashtable<String, Double> pointComputerX = new Hashtable<String, Double>();
    protected Hashtable<String, Double> pointComputerY = new Hashtable<String, Double>();
    protected ArrayList<String> history = new ArrayList<>();
    protected ArrayList<String> buffer = new ArrayList<>();
    protected double[] coordX = {215, 245, 275, 305, 335, 365, 395, 425, 455, 485};
    protected double[] coordY = {115, 145, 175, 205, 235, 265, 295, 325, 355, 385};

    public Information(){
        for (int k = 0; k < 100; k++){
            char[] a = new char[2];
            a[0] = 'А';
            for (int i = 0; i < k % 10; i++)
                a[0]++;
            if (a[0] == 'Й')
                a[0]++;
            a[1] = '0';
            for (int j = 0; j < k / 10; j++)
                a[1]++;
            String symbols = String.copyValueOf(a);
            notation.put(k, symbols);
            pointX.put(symbols, coordX[k % 10] - 2.5);
            pointComputerX.put(symbols, coordX[k % 10] + 497.5);
            pointY.put(symbols, coordY[k / 10] - 2.5);
            pointComputerY.put(symbols, coordY[k / 10] - 2.5);
            //System.out.println(symbols);
        }
    }

    public int getBufferSize(){
        return buffer.size();
    }

    public void showBuffer(){
        System.out.println(buffer);
    }

    public void addString(String string){
        history.add(string);
    }

    public void addBufferString(String string){
        buffer.add(string);
    }

    public String getString(int index){
        return history.get(index);
    }

    public String getBufferString(int index){
        return buffer.get(index);
    }

    public void Clear(){
        history.clear();
        buffer.clear();
    }

    public int getSize(){
        return history.size();
    }

    public String GetKey(int value){
        return notation.get(value);
    }

    public void showHistory(){
        System.out.println(history);
    }

    public Double getCoordxMyKey(String value){
        return pointX.get(value);
    }

    public Double getCoordyMyKey(String value){
        return pointY.get(value);
    }

    public Double getCoordxComputerKey(String value){
        return pointComputerX.get(value);
    }

    public Double getCoordyComputerKey(String value){
        return pointComputerY.get(value);
    }
}
