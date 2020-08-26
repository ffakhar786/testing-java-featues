package how2do.injava;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MyEncDec {

	public static void main(String[] args) {
		String url = "https://stash.backbase.com/projects/PO/repos/payment-order-integration-spec/browse/src/main/resources/schemas/definitions.json#38";
		Map<String, String> keyMap = new HashMap<>();
		keyMap.put("A01", "A");
		keyMap.put("A02", "B");
		keyMap.put("A03", "5");
		keyMap.put("A04", "C");
		keyMap.put("A05", "6");
		keyMap.put("A06", "D");
		keyMap.put("A07", "2");
		keyMap.put("A08", "F");
		keyMap.put("A09", "X");
		keyMap.put("A10", "G");
		keyMap.put("A11", "Y");
		keyMap.put("A12", "8");
		keyMap.put("A13", "Z");
		Map<String, String> encodingMapper = new LinkedHashMap<>();
		encodeUrl(url, encodingMapper);
		
		Set<String> keyS = encodingMapper.keySet();
		String hcode = "";
		for(String s : keyS) {
			String tmp = keyMap.get(s);
			hcode += tmp;
		}
		System.out.println(hcode);
		
	}

	private static void encodeUrl(String url, Map<String, String> encodingMapper) {
		String res = "";
		String[] arr = url.split("/");
		Character c = ' ' ;		
		//encodingMapper.put("A", "https:");
		String key = "";
		int i = 1;
		for(String s : arr) {
			key = "A" + (i <=9 ? "0"+i: i);			
			s = s+(s==null||"".equals(s) ? "/" :"/");
			encodingMapper.put(key, s);
			System.out.println("key=" + key +", "+ s);
			i++;			
		}
	}

}
