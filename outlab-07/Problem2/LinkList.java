/*!	\file LinkList
 	\brief Implements linked list in java

*/

/*!	\class LinkList
 	\brief template class representing a linked list
 	\param T data type	

*/
public class LinkList<T> {
 
    private Node<T> front;	/*!< Node pointing to the first member*/
    private Node<T> rear;	/*!< Node pointing to the end*/
     
/*!	inserting an element at the front
	\param item the element to be inserted (of type T)

*/
    public void insertFront(T item){
        //add element at the beginning of the queue
        System.out.println("adding at front: "+item);
        Node<T> nd = new Node<T>();
        nd.setValue(item);
        nd.setNext(front);
        if(front != null) front.setPrev(nd);
        if(front == null) rear = nd;
        front = nd;
    }

/*!	inserting an element at the rear
	\param item the element to be inserted (of type T)

*/     
    public void insertRear(T item){
        //add element at the end of the queue
        System.out.println("adding at rear: "+item);
        Node<T> nd = new Node<T>();
        nd.setValue(item);
        nd.setPrev(rear);
        if(rear != null) rear.setNext(nd);
        if(rear == null) front = nd;
         
        rear = nd;
    }

/*!	pop an element from the front
*/
    public void removeFront(){
        if(front == null){
            System.out.println("Deque underflow!! unable to remove.");
            return;
        }
        //remove an item from the beginning of the queue
        Node<T> tmpFront = front.getNext();
        if(tmpFront != null) tmpFront.setPrev(null);
        if(tmpFront == null) rear = null;
        System.out.println("removed from front: "+front.getValue());
        front = tmpFront;
    }

/*!	pop an element from the rear
*/
     
    public void removeRear(){
        if(rear == null){
            System.out.println("Deque underflow!! unable to remove.");
            return;
        }
        //remove an item from the beginning of the queue
        Node<T> tmpRear = rear.getPrev();
        if(tmpRear != null) tmpRear.setNext(null);
        if(tmpRear == null) front = null;
        System.out.println("removed from rear: "+rear.getValue());
        rear = tmpRear;
    }
  
    public static void main(String a[]){
        LinkList<Integer> deque = new LinkList<Integer>();
        deque.insertFront(34);
        deque.insertFront(67);
        deque.insertFront(29);
        deque.insertFront(765);
        deque.removeFront();
        deque.removeFront();
        deque.removeFront();
        deque.insertRear(43);
        deque.insertRear(83);
        deque.insertRear(84);
        deque.insertRear(546);
        deque.insertRear(356);
        deque.removeRear();
        deque.removeRear();
        deque.removeRear();
        deque.removeRear();
        deque.removeFront();
}
        deque.removeFront();
        deque.removeFront();
    }

/*!	\class Node
 	\brief template class representing a node in a linked list
 	\param T data type	

*/ 
class Node<T>{
     
    private Node<T> prev;	/*!< pointer to the previous element*/
    private Node<T> next;	/*!< pointer to the next element*/
    private T value;		/*!< value of the node*/
    
/*!	get the previous element
*/      
    public Node<T> getPrev() {
        return prev;
    }

/*!	change the previous element
	\param prev the element to be set as the previous node for the current element

*/     
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

/*!	get the next element
*/      
   public Node<T> getNext() {
        return next;
    }

/*!	change the next element
	\param next the element to be set as the next node for the current element

*/     
    public void setNext(Node<T> next) {
        this.next = next;
    }

/*!	get the value of the node
*/     
    public T getValue() {
        return value;
    }

/*!	change the value of the node
	\param value new value of the node

*/     
    public void setValue(T value) {
        this.value = value;
    }
}