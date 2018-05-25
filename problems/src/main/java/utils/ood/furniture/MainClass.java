package utils.ood.furniture;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args){
        Table table = null;
        Scanner input =  new Scanner(System.in);
        String str = input.next();
        if(str.equals("wooden")){
            table = new WoodenTable();
        }   else if (str.equals("metal")){
            table = new MetalTable();
        }
        System.out.println(table.tableType());
        table.stressTest();
        table.fireTest();
    }
}