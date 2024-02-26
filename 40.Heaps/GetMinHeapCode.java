import java.util.ArrayList;

public class GetMinHeapCode {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();
            public void add(int data){
                // add at last idx
                arr.add(data);

                int x = arr.size()-1;  // x is child index
                int par = (x-1)/2; // par index

                while (arr.get(x) > arr.get(par)) {  // O(logn)
                    // swap
                    int temp = arr.get(x);
                    arr.set(x, arr.get(par));
                    arr.set(par, temp);

                    x = par;
                    par = (x-1)/2;
                }
            }

            public int peek(){
                return arr.get(0);
            }

            private void heapify(int i){
                int left = 2*i+1;
                int right = 2*i+2;
                int minIdx = i;  // max , and <,>, singn chang kara bas max sathi honar code

                if(left < arr.size() && arr.get(minIdx) < arr.get(left)){
                    minIdx = left;
                }

                if(right < arr.size() && arr.get(minIdx) < arr.get(right)){
                    minIdx = right;
                }

                if(minIdx != i){
                    // swap
                    int temp = arr.get(i);
                    arr.set(i,arr.get(minIdx));
                    arr.set(minIdx,temp);

                    heapify(minIdx);
                }
            }

            public int remove(){
                int data = arr.get(0);

                // step1: swap first & last 
                int temp = arr.get(0);
                arr.set(0, arr.size()-1);
                arr.set(arr.size()-1, temp);

                // step2: delete last
                arr.remove(arr.size()-1);

                // step3:
                heapify(0);
                return data;
            }

            public boolean isEmpty(){
                return arr.size() == 0;
            }
        }
    public static void main(String[] args) {
        Heap hq = new Heap();
        hq.add(3);
        hq.add(4);
        hq.add(1);
        hq.add(5);
        
        while (!hq.isEmpty()) {
            System.out.println(hq.peek());
            hq.remove();
        }
    }
}
