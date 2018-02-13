package security;

import java.io.Serializable;

public class Credentials implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
}
