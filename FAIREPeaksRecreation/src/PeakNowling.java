public class PeakNowling implements Comparable<PeakNowling> {
    String chrom;
    int start;
    int end;

    public PeakNowling(String chrom, int start, int end) {
        this.chrom = chrom;
        this.start = start;
        this.end = end;
    }

    public PeakNowling(String[] split) {
        this.chrom = split[0];
        this.start = Integer.parseInt(split[1]);
        this.end = Integer.parseInt(split[2]);
    }

    /**
     * Two PeakNowlings are "equal" if they overlap
     * @param o
     * @return
     */
    public boolean equals(Object o) {
        if(! (o instanceof PeakNowling)) {
            return false;
        }
        PeakNowling PeakNowling2 = (PeakNowling) o;
        return (start <= PeakNowling2.start && PeakNowling2.start <= end) ||
                (start <= PeakNowling2.end && PeakNowling2.end <= end);
    }

    @Override
    public int compareTo(PeakNowling PeakNowling2) {
        if(equals(PeakNowling2)) {
            return 0;
        }

        if(PeakNowling2.end <= start) {
            return -1;
        } else {
            return 1;
        }
    }

    public String toString() {
        return chrom + "," + start + "," + end;
    }

    public String getPeakNowlingGroup() {
        return chrom;
    }
}
