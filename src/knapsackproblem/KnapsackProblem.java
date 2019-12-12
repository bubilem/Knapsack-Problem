package knapsackproblem;

import java.text.DecimalFormat;
import knapsackproblem.item.Items;
import knapsackproblem.solution.BetterHungryAlgorithm;
import knapsackproblem.solution.BruteForceAlgorithm;
import knapsackproblem.solution.GeneticAlgorithm;
import knapsackproblem.solution.HungryAlgorithm;
import knapsackproblem.solution.RandomAlgorithm;

public class KnapsackProblem {

    public static void main(String[] args) {

        Items items = BookLoader.read("items/items-024.csv");
        items.print("KnapsackProblem\n*All items:");
        DecimalFormat myFormatter = new DecimalFormat("###,###");
        System.out.println("Total number of combinations: " + myFormatter.format(Math.pow(2, items.count())));
        int bagCapacity = 300;

        (new RandomAlgorithm(items, bagCapacity))
                .run().getBag().print("Random Alg");

        (new HungryAlgorithm(items, bagCapacity))
                .run().getBag().print("Hungry Alg");

        (new BetterHungryAlgorithm(items, bagCapacity))
                .run().getBag().print("Better Hungry Alg");

        (new BruteForceAlgorithm(items, bagCapacity))
                .run().getBag().print("Brute Force Alg");

        /*
        (new GeneticAlgorithm(items, bagCapacity)).run().getBag().print("Genetic Alg");
         */
    }

}
