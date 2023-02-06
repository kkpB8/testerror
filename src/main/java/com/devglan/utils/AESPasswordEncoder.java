package com.devglan.utils;

import org.springframework.beans.factory.annotation.Value;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;


public class AESPasswordEncoder {

    @Value("${enc.aes128.key}")
    private static String key;

    public static SecretKey getKeyFromPassword(String password)//#JHmohittihomHJ#
            throws NoSuchAlgorithmException, InvalidKeySpecException {

        byte[] saltBytes = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), saltBytes, 65536, 256);
        SecretKey secret = new SecretKeySpec(factory.generateSecret(spec)
                .getEncoded(), "AES");
        return secret;
    }

    public static SecretKey secureKeyGeneration(String userId){
        userId = userId.toUpperCase();
        StringBuilder sb = new StringBuilder(userId);
        String midString = userId + sb.reverse();
        char[] finalCharArr = new char[32];
        for (int i = 0; i < 32; i++) {
            if (i == 0) {
                finalCharArr[0] = midString.charAt(0);
            } else {
                finalCharArr[i] = midString.charAt(i % midString.length());
            }
        }
        String finalString = String.valueOf(finalCharArr);
        return new SecretKeySpec(finalString.getBytes(StandardCharsets.UTF_8), "AES");
    }

    public static IvParameterSpec generateIv() {
        String iv = "zsefvbhukmhtfcvg";
        return new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));
    }
   static String consStr = "Microware@78534";
    public static String makingStringWithSC(String chperText){
        if(chperText.contains(consStr)){
            return chperText.replaceAll(consStr,"+");
        }
        return chperText;
    }
    public static String decrypt(String algorithm, String cipherText, SecretKey key,
                                 IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(makingStringWithSC(cipherText)));
        return new String(plainText);
    }

    public static String removeSaltFromPlainText(String plainText) {
        String orginalPassword = plainText.substring(4);
        return orginalPassword;
    }

    public static String encrypt(String algorithm, String input, SecretKey key,
                                 IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] cipherText = cipher.doFinal(input.getBytes());
        return Base64.getEncoder()
                .encodeToString(cipherText);
    }

    public static String encrypt_128(String text){
        try {
            byte[] shaText = SHA.getSHA(text);
            System.out.println("shaText : " +shaText);
            System.out.println("shaTexttoHexString : " +SHA.toHexString(shaText));
            System.out.println("shaTexttoHexString : " +SHA.toHexString(text.getBytes()));
            Key aesKey = new SecretKeySpec("8493297384932973".getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(shaText);
            return new String(Base64.getEncoder().encodeToString(encrypted));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}

