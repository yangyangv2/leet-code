package utils.designpattern;

public class FactoryNormal {

    interface Factory{
        Product build();
    }
    interface Product{
        void work();
    }
    static class ProductA implements Product{
        @Override
        public void work() {
            System.out.println("product A");
        }
    }
    static class FactoryA implements Factory{
        @Override
        public Product build() {
            return new ProductA();
        }
    }
    static class ProductB implements Product{
        @Override
        public void work() {
            System.out.println("product B");
        }
    }
    static class FactoryB implements Factory{
        @Override
        public Product build() {
            return new ProductA();
        }
    }

    public static void main(String[] args) {
        Factory factory = new FactoryA();
        Product product = factory.build();
        product.work();
    }
}
