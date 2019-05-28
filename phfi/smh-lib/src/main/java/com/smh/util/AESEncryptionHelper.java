package com.smh.util;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.generators.PKCS12ParametersGenerator;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.springframework.util.StringUtils;

public class AESEncryptionHelper {
	private final int			iterationCount	= 100;
	private CipherParameters	chiperParams;
	private final byte[]		salt		= new byte[] { (byte) 28, (byte) 116, (byte) 95, (byte) 222, (byte) 35, (byte) 65, (byte) 43, (byte) 20 };

	public AESEncryptionHelper(String passwordStr){
		final PBEParametersGenerator paramKeyGenerator = new PKCS12ParametersGenerator(new SHA256Digest());
		paramKeyGenerator.init(PKCS12ParametersGenerator.PKCS12PasswordToBytes(passwordStr.toCharArray()), salt, iterationCount);
		chiperParams = paramKeyGenerator.generateDerivedParameters(256, 128);
	}

	/**
	 * Method to decrypt the encrypted values
	 * @param encryptedValue
	 * @return
	 */
	public String decrypt(String encryptedValue){
		try	{
			if (!StringUtils.isEmpty(encryptedValue)){
				byte[] encryptedData = Base64.decodeBase64(encryptedValue);
				BufferedBlockCipher cipherDecrypt = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESEngine()), new PKCS7Padding());
				cipherDecrypt.init(false, chiperParams);
				byte[] decryptedData = processData(encryptedData, cipherDecrypt);
				return new String(decryptedData, "UTF-8");
			}
		}catch (Exception e){
			//e.printStackTrace();
		}
		return null;
	}

	/**
	 * Method to encrypt the encrypted values
	 * @param rawValue
	 * @return
	 */
	public String encrypt(String rawValue){
		try{
			if (!StringUtils.isEmpty(rawValue)){
				byte[] rawData = rawValue.getBytes("UTF-8");
				BufferedBlockCipher cipherEncrypt = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESEngine()), new PKCS7Padding());
				cipherEncrypt.init(true, chiperParams);
				byte[] encryptedData =  processData(rawData, cipherEncrypt);
				return Base64.encodeBase64String(encryptedData);
			}
		}catch (Exception e){
			//e.printStackTrace();
		}
		return null;
	}

	/**
	 * Utility method to decrypt and encrypt the values
	 * @param data
	 * @param cipher
	 * @return
	 * @throws Exception
	 */
	private byte[] processData(byte[] data, BufferedBlockCipher cipher) throws Exception{
		final byte[] processed = new byte[cipher.getOutputSize(data.length)];
		int outputLength = cipher.processBytes(data, 0, data.length, processed, 0);
		outputLength += cipher.doFinal(processed, outputLength);
		final byte[] results = new byte[outputLength];
		System.arraycopy(processed, 0, results, 0, outputLength);
		return results;
	}
}
