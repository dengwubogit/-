package cc.wubo.encrypt;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class TestRSA {
	
	private static String src="RSA加密算法";
	private static String RSATYPE="rsa";
	public static void main(String[] args) {
		jdkRSA1();
		
	}
	
	//私钥加密,公钥解密
	public static void jdkRSA1(){
		try {
			//初始化密钥
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSATYPE);
			keyPairGenerator.initialize(512);
			//初始化密钥对
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			//获取公钥
			RSAPublicKey rsapublicKey = (RSAPublicKey) keyPair.getPublic();
			//获取私钥
			RSAPrivateKey rsaprivateKey = (RSAPrivateKey) keyPair.getPrivate();
			//输出公钥\私钥
			System.out.println(Base64.encodeBase64String(rsapublicKey.getEncoded()));
			System.out.println(Base64.encodeBase64String(rsaprivateKey.getEncoded()));
			
			//私钥加密
			PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaprivateKey.getEncoded());
			KeyFactory keyFactory = KeyFactory.getInstance(RSATYPE);
			PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
			Cipher cipher = Cipher.getInstance(RSATYPE);
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);//加密模式
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("加密数据:"+Base64.encodeBase64String(result));
			
			//公钥解密
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsapublicKey.getEncoded());
			keyFactory = KeyFactory.getInstance(RSATYPE);
			PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
			cipher = Cipher.getInstance(RSATYPE);
			cipher.init(Cipher.DECRYPT_MODE,publicKey); //解密模式
			byte[] decrypResult = cipher.doFinal(result);
			System.out.println("解密结果:"+new String(decrypResult));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
