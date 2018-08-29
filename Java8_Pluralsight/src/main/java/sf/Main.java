package sf;

public class Main {
	
	public PasswordEncoder makeBadEncoder(){
		return (password,salt) -> password.toUpperCase();
	} 
	
	public void doSomething(PasswordEncoder encoder){
		String salted = encoder.encode("abc", "123");
		System.out.println(salted);
	}

	public static void main(String[] args) {
		Main app = new Main();
		PasswordEncoder encoder = app.makeBadEncoder();
		app.doSomething(encoder);
		
	}

}
