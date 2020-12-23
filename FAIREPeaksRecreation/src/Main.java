import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<HashMap<String, TreeSet<Peak>>> hashies = new ArrayList<>();

        Importer import1 = new Importer();
        File dataDirectory = new File("src/RealFiles");
        for (File f : dataDirectory.listFiles()) {
            System.out.println(f.toString());
            //HashMap<String, TreeSet<Peak>> hashy = import1.initializeFiles(f.toString());
            //hashies.add(hashy);
        }
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Which 2 files would you like to compare?");
        String temp = scan1.nextLine().toLowerCase();
        String[] arguments = temp.split("\\s+");
        System.out.println(arguments[0]);
        System.out.println(arguments[1]);

        HashMap<String, TreeSet<Peak>> firstFile;
        HashMap<String, TreeSet<Peak>> secondFile;
        for (File f : dataDirectory.listFiles()) {
            String fileName = f.toString().toLowerCase();
            if (fileName.toString().contains(arguments[0])) {
                System.out.println(f.toString());
                firstFile = import1.initializeFiles(f.toString());
                hashies.add(firstFile);
            } else if (fileName.toString().contains(arguments[1])) {
                System.out.println(f.toString());
                secondFile = import1.initializeFiles(f.toString());
                hashies.add(secondFile);
            }
        }

        System.out.println();

//        for (HashMap<String, TreeSet<Peak>> hashy : hashies) {
//            StringBuilder stringBuilder = new StringBuilder();
//            for (String key : hashy.keySet()) {
//                stringBuilder.append(key + ", ");
//            }
//            String output = stringBuilder.toString();
//            System.out.print(output.substring(0, output.length() - 2));
//
//            System.out.println();
//        }

//    for (HashMap<String, TreeSet<Peak>> hashy : hashies) {
//        System.out.println("\n" + hashy.values());
//        for (String key : hashy.keySet()) {
//            System.out.println("\n" + key);
//            for (Peak p : hashy.get(key)) {
//                System.out.print(p.toString() + ", ");
//            }
//        }
//    }
        //subSetTesting(hashies);

        Comparer comparer = new Comparer(hashies.get(0), hashies.get(1));
        List<Peak> listOfPeaks = comparer.getCollisionList();
        System.out.println("Collisons = " + comparer.getCollisions());
        for(Peak p: listOfPeaks){
            System.out.println(p);
        }
    }

    public static void subSetTesting(List<HashMap<String, TreeSet<Peak>>> hashies) {
        TreeSet<Peak> givesPeaks = hashies.get(0).get("chr2L");
        TreeSet<Peak> getsPeaks = hashies.get(1).get("chr2L");
        Peak startPeak = null, endPeak = null;

        Iterator<Peak> itr = givesPeaks.iterator();
        for (int i = 0; i < 11; i++) {
            Peak p = itr.next();
            if (i == 0) {
                startPeak = p;
            }
            if (i == 10) {
                endPeak = p;
            }
        }
        System.out.println(startPeak + "    " + endPeak);
        //SortedSet<Peak> subTree2 = givesPeaks.subSet(startPeak, endPeak);
        SortedSet<Peak> subTree = getsPeaks.subSet(startPeak, endPeak);
        System.out.println(subTree.size());
        for (Peak p : subTree) {
            System.out.print(p.toString() + ", ");
        }
//        System.out.println("\n" + subTree2.size());
//        for (Peak p : subTree2) {
//            System.out.print(p.toString() + ", ");
//        }
    }
}
