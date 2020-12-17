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

    /**
     * CompareTo method so that peaks can be stored in a BinarySearchTree
     * Use the peakNumber to do this.
     * @param o
     * @return Forgot. Look a the docs for Comparable
     */
    // This is a version of compareTo that casts to a Peak. This will be preferred
    //if it actually works well. I do not know yet
    @Override
    public int compareTo(Object o) {
        Peak p = (Peak) o;
        if(end == p.start){
            return 0;
        } else if(start > p.start){
            return 1;
        } else{
            return -1;
        }
    }

    /**
     * Takes a peak and compares it with this peak in order to see if it overlaps
     * @param p a peak
     * @return false if its a miss, true if it is a collision
     */
    public boolean overlaps(Peak peak){
        boolean overlaps = false;
        if(peak.start >= start && peak.start <= end){
            overlaps = true;
        }else if(peak.end >= start && peak.end <= end){
            overlaps = true;
        }
        if(peak.start <= start && peak.end >= end){
            overlaps = true;
        }

        return overlaps;
    }

    public String getPeakGroup(){
        return peakGroup;
    }

    public int getPeakNumber(){
        return peakNumber;
    }

    @Override
    public String toString(){
        return start + " " + end;
        //return Integer.toString(peakNumber);
    }
}
