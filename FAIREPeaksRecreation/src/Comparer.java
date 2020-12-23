import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Comparer {
    private HashMap<String, TreeSet<Peak>> dataSet1;
    private HashMap<String, TreeSet<Peak>> dataSet2;
    private int collisions, missesForSet1, missesForSet2;
    private List<Peak> collisionList;

    public Comparer(HashMap<String, TreeSet<Peak>> dataSet1,
                        HashMap<String, TreeSet<Peak>> dataSet2){
        collisionList = new ArrayList<>();
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

        Peak peak;
        while(itr1.hasNext()){
            peak = itr1.next();
            Set<Peak> potentialCollisions;
            if(givesPeaks.higher(peak) == null){
                potentialCollisions = getsPeaks.tailSet(peak);
            }else if(givesPeaks.lower(peak) == null){
                potentialCollisions = getsPeaks.subSet(peak,true, givesPeaks.higher(peak), true);
            }else{
               potentialCollisions = getsPeaks.subSet(givesPeaks.lower(peak),true, givesPeaks.higher(peak), true);
            }

            for(Peak p: potentialCollisions){
                if(peak.overlaps(p)){
                    collisionList.add(p);
                    collisions++;
                }
            }
        }
    }

    public List<Peak> getCollisionList(){
        return collisionList;
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


