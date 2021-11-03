package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonTest02 extends JFrame {

	public JButtonTest02() {
		
		//버튼을 생성하여 '창'에 담아보기
		JButton btn01 = new JButton("버튼1");
		JButton btn02 = new JButton("버튼2");
		
		add(btn01);
		add(btn02);
		
		//창을 만들었지만 창이 화면에 보이지 않는다.
		//보이게 하려면 창의 가로,세로 길이를 설정하고 화면에 보이도록 설정
		setSize(400,300);
		setVisible(true);
		
		//창을 닫을 때 프로그램도 같이 종료되도록 하는 명령어
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	public static void main(String[] args) {
		//우리가 만든 JButtonTest가 곧 JFrame이다.
		//변수이름을 굳이 줄 필요가 없을 것 같다.
		//객체를 생성하기만 해도 좋다.
		//JButtonTest02 f =  new JButtonTest02();
		new JButtonTest02();
	}

}
