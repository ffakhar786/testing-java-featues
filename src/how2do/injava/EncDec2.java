package how2do.injava;

import java.util.Base64;

public class EncDec2 {

	public static void main(String[] args) {
		String url = "https://stash.backbase.com/projects/PO/repos/payment-order-integration-spec/browse/src/main/resources/schemas/definitions.json#38";
	    byte[] res = encodeQueryString(url);
	    System.out.println(res);
	    
	}

	public static byte[] encodeQueryString(String url) {
    	System.out.println(url);
		byte[] tiny = Base64.getEncoder().encode(url.getBytes());
		String tinyStr = new String(tiny);
		System.out.println(tinyStr);
		byte[] decBytes = Base64.getDecoder().decode(tiny);
    	String url1 = new String(decBytes);
		System.out.println(url1);
		
		byte[] decBytes1 = Base64.getDecoder().decode(tinyStr);
    	String url2 = new String(decBytes1);
		System.out.println(url2);
		
        return tiny;
    }
	
    public String decodeQueryString(String tiny) {
    	byte[] decBytes = Base64.getDecoder().decode(tiny);
    	String url = new String(decBytes);
        return url;
    }
	
}	