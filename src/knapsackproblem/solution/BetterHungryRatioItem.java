package knapsackproblem.solution;

import knapsackproblem.item.IItem;

public class BetterHungryRatioItem {

    private final IItem item;

    public BetterHungryRatioItem(IItem item) {
        this.item = item;
    }

    public double getRatio() {
        return item.getPrice() / item.getWeight();
    }

    public IItem getItem() {
        return item;
    }
}
