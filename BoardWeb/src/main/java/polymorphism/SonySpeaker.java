package polymorphism;

import org.springframework.stereotype.Component;

public class SonySpeaker implements Speaker{
	public SonySpeaker(){
		System.out.println("===> �Ҵ� ����Ŀ ��ü ����");
	}
	
	public void volumeUp() {
		System.out.println("�Ҵ� ����Ŀ ���� ��!");
	}
	
	public void volumeDown() {
		System.out.println("�Ҵ� ����Ŀ ���� �ٿ�!");
	}

}
