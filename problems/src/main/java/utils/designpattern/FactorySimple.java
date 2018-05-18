package utils.designpattern;

public class FactorySimple {

    interface Product{
        void work();
    }

    static class ProductA implements Product{
        @Override
        public void work() {
            System.out.println("product A");
        }
    }

    static class ProductB implements Product{
        @Override
        public void work() {
            System.out.println("product B");
        }
    }

    static class SFactroy{

        Product build(String type){
            switch (type){
                case "A": return new ProductA();
                case "B": return new ProductB();
            }
            return null;
        }
    }

    public static void main(String[] args) {
        SFactroy sFactroy = new SFactroy();
        Product product = sFactroy.build("A");
        product.work();
    }

}
