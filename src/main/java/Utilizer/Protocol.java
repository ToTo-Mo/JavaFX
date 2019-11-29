package Utilizer;

public class Protocol {
	//Type부분
	public static final byte PT_EXIT = 0;				//종료
	public static final byte PT_REQUEST = 1;			//요청
	public static final byte PT_RESPONSE = 2;			//응답
	public static final byte PT_MESSAGE = 3;			//메시지 - 사용 미지정
	public static final byte PT_UNDEFINED = 15;			//정의되지 않은 경우

	//Code부분
	public static final byte PT_LOGIN = 1;				//로그인
	public static final byte PT_STUDENT = 2;			//학생정보
	public static final byte PT_SCHEDULE = 3;			//스케줄
	public static final byte PT_DORMITORY = 4;			//기숙사정보(관리비, 일식별 식비 포함)
	public static final byte PT_ROOM = 5;				//호실(입사자 정보 = 방 배정 된 상태)	
	public static final byte PT_APPLICANT = 6;			//신청자(신청목록) - 제출 여부도 포함 되어 있음
	public static final byte PT_WAITLIST = 7;			//합격자(학생),입사대기열(관리자)	
	public static final byte PT_OATH = 8;				//서약서
	public static final byte PT_TUBERCULOSIS = 9;		//결핵

	public static final byte PT_NO_CODE = 0;			//코드가 없는 경우
	
	//Code 확장(상세) 부분	
	public static final byte PT_APPLY = 1;				//제출(입력,지원)
	public static final byte PT_CANCEL = 2;				//취소(삭제,지원 취소)
	public static final byte PT_LOOKUP = 3;				//데이터 조회
	//--------- Code : PT_DORMITORY(기숙사의 경우 추가되는 코드) --------- 
	public static final byte PT_INSERT = 4;				//기숙사 정보 추가(삽입)
	public static final byte PT_DELETE = 5;				//기숙사 정보 삭제(제거)

	//--------- Type : RESPONSE --------- 
	public static final byte PT_SUCCESS = 1;			//성공
	public static final byte PT_FAIL = 2;				//실패

	public static final byte PT_NO_CODE_EX = 0;			//code확장부분 없는경우

	//권한 부분
	public static final byte ANYBODY = 0;
	public static final byte STUDENT = 1;
	public static final byte ADMIN = 2;
	
	//헤더 길이 관련 부분
	public static final int LEN_TYPE_FIELD = 1;
	public static final int LEN_CODE_FIELD = 1;
	public static final int LEN_CODE_EXTEND_FIELD = 1;
	public static final int LEN_POWER_FIELD = 1;
	public static final int LEN_BODY = 4;	// Packey Body의 길이
	public static final int LEN_MAX = 2000; //쓸일 없지만 넣어 뒀습니다.
	public static final int LEN_ID_LENGTH = 8;	//없애고 가변길이 예정
	public static final int LEN_PW_LENGTH = 12;
	
	//Protocol 객체가 갖는 변수
	protected byte protocolType;
	protected byte protocolCode;
	protected byte protocolExtendCode;
	protected int dataLength;
	protected byte who;
	byte[] packet;
	
	public Protocol() {
		this(ANYBODY);
	}
	
	public Protocol(byte user) {
		this(PT_UNDEFINED,PT_NO_CODE,user);
	}
	
	public Protocol(byte protocolType,byte protocolCode,byte user) {
		this.protocolType = protocolType;
		this.protocolCode = protocolCode;
		this.protocolExtendCode = PT_NO_CODE_EX;
		this.who = user;
		this.dataLength =0;
		getPacket(protocolType,protocolCode,this.protocolExtendCode,user);
	}
	
	public Protocol(byte protocolType,byte protocolCode,byte protocolExCode,byte user) {
		this.protocolType = protocolType;
		this.protocolCode = protocolCode;
		this.protocolExtendCode = PT_NO_CODE_EX;
		this.who = user;
		this.dataLength =0;
		getPacket(protocolType,protocolCode,protocolExCode,user);
	}
	
	public Protocol(byte protocolType,byte protocolCode,byte protocolExcode,byte user,String data) {
		this.protocolType = protocolType;
		this.protocolCode = protocolCode;
		this.protocolExtendCode = PT_NO_CODE_EX;
		this.who = user;
		this.dataLength =data.getBytes().length;
		getPacket(protocolType,protocolCode,protocolExcode,user);
	}
	
	// Integer -> Byte[] 로 변환하는 함수  (단, (int 형)4byte -> (byte[])2byte이므로 일정 크기 이상의 int의 경우 잘릴 가능성 有)
	public byte[] intToByteArray(int val) {
		byte[] bytearr = new byte[4];
		bytearr[0] = (byte)(val);
		bytearr[1] = (byte)(val>>8);
		bytearr[2] = (byte)(val>>16);
		bytearr[3] = (byte)(val>>24);
		return bytearr;
	}
		
