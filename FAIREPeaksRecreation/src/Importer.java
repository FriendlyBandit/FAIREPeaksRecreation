import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Importer {
    private HashMap<String, TreeMap<Integer,Peak>> data; //Peaks per key should be stored as a treeset
    private TreeMap<Integer, Peak> peakMap;
    private String name;

    public Importer(){
        peakMap = new TreeMap<>();
        data = new HashMap<>();
    }

    /**
     * Returns a HashMap of the data from a single file
     * @return
     */
    public HashMap initializeFiles(String path){
        name = path;
        Scanner scan1 = null;
        try { //Gets the file given to this methods
            scan1 = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("Wrong file path");
        }
        Peak benchmarkPeak = initalizePeak(scan1.nextLine()); //Gets the first peak from a certian chromosome? Left row
        Peak tempPeak; //Creates a temp peak which will become every line
        peakMap.put(benchmarkPeak.getPeakNumber(), benchmarkPeak);//starts off the peakmap with the first peak

        while(scan1.hasNext()){
            tempPeak = initalizePeak(scan1.nextLine());
            if(tempPeak.getPeakGroup().equals(benchmarkPeak.getPeakGroup())){ //Checks if the groups are the same
                peakMap.put(tempPeak.getPeakNumber(), tempPeak); //If noy, creates a new peakGroup hashMap with that as its key
            } else{
                TreeMap<Integer, Peak> newMap = new TreeMap<>();
                newMap.putAll(peakMap); //New Deep copy of peakMap so that it can be given to data and not be changed
                data.put(benchmarkPeak.getPeakGroup(), newMap);
                clearPeakMap(); //Clears the peakMap so it can be added to again.

                benchmarkPeak = initalizePeak(scan1.nextLine());
                peakMap.put(tempPeak.getPeakNumber(), tempPeak); //Puts first peak into peakMap
                peakMap.put(benchmarkPeak.getPeakNumber(), benchmarkPeak); //Puts second peak into peakMap
            }
        }
        scan1.close();
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

    private void clearPeakMap(){
        peakMap.clear();
    }

    public String getName(){
        return name;
    }
}
