public class Test{
	public static void main(String args[]){
		Test mt=new Test();
		boolean loginResult=mt.login("ldy","ldy666");
		if(loginResult==true){
			System.out.println("��ת����ҳ");
		}else{
			System.out.println("�û������������");
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