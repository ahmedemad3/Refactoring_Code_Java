package com.eg.rl.algorithms;

public class TokenBucketWithRefill {

	private int tokens;
	private int requestLimits;
	private final int tokensPerSecond;
	private long lastRefillTimestamp;

	public TokenBucketWithRefill(int capacity, int tokensPerSecond) {
		this.tokens = capacity;
		this.requestLimits = capacity;
		this.tokensPerSecond = tokensPerSecond;
		this.lastRefillTimestamp = System.currentTimeMillis();
	}

	public synchronized boolean allowRequest() {
		refill();
//		refillPerSecond();
		if (tokens > 0) {
			tokens--;
			return true;
		} else {
			return false;
		}
	}

	private void refill() {

		long now = System.currentTimeMillis();

		int tokensToAdd = (int) ((now - lastRefillTimestamp) / 1000) * tokensPerSecond;

		tokens = Math.min(tokens + tokensToAdd, requestLimits);

		lastRefillTimestamp = now;
	}

	private void refillPerSecond() {

		long now = System.currentTimeMillis();

		int tokensToAdd = 0;

		if ((now - lastRefillTimestamp) > 1000)
			tokensToAdd = tokensPerSecond;

		tokens = Math.min(tokens + tokensToAdd, requestLimits);

//        if ((tokens + tokensToAdd) > requestLimits)
//			tokens = requestLimits;
//		else
//			tokens = (tokens + tokensToAdd);

		System.out.println("refillPerSecond : tokens : " + tokens);
		lastRefillTimestamp = now;
	}

	public static void main(String[] args) throws InterruptedException {
		TokenBucketWithRefill rateLimiter = new TokenBucketWithRefill(10, 2);
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
