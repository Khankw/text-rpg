package scenes;

import textrpg.UserManager;

public class Signin extends Scene {
	@Override
	public void update() {
		printTitle("가입");
		String id= in.input("ID");
		String pw= in.input("PW");
		
		UserManager usermanager = UserManager.getInstance();
		
		if(usermanager.signin(id, pw)) {
			out.add(id, color.BRIGHTBLUE);
			out.resetColor();
			out.println("님의 회원가입이 완료되었습니다.");
		}else {
			out.add("ID가 중복되었습니다.", color.RED);
			out.resetColor();
			out.println();
		}
		manager.prevScene();
	}
}
