package utils.designpattern;

public class SingletonDCL {

    private static volatile SingletonDCL singleton;

    public static SingletonDCL getInstance(){

        if(singleton == null){
            synchronized (SingletonDCL.class){
                if(singleton == null){
                    singleton = new SingletonDCL();
                }
            }
        }
        return singleton;
    }

    public int add(int a, int b){
        return a + b;
    }
}
