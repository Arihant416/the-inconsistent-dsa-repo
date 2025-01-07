@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {
  private T[] arr;
  private int len = 0;
  private int capacity = 0;

  public DynamicArray() {
    this(16);
  }

  public DynamicArray(int capacity) {
    if (capacity < 0)
      throw new IllegalArgumentException("Illegal capacity: " + capacity);
    this.capacity = capacity;
    arr = (T[]) new Object[capacity];
  }

  public int size() {
    return len;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public T get(int index) {
    return arr[index];
  }

  public void set(int index, T element) {
    arr[index] = element;
  }

  public void clear() {
    for (int i = 0; i < capacity; i++) {
      arr[i] = null;
    }
    len = 0;
  }

  public void add(T element){
    if(len + 1 >= capacity){
      if(capacity == 0)capacity = 1;
      else capacity *= 2;
      T[] new_arr = (T[]) new Object[capacity];
      for(int i = 0; i < len; i++){
        new_arr[i] = arr[i];
      }
      arr = new_arr;
    }
    arr[len++] = element;
  }

  public T removeAt(int indexToRemove){
    if(indexToRemove >= len || indexToRemove < 0)throw new IndexOutOfBoundsException();
    T data = arr[indexToRemove];
    T[] new_arr = (T[]) new Object[len-1];
    for(int i = 0, j = 0; i < len; i++, j++){
      if(i == indexToRemove)j--;
      else new_arr[j] = arr[i];
    }
    arr = new_arr;
    capacity = --len;
    return data;
  }

  // We ought to override iterator
}