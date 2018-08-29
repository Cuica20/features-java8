package sf;

@FunctionalInterface
public interface PasswordEncoder {
	
	public String encode(String password, String salt);

}
