package cc.wubo.encrypt.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class EncryptUtil {
	/**
	 * 获取唯一标识
	 * @return
	 */
	public static String getUUID()    
    {    
    return UUID.randomUUID().toString(); 
     
    }   
	/**
	 * MD5加密
	 * @param groupParamertStr
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String md5Encrypt(String groupParamertStr) throws UnsupportedEncodingException {
        
        MessageDigest messageDigest = null;  
           try {  
               messageDigest = MessageDigest.getInstance("MD5");  
               messageDigest.reset();  
               messageDigest.update(groupParamertStr.getBytes("UTF-8"));  
           } catch (NoSuchAlgorithmException e) {  
               System.out.println("NoSuchAlgorithmException caught!");  
               System.exit(-1);  
           } catch (UnsupportedEncodingException e) {  
               e.printStackTrace();  
           }  
           byte[] byteArray = messageDigest.digest();  
           StringBuffer md5StrBuff = new StringBuffer();  
           for (int i = 0; i < byteArray.length; i++) {  
               if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)  
                   md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));  
               else  
                   md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));  
           }  
           return md5StrBuff.toString();  
       
       
   }
}
