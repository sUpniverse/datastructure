import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class myheap {

    // 힙은 배열로 이루어져있다. 배열로 선언하는게 옳지만, 노드를 추가할때, 배열 사이즈 추가가 애매하므로 List로 구현

    private List<Integer> heap = new ArrayList<Integer>();

    public void insert(List<Integer> heap, int value) {

        //1. heap의 맨마지막 노드에 값을 삽입
        heap.add(value);
        //2. max_heapify를 함 (삽입된 노드를 부모와 비교해가며 swap)
        for(int i = heap.size()-1; i >= 0; i = (i-1)/2) {
            if(heap.get(i) > heap.get((i-1)/2)) {
                swap(i,(i-1)/2,heap);
            } else {
                break;
            }
        }
    }

    public int delete(List<Integer> heap) {

        //0. 배열이 비었는지 검사
        if(heap.size() == 0) {
            return 0;
        }

        //1. heap의 루트노드 삭제
        int maxValue = heap.get(0);

        //2. 맨 마지막 노드를 루트 노드로 옮긴다.
        heap.set(0,heap.get(heap.size()-1));

        //3. min_heapify를 실행한다. (자식 노드와 비교해가며 swap)
        for(int i = 0; i < heap.size()-1;) {

            //3-1. 자식보다 큰지 먼저 일단 비교
            if((heap.get(i) >= (heap.get(i*2)+1)) && (heap.get(i) >= heap.get((i*2)+2))){
                break;
            //3-2. 자식보다 작다면, 왼쪽,오른쪽 자식노드를 서로 비교하여 큰 자식과 swap한다.
            } else if(heap.get((i*2)+1) > heap.get((i*2)+2)) {
                swap(i,(i*2)+1,heap);
                i = (i*2)+1;
            } else {
                swap(i,(i*2)+2,heap);
                i = (i*2)+2;
            }
        }
        heap.remove(heap.size()-1);
        return maxValue;
    }

    private void swap(int index1, int index2, List<Integer> heap) {
        int temp = 0;
        temp = heap.get(index1);
        heap.set(index1,heap.get(index2));
        heap.set(index2,temp);
    }

    public void printHeap(List<Integer> heap) {
        Iterator<Integer> iterator = heap.iterator();
        System.out.println("힙 출력 :");
        while(iterator.hasNext()) {
            System.out.print(iterator.next());
        }
        System.out.println("");
    }

    public void setHeap(List<Integer> heap) {
        this.heap = heap;
    }

    public List<Integer> getHeap() {
        return heap;
    }
}
