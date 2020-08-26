package how2do.injava;

import java.util.Base64;

public class EncDec3 {

	public static void main(String[] args) {
		String url = "https://stash.backbase.com/projects/PO/repos/payment-order-integration-spec/browse/src/main/resources/schemas/definitions.json#38";
		url = "[B@15db9742";
		url = "aHR0cHM6Ly9zdGFzaC5iYWNrYmFzZS5jb20vcHJvamVjdHMvUE8vcmVwb3MvcGF5bWVudC1vcmRlci1pbnRlZ3JhdGlvbi1zcGVjL2Jyb3dzZS9zcmMvbWFpbi9yZXNvdXJjZXMvc2NoZW1hcy9kZWZpbml0aW9ucy5qc29uIzM4";
	    String res = decodeQueryString(url);
	    System.out.println(res);
	    
	}

	public static byte[] encodeQueryString(String url) {
    	System.out.println(url);
		byte[] tiny = Base64.getEncoder().encode(url.getBytes());
		/*String tinyStr = new String(tiny);
		System.out.println(tiny);
		byte[] decBytes = Base64.getDecoder().decode(tiny);
    	String url1 = new String(decBytes);
		System.out.println(url1);
		*/
        return tiny;
    }
	
    public static String decodeQueryString(String tiny) {
    	System.out.println(tiny);
    	byte[] decBytes = Base64.getDecoder().decode(tiny);
    	String url = new String(decBytes);
        return url;
    }
	
}	