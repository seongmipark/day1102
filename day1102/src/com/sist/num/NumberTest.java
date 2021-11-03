package com.sist.num;
//1~100까지의 난수를 랜덤하게 생성하여 가지고잇다.
//사용자는 숫자를 추축하고 컴퓨터는 사용자가 입력한 숫자가 정답보다 높은지낮은지 알려준다.


import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.TextEvent;
import java.awt.Color;
import java.awt.event.KeyListener;

public class NumberTest extends JFrame implements ActionListener,KeyListener{
	Random r = new Random();
	int num = r.nextInt(100);  // 시스템이 갖고 잇는 숫자

	JTextField jtf; //숫자입력칸
	JTextField hint; //힌트칸
	JButton btn1;
	JButton btn2;

	public NumberTest() {
		
		System.out.println(num);
		
		setTitle("숫자게임");
		
		//숫자입력 패널
		JPanel p1 = new JPanel();
		jtf = new JTextField(10);
		p1.add(new JLabel("숫자를 추측하시오:"));
		p1.add(jtf);
		
		//힌트 텍스트에리어
		JTextPane jtp = new JTextPane();
		JPanel p2 = new JPanel();
		hint = new JTextField("힌트",20);
		p2.add(hint);
		
		//버튼
		JPanel p3 = new JPanel();
		JButton replay = new JButton("다시 한번");
		p3.add(replay);
		JButton finish = new JButton("종료");
		p3.add(finish);
		
		setSize(300,150);
		setVisible(true);
		
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
		
		replay.addActionListener(this);
		finish.addActionListener(this);
		jtf.addKeyListener(this);

		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NumberTest();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		
		try {
			if(cmd.equals("다시 한번")) {
				int num = r.nextInt(100); 
				System.out.println(num);
				hint.setBackground(Color.white);
				hint.setText("힌트");
				jtf.setText("");
				
			}else if(cmd.equals("종료")) {
				System.exit(0);	
			}
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
		

	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		try {
			int usernum = Integer.parseInt(jtf.getText());		
			if(num < usernum) {
				hint.setBackground(Color.red);
				hint.setText("더 낮습니다.");
			}else if(num > usernum) {
				hint.setBackground(Color.red);
				hint.setText("더 높습니다.");
			}else if(num == usernum) {
				hint.setBackground(Color.green);
				hint.setText("맞혔습니다!");
			}
		} catch (Exception e2) {
			// TODO: handle exception
		} 
	
	}

}
