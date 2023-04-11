package ch01;

public class MainTest1 {

	public static void main(String[] args) {
		// 옵저버 패턴을 배워보자
		Button button = new Button("button1");
		// 인터페이스 -> 익명 클래스 -> 익명 구현 클래스
		button.setIButtonListener(new IButtonListener() {

			@Override
			public void clickEvent(String event) {
				// 하고싶은 동작, 알고리즘을 구현하면 된다
				System.out.println("콜백 들어왔어!! " + event);

			}
		});
		////////// 설계 콜백 메서드 - 옵저버 패턴
		// 오후 4시 됨 -> 알람 울림
		button.click("집에 가야지 엄마기다려");

		button.click("이게 정말 콜백이야");
		button.click("마자용");

	}

}
