package com.smh.util;


import java.security.KeyPair;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 *  This is an utility class to encode and decode
 */
public class EncryptionUtil {

  public EncryptionUtil() {
  }
  
  /**
   * Encrypt the password string using MD5 encryption and return the Hex decimal
   * format of it
   * 
   * @param password
   * @return: MD5 encrypted password in Hex decimal format.
   * @throws Exception
   */
  public static String encodePassword(String password) throws Exception {
    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
    byte[] md5Binary = messageDigest.digest(password.getBytes());
    String hexParam = Hex.encodeHex(md5Binary);
    return hexParam.toUpperCase();
  }

  /**
   * This method used for generate the random password pin.
   * 
   * @param length
   * @return String - random pin
   */
  public static String generatePin(int length) {
    String charString = "0123456789";
    Random rnd = new Random();
    StringBuilder sb = new StringBuilder(length);
    for(int i = 0; i < length; i++) {
      sb.append(charString.charAt(rnd.nextInt(charString.length())));
    }
    return sb.toString();
  }
  
  /**
   * This method used for generate the alpha numeric password based on length.
   * 
   * @param length
   * @return String
   */
  public static String generatePassword(int length) {
    String charString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random rnd = new Random();
    StringBuilder sb = new StringBuilder(length);
    for(int i = 0; i < length; i++) {
      sb.append(charString.charAt(rnd.nextInt(charString.length())));
    }
    return sb.toString();
  }
  
  /**
   * This method generate the random numeric value based on length
   * 
   * @param length
   * @return String
   */
  public static String generateRandNumeric(int length) {
    String finalRandString = "";
    Random randomObj = new Random();
    for(int j = 0; j < length; j++) {
      int rand_int = randomObj.nextInt(72);
      finalRandString += rand_int;
      if(finalRandString.length() >= length) {
        finalRandString = finalRandString.substring(0, length);
        break;
      }
    }
    return finalRandString;
  }

  /**
   * This method used for encrypted password.
   * 
   * @param message
   * @return byte[]
   * @throws Exception
   */
  public static String encrypt(String message) throws Exception {
    final MessageDigest md = MessageDigest.getInstance("MD5");
    final byte[] digestOfPassword = md.digest();
    final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
    for(int j = 0, k = 16; j < 8;) {
      keyBytes[k++] = keyBytes[j++];
    }

    final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
    final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
    final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, key, iv);

    final byte[] plainTextBytes = message.getBytes("utf-8");
    final byte[] cipherText = cipher.doFinal(plainTextBytes);
    return hexString(cipherText);
  }

  /**
   * This method used for decrypted the encrypted password.
   * 
   * @param message
   * @return String
   * @throws Exception
   */
  public static String decrypt(String message) throws Exception {
    final MessageDigest md = MessageDigest.getInstance("MD5");
    final byte[] digestOfPassword = md.digest();
    final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
    for(int j = 0, k = 16; j < 8;) {
      keyBytes[k++] = keyBytes[j++];
    }

    final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
    final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
    final Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
    decipher.init(Cipher.DECRYPT_MODE, key, iv);

    final byte[] plainText = decipher.doFinal(hex2byte(message));
    return new String(plainText, "UTF-8");
  }

  public static void main(String arg[]) throws Exception {
    System.out.println("MDS(DESede) Encrypt : " + EncryptionUtil.encrypt("RAKESH"));
    System.out.println("MDS(DESede) Decrypt : " + EncryptionUtil.decrypt("ABAE0FD233AB0ADB627B5EC0A5DFBCA5D8AEA15096126C0D"));
    System.out.println(EncryptionUtil.generatePin(6));
  }
  
  /**
   * @param   b       source byte array
   * @param   offset  starting offset
   * @param   len     number of bytes in destination (processes len*2)
   * @return  byte[len]
   */
  public static byte[] hex2byte (byte[] b, int offset, int len) {
      byte[] d = new byte[len];
      for (int i=0; i<len*2; i++) {
          int shift = i%2 == 1 ? 0 : 4;
          d[i>>1] |= Character.digit((char) b[offset+i], 16) << shift;
      }
      return d;
  }
  /**
   * @param s source string (with Hex representation)
   * @return byte array
   */
  public static byte[] hex2byte (String s) {
      if (s.length() % 2 == 0) {
          return hex2byte (s.getBytes(), 0, s.length() >> 1);
      } else {
      	// Padding left zero to make it even size #Bug raised by tommy
      	return hex2byte("0"+s);
      }
  }
  
  /**
   * converts a byte array to hex string 
   * (suitable for dumps and ASCII packaging of Binary fields
   * @param b - byte array
   * @return String representation
   */
  public static String hexString(byte[] b) {
      StringBuffer d = new StringBuffer(b.length * 2);
      for (int i=0; i<b.length; i++) {
          char hi = Character.forDigit ((b[i] >> 4) & 0x0F, 16);
          char lo = Character.forDigit (b[i] & 0x0F, 16);
          d.append(Character.toUpperCase(hi));
          d.append(Character.toUpperCase(lo));
      }
      return d.toString();
  }
  
  /**
   * @return
   */
  public static Object[] getJCryptoKeyPair() {
    
    JCryption jc = new JCryption();
    KeyPair keys = jc.getKeyPair();
    String e = jc.getPublicExponent();
    String n = jc.getKeyModulus();
    String md = String.valueOf(jc.getMaxDigits());
    
    StringBuffer out = new StringBuffer();

    out.append("{\"e\":\"");
    out.append(e);
    out.append("\",\"n\":\"");
    out.append(n);
    out.append("\",\"maxdigits\":\"");
    out.append(md);
    out.append("\"}");

    return new Object[]{keys, (
        out.toString().replaceAll("\r", "").replaceAll("\n", "")
        .trim())};
  }
  
  public static String decrypt(KeyPair keyPair, String key) {
    JCryption jc = new JCryption(keyPair);
    return jc.decrypt(key);
  }
  
}