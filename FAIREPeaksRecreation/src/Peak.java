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
     * @param s
     */
    private void parsePeak(String[] s){

    }


    /**
     * CompareTo method so that peaks can be stored in a BinarySearchTree
     * Use the peakNumber to do this.
     * @param p
     * @return Forgot. Look a the docs for Comparable
     */
    @Override
    public int compareTo(Object o) {
        int peakNumber = Integer.parseInt(o.toString());
        if(peakNumber == getPeakNumber()){
            return 0;
        } else if(peakNumber > getPeakNumber()){
            return -1;
        } else{
            return 1;
        }
    }

    /* This is a version of compareTo that casts to a Peak. This will be preferred
    if it actually works well. I do not know yet
    @Override
    public int compareTo(Object o) {
        o = (Peak)o;
        if(peakNumber == ((Peak) o).getPeakNumber()){
            return 0;
        } else if(peakNumber > ((Peak) o).getPeakNumber()){
            return -1;
        } else{
            return 1;
        }
     */


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
}
