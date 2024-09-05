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
            String itemPrice1 = item1.getPrice().replace("$", "");
            String itemPrice2 = item2.getPrice().replace("$", "");
            return Double.compare(Double.parseDouble(itemPrice1), Double.parseDouble(itemPrice2));
        }
    }

    public static double[] sortIpodItemsAndGetMinMax(List<IpodItem> ipodItems) {
        if (ipodItems == null || ipodItems.isEmpty()) {
            throw new IllegalArgumentException("IpodItem list cannot be null or empty");
        }

        // Sort the items by price using the PriceComparator
        ipodItems.sort(new PriceComparator());

        // After sorting, the minimum price will be the first element,
        // and the maximum price will be the last element in the sorted list.
        double minPrice = Double.parseDouble(ipodItems.get(0).getPrice().replace("$", ""));
        double maxPrice = Double.parseDouble(ipodItems.get(ipodItems.size() - 1).getPrice().replace("$", ""));

        return new double[]{minPrice, maxPrice}; // Return min and max prices
    }}

