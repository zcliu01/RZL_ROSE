package com.zrt.commons.sign;
	import java.security.Key;  
	import java.security.SecureRandom;  
	  
	import javax.crypto.Cipher;  
	import javax.crypto.KeyGenerator;    
	  
	/** 
	 * this class is used to encrypt and decrypt 
	 *  
	 * @author WWFU
	 * @date 2017-2-20 14:11:27 
	 */  
	public class CipherUtil {  
		//对称加密key
		public static final String  KEY="zrt_oa@#";
		//默认加密3des
		public static final String SEC_TYPE="DESede";
	    /** 
	     * encrypt base on Base64 
	     *  
	     * @param target 
	     *            The target (which is used to encrypt) @return @throws 
	     */  
	    public static String encryptByBase64(byte[] target) {  
	    return Base64.encodeToString(target);  
	  
	    }  
	  
	    /** 
	     * decrypt base on Base64 
	     *  
	     * @param target 
	     *            The target (which is used to decrypt) 
	     * @return 
	     */  
	    public static byte[] decryptByBase64(String target) {  
	    try {  
	        return Base64.decode(target);  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	    return null;  
	  
	    }  
	  
	    /** 
	     * encrypt base on DES or 3DES or AES. 
	     *  
	     * @param target 
	     *            The target (which is used to encrypt) 
	     * @param algorithm 
	     *            The algorithm can be DES or DESede or AES 
	     * @param key 
	     *            The key (which is key to handle this encrypt) 
	     * @return 
	     */  
	    public static String encrypt(String target, String algorithm, String key) {  
	    try {  
	  
	        byte[] targetToByte = target.getBytes("UTF-8");  
	        Cipher cipher = Cipher.getInstance(algorithm);  
	        cipher.init(Cipher.ENCRYPT_MODE, getKey(key, algorithm));  
	        byte[] result = cipher.doFinal(targetToByte);  
	        // System.out.println("base64:" +encryptByBase64(result));  
	        return encryptByBase64(result); // 需要BASE64包装一下，否则会抛出异常  
	  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	    return null;  
	  
	    }  
	  
	    /** 
	     * decrypt base on DES or 3DES or AES. 
	     *  
	     * @param target 
	     *            The target (which is used to decrypt) 
	     * @param algorithm 
	     *            The algorithm can be DES or DESede or AES 
	     * @param key 
	     *            The key (which is key to handle this decrypt) 
	     * @return 
	     */  
	    public static String decrypt(String target, String algorithm, String key) {  
	  
	    try {  
	  
	        byte[] targetToByte = decryptByBase64(target); // 需要BASE64包装一下，否则会抛出异常  
	        Cipher cipher = Cipher.getInstance(algorithm);  
	        cipher.init(Cipher.DECRYPT_MODE, getKey(key, algorithm));  
	        byte[] result = cipher.doFinal(targetToByte);  
	        // System.out.println("base:" + new String(result,"UTF-8"));  
	        return new String(result, "UTF-8");  
	  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	    return null;  
	    }  
	  
	    public static Key getKey(String key, String algorithm) {  
	    try {  
	        KeyGenerator generator = KeyGenerator.getInstance(algorithm);  
	        generator.init(new SecureRandom(key.getBytes()));  
	        return generator.generateKey();  
	  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	    return null;  
	  
	    }  

	    /** 
	     * encrypt base on DES or 3DES or AES. 
	     *  
	     * @param target 
	     *            The target (which is used to encrypt) 
	     * @param algorithm 
	     *            The algorithm can be DES or DESede or AES 
	     * @param key 
	     *            The key (which is key to handle this encrypt) 
	     * @return 
	     */  
	    public static String encrypt(String target, String algorithm) {  
	    try {  
	  
	        byte[] targetToByte = target.getBytes("UTF-8");  
	        Cipher cipher = Cipher.getInstance(algorithm);  
	        cipher.init(Cipher.ENCRYPT_MODE, getKey(KEY, algorithm));  
	        byte[] result = cipher.doFinal(targetToByte);  
	        // System.out.println("base64:" +encryptByBase64(result));  
	        return encryptByBase64(result); // 需要BASE64包装一下，否则会抛出异常  
	  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	    return null;  
	  
	    }  
	  
	    /** 
	     * decrypt base on DES or 3DES or AES. 
	     *  
	     * @param target 
	     *            The target (which is used to decrypt) 
	     * @param algorithm 
	     *            The algorithm can be DES or DESede or AES 
	     * @param key 
	     *            The key (which is key to handle this decrypt) 
	     * @return 
	     */  
	    public static String decrypt(String target, String algorithm) {  
	  
	    try {  
	  
	        byte[] targetToByte = decryptByBase64(target); // 需要BASE64包装一下，否则会抛出异常  
	        Cipher cipher = Cipher.getInstance(algorithm);  
	        cipher.init(Cipher.DECRYPT_MODE, getKey(KEY, algorithm));  
	        byte[] result = cipher.doFinal(targetToByte);  
	        // System.out.println("base:" + new String(result,"UTF-8"));  
	        return new String(result, "UTF-8");  
	  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	    return null;  
	    }  
	    
	    
	    /** 
	     * encrypt base on DES or 3DES or AES. 
	     *  
	     * @param target 
	     *            The target (which is used to encrypt) 
	     * @param algorithm 
	     *            The algorithm can be DES or DESede or AES 
	     * @param key 
	     *            The key (which is key to handle this encrypt) 
	     * @return 
	     */  
	    public static String encrypt(String target) {  
	    try {  
	  
	        byte[] targetToByte = target.getBytes("UTF-8");  
	        Cipher cipher = Cipher.getInstance(SEC_TYPE);  
	        cipher.init(Cipher.ENCRYPT_MODE, getKey(KEY, SEC_TYPE));  
	        byte[] result = cipher.doFinal(targetToByte);  
	        // System.out.println("base64:" +encryptByBase64(result));  
	        return encryptByBase64(result); // 需要BASE64包装一下，否则会抛出异常  
	  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	    return null;  
	  
	    }  
	  
	    /** 
	     * decrypt base on DES or 3DES or AES. 
	     *  
	     * @param target 
	     *            The target (which is used to decrypt) 
	     * @param algorithm 
	     *            The algorithm can be DES or DESede or AES 
	     * @param key 
	     *            The key (which is key to handle this decrypt) 
	     * @return 
	     */  
	    public static String decrypt(String target) {  
	  
	    try {  
	  
	        byte[] targetToByte = decryptByBase64(target); // 需要BASE64包装一下，否则会抛出异常  
	        Cipher cipher = Cipher.getInstance(SEC_TYPE);  
	        cipher.init(Cipher.DECRYPT_MODE, getKey(KEY, SEC_TYPE));  
	        byte[] result = cipher.doFinal(targetToByte);  
	        // System.out.println("base:" + new String(result,"UTF-8"));  
	        return new String(result, "UTF-8");  
	  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	    return null;  
	    }  
	    
	    /**
	    public static void main(String[] args) {  
	    String target = "测试";  
	    // String target = "test";  
	    // DES  
	    String encrypt = encrypt(target, "DES", "im a ky");  
	    System.out.println("加密后：" + encrypt);  
	    String decrypt = decrypt(encrypt, "DES", "im a ky");  
	    System.out.println("解密后：" + decrypt);  
	    // 3DES  
	     
	      String encrypt1 = encrypt(target, "DESede"); 
	      System.out.println("加密后：" + encrypt1); 
	      String decrypt1 = decrypt(encrypt1, "DESede"); 
	      System.out.println("解密后：" + decrypt1);  
	    // AES  
	    
	      String encrypt2 = encrypt(target, "AES", "im a key"); 
	      System.out.println("加密后：" + encrypt2); 
	      String decrypt2 = decrypt(encrypt2, "AES", "im a key"); 
	      System.out.println("解密后：" + decrypt2);  
	    }  
	  **/
	}  
