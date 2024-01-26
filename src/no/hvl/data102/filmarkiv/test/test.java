package no.hvl.data102.filmarkiv.test;

import java.lang.*;

public class test {

	public static void main(String[] args) {
		long n1 = (long) Math.pow(10,9);
		long antall = 1000;
		long f = 1_000_000;
		
		long tTime = avrage(n1, antall);
		int len = String.valueOf(tTime).length();
		
		
		
		System.out.println("avrage tid :\n"
							+ tTime + "ns ----"+"antal digits: "+ len +"\n"+
							+ tTime/f + "ms\n");
		
		
		

	}



	public static long tid(long n) {
		long start = System.nanoTime();
		long k = 0;
		for (long i = 1; i <= n; i++) {
			k = k + 5;
		}
		if(k == -1) {
			System.out.println("this soudnt happen");
		}
		long end = System.nanoTime();
		return (end - start);
	}
	public static long avrage(long n, long times) {
		long totTid = 0;
		for(int i = 0; i < times; i++) {
			totTid += tid(n);
		}
		return totTid/times;
	}



	

}

