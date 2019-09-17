import java.util.ArrayList;
import java.util.List;

public class heapapplication {

    public static void main(String[] args) {
        myheap myheap = new myheap();
        List<Integer> heap = new ArrayList<Integer>();
        for(int i =8; i > 0; i-- ) {
            heap.add(i);
        }
        myheap.setHeap(heap);

        myheap.printHeap(myheap.getHeap());

        myheap.insert(myheap.getHeap(),9);

        myheap.printHeap(myheap.getHeap());

        myheap.delete(myheap.getHeap());

        myheap.printHeap(myheap.getHeap());

    }

}
