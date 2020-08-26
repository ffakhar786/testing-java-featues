package how2do.injava;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class EncDec1 {

	public static void main(String[] args) {
		String longStr = "A";
		System.out.println(longStr+ ",\nlongStr.length=" + longStr.getBytes().length);
		myhash(longStr);
		if(true)
		return;
		byte[] src = new byte[longStr.getBytes().length];
		byte[] dst = new byte[longStr.getBytes().length+50];
		Encoder encoder = Base64.getEncoder();
		src = longStr.getBytes();
		byte[] res = encoder.encode(src);
		
		//System.out.println("Number of bytes="+num);
		System.out.println(src +", " + (new String(src)));
		System.out.println(res + ", " + (new String(res)));
		
		Decoder decoder = Base64.getDecoder();
		byte[] dec = decoder.decode(res);
		
		System.out.println(new String(dec));
	}
	/*
s[0]*31^(n-1) + s[1]*31^(n-2) + … + s[n-1] where :
s[i] – is the ith character of the string
n – is the length of the string, and
^ – indicates exponentiation
*/
	public static long myhash(String src){
		byte[] srcbytes = src.getBytes();
		long longRes = 0;
		for(int i=srcbytes.length-1 ; i >=0 ; i--) {
			int ascii = srcbytes[i];
			System.out.println(srcbytes[i]);
			int res =  ascii * 7^i;
			System.out.println(res);
			longRes = longRes +res;
		}
		System.out.println("LongResult"+longRes);	
	return longRes;
	}
	
	public static String myStrfromHash(long hcode) {
		String resStr="";
		int res = 0;
		while (true) {
			//hcode
			if(res==0) break;
		}
		return resStr;
	}
}
