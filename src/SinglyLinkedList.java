/**
 * Implements a singly linked list (there is only 1 link between nodes, while
 * maintaining "head" and "tail" of the list at all times). The class has methods
 * to append (add a node at the end), find and delete. There is also a method to
 * print the list in a neat way.
 *
 * @author Fahad Dawood
 * @version 31 July, 2020
 */
public class SinglyLinkedList { // 1

    private Node head;
    private Node tail;
    private int id;     // id of this list (used for printing)
    private int size;

    // Node in this list. Private to SinglyLinkedList
    private class Node { // open node
        String name;
        double gdpPerCapita;
        Node nextNode;

        // Constructor to create a new node.
        public Node(String name, double gdpPerCapita) { // open cons
            this.name = name;
            this.gdpPerCapita = gdpPerCapita;
        } // close cons

        // print the contents of this node
        public void printNode() {  // open printnode
            System.out.printf("%-25s%,-20.2f\n", name, gdpPerCapita);
        } // close printnode
    } // close node

/**
* Constructor for a new empty SinglyLinkedList with a given id. This id
* is only used in printing this list.
*
* @param id id of this list
*/
    public SinglyLinkedList(int id) { // open list
        head = null;
        tail = null;
        size = 0;
        this.id = id;
    } // close list

/**
* Add a new node with the given name and value, at the end of
* this list.
*
* @param name name to add
* @param value the value of this node.
*/
    public void append(String name, double value) { // open append
        //check();

        Node node = new Node(name, value);
        if (head == null) {  // if
            // inserting the 1st node
            head = node;
            tail = node;
        } else { // else
            // inserting at the end
            tail.nextNode = node;
            tail = node;
        } // loop
        size++;
    } // close append

/**
* Search for a given name in this list. Return its value if
* found, or -1 if not found.
*
* @param name name to find
* @return the value in the list, or -1 if not found.
*/
    public double find(String name) { // opne find
        //check();

        double value = -1;
        Node node = head;
        while (node != null) { // open loop
            if (node.name.compareTo(name) == 0) { // if
                value = node.gdpPerCapita;
                break;
            } // if
            node = node.nextNode;
        } // loop
        return value;
    } // close find

/**
* Delete the node with the given name.
*
* @param name the name to delete
*/
    public void delete(String name) { // open delete 
        //check();

        if (head == null) { return; }   // empty list, nothing to do

        if (head.name.compareTo(name) == 0) { // if
            // deleting the 1st node in the list
            head = head.nextNode;
            if (head == null) { // if
                tail = null;   // list had only 1 node. We deleted it
            } // if
            size--;
        } else { // if
            // deleting in a list of length > 1
            Node node = head;
            while (node.nextNode != null) { // loop
                if (node.nextNode.name.compareTo(name) == 0) { // if
                    // found the node to delete
                    node.nextNode = node.nextNode.nextNode;
                    if (node.nextNode == null) { // if
                        tail = node;   // we deleted the last node
                    } // if
                    size--;
                    break;
                } // if
                node = node.nextNode;
            } // loop
        } // if
    } // close delete

/**
* Neatly print this list. It prints the id of the list. For an
* empty list it prints "Empty". For non empty list it prints all
* the list nodes, one line at a time.
*/
    public void print() { // open print
        if (head == null) { // if
            // list is empty
            System.out.printf("%3d. %s\n", id, "Empty");
            return;
        } // if

        // print the first node along with the list id
        System.out.printf("%3d. ", id);
        head.printNode();

        // print the rest of the list
        Node node = head.nextNode;
        while (node != null) { // loop
            System.out.printf("     ");
            node.printNode();
            node = node.nextNode;
        } // loop
    } // close print

/**
* Is this list empty?
*
* @return true if this list is empty, false otherwise.
*/
    public boolean isEmpty() { // open empty
        //check();
        return size == 0;
    } // close empty

/**
* Return the length of this list.
*
* @return the length of this list.
*/
    public int length() { // open length
        return size;
    } // close length

    // method for debugging purpose
    private void check() { // open check
        // either both head and tail must be not null (non empty list), or
        // both are null (empty list)
        assert( (head != null && tail != null && size > 0) ||
                (head == null && tail == null && size == 0) );
    } // close check
} // 1
