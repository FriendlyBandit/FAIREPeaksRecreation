import java.util.HashMap;
import java.util.TreeSet;

public class Comparer {
    private HashMap<String, TreeSet<Peak>> dataSet1;
    private HashMap<String, TreeSet<Peak>> dataSet2;
    private int collisions, missesForSet1, missesForSet2;

    public Comparer(HashMap<String, TreeSet<Peak>> dataSet1,
                        HashMap<String, TreeSet<Peak>> dataSet2){
        this.dataSet1 = dataSet1;
        this.dataSet2 = dataSet2;
        compareDataSets(dataSet1, dataSet2);
        compareDataSets(dataSet2, dataSet1);
    }

    /**
     * Compares the 2 dataSets in order to print how many peaks overlap, how many peaks don't overlap
     * per each of the dataSets.
     * E.g.: dataSet1.name: x unmatched peaks
     *       x overlapped peaks
     *       dataSet2.name: x unmatched peaks
     */
    private void compareDataSets(HashMap<String, TreeSet<Peak>> givesPeaks,
                                     HashMap<String, TreeSet<Peak>> getsPeaks){

    }

    /**
     * Finds any overlapping peaks in other file
     */
    private void searchPeak(HashMap<String, TreeSet<Peak>> givesPeaks,
                                HashMap<String, TreeSet<Peak>> getsPeaks){

    }





}
