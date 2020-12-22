import java.util.*;

public class TesterNowling {
    public static List<PeakNowling> findOverlapsInPeakNowlingList1(ArrayList<PeakNowling> PeakNowlingList1, Collection<PeakNowling> PeakNowlingList2) {
        List<PeakNowling> matches = new ArrayList<>();
        for(PeakNowling PeakNowling : PeakNowlingList2) {
            if(Collections.binarySearch(PeakNowlingList1, PeakNowling) >= 0) {
                matches.add(PeakNowling);
            }
        }

        return matches;
    }

    public static void main(String[] args) {
        ArrayList<PeakNowling> PeakNowlingList1 = new ArrayList<>();
        ArrayList<PeakNowling> PeakNowlingList2 = new ArrayList<>();

        PeakNowlingList1.add(new PeakNowling("2L", 21, 30));
        PeakNowlingList1.add(new PeakNowling("2L", 41, 50));
        PeakNowlingList1.add(new PeakNowling("2L", 61, 70));

        PeakNowlingList2.add(new PeakNowling("2L", 1, 10)); // no overlap
        PeakNowlingList2.add(new PeakNowling("2L", 10, 25)); // overlap with [21, 30]
        PeakNowlingList2.add(new PeakNowling("2L", 26, 35)); // overlap with [21, 30]
        PeakNowlingList2.add(new PeakNowling("2L", 10, 25));
        PeakNowlingList2.add(new PeakNowling("2L", 71, 80));

        PeakNowling PeakNowling1 = new PeakNowling("2L", 10, 25);
        PeakNowling PeakNowling2 = new PeakNowling("2L", 21, 30);
        PeakNowling PeakNowling3 = new PeakNowling("2L", 71, 80);
        System.out.println(PeakNowling1.equals(PeakNowling2));
        System.out.println(PeakNowling1.equals(PeakNowling3));

        Collections.sort(PeakNowlingList1);
        Collections.sort(PeakNowlingList2);

        List<PeakNowling> overlaps = findOverlapsInPeakNowlingList1(PeakNowlingList1, PeakNowlingList2);
        for(PeakNowling PeakNowling : overlaps) {
            System.out.println(PeakNowling);
        }
    }
}

