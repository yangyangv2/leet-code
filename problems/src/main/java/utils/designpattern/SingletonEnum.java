package utils.designpattern;

public enum SingletonEnum {
    INSTANCE;
    SingletonEnum(){}
    public int add(int a, int b){
        return a + b;
    }
}
