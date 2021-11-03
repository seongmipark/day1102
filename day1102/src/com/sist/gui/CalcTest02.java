package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcTest02 extends JFrame implements ActionListener {
	
	//두수를 입력받기 위한 결과를 출력하기 위한 텍스트필드를
	//멤버변수로 선언한다.
	JTextField result;
	
	int num1; //연산을 위한 첫번째 수를 담을 변수
	int num2; //연산을 위한 두번째 수를 담을 변수
	int res; //결과값
	String op; //어떤 연산을 할지 담을 변수
	
	public CalcTest02() {

		//텍스트필드 객체를 생성한다. 매개변수의 값은 한번에 보여주는 글자의 수이다.
		result = new JTextField();
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,4));
		
		//16개의 버튼이 표시될 문자열을 배열에 담는다
		String [] arr = {"7","8","9","+","4","5","6","-","1","2","3","*","0","C","=","/"};
		
		//버튼 배열을 선언한다
		JButton []btn = new JButton[arr.length];
		
		//버튼배열이 수만큼 반복실행하여 버튼을 생성하여 패널에 담는다
		for (int i = 0 ; i<arr.length ;i++ ) {
			btn[i]= new JButton(arr[i]);
			p.add(btn[i]);
			
			//버튼에 이벤트 등록
			btn[i].addActionListener(this);
		}
		
		//프레임 위쪽에 결과창 넣고 가운데에 버튼을 배치
		add(result, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		
		setSize(300,400);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CalcTest02();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//눌러진 버튼의 글자를 읽어오는 메서드
		String cmd = e.getActionCommand();
		System.out.println(cmd);  
		
		if(cmd.equals("+")||cmd.equals("-")||cmd.equals("*")||cmd.equals("/")) {
			//지금 화면에 보이고 있는 숫자를 변수(num1)에 저장한다.
			num1 = Integer.parseInt(result.getText());
			
			//그리고 어떤 연산을 해야 할지를 변수(op)에 저장한다.
			op = cmd;
			
			//그리고 화면을 깨끗이 지워준다.
			result.setText("");
			
		}else if(cmd.equals("=")) {
			//지금 화면에 보이고 있는 숫자를 변수(num2)에 저장
			num2 = Integer.parseInt(result.getText());
			//그리고 op에 연산자의 종류에 따라 num1과 num2를 해당 연산을 수행하여
			switch(op) {
			case "+": res = num1 + num2; break;
			case "-": res = num1 - num2; break;
			case "*": res = num1 * num2; break;
			case "/": res = num1 / num2; break;
			}
			//result에 출력한다.
			result.setText(res+"");
			
			
		}else if (cmd.equals("C")) {
			//지금 화면에 보이고 있는 숫자를 지운다.
			result.setText("");
			
		}else {
			//눌러진 버튼의 글자를 텍스트필드에 계속 누적하여 출력하기
			result.setText(result.getText() + cmd );
		}
	}
}
