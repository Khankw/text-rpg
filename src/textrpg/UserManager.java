package textrpg;

import java.util.ArrayList;

public class UserManager {
	private UserManager() {
	}

	private static UserManager instance = new UserManager();

	public static UserManager getInstance() {
		return instance;
	}

	private ArrayList<User> users = new ArrayList<>();
	private User loginUser;

	public boolean login(String id, String pw) {
		User user = new User(id, pw);
		int idx = users.indexOf(user);
		if (idx == -1)
			return false;

		loginUser = users.get(idx);
		return true;
	}

	public boolean signin(String id, String pw) {
		for (User chk : users)
			if (chk.chkId(id))
				return false;

		User user = new User(id, pw);
		users.add(user);
		return true;
	}

	public void logout() {
		loginUser = null;
	}

	public boolean isLogin() {
		return loginUser != null;
	}

	public String getUserId() {
		return loginUser.getId();
	}
}
