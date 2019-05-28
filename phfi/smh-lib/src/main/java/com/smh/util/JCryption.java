package com.smh.util;


import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class JCryption
{

    private KeyPair keyPair;
    private int keyLength;

    public JCryption()
    {
        keyPair = null;
        keyLength = 1024;
        generateKeyPair(keyLength);
    }

    public JCryption(int keyLength)
    {
        keyPair = null;
        this.keyLength = 1024;
        generateKeyPair(keyLength);
    }

    public JCryption(KeyPair keyPair)
    {
        this.keyPair = null;
        keyLength = 1024;
        setKeyPair(keyPair);
    }

    public KeyPair getKeyPair()
    {
        return keyPair;
    }

    public void setKeyPair(KeyPair keyPair)
    {
        this.keyPair = keyPair;
        keyLength = ((RSAPublicKey)keyPair.getPublic()).getModulus().bitLength();
    }

    public int getKeyLength()
    {
        return keyLength;
    }

    public void generateKeyPair(int keyLength)
    {
        try
        {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(keyLength);
            keyPair = kpg.generateKeyPair();
            this.keyLength = keyLength;
        }
        catch(NoSuchAlgorithmException e)
        {
            throw new CryptoException("Error obtaining RSA algorithm", e);
        }
    }

    public String getKeyModulus()
    {
        RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();
        return publicKey.getModulus().toString(16);
    }

    public String getPublicExponent()
    {
        RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();
        return publicKey.getPublicExponent().toString(16);
    }

    public int getMaxDigits()
    {
        return (keyLength * 2) / 16 + 3;
    }

    public String decrypt(String encrypted)
    {
        RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey)keyPair.getPrivate();
        String blocks[] = encrypted.split("\\s");
        String result = "";
        for(int i = 0; i < blocks.length; i++)
        {
            BigInteger data = new BigInteger(blocks[i], 16);
            BigInteger decryptedBlock = data.modPow(privateKey.getPrivateExponent(), publicKey.getModulus());
            result = (new StringBuilder(String.valueOf(result))).append(decodeBigIntToHex(decryptedBlock)).toString();
        }

        return redundancyCheck(result);
    }

    private String decodeBigIntToHex(BigInteger bigint)
    {
        String message;
        BigInteger ascii;
        for(message = ""; bigint.compareTo(new BigInteger("0")) != 0; message = (new StringBuilder(String.valueOf(message))).append((char)ascii.intValue()).toString())
        {
            ascii = bigint.mod(new BigInteger("256"));
            bigint = bigint.divide(new BigInteger("256"));
        }

        return message;
    }

    private String redundancyCheck(String string)
    {
        String r1 = string.substring(0, 2);
        String r2 = string.substring(2);
        int check = Integer.parseInt(r1, 16);
        String value = r2;
        int sum = 0;
        for(int i = 0; i < value.length(); i++)
        {
            sum += value.charAt(i);
        }

        if(check == (sum & 0xff))
        {
            return value;
        } else
        {
            return null;
        }
    }
}
