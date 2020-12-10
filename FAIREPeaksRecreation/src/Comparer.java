import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedSet;
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

    public void subSetTesting(TreeSet<Peak> givesPeaks,
                                    TreeSet<Peak> getsPeaks){
        Peak startPeak = null, endPeak = null;
        Iterator<Peak> itr = givesPeaks.iterator();
        for(int i = 0; i < 10; i++){
            if(i == 1){
                startPeak = itr.next();
            }
            if (i == 9){
                endPeak = itr.next();
            }
        }

        SortedSet<Peak> subTree = getsPeaks.subSet(startPeak, endPeak);
        System.out.println(subTree.size());
        for(Peak p: subTree){
            System.out.print(p.toString() + ", ");
        }
    }



}
