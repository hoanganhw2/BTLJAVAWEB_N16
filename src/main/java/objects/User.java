package objects;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	private int user_id;
	private String user_name;
	private String user_pass;
	private String user_image;
	private String user_fullname;
	private boolean user_gender;
	private String user_email;
	private String user_phone;
	private String user_address;
	private int user_role;
	private Date user_createAt ;
	private Date user_updateAt;
	
	

}
