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
 * @category APP端 ras加密
 * @author liwenbin
 *
 */
public class RsaAppUtil {

	private static RSAPrivateKey pkey;
	
	private static final BigInteger n = new BigInteger(
			"F1E9E08206E9BF8AD30488F78A510D4E02D7713FD6D9C0962D14578CC6401959D280976947524779ED9E61631F650CF0F24F25DEEB4602757A096D3C8378845472B8C8D2451A51C3AC143149BF70DA8C873171BCAB3C73FA42B67DD7C2EB305CB470BBD534C7D9E75CEDE9A0C69D1F3EA8B51781E4C4C363D4E41C8F16FD9167",
			16);
	private static final BigInteger d = new BigInteger(
			"2EE4C7406D56A26AA6BD1A4FE1E014542AF8D85B27AACE4A4E32C345E6A84641C32C6A2D5E45F4D50DDAC5C6112FE5724F8648310E2A640FA1B8721468E7D3BEAA799C2B8DB4577543C5A7D8DCEBB02FC1D074F58D272459D09F47A02FA3DDC45D64FA68B87EDB0C0E88038CD8269DFEBACA7CF53947451AC86F0013C3E6F41",
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
		s1 = "Y5VTjZUtKYU1gCp0ADDwV/MWMxXJV4dIgqXRHy6HaLqZNVBSjOdP8/n+4IZzyRKdVm1EGu3TRd0XhvDPL3RoOUS8OZO6qT+hc3bcqF9H5/GazGIB3rbFzfq/rXj5/PuiE1sqA7DnQpby6qee+fK2EzrXDdyVDIXOX5c1Qxn5Paw=";
		s1 = "lNeIMBHLjS5xSj9XdZ1RdrYBjB2LGF2ikps9r60lsWWTXZKLjYX4hkcr6LvYM539A0gYf3N8TdJ6ODSB5xV3bOLzjUzdNu+KlltPqhHw2IGHOW4e931pZkt73+a6M3JIoI5nXZ+H9H32rKY0o+1xN8gJEW0H6x6KiIQX0Qg9NvI=";
		s1="PYB5cHUWeE5SFarI/XWhvRM+h7bgFMDTcJLjsusoct9r/1Cuin3tEdOxvXS8tAxmnKpsVtjt+0LBC/yN7WFLAjO1lNdInTl/uFv3284HIPGClG/k1k6xe4zF0MWo0jBKtekttiLpCTA3p6CyFjQwNAJ7icVDUCSUCf/duolUmHQ=";
		String s2 = Decrypt(s1);
		System.err.println(s2);
		
		
		
		
	}
	
}
