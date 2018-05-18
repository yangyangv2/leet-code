package utils.designpattern;

public class Strategy {

    interface Operate {
        int operate(int a, int b);
    }

    static class Add implements Operate{
        @Override
        public int operate(int a, int b) {
            return a + b;
        }
    }
    static class Sub implements Operate{
        @Override
        public int operate(int a, int b) {
            return a - b;
        }
    }

    static class Operator {

        private Operate operate;
        Operator(String method){
            switch (method){
                case "add": operate = new Add(); break;
                case "sub": operate = new Sub(); break;
            }
        }

        int operate(int a, int b){

            return operate.operate(a, b);
        }
    }

    public static void main(String[] args) {
        Operator operator = new Operator("add");
        assert operator.operate(1, 4) == 5;
    }
}
