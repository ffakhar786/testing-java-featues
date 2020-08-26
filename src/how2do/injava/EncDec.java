package how2do.injava;

import java.util.Date;
import java.util.Random;
 
public class EncDec {
 
    private static Random rand = new Random((new Date()).getTime());
 /*
    public static void main(String[] args) throws Exception {
 
  String st = "secrete";
 
  String enc = encrypt(st);
 
  System.out.println("Encrypted string :" + enc);
 
  System.out.println("Decrypted string :" + decrypt(enc));
 
    }
 
    public static String encrypt(String str) {
 
  //BASE64Encoder encoder = new BASE64Encoder();
 
  byte[] salt = new byte[8];
 
  rand.nextBytes(salt);
 
  return encoder.encode(salt) + encoder.encode(str.getBytes());
    }
 
    public static String decrypt(String encstr) {
 
  if (encstr.length() > 12) {
 
String cipher = encstr.substring(12);
 
BASE64Decoder decoder = new BASE64Decoder();
 
try {
 
    return new String(decoder.decodeBuffer(cipher));
 
} catch (IOException e) {
 
    //  throw new InvalidImplementationException(
 
    //Fail
 
}
 
  }
 
  return null;
    }
    */
}