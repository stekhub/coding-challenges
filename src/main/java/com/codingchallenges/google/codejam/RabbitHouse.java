package com.codingchallenges.google.codejam;

import org.javatuples.Pair;

import java.util.*;

/*
Rabbit House

Barbara got really good grades in school last year, so her parents decided to gift her with a pet rabbit.
She was so excited that she built a house for the rabbit, which can be seen as a 2D grid with R rows and C columns.

Rabbits love to jump, so Barbara stacked several boxes on several cells of the grid.
Each box is a cube with equal dimensions, which match exactly the dimensions of a cell of the grid.

However, Barbara soon realizes that it may be dangerous for the rabbit to make jumps of height greater than 1 box,
so she decides to avoid that by making some adjustments to the house. For every pair of adjacent cells,
Barbara would like that their absolute difference in height be at most 1 box. Two cells are considered adjacent if they
share a common side.

As all the boxes are superglued, Barbara cannot remove any boxes that are there initially,
however she can add boxes on top of them. She can add as many boxes as she wants, to as many cells as she wants
(which may be zero). Help her determine what is the minimum total number of boxes to be added so that the rabbit's
house is safe.
*/
public class RabbitHouse {

    private static Integer[][] rabbitHouse = {
            { 3, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 2, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 4, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }};

    private static Integer boxesAdded = 0;

    private static Comparator comparator = new Comparator<Pair<Integer, Integer>>() {
        @Override
        public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
            return rabbitHouse[o2.getValue0()][o2.getValue1()].compareTo(rabbitHouse[o1.getValue0()][o1.getValue1()]);
        }
    };

    public static void main(String args[]) {
        List<Pair<Integer, Integer>> fieldsToOptimize = findInitialSetOfFieldsForImprovement();

        optimizeRabbitHouse(fieldsToOptimize);

        printResult();
    }

    private static void optimizeRabbitHouse(List<Pair<Integer, Integer>> fieldsToOptimize) {
        fieldsToOptimize.sort(comparator);
        List<Pair<Integer, Integer>> fieldsToOptimizeInNextIteration = new ArrayList<>();

        for (Pair<Integer, Integer> field : fieldsToOptimize) {
            processNeighboringField(field, new Pair<>(field.getValue0() - 1, field.getValue1()), fieldsToOptimizeInNextIteration);
            processNeighboringField(field, new Pair<>(field.getValue0() + 1, field.getValue1()), fieldsToOptimizeInNextIteration);
            processNeighboringField(field, new Pair<>(field.getValue0(), field.getValue1() - 1), fieldsToOptimizeInNextIteration);
            processNeighboringField(field, new Pair<>(field.getValue0(), field.getValue1() + 1), fieldsToOptimizeInNextIteration);
        }

        if (!fieldsToOptimizeInNextIteration.isEmpty()) {
            optimizeRabbitHouse(fieldsToOptimizeInNextIteration);
        }
    }

    private static void processNeighboringField(Pair<Integer, Integer> field, Pair<Integer, Integer> neighbor,  List<Pair<Integer, Integer>> fieldsToOptimizeInNextIteration) {
        if (neighbor.getValue0() < 0 || neighbor.getValue1() < 0 || neighbor.getValue0() >= rabbitHouse.length || neighbor.getValue1() >= rabbitHouse[0].length) return;

        Integer heightDifference = rabbitHouse[field.getValue0()][field.getValue1()] - rabbitHouse[neighbor.getValue0()][neighbor.getValue1()];

        if (heightDifference > 1) {
            Integer boxesToAdd = heightDifference - 1;

            boxesAdded += boxesToAdd;
            rabbitHouse[neighbor.getValue0()][neighbor.getValue1()] += boxesToAdd;

            if (rabbitHouse[neighbor.getValue0()][neighbor.getValue1()] > 1) {
                fieldsToOptimizeInNextIteration.add(neighbor);
            }
        }
    }

    private static List<Pair<Integer, Integer>> findInitialSetOfFieldsForImprovement() {
        List<Pair<Integer, Integer>> fieldsToOptimize = new ArrayList<>();
        for (int i = 0; i < rabbitHouse.length; i++) {
            for (int j = 0; j < rabbitHouse[i].length; j++) {
                if (rabbitHouse[i][j] >= 2) {
                    fieldsToOptimize.add(new Pair(i, j));
                }
            }
        }

        return fieldsToOptimize;
    }

    private static void printResult() {
        for (int i = 0; i < rabbitHouse.length; i++) {
            for (int j = 0; j < rabbitHouse[i].length; j++) {
                System.out.print(rabbitHouse[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(String.format("Boxes added: %s", boxesAdded));
    }
}
