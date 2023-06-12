package com.eg.rl.algorithms;

import java.util.concurrent.TimeUnit;

public class FixedWindowRateLimiter {
	
	private final int requestsLimit;
    private final long timeWindowInMillis;
    private int count;
    private long windowStart;
    
	public FixedWindowRateLimiter(int requestsLimit, long timeWindowInMillis) {
		super();
		this.requestsLimit = requestsLimit;
		this.timeWindowInMillis = timeWindowInMillis;
		this.count = 0;
		this.windowStart = System.currentTimeMillis();
	}
	
	public synchronized boolean allowRequest() {
		long current = System.currentTimeMillis();
		long timeElapsed = current - windowStart;
		if(timeElapsed < timeWindowInMillis) {
			if(count < requestsLimit) {
				count ++;
				return true;
			}
		}
		return false;
	}
    
	public static void main(String[] args) throws InterruptedException {
		FixedWindowRateLimiter rateLimiter = new FixedWindowRateLimiter(10, TimeUnit.SECONDS.toMillis(5));
        for (int i = 0; i < 20; i++) {
            if (rateLimiter.allowRequest()) {
                System.out.println("Request allowed: " + i);
            } else {
                System.out.println("Request denied: " + i);
            }
            Thread.sleep(500);
        }
    }
    

}
