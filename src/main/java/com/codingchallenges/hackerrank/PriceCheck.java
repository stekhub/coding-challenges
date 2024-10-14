package com.codingchallenges.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PriceCheck {
	
	public static void main(String[] args) {
		String[] products = {"eggs", "milk", "cheese"};
		Float[] productPrices = {2.89f, 3.29f, 5.79f};
		String [] productsSold  = {"eggs", "eggs", "cheese", "milk"};
		Float[] soldPrices = {2.89f, 2.99f, 5.97f, 3.29f};
		
		System.out.println(priceCheck(Arrays.asList(products), Arrays.asList(productPrices),
				Arrays.asList(productsSold), Arrays.asList(soldPrices)));

	}
	
	public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productsSold,
								 List<Float> soldPrices) {
		return (int) IntStream.range(0, productsSold.size())
			.filter(i -> soldPrices.get(i).equals(productPrices.get(products.indexOf(productsSold.get(i)))))
			.count();
	}
}
