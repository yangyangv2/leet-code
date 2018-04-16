package utils.test;

public class TestSquare {

    public static void main(String[] args) {

        int n = 1000000;

        int x, y;
        x = y = (int) Math.sqrt(n);


        int z = 0;
        while(true){
            z = x * y;
            if(z > n + 2){
                x --;
            } else if(z < n ){
                y ++;
            } else {
                break;
            }
        }


        System.out.println(String.format("x = %s, y = %s", x, y));


    }
}
