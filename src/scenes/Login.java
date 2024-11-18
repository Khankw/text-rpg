package scenes;

import textrpg.UserManager;

public class Login extends Scene {

	@Override
	public void update() {
		printTitle("로그인");
		String id= in.input("ID");
		String pw= in.input("PW");
		
		UserManager usermanager = UserManager.getInstance();
		
		if(usermanager.login(id, pw)) {
			out.add(usermanager.getUserId(), color.BRIGHTBLUE);
			out.resetColor();
			out.println("님, 로그인 완료되었습니다.");
		}else {
			out.add("사용자 정보를 확인해 주세요.", color.RED);
			out.resetColor();
			out.println();
		}
		manager.prevScene();
	}
}
