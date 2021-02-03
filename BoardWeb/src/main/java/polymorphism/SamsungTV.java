package polymorphism;


public class SamsungTV implements TV{

	private Speaker speaker;
	private int price;
	
	public void initMethod() {
		System.out.println("객체 초기화 작업 실시");
	}
	public void destroyMethod() {
		System.out.println("객체 삭제전 처리할 작업 실시");
	}
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker 호출");
		this.speaker = speaker;
	}
	
	public void setPrice(int price) {
		System.out.println("===> setPrice 호출");
		this.price = price;
	}
	
	public SamsungTV() {
		System.out.println("==> 삼성티비(1) 객체생성");
	}
	
//	public SamsungTV(Speaker speaker) {
//		System.out.println("==> 삼성티비(2) 객체생성");
//		this.speaker = speaker;
//	}
//	
//	public SamsungTV(Speaker speaker, int price) {
//		System.out.println("==> 삼성티비(3) 객체생성 가격은 ( "+price+" )");
//		this.speaker = speaker;
//	}
	
	public void powerOn() {
		System.out.println("SamSungTV---전원을 켠다. 가격 : "+price+" ");
	}
	
	public void powerOff() {
		System.out.println("SamSungTV---전원을 끈다.");
	}
	
	public void VolumeUp() {
		speaker.volumeUp();
	}
	
	public void volumeDown() {
		speaker.volumeDown();
	}
}

