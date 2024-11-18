package textrpg;

public class User {
	private String id;
	private String password;
	private int code;

	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public boolean chkId(String id) {
		return this.id.equals(id);
	}

	public boolean chkPassword(String password) {
		return this.password.equals(password);
	}

	public String getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			User other = (User) obj;
			return other.chkId(this.id) && other.chkPassword(this.password);
		}
		return false;
	}

}
