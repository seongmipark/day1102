package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class BorderLayoutTest02 extends JFrame {
	
	public BorderLayoutTest02() {
		//프레임을 BorderLayout으로 설정한다.
		setLayout(new BorderLayout());
		
		//다섯개의 버튼을 생성하여 위,아래,좌,우,가운데에 담기
		add(new JButton("위"), BorderLayout.NORTH);
//		add(new JButton("아래"), BorderLayout.SOUTH);
//		add(new JButton("좌"), BorderLayout.WEST);
//		add(new JButton("우"), BorderLayout.EAST);
		add(new JButton("가운데"), BorderLayout.CENTER);
	
		setSize(400,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BorderLayoutTest02();
	}
}
