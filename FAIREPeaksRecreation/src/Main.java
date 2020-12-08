import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args){
        List<HashMap<String, TreeSet<Peak>>> hashies = new ArrayList<>();

        Importer import1 = new Importer();
        File dataDirectory = new File("src/RealFiles");
        for(File f: dataDirectory.listFiles()){
            System.out.println(f.toString());
            //HashMap<String, TreeSet<Peak>> hashy = import1.initializeFiles(f.toString());
            //hashies.add(hashy);
        }
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Which 2 files would you like to compare?");
        String temp = scan1.nextLine();
        String[] arguments = temp.split("\\s+");
        System.out.println(arguments[0]);
        System.out.println(arguments[1]);

        for(File f: dataDirectory.listFiles()){
            HashMap<String, TreeSet<Peak>> hashy;

            if(f.toString().contains(arguments[0])){
                System.out.println(f.toString());
                hashy = import1.initializeFiles(f.toString());
                hashies.add(hashy);
            }else if (f.toString().contains(arguments[1])){
                System.out.println(f.toString());
                hashy = import1.initializeFiles(f.toString());
                hashies.add(hashy);

            }
        }

       for(HashMap<String, TreeSet<Peak>> hashy: hashies){
            StringBuilder stringBuilder = new StringBuilder();
            for(String key: hashy.keySet()) {
                stringBuilder.append(key + ", ");
            }
            String output = stringBuilder.toString();
            System.out.print(output.substring(0, output.length()-2));

            System.out.println();
        }

        //System.out.println(hashies.get(0).get("chr2L"));



    }
}
