package com.devglan.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class EncryptionAadhaarNrlm {
   public static String bytesToHex(byte[] bytes) {
      StringBuilder sb = new StringBuilder();
      for (byte b : bytes) {
         sb.append(String.format("%02x", b));
      }
      return sb.toString();
   }

   public static String getSha256(String plain_text){
      MessageDigest digest = null;
      try {
         digest = MessageDigest.getInstance("SHA-256");
      } catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
      }
      byte[] hash = null;
      try {
         hash = digest.digest(plain_text.getBytes("UTF-8"));
      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
      }
      return bytesToHex(hash);
   }

   public static String encryptSaltValue(String aadharSalt) throws Exception {
      byte[] dataToBeEncrypt = aadharSalt.getBytes();
      byte[] key = getSecrectKey("84932973".getBytes());
      SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
      Cipher cipher = Cipher.getInstance("AES");
      cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
      //System.out.println("AES128-"+cipher.doFinal(dataToBeEncrypt));
      //encrypted = cipher.doFinal(dataToBeEncrypt);
      byte[] encrypted = Base64.getEncoder().encode(cipher.doFinal(dataToBeEncrypt));
      String encryptedValue = new String(encrypted);
      //Base64.getEncoder().encode(arg0);
      return encryptedValue;
   }

   public static byte[] getSecrectKey(byte[] seed) {
      byte[] raw = null;
      try{
         KeyGenerator kgen = KeyGenerator.getInstance("AES");
         SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
         sr.setSeed(seed);
         kgen.init(128, sr); // 192 and 256 bits may not be available
         SecretKey skey = kgen.generateKey();
         raw = skey.getEncoded();
      }catch(Exception e){
         e.printStackTrace();
      }
      return raw;
   }

   public static String finalEncryption(String pText){
     System.out.println( "Aadhar number-"+ pText);
      String saltAadhaar = getSha256(pText);
      System.out.println( "SHA256-"+ saltAadhaar);
      String encryptSaltValue = null;
      try {
         encryptSaltValue = encryptSaltValue(saltAadhaar);
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
      System.out.println( "Base64-"+ encryptSaltValue);
      return encryptSaltValue;
   }


}
