package NowlingFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ImporterNowling2 {

    public ImporterNowling2(){
    }

    /**
     * Returns a HashMap of the data from a single file
     * @return
     */
    public HashMap initializeFiles(String path){
        ArrayList<PeakNowling> PeakNowlingList1 = new ArrayList<>();
        HashMap<String, ArrayList<PeakNowling>> returnData = new HashMap<>();
        Scanner scan1 = null;
        try {
            scan1 = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("Wrong file path");
        }
        PeakNowling benchmarkPeakNowling = initalizePeakNowling(scan1.nextLine());
        PeakNowling tempPeakNowling;
        PeakNowlingList1.add(benchmarkPeakNowling);

        while(scan1.hasNext()){
            tempPeakNowling = initalizePeakNowling(scan1.nextLine());
            if(tempPeakNowling.getPeakNowlingGroup().equals(benchmarkPeakNowling.getPeakNowlingGroup())){
                PeakNowlingList1.add(tempPeakNowling);
            } else{
                Collections.sort(PeakNowlingList1);
                returnData.put(benchmarkPeakNowling.getPeakNowlingGroup(), new ArrayList<>(PeakNowlingList1));
                PeakNowlingList1.clear();
                if(scan1.hasNextLine()) {
                    benchmarkPeakNowling = initalizePeakNowling(scan1.nextLine());
                }
                PeakNowlingList1.add(tempPeakNowling);
                PeakNowlingList1.add(benchmarkPeakNowling);
            }
        }
        Collections.sort(PeakNowlingList1);

        returnData.put(benchmarkPeakNowling.getPeakNowlingGroup(), new ArrayList<>(PeakNowlingList1));
        return returnData;
    }

    /**
     * Takes a string (Line from file) and makes it into a NowlingFiles.PeakNowling
     */
    private PeakNowling initalizePeakNowling(String LineFromFile){
        return new PeakNowling(LineFromFile.split("\\s+"));
    }

    private void printList(ArrayList<PeakNowling> list){
        for(PeakNowling p: list){
            System.out.println(p.toString());
        }
        System.out.println();
    }

}

