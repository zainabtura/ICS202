import java.util.Arrays;

public class BinaryHeap
{
   protected Comparable array[];
   int count;

   public BinaryHeap(int i) {
      array = new Comparable[i + 1];
   }

   public BinaryHeap(Comparable[] comparable) {
      this(comparable.length);
      for (int i = 0; i < comparable.length; i++)
         array[i + 1] = comparable[i];

      count = comparable.length;

      buildHeapTopDown();
      //buildHeapBottomUp();
   }

   private void buildHeapBottomUp() {
      for (int i = count / 2; i > 0; i--) {
         percolateDown(i);
      }
   }

   private void buildHeapTopDown() {
      for (int i = 2; i <= count; i++) {
         percolateUp(i);
      }
   }

   private void percolateDown(int index) {
      int child;
      Comparable tmp = array[index];
      for (; index * 2 <= count; index = child) {
         child = index * 2;
         if (child != count && array[child + 1].compareTo(array[child]) < 0)
            child++;
         if (array[child].compareTo(tmp) < 0)
            array[index] = array[child];
         else
            break;
      }
      array[index] = tmp;
   }

   private void percolateUp(int index) {
      Comparable tmp = array[index];
      for (; index > 1 && tmp.compareTo(array[index / 2]) < 0; index /= 2) {
         array[index] = array[index / 2];
      }
      array[index] = tmp;
   }

   public void purge()
   {
      while(count > 0)
         array[count--] = null;
   }

   public void enqueue(Comparable comparable)
   {
      int index = ++count;

      //percolate up via a gap
      while(index > 1 && array[index / 2].compareTo(comparable) > 0)
      {
         array[index] = array[index / 2];
         index = index / 2 ;
      }

      array[index] = comparable;
   }

   public Comparable findMin()
   {
      return array[1];
   }

   public Comparable dequeueMin()
   {
      Comparable minItem = array[1];
      array[1] = array[count];
      count--;
      percolateDown(1);
      return minItem;
   }

   public Comparable[] heapSort()
   {
      Comparable[] x = new Comparable[count];
      int total = count;
      for(int i = 0; i < total; i++) {
         x[i] = dequeueMin();
      }
   return x;
   }


   public boolean isFull()
   {
      return count == array.length - 1;
   }

   public boolean isEmpty()
   {
      return count == 0;
   }

   public String toString()
   {
      Comparable[] tempArray = new Comparable[array.length - 1];
    	System.arraycopy(array, 1, tempArray, 0, array.length - 1);
    	return Arrays.toString(tempArray);
   }

   public static void main(String[] args) {
      Integer[] a = {10, 2, 8, 9, 1, 6, 3, 4, 0, 5};
      System.out.println("The original array is: " + Arrays.toString(a));
      BinaryHeap bh = new BinaryHeap(a);
      // builds heap bottom up: change the constructor to build it top-down
      System.out.println("\nThe heap is: " + bh);
      System.out.println("\nSorted Array is: " + Arrays.toString(bh.heapSort()));
   }
}


