package ValidateUtils;

public class UserValidate {
	private static UserValidate instance ;

	public static UserValidate getInstance() {
		if(instance==null) {
			instance = new UserValidate();
			return instance;
		}
		return instance ;
	}
	
	
	public boolean isEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	    return email != null && email.matches(emailRegex);
	}
	public boolean isPhone(String phone) {
		 String phoneRegex = "^\\d{10}$";
		    return phone != null && phone.matches(phoneRegex);
	}
	public static void main(String[] args) {
		String email = "hoanganh@gmail.com";
		System.out.println(UserValidate.getInstance().isEmail(email));
	}
	
}
