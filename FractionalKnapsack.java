import java.util.Arrays;
import java.util.Comparator;

class Item {
    int w; // weight
    int p; // profit

    public Item(int w, int p) {
        this.w = w;
        this.p = p;
    }
}

public class FractionalKnapsack {
    
    public static double[] getFractionalKnapsack(Item[] items, int W) {
        int n = items.length;
        double[] x = new double[n]; // Fraction array
        Arrays.fill(x, 0);

        // Sort items by profit-to-weight ratio in descending order
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                double x1 = (double) a.p / a.w;
                double x2 = (double) b.p / b.w;
                return Double.compare(x2, x1);
            }
        });

        int weight = 0;
        double totalProfit = 0.0;

        for (int i = 0; i < n; i++) {
            if (weight + items[i].w <= W) {
                x[i] = 1;
                weight += items[i].w;
                totalProfit += items[i].p;
            } else {
                x[i] = (double) (W - weight) / items[i].w;
                totalProfit += items[i].p * x[i];
                weight = W;
                break;
            }
        }
        
        System.out.println("Maximum profit we can obtain = " + totalProfit);
        return x;
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item(40, 280),
            new Item(10, 100),
            new Item(20, 120),
            new Item(24, 120)
        };
        int W = 60;

        double[] fractions = getFractionalKnapsack(items, W);
        System.out.println("Fractions of items taken: ");
        for (double fraction : fractions) {
            System.out.print(fraction + " ");
        }
    }
}
