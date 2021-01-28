import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * COP 3530: Project 3 - Hash Tables
 * <p>
 *     Driver class to test HashTable class functionality. A hash table
 *     is created using a CSV file, and delete/find/display etc operations
 *     are performed on it as per specs.
 * </p>
 *
 * @author Fahad Dawood
 * @version 31 July 2020
 *
 */
public class Project3 { // 1

/**
* Main driver class to test things.
* @param args args to this class (We don't use it
* @throws Exception in case of any exception like bad number format or
* file IO
*/
    public static void main(String[] args) throws Exception { // main
        // 1. Read Countries3.csv and insert into a new hash table
        // and display it
        HashTable ht = readFile();
        ht.display();

        // 2. Delete "Cyprus", "Kazakhstan", "Hungary" and "Japan"
        String[] toDel1 = {"Cyprus", "Kazakhstan", "Hungary", "Japan"};
        deleteCountries(ht, toDel1);

        // 3. Search "Costa Rica". "North Cyprus", "Hungary" and
        // print their GDP per capita
        String[] toFind = {"Costa Rica", "North Cyprus", "Hungary"};
        findCountries(ht, toFind);

        // 4. Delete following and display hash table
        String[] toDel2 = {"Zambia", "Canada", "Egypt", "Yemen", "India",
                "Singapore"};
        deleteCountries(ht, toDel2);
        ht.display();

        // 5. Print the no. of empty cells and the no. of cells with
        // collisions in the final table by calling printFreeAndCollisions()
        ht.printFreeAndCollisions();
    } // close main

    // helper method to read the csv file and load into a hash table.
    // Return that hash table.
    private static HashTable readFile() throws Exception { // read
        System.out.print("Enter the file name: ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        // create hash table from file read
        HashTable ht = new HashTable();
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));

        br.readLine();  //ignore 1st header line

        String line;
        int numLines = 0;
        while ((line = br.readLine()) != null) { // loop
            numLines++;

            String[] splits = line.split(",");
            String name = splits[0];
            double population = Double.valueOf(splits[3]);
            double gdp =  Double.valueOf(splits[4]);
            double gdpPerCapita = gdp / population;
            ht.insert(name, gdpPerCapita);
        } // loop
        System.out.printf("\nThere were %d country records read into " +
                "the hash table.\n\n", numLines);
        return ht;
    } // read

    // helper method to delete all counties in a given array from a given bst
    private static void deleteCountries(HashTable ht, String[] countries) { // open delete
        for (int i = 0; i < countries.length; i++) { // loop
            ht.delete(countries[i]);
            System.out.printf("%s has been deleted from hash table\n",
                    countries[i]);
        } // loop
        System.out.printf("\n");
    } // close delete

    // helper method to find countries given in an array
    private static void findCountries(HashTable ht, String[] countries) { // open find
        for (String country : countries) { // for
            double gdpPerCapita = ht.find(country);
            if (gdpPerCapita < 0) { // if
                System.out.printf("%s is not found\n", country);
            } else { // if
                System.out.printf("%s is found with a GDP per capita of %.2f\n",
                        country, gdpPerCapita);
            } // if
        } // for
        System.out.printf("\n");
    }
} // 1
