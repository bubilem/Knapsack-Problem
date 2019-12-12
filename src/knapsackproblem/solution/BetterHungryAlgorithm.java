package knapsackproblem.solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import knapsackproblem.item.Bag;
import knapsackproblem.item.Items;

public class BetterHungryAlgorithm extends Algorithm {

    List<BetterHungryRatioItem> ratios;

    public BetterHungryAlgorithm(Items items, int capacity) {
        super(items, capacity);
        ratios = new ArrayList<>();
    }

    @Override
    public BetterHungryAlgorithm run() {
        items.getItems().forEach((item) -> {
            ratios.add(new BetterHungryRatioItem(item));
        });
        ratios.sort(Comparator.comparing(BetterHungryRatioItem::getRatio).reversed());
        ratios.forEach((BetterHungryRatioItem ratioItem) -> {
            bag.add(ratioItem.getItem());
        });
        return this;
    }

}
