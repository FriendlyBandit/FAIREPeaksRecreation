import com.sun.source.tree.BinaryTree;

import java.util.HashMap;
import java.util.List;

public class Importer {
    private HashMap<String, List<Peak>> data; //Peaks per key should be stored as a binary tree
    //We might have to implement this binary tree

    /**
     * Returns a HashMap of the data from a single file
     * @return
     */
    public HashMap initializeFiles(){


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

}
