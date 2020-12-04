public class Peak implements Comparable {
    private int start, end, peakNumber; //Start and end of a peak, peak number in sequence
    private String peakID; //Gives peak number and also


    /**
     * Takes a string and gives the peak values
     * @param line
     */
    public Peak(String[] line){
        parsePeak(line);
    }

    /**
     * Parses a peak line and give the stuff to the related variables
     * @param s
     */
    private void parsePeak(String[] s){

    }


    /**
     * CompareTo method so that peaks can be stored in a BinarySearchTree
     * Use the peakNumber to do this.
     * @param o
     * @return Forgot. Look a the docs for Comparable
     */
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
