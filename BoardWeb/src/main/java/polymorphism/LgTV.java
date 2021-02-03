package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	
	@Autowired
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("===> ¿¤Áã °´Ã¼ »ı¼º");
	}
	
	public void powerOn() {
		System.out.println("LgTV---Àü¿øÀ» ÄÒ´Ù");
	}
	
	public void powerOff() {
		System.out.println("LgTV---Àü¿øÀ» ²ö´Ù.");
	}
	
	public void VolumeUp() {
		speaker.volumeUp();;
	}
	
	public void volumeDown() {
		speaker.volumeDown();
	}
}
