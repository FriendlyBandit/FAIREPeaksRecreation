import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Importer {
    private HashSet peakSet;
    private String name;

    public Importer(){
        peakSet = new HashSet();
    }

    /**
     * Returns a HashMap of the data from a single file
     * @return
     */
    public HashMap initializeFiles(String path){
        HashMap<String, TreeSet<Peak>> returnData = new HashMap<>();
        name = path;
        Scanner scan1 = null;
        try {
            scan1 = new Scanner(new File(path));
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
                returnData.put(benchmarkPeak.getPeakGroup(), new TreeSet<Peak>(peakSet));
                clearPeakList();
                if(scan1.hasNextLine()) {
                    benchmarkPeak = initalizePeak(scan1.nextLine());
                }
                peakSet.add(tempPeak);
                peakSet.add(benchmarkPeak);
            }
        }
        return returnData;
    }


//    TreeMap<Integer, Peak> newMap = new TreeMap<>();
//                newMap.putAll(peakMap); //New Deep copy of peakMap so that it can be given to data and not be changed
//                data.put(benchmarkPeak.getPeakGroup(), newMap);
//    clearPeakMap(); //Clears the peakMap so it can be added to again.
//
//    benchmarkPeak = initalizePeak(scan1.nextLine());
//                peakMap.put(tempPeak.getPeakNumber(), tempPeak); //Puts first peak into peakMap
//                peakMap.put(benchmarkPeak.getPeakNumber(), benchmarkPeak); //Puts second peak into peakMap



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

    public String getName(){
        return name;
    }
}
