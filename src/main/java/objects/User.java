package objects;

public class User {
	private int user_id;
	private String user_name;
	private String user_pass;
	private String user_image;
	private String user_fullname;
	private byte user_gender;
	private String user_email;
	private String user_phone;
	private String user_address;
	private int user_role;

	public User(int user_id, String user_name, String user_pass, String user_image, String user_fullname,
			byte user_gender, String user_email, String user_phone, String user_address, int user_role) {

		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pass = user_pass;
		this.user_image = user_image;
		this.user_fullname = user_fullname;
		this.user_gender = user_gender;
		this.user_email = user_email;
		this.user_phone = user_phone;
		this.user_address = user_address;
		this.user_role = user_role;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public String getUser_image() {
		return user_image;
	}

	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}

	public String getUser_fullname() {
		return user_fullname;
	}

	public void setUser_fullname(String user_fullname) {
		this.user_fullname = user_fullname;
	}

	public byte getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(byte user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public int getUser_role() {
		return user_role;
	}

	public void setUser_role(int user_role) {
		this.user_role = user_role;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_pass=" + user_pass + ", user_image="
				+ user_image + ", user_fullname=" + user_fullname + ", user_gender=" + user_gender + ", user_email="
				+ user_email + ", user_phone=" + user_phone + ", user_address=" + user_address + ", user_role="
				+ user_role + "]";
	}

}
