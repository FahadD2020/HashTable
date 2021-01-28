/**
 * Implements a hash table with insert, find and delete operations. A method
 * to display the table as well as printing free and collision is also there.
 * Collisions are resolved using 'separate chaining'. A double-ended singly
 * linked list is used for the same.
 *
 * @author Fahad Dawood
 * @version 31 July 2020
 */
public class HashTable { // 1

    private int tableLen;
    private SinglyLinkedList[] table;

/**
* Create a new and empty hash table
*/
    public HashTable() { // open table
        tableLen = 311;   // hash array is of size 311 (fixed; as per specs)
        table = new SinglyLinkedList[tableLen];

        for (int i = 0; i < table.length; i++) { // open for
            table[i] = new SinglyLinkedList(i);
        } // close for 
    } // close table

/**
* Insert the given country with the given GDP per capita into the
* hash table using separate chaining.
*
* @param country country name
* @param gdpPerCapita GDP per capita value
*/
    public void insert(String country, double gdpPerCapita) { // open insert
        int idx = hash(country);
        table[idx].append(country, gdpPerCapita);
    } // close insert

/**
* Find and return the GDP per capita value of the given country in this
* hash table.
*
* @param country country name to lookup
* @return the GDP per capita of the country, or -1 if not found
*/
    public double find(String country) { // open find
        int idx = hash(country);
        return table[idx].find(country);
    } // close find

/**
* Delete the given country name from the hash table.
*
* @param country country name to delete
*/
    public void delete(String country) { // open delete
        int idx = hash(country);
        table[idx].delete(country);
    } // close delete

/**
* Print out all the "lists" in this hash table.
*/
    public void display() { // open display
        System.out.printf("Hash table content:\n\n");
        for (int idx = 0; idx < table.length; idx++) { // open for
            table[idx].print();
        } // close for
        System.out.printf("\n");
    } // close display

/**
* Print the "empty" and "collision" locations in this hash table.
* A location is "empty" if there are 0 elements in the list there.
* A location is "collision" if there > 1 elements in the list
* there.
*/
    public void printFreeAndCollisions() { // open Free
        int empty = 0;
        int collision = 0;
        for (int idx = 0; idx < table.length; idx++) { // open for
            if (table[idx].isEmpty()) { // if
                empty++;
            } else if (table[idx].length() > 1){
                collision++;
            } // if
        } // close for
        System.out.printf("There are %d spaces available and %d collisions " +
                "in the hash table\n", empty, collision);
    } // close free

    // return the hash of the given string name.
    // hash = sum of all Unicode values in name % tableLen
    private int hash(String name) { // open hash
        int sum = 0;
        for (int i = 0; i < name.length(); i++) { // for
            sum += name.codePointAt(i);
        } // for
        return sum % tableLen;
    } // hash
} // 1
