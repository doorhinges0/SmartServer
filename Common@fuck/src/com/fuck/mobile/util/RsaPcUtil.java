package com.fuck.mobile.util;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * @category PC端 ras加密
 * @author liwenbin
 *
 */
public class RsaPcUtil {

	private static RSAPrivateKey pkey;
	
	private static final BigInteger n = new BigInteger(
			"B2B41708916608F05AD96EBB26512E9700151348F13167BFDC79825F39FE68F867252275AD3476A3F36DAC7D2B370A15A2FAEFCA7C08980996A163984450642CD8B9A5788BB2D0F3940F8F7A41A0FCD2AFD823FDD3762729B2F4A56F8C4BFBDCD51EA314792527151D32EC6765B073756409C9BB2187278EFAD6DC0C167E0B33",
			16);
	private static final BigInteger d = new BigInteger(
			"22323E1A20A0B2E333AF59F62C2DEAC9707597FC24537CF404FFA7880B73F8A8582C8DFC90C9724E8B5D985D5770AFD85618C8DC2982077E063A19F1E058B5E260ADA30E099EDDC35D8C0D5C968ACE02F8522929A28791D9090EDC7EAE5185405E84AFFD74F1D6AD1A310B140A033BDA3A0399A89B1398FF4C3163A3798D9289",
			16);
	
	
	static
	{
		try {  
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");  
            RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(n, d);  
            pkey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);  
        } catch (Exception e) {  
            
        }  
		
	}
	
	
	public static RSAPrivateKey getPrivateKey() {  
        try {  
             
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");  
            RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(n, d);  
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    } 
	
	
	private static RSAPublicKey getPublicKey() {  
        try {  
            BigInteger exponent = new BigInteger("10001",16);  
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");  
            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(n,exponent);  
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    } 
	
	public static String Encrypt(String s) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		//加密后的密文
		byte[] mi = RSAUtil.RSAPublicKeyEncrypt(getPublicKey(), s.getBytes());
		String ss = Base64.ToBase64String(mi);
		return ss;
	}
	
	public static String Decrypt(String s) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		//解密后的明文
		byte[] b = RSAUtil.RSAPrivateKeyDecrypt(pkey, Base64.FromBase64String(s));
		String ss = new String(b);
		return ss;
	}
	
	
	public static void main(String[] args) throws Exception {
		
		//明文
		String ming = "123456789";
		
		//加密
		String s1 = Encrypt(ming);
		System.err.println(s1);
		
		//解密
		//s1="ipmxT6DszAeWKdOi1VAwUcd4vNjyGf5SrBjBj0xVRVqHMsYXqgnf7heNhbYZoGXCvs2ApmUp/nbKGK3/o4eIkWuNlKrQ8ftK5KQwEpzTUziUL5iieHvI0P7G1a8HdCnCSIwL9gO/07z+XEyfNtXWrV38fu79ebgBXvkpyETMaBU=";
		//s1="ce91/f5j5J+EnP5sEkocp3eTn5lFbK+0yuWLsMYhfsQYB2YmM5HPO9+8dsn0/JAgkTmIGdiseniJ9dNziQ8Jlcr+8cLAdXDG39LmnGZiz+8zxoXJj84b1AD2n5YP1qiSDka53xbUWK6ND5bASgvoDYfx4Q0AYMExzhoPrjr31To=";
		String s2 = Decrypt(s1);
		System.err.println(s2);
		
		
	}
	
}
