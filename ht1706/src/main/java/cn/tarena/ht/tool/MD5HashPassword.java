package cn.tarena.ht.tool;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5HashPassword {
	public static void main(String[] args){
		/**
		 * source 明文
		 * salt   盐
		 * hashIterations 哈希次数
		 */
		Md5Hash md5Hash = new Md5Hash("daji", "daji", 3);
		System.out.println(md5Hash);
	}
	
	public static String getPassword(String userName,String password){
		Md5Hash md5Hash = new Md5Hash(password, userName, 3);
		return md5Hash.toString();
	}
	
}
