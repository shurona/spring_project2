package polymorphism;


public class SamsungTV implements TV{

	private Speaker speaker;
	private int price;
	
	public void initMethod() {
		System.out.println("��ü �ʱ�ȭ �۾� �ǽ�");
	}
	public void destroyMethod() {
		System.out.println("��ü ������ ó���� �۾� �ǽ�");
	}
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker ȣ��");
		this.speaker = speaker;
	}
	
	public void setPrice(int price) {
		System.out.println("===> setPrice ȣ��");
		this.price = price;
	}
	
	public SamsungTV() {
		System.out.println("==> �ＺƼ��(1) ��ü����");
	}
	
//	public SamsungTV(Speaker speaker) {
//		System.out.println("==> �ＺƼ��(2) ��ü����");
//		this.speaker = speaker;
//	}
//	
//	public SamsungTV(Speaker speaker, int price) {
//		System.out.println("==> �ＺƼ��(3) ��ü���� ������ ( "+price+" )");
//		this.speaker = speaker;
//	}
	
	public void powerOn() {
		System.out.println("SamSungTV---������ �Ҵ�. ���� : "+price+" ");
	}
	
	public void powerOff() {
		System.out.println("SamSungTV---������ ����.");
	}
	
	public void VolumeUp() {
		speaker.volumeUp();
	}
	
	public void volumeDown() {
		speaker.volumeDown();
	}
}

