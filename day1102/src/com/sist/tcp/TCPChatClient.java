package com.sist.tcp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TCPChatClient extends JFrame implements ActionListener{
	
	//��ȭ������ ����� �ؽ�Ʈ����� ��������� �����
	JTextArea jta;
	
	//���� ��ȭ������ �Է��� �ؽ�Ʈ�ʵ带 ���������
	JTextField jtf;
	
	//����½�Ʈ���� ��������� �����
	InputStream is;
	OutputStream os;
	
	public TCPChatClient() {
				
		//������� �ؽ�Ʈ������� �ؽ�Ʈ�ʵ带 ����
		jta = new JTextArea();
		jtf = new JTextField(50);
		
		//������ ���� ��ư����
		JButton btn = new JButton("����");
		
		//��ư�� �̺�Ʈ�� ����Ѵ�
		btn.addActionListener(this);
		
		
		//�ؽ�Ʈ�ʵ�� ��ư�� ������� �г��� ����
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);
		
		//�ؽ�Ʈ����� ��ũ�������� ���Ѵ�.
		JScrollPane jsp = new JScrollPane(jta);
		
		//�������� ����� �ؽ�Ʈ����� ���ΰ��ִ� ��ũ������ ��´�.
		add(jsp,BorderLayout.CENTER);
		
		//�ؽ�Ʈ�ʵ�� ��ư�� ����ִ� �г��� �������� �Ʒ��� ��´�.
		add(p,BorderLayout.SOUTH);
		
		//�������� ũ�⸦ �����Ѵ�.
		setSize(600,400);
		setVisible(true);

		try {
			//����� ���Ͽ� ������ ������ ��û�Ѵ�.
			Socket socket = new Socket("192.168.0.27", 9003);
			
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		//������ �������� �����͸� ����Ͽ� �ޱ� ���� ������ Ŭ������ �����
		//Ŭ���� �ȿ� �ִ� Ŭ������ innerŬ������� �ϰ�
		//�ٱ��� �ִ� Ŭ������ outterŬ������� �Ѵ�.
		//innerŬ������ ��ġ outterŬ������ ���ó�� �����Ѵ�.
		//outterŬ������ ����� �����Ӱ� ���� �� �� �ִ�.
		class ClientThread extends Thread{
			
			byte []data = new byte[100];
			
			public void run() {
				while(true) {
					try {
						//������ ������ �����͸� �����Ѵ�.
						is.read(data);
						
						//������ �����͸� ���ڿ��� �����.
						String msg = new String(data);
						
						//������ ���ڿ��� �ؽ�Ʈ������ �߰��Ѵ�.
						jta.append(msg.trim()+"\n");
						
					} catch (Exception e) {
						System.out.println("���ܹ߻�:"+e.getMessage());
					}
				}
			}
		}//end innerClass
		
		//�����κ��� ����Ͽ� ���ŵ� �޼����� �ޱ� ���� �����尴ü�� �����ϰ� �����Ѵ�.
		ClientThread ct = new ClientThread();
		ct.start();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TCPChatClient();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try {
			//����ڰ� �Է��� �ؽ�Ʈ�ʵ��� ������ ������ �������� �Ѵ�.
			//OutputStream�� void write(byte[] b) �޼ҵ带 �̿��Ѵ�.
			byte []data = jtf.getText().getBytes();
			os.write(data);
			
			//�޼����� �����ϰ� ���� �޼����Է��� ���Ͽ� �ؽ�Ʈ �ʵ带 ������ �����.
			jtf.setText("");
			
		} catch (Exception ex) {
		System.out.println("���ܹ߻�:"+ex.getMessage());
		}
	}

}



