package textrpg;

import java.util.ArrayList;
import java.util.HashMap;

import framework.Output;
import framework.RandomGen;

public class UserManager {
	private UserManager() {
	}

	private static UserManager instance = new UserManager();

	public static UserManager getInstance() {
		return instance;
	}

	private final int STARTCODE = 1000;
	private final int USERMAX = 9000;

	private Output out = Output.getInstance();

	private ArrayList<User> users = new ArrayList<>();
	private HashMap<Integer, Player> Players = new HashMap<>();

	private User log;
	private Player player;

	public boolean login(String id, String pw) {
		User user = new User(id, pw, 0);
		int idx = users.indexOf(user);
		if (idx == -1)
			return false;

		log = users.get(idx);
		player = Players.get(log.getCode());
		return true;
	}

	public boolean signin(String id, String pw) {
		if (users.size() == USERMAX) {
			out.printErrln("더 이상 가입이 불가합니다.");
			return false;
		}
		
		for (User chk : users) {
			if (chk.chkId(id)) {
				out.printErrln("이미 사용된 ID입니다.");
				return false;
			}
		}

		int code = 0;
		boolean isFound = true;
		while (isFound) {
			code = RandomGen.getInstance().get(USERMAX) + STARTCODE;
			isFound = false;
			for (User chk : users) {
				if (chk.chkCode(code)) {
					isFound = true;
					break;
				}
			}
		}

		User user = new User(id, pw, code);
		Player newPlayer = new Player();
		users.add(user);
		Players.put(code, newPlayer);
		return true;
	}

	public boolean leave(String pw) {
		if (!log.chkPassword(pw)) {
			out.printErrln("비밀번호가 틀렸습니다.");
			return false;
		}

		Players.remove(log.getCode());
		users.remove(log);
		log = null;
		Players = null;
		return true;
	}

	public void logout() {
		log = null;
		Players = null;
	}

	public boolean isLogin() {
		return log != null;
	}

	public String getUserId() {
		return log.getId();
	}

	public Player getPlayer() {
		return player;
	}
}
