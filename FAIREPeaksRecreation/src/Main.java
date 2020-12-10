import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<HashMap<String, TreeMap<Integer, Peak>>> hashies = new ArrayList<>();

        Importer import1 = new Importer();
        File dataDirectory = new File("src/RealFiles");
        for (File f : dataDirectory.listFiles()) {
            System.out.println(f.toString());
            //HashMap<String, TreeSet<Peak>> hashy = import1.initializeFiles(f.toString());
            //hashies.add(hashy);
        }
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Which 2 files would you like to compare?");
        String temp = scan1.nextLine();
        String[] arguments = temp.split("\\s+");

        for(File file: dataDirectory.listFiles()){ //Gets all files in RealFiles
            HashMap<String, TreeMap<Integer, Peak>> hashy;

            if(file.toString().contains(arguments[0])){
                System.out.println(file.toString());
                hashy = import1.initializeFiles(file.toString());
                hashies.add(hashy); //Gets the path from the string given and stores that file in hashies
                import1 = new Importer();
            } else if(file.toString().contains(arguments[1])){
                System.out.println(file.toString());//Does the same for the second argument
                hashy = import1.initializeFiles(file.toString());
                hashies.add(hashy);
                import1 = new Importer();
            }
        }

        System.out.println();
        for(HashMap<String, TreeMap<Integer, Peak>> hashy2 : hashies){ //Verification that it loaded properly
            StringBuilder stringBuilder = new StringBuilder(); //Simply prints the objects in hashies
            for(String key: hashy2.keySet()){
                stringBuilder.append(key + ", ");
            }
            String output = stringBuilder.toString();
            System.out.print(output.substring(0, output.length() - 2));
            System.out.println();
        }
//      Displays all Peaks that were grabbed...
//        for (HashMap<String, TreeMap<Integer, Peak>> hashy3 : hashies){
//            for(String key : hashy3.keySet()){
//                TreeMap<Integer, Peak> tree = hashy3.get(key);
//                System.out.println("\n\n\n\n\n" + key);
//                for(Integer I: tree.keySet()){
//                    System.out.print(I + " Goes to " + tree.get(I).startAndEnd() + ", ");
//                }
//            }
//            System.out.println();
//            System.out.println();
//            System.out.println();
//            System.out.println();
//            System.out.println();
//            System.out.println();
//        }
    }
}
