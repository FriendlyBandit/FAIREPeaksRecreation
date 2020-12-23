package NowlingFiles;

import java.io.File;
import java.util.*;

public class TesterNowling {
    public static List<PeakNowling> findOverlapsInPeakNowlingList1(ArrayList<PeakNowling> PeakNowlingList1, Collection<PeakNowling> PeakNowlingList2) {
        List<PeakNowling> matches = new ArrayList<>();
        for(PeakNowling PeakNowling : PeakNowlingList2) {
            if(Collections.binarySearch(PeakNowlingList1, PeakNowling) >= 0) {
                matches.add(PeakNowling);
            }
        }
        return matches;
    }

    public static void main(String[] args) {
        //craftedTester();
        testerWithFileGet();
    }

    public static void craftedTester(){
        ArrayList<PeakNowling> PeakNowlingList1 = new ArrayList<>();
        ArrayList<PeakNowling> PeakNowlingList2 = new ArrayList<>();

        PeakNowlingList1.add(new PeakNowling("2L", 21, 30));
        PeakNowlingList1.add(new PeakNowling("2L", 41, 50));
        PeakNowlingList1.add(new PeakNowling("2L", 61, 70));

        PeakNowlingList2.add(new PeakNowling("2L", 1, 10)); // no overlap
        PeakNowlingList2.add(new PeakNowling("2L", 10, 25)); // overlap with [21, 30]
        PeakNowlingList2.add(new PeakNowling("2L", 26, 35)); // overlap with [21, 30]
        PeakNowlingList2.add(new PeakNowling("2L", 10, 25));
        PeakNowlingList2.add(new PeakNowling("2L", 71, 80));

        PeakNowling PeakNowling1 = new PeakNowling("2L", 10, 25);
        PeakNowling PeakNowling2 = new PeakNowling("2L", 21, 30);
        PeakNowling PeakNowling3 = new PeakNowling("2L", 71, 80);
        System.out.println(PeakNowling1.equals(PeakNowling2));
        System.out.println(PeakNowling1.equals(PeakNowling3));

        Collections.sort(PeakNowlingList1);
        Collections.sort(PeakNowlingList2);

        List<PeakNowling> overlaps = findOverlapsInPeakNowlingList1(PeakNowlingList1, PeakNowlingList2);
        for(PeakNowling PeakNowling : overlaps) {
            System.out.println(PeakNowling);
        }
    }

    public static void testerWithFileGet(){
        List<HashMap<String, ArrayList<PeakNowling>>> hashies = new ArrayList<>();
        HashMap<String, ArrayList<PeakNowling>> firstFile;
        HashMap<String, ArrayList<PeakNowling>> secondFile;
        ImporterNowling2 import1 = new ImporterNowling2();
        String [] arguments = {"t1", "t2"};

        File dataDirectory = new File("src/RealFiles");
        for (File f : dataDirectory.listFiles()) {
            String fileName = f.toString().toLowerCase();
            if (fileName.toString().contains(arguments[0])) {
                firstFile = import1.initializeFiles(f.toString());
                hashies.add(firstFile);
            } else if (fileName.toString().contains(arguments[1])) {
                secondFile = import1.initializeFiles(f.toString());
                hashies.add(secondFile);
            }
        }

        HashMap<String, List<PeakNowling>> overLapsMap = new HashMap<>();
        List<PeakNowling> overlaps;

        for(HashMap<String, ArrayList<PeakNowling>> file: hashies){
            for(String key: file.keySet()){
                overlaps = findOverlapsInPeakNowlingList1(hashies.get(0).get(key), hashies.get(1).get(key));
                overLapsMap.put(key, overlaps);
            }
        }

        for(String key: overLapsMap.keySet()){
            for(PeakNowling p: overLapsMap.get(key)){
                System.out.println(p);
            }
        }
    }
}

