import java.util.HashMap;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args){
        Importer import1 = new Importer();
        HashMap<String, TreeSet<Peak>> hashy = import1.initializeFiles();
        for(String key: hashy.keySet()){
            System.out.println(key);
        }
    }
}
