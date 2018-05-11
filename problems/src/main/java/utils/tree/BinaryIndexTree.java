package utils.tree;

public class BinaryIndexTree {


    static class BIT{

        int[] count;

        BIT(int n){
            count = new int[n + 1];
        }

        void update(int index){
            while(index > 0){
                count[index] ++;
                index -= index & (- index);
            }

            this.print();
        }

        int find(int index){
            int sum = 0;
            while(index < count.length){
                sum += count[index];
                index += index & (- index);
            }
            return sum;
        }

        void print(){
            StringBuilder sb1 = new StringBuilder();
            sb1.append("index:\t");
            StringBuilder sb2 =  new StringBuilder();
            sb2.append("count:\t");
            for(int i = 1; i < count.length; i ++){
                sb1.append(i).append("\t");
                sb2.append(count[i]).append("\t");
            }
            System.out.println(sb1.append("\n").append(sb2.toString()).append("\n"));
        }

    }



    public static void main(String[] args) {

        int[] nums = new int[] {1,2,3,4,5};
        BIT bit = new BIT(nums.length);
        for(int i = 0; i < nums.length; i ++){
            bit.update(i + 1);
        }

        System.out.println(bit.find(3) - bit.find(4 + 1));

    }
}
