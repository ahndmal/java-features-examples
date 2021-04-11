package com.anma.java.exam.security;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidParameterSpecException;

public class SecurityExe {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] digest = messageDigest.digest("secret".getBytes());
        String hash = (new BigInteger(1, digest)).toString(16);

        try {
            String toEncrypt = "secret here";
            SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] value = toEncrypt.getBytes();
            byte[] encryptedValue = cipher.doFinal(value);
            GCMParameterSpec spec = cipher.getParameters().getParameterSpec(GCMParameterSpec.class);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, spec);
            byte[] decryptedValue = cipher.doFinal(encryptedValue);
            System.out.println(new String(decryptedValue));

        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidParameterSpecException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }

    }
}
