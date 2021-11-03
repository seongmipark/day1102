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
	
	//�μ��� �Է¹ޱ� ���� ����� ����ϱ� ���� �ؽ�Ʈ�ʵ带
	//��������� �����Ѵ�.
	JTextField result;
	
	int num1; //������ ���� ù��° ���� ���� ����
	int num2; //������ ���� �ι�° ���� ���� ����
	int res; //�����
	String op; //� ������ ���� ���� ����
	
	public CalcTest02() {

		//�ؽ�Ʈ�ʵ� ��ü�� �����Ѵ�. �Ű������� ���� �ѹ��� �����ִ� ������ ���̴�.
		result = new JTextField();
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,4));
		
		//16���� ��ư�� ǥ�õ� ���ڿ��� �迭�� ��´�
		String [] arr = {"7","8","9","+","4","5","6","-","1","2","3","*","0","C","=","/"};
		
		//��ư �迭�� �����Ѵ�
		JButton []btn = new JButton[arr.length];
		
		//��ư�迭�� ����ŭ �ݺ������Ͽ� ��ư�� �����Ͽ� �гο� ��´�
		for (int i = 0 ; i<arr.length ;i++ ) {
			btn[i]= new JButton(arr[i]);
			p.add(btn[i]);
			
			//��ư�� �̺�Ʈ ���
			btn[i].addActionListener(this);
		}
		
		//������ ���ʿ� ���â �ְ� ����� ��ư�� ��ġ
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
		//������ ��ư�� ���ڸ� �о���� �޼���
		String cmd = e.getActionCommand();
		System.out.println(cmd);  
		
		if(cmd.equals("+")||cmd.equals("-")||cmd.equals("*")||cmd.equals("/")) {
			//���� ȭ�鿡 ���̰� �ִ� ���ڸ� ����(num1)�� �����Ѵ�.
			num1 = Integer.parseInt(result.getText());
			
			//�׸��� � ������ �ؾ� ������ ����(op)�� �����Ѵ�.
			op = cmd;
			
			//�׸��� ȭ���� ������ �����ش�.
			result.setText("");
			
		}else if(cmd.equals("=")) {
			//���� ȭ�鿡 ���̰� �ִ� ���ڸ� ����(num2)�� ����
			num2 = Integer.parseInt(result.getText());
			//�׸��� op�� �������� ������ ���� num1�� num2�� �ش� ������ �����Ͽ�
			switch(op) {
			case "+": res = num1 + num2; break;
			case "-": res = num1 - num2; break;
			case "*": res = num1 * num2; break;
			case "/": res = num1 / num2; break;
			}
			//result�� ����Ѵ�.
			result.setText(res+"");
			
			
		}else if (cmd.equals("C")) {
			//���� ȭ�鿡 ���̰� �ִ� ���ڸ� �����.
			result.setText("");
			
		}else {
			//������ ��ư�� ���ڸ� �ؽ�Ʈ�ʵ忡 ��� �����Ͽ� ����ϱ�
			result.setText(result.getText() + cmd );
		}
	}
}
