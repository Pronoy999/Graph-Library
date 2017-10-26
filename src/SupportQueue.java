import java.util.NoSuchElementException;

/**
 * The class for the Queue.
 * @param <T>: The data of the queue.
 */
public class SupportQueue<T> {
    private static class QueueNode<T>{
        private T data;
        private QueueNode<T> next;
        public QueueNode(T data){
            this.data=data;
        }
    }
    private QueueNode<T> first;
    private QueueNode<T> last;

    /**
     * The Method to add element to the queue.
     * @param item: The element to be added to the end of the queue.
     */
    void add(T item){
        QueueNode<T> node=new QueueNode<>(item);
        if(last!=null){
            last.next=node;
        }
        last=node;
        if(first==null)
            first=last;
    }

    /**
     * The Method to remove the first element from the queue.
     * @return item: The first element of the queue.
     */
    T remove(){
        if(first==null) throw new NoSuchElementException();
        T data=first.data;
        first=first.next;
        if(first==null){
            last=null;
        }
        return data;
    }

    /**
     * The Method to check the front of the queue.
     * @return item: The first element of the queue.
     */
    public T peek(){
        if(first==null)throw new NoSuchElementException();
        return first.data;
    }

    /**
     * Method to check whether the queue is empty or not.
     * @return true: if the Queue is empty, else it will return false.
     */
    boolean isEmpty(){
        return first==null;
    }
}
