/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackproblem.solution;

import knapsackproblem.item.Bag;
import knapsackproblem.item.Items;

/**
 *
 * @author Michal
 */
public class BruteForceAlgorithm extends Algorithm {

    public BruteForceAlgorithm(Items items, int capacity) {
        super(items, capacity);
    }

    @Override
    public BruteForceAlgorithm run() {
        for (long i = 0; i < (long) Math.pow(2, items.count()); i++) {
            String configuration = String.format("%" + items.count() + "s", Long.toBinaryString(i)).replace(' ', '0');
            Bag actBag = generateBag(configuration);
            if (actBag instanceof Bag && actBag.getItems().getTotalPrice() > bag.getItems().getTotalPrice()) {
                bag = actBag;
            }
        }
        return this;
    }

    private Bag generateBag(String configuration) {
        Bag actBag = new Bag(bag.getCapacity());
        for (int i = 0; i < items.count(); i++) {
            if (configuration.charAt(i) == '1') {
                if (actBag.getItems().getTotalWeight() + items.getItem(i).getWeight() > actBag.getCapacity()) {
                    return null;
                }
                actBag.add(items.getItem(i));
            }
        }
        return actBag;
    }
}
