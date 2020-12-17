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
        collisions = 0;
        missesForSet1 = 0;
        missesForSet2 = 0;
        compareDataSets(dataSet1, dataSet2, "set1");
        //compareDataSets(dataSet2, dataSet1, "set2");

    }

    /**
     * Compares the 2 dataSets in order to print how many peaks overlap, how many peaks don't overlap
     * per each of the dataSets.
     * E.g.: dataSet1.name: x unmatched peaks
     *       x overlapped peaks
     *       dataSet2.name: x unmatched peaks
     */
    private void compareDataSets(HashMap<String, TreeSet<Peak>> givesPeaks,
                                     HashMap<String, TreeSet<Peak>> getsPeaks, String dataSet){
        for(String key: givesPeaks.keySet()){
            searchChromosome(givesPeaks.get(key), getsPeaks.get(key), dataSet);
        }
    }

    /**
     * Finds any overlapping peaks in other file
     */
    private void searchChromosome(TreeSet<Peak> givesPeaks,
                                TreeSet<Peak> getsPeaks, String dataSet){
        Iterator<Peak> itr1 = givesPeaks.iterator();
        Iterator<Peak> itr2 = givesPeaks.iterator();

        itr2.next();//Moves itr2 one step ahead of itr1
        while(itr1.hasNext()){
            Peak peak1 = itr1.next();
            Peak peak2 = null;

            if(itr2.hasNext()){
                peak2 = itr2.next();
            }
            if(peak2 == null){
                peak2 = peak1;
            }
            SortedSet<Peak> potentialCollisions;

            if(peak1.equals(peak2)){
                potentialCollisions = getsPeaks.tailSet(peak1);
            }else{
                potentialCollisions = getsPeaks.subSet(peak1, peak2);
            }
            for(Peak p: potentialCollisions){
             if(peak1.overlaps(p)){
                 collisions++;
             }else if(dataSet.equals("set1")){
                 missesForSet1 ++;
             }else{
                 missesForSet2++;
             }
            }
        }
    }

    public int getCollisions(){
        return collisions;
    }

    public int getMissesForSet1(){
        return missesForSet1;
    }

    public int getMissesForSet2(){
        return missesForSet2;
    }

}


