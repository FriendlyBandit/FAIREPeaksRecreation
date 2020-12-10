import static java.lang.Integer.parseInt;

public class Peak implements Comparable {
    private int start, end, peakNumber; //Start and end of a peak, peak number in sequence
    private String peakID, peakGroup; //Gives peak number and also


    /**
     * Takes a string and gives the peak values
     * @param line
     */
    public Peak(String[] line){
        parsePeak(line);
    }

    /**
     * Parses a peak line and give the stuff to the related variables
     * @param line
     */
    private void parsePeak(String[] line){
        this.peakGroup = line[0];
        this.start = Integer.parseInt(line[1]);
        this.end = Integer.parseInt(line[2]);
        this.peakID = line[3];
        this.peakNumber = generatePeakNumber();
    }


    private int generatePeakNumber(){
        return Integer.parseInt(peakID.split("_")[2]);
    }

    /*
    /**
     * CompareTo method so that peaks can be stored in a BinarySearchTree
     * Use the peakNumber to do this.
     * @param o
     * @return Forgot. Look a the docs for Comparable
     */
    /*@Override
    public int compareTo(Object o) {
        int peakNumber = parseInt(o.toString());
        if(peakNumber == getPeakNumber()){
            return 0;
        } else if(peakNumber > getPeakNumber()){
            return -1;
        } else{
            return 1;
        }
    }*/

    /**
     * CompareTo method so that peaks can be stored in a BinarySearchTree
     * Use the peakNumber to do this.
     * @param o
     * @return Forgot. Look a the docs for Comparable
     */
    // This is a version of compareTo that casts to a Peak. This will be preferred
    //if it actually works well. I do not know yet. It works. This is buckets lel
    @Override
    public int compareTo(Object o) {
        o = (Peak) o;
        if (peakNumber == ((Peak) o).getPeakNumber()) {
            return 0;
        } else if (peakNumber > ((Peak) o).getPeakNumber()) {
            return 1;
        } else {
            return -1;
        }
    }

    public String getPeakGroup(){
        return peakGroup;
    }

    public int getPeakNumber(){
        return peakNumber;
    }

    @Override
    public String toString(){
        return Integer.toString(peakNumber);
    }

    public String startAndEnd(){
        return start + "==>" + end;
    }
}
