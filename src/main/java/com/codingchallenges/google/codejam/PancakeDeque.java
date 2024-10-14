package com.codingchallenges.google.codejam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Pancake Deque

Pancakes are normally served in stacks, but the Infinite House of Pancakes embraces change! The restaurant's new
advertising hook is to serve the pancakes from a deque, or double-ended queue.

You are a server at the restaurant, and your job is to serve every pancake in the deque. Customers will arrive one at
a time, and each one gets a single pancake. You must serve each customer either the leftmost or rightmost pancake in
the deque; the choice is yours. When a pancake is served, it disappears from the deque, exposing the pancake that was
next to it. Or, once there is only one pancake left, your only choice is to serve that one, and then your job is
complete!

Each pancake has a deliciousness level. Because customers do not get to choose which pancakes they get, each customer
only has to pay for their pancake if it is at least as delicious as each of the pancakes that all of the previous
customers got. (The first customer always pays for their pancake, since in that case there are no previous customers.)

How many customers will pay for their pancake, if you serve the pancakes in an order that maximizes that number?
 */
public class PancakeDeque {

    private static Integer[] PANCAKE_DEQUE = { 666, 1, 101, 1337, 42, 999 };

    public static void main(String args[]) {
        List<Integer> pancakeDequeList = new ArrayList<Integer>(Arrays.asList(PANCAKE_DEQUE));

        int maximumDeliciousnessServed = 0;
        int sumOfPayingCustomers = 0;

        while(!pancakeDequeList.isEmpty()) {
            int nextPancakeToServeIndex;

            nextPancakeToServeIndex = pancakeDequeList.get(0) < pancakeDequeList.get(pancakeDequeList.size() - 1)
                    ? 0 : pancakeDequeList.size() - 1;

            if (pancakeDequeList.get(nextPancakeToServeIndex) >= maximumDeliciousnessServed) {
                sumOfPayingCustomers++;
                maximumDeliciousnessServed = pancakeDequeList.get(nextPancakeToServeIndex);
            }

            pancakeDequeList.remove(nextPancakeToServeIndex);
        }

        System.out.println(sumOfPayingCustomers);
    }
}
