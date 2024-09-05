package Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PriceUtils {

    // Comparator class to sort by price
    public static class PriceComparator implements Comparator<IpodItem> {
        @Override
        public int compare(IpodItem item1, IpodItem item2) {
            return Double.compare(Double.parseDouble(item1.getPrice()), Double.parseDouble(item2.getPrice()));
        }
    }

    public static double[] sortIpodItemsAndGetMinMax(List<IpodItem> ipodItems) {
        if (ipodItems == null || ipodItems.isEmpty()) {
            throw new IllegalArgumentException("IpodItem list cannot be null or empty");
        }

        // Sort the items by price using the PriceComparator
        Collections.sort(ipodItems, new PriceComparator());

        // After sorting, the minimum price will be the first element,
        // and the maximum price will be the last element in the sorted list.
        double minPrice = Double.parseDouble(ipodItems.get(0).getPrice());
        double maxPrice = Double.parseDouble(ipodItems.get(ipodItems.size() - 1).getPrice());

        return new double[]{minPrice, maxPrice}; // Return min and max prices
    }
}

