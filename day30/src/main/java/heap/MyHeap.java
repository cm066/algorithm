package heap;



import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Administrator
 */
public class MyHeap<E> {
   private Object[] data;
   private int size;
   private Comparator<? super E> comparator;

   public MyHeap(int  initialCapacity){
      this(initialCapacity,null);
   }

   public MyHeap(int initialCapacity, Comparator<? super E>  comparator) {
      if (initialCapacity < 1){
         throw new IllegalArgumentException("堆的大小必须大于0");
      }
      this.data = new Object[initialCapacity];
      this.comparator = comparator;

   }

   public boolean add(E e){
      if (e == null){
         throw new NullPointerException();
      }
      if (size >= data.length){
         data = Arrays.copyOf(data,data.length << 1);
      }
      if (size == 0){
         data[0] = e;
      }else {
         siftUp(e);
      }
      size++;
      return true;
   }

   public int getSize(){
      System.out.println(Arrays.toString(data));
      return size;
   }

   /**
    * 删除栈顶元素
    * @return
    */
   public E remove(){
      if (size == 0){
         return null;
      }
      size--;
      E result = (E)data[0];
      //获取栈顶元素 todo 这里应该是有问题的
      E e = (E) data[size];
      data[size] = null;
      if (size != 0){
         siftDownWithComparable(e);
         if (comparator != null){
            siftDownWithComparator(e);
         }else {
            siftDownWithComparable(e);
         }
      }
      return result;
   }

   public E peek(){
      return (size == 0)?null: (E) data[0];
   }

   public <T> T[] toArray(T[] a){
      if (a.length < size){
         return (T[])Arrays.copyOf(data,size,a.getClass());
      }
      System.arraycopy(data,0,a,0,size);
      if (a.length > size){
         a[size] = null;
      }
      return a;
   }
   private void siftDown(int k, E x) {
      if (comparator != null) {
         siftDownUsingComparator(k, x, data, size, comparator);
      } else {
         siftDownComparable(k, x, data, size);
      }
   }
   private static <T> void siftDownComparable(int k, T x, Object[] es, int n) {
      // assert n > 0;
      Comparable<? super T> key = (Comparable<? super T>)x;
      int half = n >>> 1;           // loop while a non-leaf
      while (k < half) {
         int child = (k << 1) + 1; // assume left child is least
         Object c = es[child];
         int right = child + 1;
         if (right < n &&
                 ((Comparable<? super T>) c).compareTo((T) es[right]) > 0) {
            c = es[child = right];
         }
         if (key.compareTo((T) c) <= 0) {
            break;
         }
         es[k] = c;
         k = child;
      }
      es[k] = key;
   }
   private static <T> void siftDownUsingComparator(
           int k, T x, Object[] es, int n, Comparator<? super T> cmp) {
      // assert n > 0;
      int half = n >>> 1;
      while (k < half) {
         int child = (k << 1) + 1;
         Object c = es[child];
         int right = child + 1;
         if (right < n && cmp.compare((T) c, (T) es[right]) > 0) {
            c = es[child = right];
         }
         if (cmp.compare(x, (T) c) <= 0) {
            break;
         }
         es[k] = c;
         k = child;
      }
      es[k] = x;
   }

   private void siftDownWithComparator(E e){
      int half = size >>> 1;
      int index = 0;
      while (index < half){
         //左子树
         int min = (index << 1)+1;
         //现在要做的就是找出当前节点中左右子树中最小的一个节点
         Object minChild = data[min];
         int right = min +1;
         //这个是判断是否有右子树
         if (right < size && (comparator.compare((E) minChild,(E)data[right]) > 0)){
            minChild = data[min = right];
         }
         if (comparator.compare(e,(E)minChild ) <= 0){
            break;
         }
         data[index] = minChild;
         index = min;
      }
      //这个是讲最后一个元素赋值到正确的位置
      data[index] = e;
   }
   /**
    * 往下调整，往下调整需要和他的两个的两个子节点（如果有两个子节点）都要比较，
    * 那个最小就和那个交换，如果比两个子节点都小就不用交换
    * @param e
    */
   private void siftDownWithComparable(E e) {
      int half = size >>> 1;
      int index = 0;
      while (index < half) {
         //根据父节点的位置可以找到左节点的位置
         int min = (index << 1) + 1;
         Object minChild = data[min];
         int right = min + 1;
         if (right < size && (((Comparable<? super E>) minChild).compareTo((E) data[right]) > 0)) {
            minChild = data[min=right];

         }
         if (((Comparable<? super E>) e).compareTo((E) minChild) <= 0) {
            break;
         }

         data[index] = minChild;
         index = min;
      }
      data[index] = e;
   }

   /**
    * 添加的时候可能会往上或者往下调整
    * @param e
    */
   private void siftUp(E e) {
      int s = size;
      while (s > 0){
         //插入的时候不是一来就跟堆顶的元素进行比较，而是更自己的父节点进行比较
         int parent = (s-1)>>>1;
         Object pData = data[parent];
         if (comparator != null){
            if (comparator.compare(e,(E) pData) >= 0){
               break;
            }
         }else {
            if (((Comparable<? super E>)e).compareTo((E) pData) >= 0){
               break;
            }
         }
         data[s] = pData;
         s = parent;
      }
      data[s] = e;
   }
}
