/**
 * Visitor Comparator: Used for sorting the ride history
 * Sorting logic: First, prioritize the ones with fast passes, then sort by age in ascending order, and finally sort by the visitor ID in ascending order.
 */
import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        if (v1 == null || v2 == null) {
            throw new IllegalArgumentException("The tourist target cannot be empty!");
        }

        // Step 1: Priority for those with a fast pass（true < false）
        int fastPassCompare = Boolean.compare(v2.isHasFastPass(), v1.isHasFastPass());
        if (fastPassCompare != 0) {
            return fastPassCompare;
        }
        // Step 2: Sort by age in ascending order
        int ageCompare = Integer.compare(v1.getAge(), v2.getAge());
        if (ageCompare != 0) {
            return ageCompare;
        }
        // Step 3: If the ages are the same, then sort by the ascending order of the tourist IDs.
        return v1.getVisitorId().compareTo(v2.getVisitorId());
    }
}