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

        HashMap<String, TreeSet<Peak>> firstFile;
        HashMap<String, TreeSet<Peak>> secondFile;
        for(File f: dataDirectory.listFiles()){
            if(f.toString().contains(arguments[0])){
                System.out.println(f.toString());
                firstFile = import1.initializeFiles(f.toString());
                hashies.add(firstFile);
            }else if (f.toString().contains(arguments[1])){
                System.out.println(f.toString());
                secondFile = import1.initializeFiles(f.toString());
                hashies.add(secondFile);
            }
        }

        System.out.println();

        for(HashMap<String, TreeSet<Peak>> hashy: hashies){
            StringBuilder stringBuilder = new StringBuilder();
            for(String key: hashy.keySet()) {
                stringBuilder.append(key + ", ");
            }
            String output = stringBuilder.toString();
            System.out.print(output.substring(0, output.length()-2));

            System.out.println();
        }

        /*for(String key: hashies.get(0).keySet()){
            for(Peak p: hashies.get(0).get(key)){
                System.out.print(p.toString() + ", ");
            }
        }*/

        HashMap<String, TreeSet<Peak>> set1 = hashies.get(0);
        HashMap<String, TreeSet<Peak>> set2 = hashies.get(1);

//        System.out.println(set1.get("chr2L").first().toString());
//        System.out.println(set2.get("chr2L").first().toString());

        set1.get("chr2L").first().toString();
        set2.get("chr2L").first().toString();

        subSetTesting(set1.get("chr2L"), set2.get("chr2L"));
    }
    
    public static void subSetTesting(TreeSet<Peak> givesPeaks,
                              TreeSet<Peak> getsPeaks) {
        Peak startPeak = null, endPeak = null;
        Iterator<Peak> itr = givesPeaks.iterator();
        for (int i = 0; i < 30; i++) {
            Peak p = itr.next();
            if (i == 9) {
                startPeak = p;
            }
            if (i == 29) {
                endPeak = p;
            }
        }
        SortedSet<Peak> subTree2 = givesPeaks.subSet(startPeak, endPeak);
        SortedSet<Peak> subTree = getsPeaks.subSet(startPeak, endPeak);
        System.out.println(subTree.size());
        for (Peak p : subTree) {
            System.out.print(p.toString() + ", ");
        }
        System.out.println("\n" + subTree2.size());
        for (Peak p : subTree2) {
            System.out.print(p.toString() + ", ");
        }
    }
}
