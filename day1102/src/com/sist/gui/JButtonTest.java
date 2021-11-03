package com.sist.gui;

import javax.swing.JFrame;

public class JButtonTest extends JFrame {

	public JButtonTest() {	
	}
	
	public static void main(String[] args) {
		//우리가 만든 JButtonTest가 곧 JFrame이다.
		JButtonTest f =  new JButtonTest();
		
		//창을 만들었지만 창이 화면에 보이지 않는다.
		//보이게 하려면 창의 가로,세로 길이를 설정하고 화면에 보이도록 설정
		f.setSize(400,300);
		f.setVisible(true);
		
		//창을 닫을 때 프로그램도 같이 종료되도록 하는 명령어
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

}
