package utils.designpattern;

public class SingletonStatic {

    private SingletonStatic(){}

    private static class InnerStaticSingleton {
        private static SingletonStatic singleton = new SingletonStatic();
    }

    public static SingletonStatic getInstatnce(){
        return InnerStaticSingleton.singleton;
    }
    public int add(int a, int b){
        return a + b;
    }

}
