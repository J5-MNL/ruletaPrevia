package probando;

import java.util.Random;

/**
 *
 * @author sweet_milkshake
 */

public class Node {
    String data;
    boolean alive;
    int chamber;
    Node next;
    
    public Node(String d, Node n){
        this.data = d;
        this.next = n;
    }
    
    public void bang(){
        Random r = new Random();
        int bullet = r.nextInt(7);
        int chamber = r.nextInt(7);
        System.out.println("La bala está en la recámara " + bullet + ", y el revólver se ubica en la recámara " + chamber);
    }
    
}
