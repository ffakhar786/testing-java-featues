package com.test.example.encdec;

import java.util.Base64;

public class Base64EncDec {

	public static void main(String[] args) {
		//String s = "Allah is great!";
		String url1 = "https://stash.backbase.com/projects/PO/repos/payment-order-integration-spec/browse/src/main/resources/schemas/definitions.json#38";
		System.out.println(url1);
		byte enc[] = Base64.getEncoder().encode(url1.getBytes());
		
		System.out.println(enc);
		
		byte barr[] = Base64.getDecoder().decode(enc);
		//String dec = barr.toString();
		String dec = new String(barr);
		System.out.println(dec);
		
		byte[] decodedBytes = Base64.getDecoder().decode(enc);
		String decodedString = new String(decodedBytes);
		
		System.out.println(decodedString);
	}

}
