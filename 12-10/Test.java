public class Test{
	public static void main(String args[]){
		Test mt=new Test();
		boolean loginResult=mt.login("ldy","ldy666");
		if(loginResult==true){
			System.out.println("跳转到主页");
		}else{
			System.out.println("用户名或密码错误");
		}
	}
	public boolean login(String username,String password){
		if (username.equals("ldy") && password.equals("ldy666")){
			return true;
		}else{
			return false;
		}
	}
}