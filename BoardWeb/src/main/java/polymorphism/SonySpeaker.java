package polymorphism;

import org.springframework.stereotype.Component;

public class SonySpeaker implements Speaker{
	public SonySpeaker(){
		System.out.println("===> 소니 스피커 객체 생성");
	}
	
	public void volumeUp() {
		System.out.println("소니 스피커 볼륨 업!");
	}
	
	public void volumeDown() {
		System.out.println("소니 스피커 볼륨 다운!");
	}

}
