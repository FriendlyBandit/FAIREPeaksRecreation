import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args){
        List<HashMap<String, TreeSet<Peak>>> hashies = new ArrayList<>();

        Importer import1 = new Importer();
        File dataDirectory = new File("src/RealFiles");
        for(File f: dataDirectory.listFiles()){
            HashMap<String, TreeSet<Peak>> hashy = import1.initializeFiles(f.toString());
            hashies.add(hashy);
        }

        for(HashMap<String, TreeSet<Peak>> hashy: hashies){
            for(String key: hashy.keySet()) {
                System.out.print(key + ", ");
            }
            System.out.println();
        }

        System.out.println(hashies.get(0).get("chr2L"));



    }
}
