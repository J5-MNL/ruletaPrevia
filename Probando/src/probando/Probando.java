package probando;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author sweet_milkshake
 */

public class Probando {

    public static void main(String[] args) throws FileNotFoundException, IOException{
        startGame(6, "C:\\Users\\sweet\\Documents\\Probando\\src\\probando\\Players.in.txt");
        createRevolversChambers();
        bang();
        assignAlive();
        
        
        
    }
    
    static CircularLinkedList CLL = new CircularLinkedList();
    
    static CircularLinkedList CLL2 = new CircularLinkedList();
    
    static void startGame(int listSize, String filepath) throws FileNotFoundException, IOException{
        try {
            System.out.println("\t\t\t\t\tUsuarios y usuarias, estimados y estimadas; bienvenidos al juego potencialmente mortal del momento:");
            System.out.println("\t\t\t\t\t\t\t\t\t\t¡la ruleta rusa! 😵\n");
            int i = 0;
            String[] playersName = new String[listSize];
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String line = br.readLine();
        
            while(i < listSize && line != null){
                CLL.addLast(line);
                i++;
                line = br.readLine();
            }
        
            br.close();
            
            System.out.println("\t\tPara esta partida contaremos, en principio, con " + CLL.length() + " jugadores (no garantizamos la seguridad ni el bienestar de los jugadores a través de la partida 💀)\n");
            int h = 0;
            Node p = CLL.head;
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\n\t\tUna vez dicho eso, podemos anunciar a los participantes de este peculiar evento. Con muchísimo que perder y poco que ganar, estos dementes son:\n");
            
            while(h <CLL.length()){
                h++;
                System.out.println("\t\t\t\t\t\t\t\tCon el número #" + h + ", tenemos al jugador/a " + p.data);
                p = p.next;
            }
            
            } catch (IOException e){
                System.out.println("\t\t\t\t\t\tChamo/a, usted especificó mal la dirección del archivo y sin archivo no hay jugadores 😕");
            }
           
    }
    
    static void createRevolversChambers(){
        int i = 0;
        while(i < 6){
            CLL2.addLast("");
            i++;
        }
        
        Node p1 = CLL2.head;
        int j = 1;
        while(p1.next != CLL2.head){
            p1.chamber = j;
            j++;
            p1 = p1.next;
        }
        CLL2.tail.chamber += j;
    }
    
    static void bang(){
        Node p = CLL.head;
        Random r = new Random();
        while(p.next != CLL.head){
            int bullet = r.nextInt((6-1) + 1) + 1;
            int randomChamber = r.nextInt((6-1) + 1) + 1;
            if(bullet == randomChamber){
                CLL2.head.alive = false;
                p = p.next;
            } else {
                CLL2.head.alive = true;
                p = p.next;
            }   
        }
        
        int bullet = r.nextInt((6-1) + 1) + 1;
        int randomChamber = r.nextInt((6-1) + 1) + 1;
        if(bullet == randomChamber){
                CLL2.tail.alive = false;
            } else {
                CLL2.tail.alive = true;
            } 
    
    }
    
    static void assignAlive(){
        Node p = CLL.head;
        while(p.next != CLL.head){
            CLL.head.alive = CLL2.head.alive;
            p = p.next;
        }
        
        CLL.tail = CLL2.tail;
    }
    
    static void playersOut(){
        
    }
    
}
    