	// Byte[] -> Integer 로 변환하는 함수 (단, Byte[] 의 크기는 2byte로 한정되어 있다.)
	public int byteArrayToint(byte[] bytearr) {
		return ((int)(bytearr[0]&0xff)+(int)((bytearr[1]&0xff)<<8)+(int)((bytearr[2]&0xff)<<16)+(int)((bytearr[3]&0xff)<<24));
	}
	
	public byte[] getPacket(byte protocolType,byte protocolCode,byte protocolExCode, byte power) {
		if(packet == null) {
			switch(protocolType) {
			case PT_EXIT:
				packet = new byte [LEN_TYPE_FIELD];
				packet[0] = protocolType;
				break;
			case PT_MESSAGE:	
				packet = new byte[LEN_MAX];
				packet[0] = protocolType;
				break;
			case PT_UNDEFINED:
				packet = new byte[LEN_MAX];
				break;
			case PT_REQUEST:
			case PT_RESPONSE:
			{
				if(protocolCode == 1)
					packet = new byte[LEN_TYPE_FIELD+LEN_CODE_FIELD+LEN_CODE_EXTEND_FIELD+LEN_POWER_FIELD+LEN_BODY+LEN_ID_LENGTH+LEN_PW_LENGTH];
				else
					packet = new byte[LEN_TYPE_FIELD+LEN_CODE_FIELD+LEN_CODE_EXTEND_FIELD+LEN_POWER_FIELD+LEN_BODY+dataLength];
				packet[0] = protocolType;
				packet[1] = protocolCode;
				packet[2] = protocolExCode;
				packet[3] = power;
			}
			}
		}
		return packet;
	}
	
	
	public void setDataLength(String data) {
		this.dataLength = data.getBytes().length;
	}
	public void setDataLength() {
		byte[] length = new byte[4];
		length[0] = packet[4];
		length[1] = packet[5];
		length[2] = packet[6];
		length[3] = packet[7];
		dataLength= byteArrayToint(length);
	}
	
	public int getDataLength() {
		return dataLength;
	}
	
	public byte[] getPacket() {
		return packet;
	}
	
	public void setPacket(byte protocolType,byte protocolCode,byte protocolExCode,byte user,byte[] buf) {
		packet =null;
		byte[] length = new byte[4];
		length[0]= buf[4];
		length[1]=buf[5];
		length[2]=buf[6];
		length[3]=buf[7];
		dataLength= byteArrayToint(length);
		packet = getPacket(protocolType,protocolCode,protocolExCode,user);
		this.protocolType=protocolType;
		this.protocolExtendCode= protocolExCode;
		this.protocolCode = protocolCode;
		System.arraycopy(buf, 0, packet, 0, packet.length);
	}
	
	public void setData(String data) {
		System.arraycopy(data.trim().getBytes(), 0, packet, LEN_TYPE_FIELD+LEN_CODE_FIELD+LEN_CODE_EXTEND_FIELD+LEN_POWER_FIELD+LEN_BODY, data.trim().getBytes().length);
		packet[LEN_TYPE_FIELD+LEN_CODE_FIELD+LEN_CODE_EXTEND_FIELD+LEN_POWER_FIELD+LEN_BODY + data.trim().getBytes().length]='\0';
	}
	public String getData() {
		this.setDataLength();
		return new String(packet,LEN_TYPE_FIELD+LEN_CODE_FIELD+LEN_CODE_EXTEND_FIELD+LEN_POWER_FIELD+LEN_BODY, dataLength).trim();
	}
	public void setId(String id){
		System.arraycopy(id.trim().getBytes(), 0, packet, LEN_TYPE_FIELD+LEN_CODE_FIELD+LEN_CODE_EXTEND_FIELD+LEN_POWER_FIELD+LEN_BODY, id.trim().getBytes().length);
	}
	public void setPW(String PW){
		System.arraycopy(PW.trim().getBytes(), 0, packet, LEN_TYPE_FIELD+LEN_CODE_FIELD+LEN_CODE_EXTEND_FIELD+LEN_POWER_FIELD+LEN_BODY+LEN_ID_LENGTH, PW.trim().getBytes().length);
		packet[LEN_TYPE_FIELD+LEN_CODE_FIELD+LEN_CODE_EXTEND_FIELD+LEN_POWER_FIELD+LEN_BODY+LEN_ID_LENGTH+ PW.trim().getBytes().length]='\0';
	}
	public String getID(){
		return new String(packet, LEN_TYPE_FIELD+LEN_CODE_FIELD+LEN_CODE_EXTEND_FIELD+LEN_POWER_FIELD+LEN_BODY,LEN_ID_LENGTH).trim();
	}
	public String getPW(){
		return new String(packet, LEN_TYPE_FIELD+LEN_CODE_FIELD+LEN_CODE_EXTEND_FIELD+LEN_POWER_FIELD+LEN_BODY+LEN_ID_LENGTH,LEN_PW_LENGTH).trim();
	}
	
}
