package polymorphism;

import org.springframework.stereotype.Component;

public class AppleSpeaker implements Speaker{
	
	public AppleSpeaker() {
		System.out.println("===> ���� ����Ŀ ��ü ����");
	}

	@Override
	public void volumeUp() {
		System.out.println("���� ����Ŀ ----- ���� ��!");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("���� ����Ŀ ----- �����ٿ�!");
		
	}
	
}
