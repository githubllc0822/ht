package cn.tarena.ht.tool;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5HashPassword {
	public static void main(String[] args) {
		//参数分别表示：明文  盐    哈希次数
		Md5Hash m=new Md5Hash("admin", "admin", 3);
		
		
		System.out.println(m.toString());
	}
	//获取密文
	public static String  getPsw(String psw,String username){
		return new Md5Hash(psw,username,3).toString();
		
	}
}
