package com.eg.lb.algorithms;

import java.net.*;
import java.util.*;

public class IPHashLoadBalancer {

	private List<InetAddress> servers;

	public IPHashLoadBalancer(List<InetAddress> servers) {
		this.servers = servers;
	}

	public InetAddress getServerForRequest(InetAddress clientAddress) {
		int hash = clientAddress.hashCode();
		int serverIndex = Math.abs(hash % servers.size());
		return servers.get(serverIndex);
	}

	public static void main(String[] args) throws Exception {
		// Create a list of servers
		List<InetAddress> servers = new ArrayList<>();
		servers.add(InetAddress.getByName("192.168.1.10"));
		servers.add(InetAddress.getByName("192.168.1.11"));
		servers.add(InetAddress.getByName("192.168.1.12"));

		// Create a load balancer instance
		IPHashLoadBalancer loadBalancer = new IPHashLoadBalancer(servers);

		// Get the server for a sample request
		InetAddress clientAddress = InetAddress.getByName("192.168.1.50");
		InetAddress serverAddress = loadBalancer.getServerForRequest(clientAddress);

		System.out.println("Request from " + clientAddress.getHostAddress() + " will be sent to "
				+ serverAddress.getHostAddress());
	}
}
