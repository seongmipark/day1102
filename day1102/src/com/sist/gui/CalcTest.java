package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcTest extends JFrame implements ActionListener{
	
	//두수를 입력받기 위한 결과를 출력하기 위한 텍스트필드를
	//멤버변수로 선언한다.
	JTextField jtf01;
	JTextField jtf02;
	JTextField jtf03;
	
	public CalcTest() {
		
		//텍스트필드 객체를 생성한다. 매개변수의 값은 한번에 보여주는 글자의 수이다.
		jtf01 = new JTextField(10);
		jtf02 = new JTextField(10);
		jtf03 = new JTextField(10);
		
		//프레임의 레이아웃 방식을 FlowLayout방식으로 설정
		setLayout(new FlowLayout());
	
		//차례대로 라벨과 버튼을 생성하여 프레임에 담는다.
		//라벨은 화면에 보이기만 하면 되기 때문에 이름을 줄 필요는 없다.
		add(new JLabel("수1:"));
		add(jtf01);
		
		add(new JLabel("수2:"));
		add(jtf02);
		
		JButton btnAdd = new JButton("더하기");
		add(btnAdd);
	
		add(new JLabel("결과:"));
		add(jtf03);
		
		setSize(600,200);
		setVisible(true);
		
		//버튼에 이벤트를 등록한다.
		//매개변수로 'this'로 전달하는 것은 버튼이 눌러졌을 때
		// 일처리 하는 담당객체가 바로 CalcTest 자신이라는 것이다.
		btnAdd.addActionListener(this);
	
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CalcTest();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//텍스트필드 jtf01,02의 값을 읽어와야한다.	
		int num1 = Integer.parseInt(jtf01.getText());
		int num2 = Integer.parseInt(jtf02.getText());
		
		int sum = num1+num2;
		jtf03.setText(sum+"");
	}

}
