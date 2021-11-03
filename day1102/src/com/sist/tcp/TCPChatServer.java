package com.sist.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

//������ �ѹ��� �������� Ŭ���̾�Ʈ�� ��ȭ�� �����ϵ���(�޾Ƹ�) �ϱ� ���Ͽ�
//Ŭ���̾�Ʈ�� ����Ͽ� ��ȭ�� �ְ�޴� ����� ������� �����Ѵ�.
class ServerThread extends Thread{

	//��û�� Ŭ���̾�Ʈ�� ����� ������ ��������� ����
	Socket socket;
	
	//����� Ŭ���̾�Ʈ�� �����͸� �ְ� ���� ��Ʈ���� �����Ѵ�.
	InputStream is;
	OutputStream os;

	//������ �����Ͱ� ��� �迭�� �����Ѵ�.
	byte []data = new byte[100];
	
	
	//��ü������ Ŭ���̾�Ʈ�� ����� ������ �Ű������� ���޹޾� ��������� ���
	//��Ʈ���� �����Ѵ�.
	public ServerThread(Socket socket) {
		this.socket = socket;
		try {
			is = this.socket.getInputStream();
			os = this.socket.getOutputStream();
		} catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}

	}
	
	
	public void run() {
		//����� Ŭ���̾�Ʈ�ο� ����Ͽ� �����͸� �ְ�ޱ� ���Ͽ� �ݺ��� �̿�
		while(true) {
			try {
				//Ŭ���̾�Ʈ�κ��� �����͸� �����Ѵ�.
				is.read(data);
				String msg = new String(data);
				System.out.println("���ŵ� ������:"+ msg.trim());
				
				//Ŭ���̾�Ʈ�κ��� ���ŵ� �����͸� �״�� �޾Ƹ��Ѵ�.
				os.write(data);
				
				//������ ���ŵ� �����͸� ���Ͽ� �迭�� ������ ����ش�.
				Arrays.fill(data, (byte)0);
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}	
	}
}

public class TCPChatServer {
	public static void main(String[] args) {
		
		//Ŭ���̾�Ʈ�κ��� ���ŵ� �����͸� ������� byte�� �迭�� �����.
		byte []data = new byte[100];
		
		try {
		//1. ServerSocket�� ���� ������ �����Ѵ�
			ServerSocket server = new ServerSocket(9003);
			
			while(true) {//���Ѵ����·� Ŭ���̾�Ʈ�� ������ ��ٸ���.
				//Ŭ���̾�Ʈ�� ��û�� �����Ѵ�.
				Socket socket = server.accept();
				
				//����� Ŭ���̾�Ʈ�� ��ȭ�� ��� �ְ� �ޱ� ���� �����尴ü�� �����ϰ�
				//�����带 �����Ѵ�.
				ServerThread thread = new ServerThread(socket);
				thread.start();
				
			}
		} catch (Exception e) {
		
		}
	}

}
