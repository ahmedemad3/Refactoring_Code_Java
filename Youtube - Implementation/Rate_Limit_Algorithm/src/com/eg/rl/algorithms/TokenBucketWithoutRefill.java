package com.eg.rl.algorithms;

public class TokenBucketWithoutRefill {

    private int tokens;

    public TokenBucketWithoutRefill(int capacity) {
        this.tokens = capacity;
    }

    public synchronized boolean allowRequest() {
        if (tokens > 0) {
            tokens--;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucketWithoutRefill rateLimiter = new TokenBucketWithoutRefill(10);
        for (int i = 0; i < 20; i++) {
            if (rateLimiter.allowRequest()) {
                System.out.println("Request allowed: " + i);
            } else {
                System.out.println("Request denied: " + i);
            }
            Thread.sleep(1000);
        }
    }
}

