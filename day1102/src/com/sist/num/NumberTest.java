package com.sist.num;
//1~100������ ������ �����ϰ� �����Ͽ� �������մ�.
//����ڴ� ���ڸ� �����ϰ� ��ǻ�ʹ� ����ڰ� �Է��� ���ڰ� ���亸�� ������������ �˷��ش�.


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
	int num = r.nextInt(100);  // �ý����� ���� �մ� ����

	JTextField jtf; //�����Է�ĭ
	JTextField hint; //��Ʈĭ
	JButton btn1;
	JButton btn2;

	public NumberTest() {
		
		System.out.println(num);
		
		setTitle("���ڰ���");
		
		//�����Է� �г�
		JPanel p1 = new JPanel();
		jtf = new JTextField(10);
		p1.add(new JLabel("���ڸ� �����Ͻÿ�:"));
		p1.add(jtf);
		
		//��Ʈ �ؽ�Ʈ������
		JTextPane jtp = new JTextPane();
		JPanel p2 = new JPanel();
		hint = new JTextField("��Ʈ",20);
		p2.add(hint);
		
		//��ư
		JPanel p3 = new JPanel();
		JButton replay = new JButton("�ٽ� �ѹ�");
		p3.add(replay);
		JButton finish = new JButton("����");
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
			if(cmd.equals("�ٽ� �ѹ�")) {
				int num = r.nextInt(100); 
				System.out.println(num);
				hint.setBackground(Color.white);
				hint.setText("��Ʈ");
				jtf.setText("");
				
			}else if(cmd.equals("����")) {
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
				hint.setText("�� �����ϴ�.");
			}else if(num > usernum) {
				hint.setBackground(Color.red);
				hint.setText("�� �����ϴ�.");
			}else if(num == usernum) {
				hint.setBackground(Color.green);
				hint.setText("�������ϴ�!");
			}
		} catch (Exception e2) {
			// TODO: handle exception
		} 
	
	}

}
