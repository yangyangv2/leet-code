package utils.designpattern;

public class Main {

    public static void main(String[] args) {

        assert SingletonEnum.INSTANCE.add(1, 5) == 6;
        assert SingletonStatic.getInstatnce().add(1 , 5) == 6;
        assert SingletonDCL.getInstance().add(1, 6) == 6;
    }
}
