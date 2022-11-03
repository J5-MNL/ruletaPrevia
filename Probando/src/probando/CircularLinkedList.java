package probando;

/**
 *
 * @author sweet_milkshake
 */

public class CircularLinkedList {
    Node head;
    Node tail;
    int size;
    
    public CircularLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    // -------------------------------------------------------------------------
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public int length(){
        return size;
    }
    
    public void addLast(String d) {
        Node newest = new Node(d, null);
        if(isEmpty()) {
            newest.next = newest;
            head = newest;
        } else {
            newest.next = tail.next;
            tail.next = newest;
        }
        tail = newest;
        size++;
    }
        
    public void removeAt(int position){
        Node p = head;
        int i = 1;
        
        if(isEmpty()){
            System.out.println("\nThe Circular Linked List is empty, chum!");
        } else if(position <= 0 || position > length()){
            System.out.println("\nInvalid position, pal!");
        } else if(position == 1){
            String d = head.data;
            tail.next = head.next;
            head = head.next;
            System.out.println("\nRemoved element at the begining: " + d + "\n");
            size--;
        } else if(position == length()){
            while(i < length()-1){
                p = p.next;
                i++;
            }
            String d = tail.data;
            p.next = tail.next;
            tail = p;
            System.out.println("\nRemoved element at the end: " + d);
            size--;   
        } else {
            while(i < position-1){
                p = p.next;
                i++;
            }
            String d = p.next.data;
            p.next = p.next.next;
            System.out.println("\nRemoved element: " + d);
            size--;
        }
        
    }
    
    public void display() {
        Node p = head;
        int i = 1;
        
        if(isEmpty()){
            System.out.println("\nThe Circular Linked List is empty, chum!");
        }
        
        System.out.println("");
        
        while(p.next != head) {
            System.out.println("Node #" + i + ": " + p.data);
            i++;
            p = p.next;
        }
        System.out.println("Node #" + i + ": " + tail.data + "\n");
    }
    
    public void searchData(int d) {
        
        /* Muy pendiente con este método, el mío, que este es el que menos revisaste hoy, domingo 30/10. 😒
        
        P.D: me parece que este método como que no va a hacer mucha falta para la ruleta en cuestión, así que mejor 
        prioriza otras cosas como la clase Player, el método bang() y el manejo de archivos. */
        
        /* Node p = head;
        int position = 1;
        if(isEmpty()){
            System.out.println("\nThe Circular Linked List is empty, chum!");
        }
        
        while(p.next != head) {
            if(p.data == d) {
                System.out.println("Data found in the position: " + position);
            } 
        p = p.next;
        position++;
        } */ 
        
    } 
    
}
