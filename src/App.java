import java.util.Scanner;
import java.util.HashMap;

public class App {
    static HashMap database;

    public static void main(String[] args) throws Exception {
        database = new HashMap<String, String>(); //Code, then Name
    
        Scanner scan = new Scanner(System.in);  

        while(true) {
            System.out.println("Enrollment, Recognition or Stop? (e, r, s)");
            String input = scan.nextLine();
            
            if (input.equals("e")) {
                System.out.println("Please enter your Iris Code");
                Long hexIris = Long.parseLong(scan.nextLine(), 16);
                String binary = Long.toBinaryString(hexIris);  
                System.out.println("Binary: " + binary);

                System.out.println("Please enter your Name");
                String name = scan.nextLine();

                database.put(name, binary);
                System.out.println("Enrolled");
            }

            if (input.equals("s")) break;

            if (input.equals("r")) {
                Double unmatchedBits = 0.0;
                Double totalBits = 0.0;

                System.out.println("Who are you?");
                String name = scan.nextLine();

                System.out.println("Please enter your Iris Code");
                Long hexIris = Long.parseLong(scan.nextLine(), 16);
                String binary = Long.toBinaryString(hexIris);  
                System.out.println("Binary: " + binary);

                String realbinary = (String) database.get(name);
                totalBits = (double) binary.length();
                System.out.println("Real binary: " + realbinary);

                for (int i = 0; i < binary.length(); i++) {
                    if (realbinary.charAt(i) != (binary.charAt(i))) {
                        unmatchedBits++;
                    }
                }

                Double hammingDistance = (unmatchedBits/totalBits);
                System.out.println("Hamming Dist: " + hammingDistance);

                if (hammingDistance < 0.32) System.out.println("Access Granted");
                else System.out.println("Access Denied");
            }
        }
    }

    
}
