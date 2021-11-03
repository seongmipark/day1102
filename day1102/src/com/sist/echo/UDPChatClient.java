package com.sist.echo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UDPChatClient extends JFrame implements ActionListener {
	
	//UDP������� �����͸� �ְ� �ޱ� ���� 
	//DatagramSocket�� DatagramPacket�� ��������� �����Ѵ�.
	DatagramSocket socket;
	DatagramPacket packet;
	
	//��ȭ ������ ǥ���ϱ� ���� �ؽ�Ʈ����� ��������� �����Ѵ�
	JTextArea jta;
	
	//��ȭ ������ �Է��ϱ� ���� �ؽ�Ʈ �ʵ带 ��������� ����
	JTextField jtf;
	
	public UDPChatClient() {
		//����������� �����Ѵ�
		jta = new JTextArea();
		jtf = new JTextField(50);
		
		//'����'�� ���� ��ư ����
		JButton btn = new JButton("����");
		
		//�ؽ�Ʈ�ʵ�� ��ư�� ���� �г��� ����
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);
		
		//�ؽ�Ʈ����� ��ũ���� ǥ���ϴ� ��ũ���Ұ�ü�� �����Ѵ�.
		JScrollPane jsp = new JScrollPane(jta);
		
		//�������� ����� �ؽ�Ʈ�� ����� ���ΰ� �ִ� ��ũ������ ��´�.
		add(jsp,BorderLayout.CENTER);
		
		//�������� �Ʒ��� �ؽ�Ʈ�ʵ�� ��ư�� ����ִ� �г��� ��´�.
		add(p,BorderLayout.SOUTH);
		
		//�������� ũ�⸦ �����Ѵ�.
		setSize(800,600);
		
		//ȭ�鿡 �����ֵ��� ����
		setVisible(true);
		
		try {
			//�����͸� �ְ� �ޱ� ���� �޼ҵ带 ���� �ִ� DatagramSocket��ü�� ����
			socket = new DatagramSocket();
		} catch (Exception e) {
		System.out.println("���ܹ߻�:"+e.getMessage());
		}
		
		//���۹�ư�� �̺�Ʈ�� ����Ͽ� ����Ʈ�ʵ忡 �Է��� ������ ������ �����ϵ��� �Ѵ�. 
		btn.addActionListener(this);
		
		//�����κ��� �����͸� ����Ͽ� �����ϱ� ���� ������Ŭ������ innerŬ������ �����.
		class ClientThread implements Runnable{
			DatagramPacket packet;
			byte []data = new byte[100];
			public void run() {
				
				//�����͸� �����ϱ� ���� ��Ŷ�� ���� ����
				packet = new DatagramPacket(data, data.length);
				
				//����Ͽ� �����κ��� �����͸� �����ϵ��� �Ѵ�.
				while(true) {

					try {
						//�����͸� �����ϱ� ���ؼ� ������ receive�޼ҵ� �̿�
						socket.receive(packet);
						
						//�����κ��� ���ŵ� �����Ͱ� �ִ� �迭�� ������ ���ڿ��� �����
						String msg = new String(data);
						
						//���ŵ� ���ڿ��� �ؽ�Ʈ����� �߰��Ѵ�.
						jta.append(msg.trim()+"\n");
						
						//���������� ������ ���Ͽ� �迭�� �����ش�.
						Arrays.fill(data, (byte)0);
						
					} catch (Exception e) {
						System.out.println("���ܹ߻�:"+e.getMessage());
					}//end catch
				}//end while
				
				
			}//end run
		}//end innerŬ����
		
		//������ ��ü�� �����ϰ� �����带 ������Ų��.
		new Thread(new ClientThread()).start();
	
	}//end ������ 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UDPChatClient();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
		// TODO Auto-generated method stub
		// ����ڰ� �Է��� ��ȭ������ �ִ� �ؽ�Ʈ�ʵ��� ���ڿ��� ���� �´�.
		String msg = jtf.getText();
		
		//UDP������� �����͸� �������� ��Ŷ�� �����ؾ� �Ѵ�.
		//�׷��� �� ���ڿ��� byte[] �迭�� ������ �Ѵ�.
		byte []data = msg.getBytes();
		
		//192.168.0.27 ������ �ּҸ� ���� InetAddress��ü ����
		InetAddress addr = InetAddress.getByName("192.168.0.27");
		
		int port = 9005;
		
		//�����͸� ���� ��Ŷ�� ����
		packet = new DatagramPacket(data, data.length, addr, port);
		
		//������ �����͸� ����
		socket.send(packet);
		
		}catch(Exception ex) {
			System.out.println("���ܹ߻�:"+ex.getMessage());
		}
	}

}
