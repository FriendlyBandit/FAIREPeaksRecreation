import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ImporterNowling2 {
    private HashSet PeakNowlingSet;

    public ImporterNowling2(){
        PeakNowlingSet = new HashSet();
    }

    /**
     * Returns a HashMap of the data from a single file
     * @return
     */
    public HashMap initializeFiles(String path){
        HashMap<String, TreeSet<PeakNowling>> returnData = new HashMap<>();
        Scanner scan1 = null;
        try {
            scan1 = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("Wrong file path");
        }
        PeakNowling benchmarkPeakNowling = initalizePeakNowling(scan1.nextLine());
        PeakNowling tempPeakNowling;
        PeakNowlingSet.add(benchmarkPeakNowling);

        while(scan1.hasNext()){
            tempPeakNowling = initalizePeakNowling(scan1.nextLine());
            if(tempPeakNowling.getPeakNowlingGroup().equals(benchmarkPeakNowling.getPeakNowlingGroup())){
                PeakNowlingSet.add(tempPeakNowling);
            } else{
                returnData.put(benchmarkPeakNowling.getPeakNowlingGroup(), new TreeSet<PeakNowling>(PeakNowlingSet));
                clearPeakNowlingList();
                if(scan1.hasNextLine()) {
                    benchmarkPeakNowling = initalizePeakNowling(scan1.nextLine());
                }
                PeakNowlingSet.add(tempPeakNowling);
                PeakNowlingSet.add(benchmarkPeakNowling);
            }
        }
        returnData.put(benchmarkPeakNowling.getPeakNowlingGroup(), new TreeSet<>(PeakNowlingSet));

        return returnData;
    }

    /**
     * Takes a string (Line from file) and makes it into a PeakNowling
     */
    private PeakNowling initalizePeakNowling(String LineFromFile){
        return new PeakNowling(LineFromFile.split("\\s+"));
    }

    private void clearPeakNowlingList(){
        PeakNowlingSet.clear();
    }
}

