import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Importer {
    private HashMap<String, TreeSet<Peak>> data; //Peaks per key should be stored as a treeset
    private HashSet peakSet;

    public Importer(){
        peakSet = new HashSet();
        data = new HashMap<>();
    }

    /**
     * Returns a HashMap of the data from a single file
     * @return
     */
    public HashMap initializeFiles(){
        Scanner scan1 = null;
        try {
            scan1 = new Scanner(new File("C:\\Workspaces\\IntelliJ Workspace\\FAIREPeaksRecreation\\FAIREPeaksRecreation\\FAIREPeaksRecreation\\src\\RealFiles\\larval_cns_faire_peaks.bed"));
        } catch (FileNotFoundException e) {
            System.out.println("Wrong file path");
        }
        Peak benchmarkPeak = initalizePeak(scan1.nextLine());
        Peak tempPeak;
        peakSet.add(benchmarkPeak);

        while(scan1.hasNext()){
            tempPeak = initalizePeak(scan1.nextLine());
            if(tempPeak.getPeakGroup().equals(benchmarkPeak.getPeakGroup())){
                peakSet.add(tempPeak);
            } else{
                data.put(benchmarkPeak.getPeakGroup(), new TreeSet<Peak>(peakSet));
                clearPeakList();
                benchmarkPeak = initalizePeak(scan1.nextLine());
            }
        }

        return data;
    }

    /**
     * Takes a string (Line from file) and makes it into a peak
     * @return
     */
    private Peak initalizePeak(String LineFromFile){
        Peak peak = new Peak(LineFromFile.split("\\s+"));
        return peak;
    }

    /**
     * TO:DO
     */
    private void generatePeakTree(){
    }

    private void clearPeakList(){
        peakSet = new HashSet();
    }

}
