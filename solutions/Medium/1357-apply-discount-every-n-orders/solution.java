// ──────────────────────────────────────────────────
// Problem  : 1357. Apply Discount Every n Orders
// Difficulty: Medium
// Tags     : Array, Hash Table, Design
// Link     : https://leetcode.com/problems/apply-discount-every-n-orders/
// Runtime  : 17 ms (beats 0%)
// Memory   : 45604000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.Map;

class Cashier {
    private int n;
    private int discount;
    private int customerCount;
    private Map<Integer, Integer> priceMap;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.customerCount = 0;
        this.priceMap = new HashMap<>();

        // Store each product ID and its corresponding price
        for (int i = 0; i < products.length; i++) {
            priceMap.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        customerCount++;
        double total = 0;

        // Calculate the subtotal for the current order
        for (int i = 0; i < product.length; i++) {
            total += (double) priceMap.get(product[i]) * amount[i];
        }

        // Apply discount every nth customer
        if (customerCount % n == 0) {
            total = total * (100 - discount) / 100.0;
        }

        return total;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */