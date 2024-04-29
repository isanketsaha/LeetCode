package StudyPlan.PriorityQueue;

public class Heap {

    int[] heapElement = new int[10];

    int lastInsertedIndex = 0;


    void insert(int data) {
        heapElement[lastInsertedIndex] = data;
        int index = lastInsertedIndex;
        int parent = (index - 1) / 2;
        while (heapElement[index] < heapElement[parent]) {
            int tmp = heapElement[parent];
            heapElement[parent] = heapElement[index];
            heapElement[parent] = tmp;
            index = parent;
            parent = (index - 1) / 2;
        }
        lastInsertedIndex++;
    }

    void delete() {
        int element = heapElement[0];
        heapElement[0] = heapElement[lastInsertedIndex - 1];

//        while()
    }


}
