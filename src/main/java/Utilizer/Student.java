package Utilizer;

import java.io.*;

public class Student implements Serializable {
    static final long serialVersionUID = 1L;    // 직렬화를 위한 내부 변수

	public static Student student = new Student();

	public static Student getInstance() {
		return student;
	}
	
	String student_number;			//학번
	String name;					//이름
	String gender;					//성별
	String student_postcode;		//학생 우편번호
	String student_address;			//학생 주소
	String parent_name;				//부모 이름
	String parent_postcode;			//부모 우편번호
	String parent_address;			//부모 주소

	public static final int LEN_STUDENT_NUMBER = 8;
	public static final int LEN_NAME = 15;
	public static final int LEN_GENDER = 1;
	public static final int LEN_STUDENT_POSTCODE = 11;
	public static final int LEN_STUDENT_ADDRESS = 200;
	public static final int LEN_PARENT_NAME = 15;
	public static final int LEN_PARENT_POSTCODE = 11;
	public static final int LEN_PARENT_ADDRESS = 200;
	public static final int LEN_STUDENT_OBEJCT = 461;

	public Student() {

	}

	public Student(String student_number, String name, String gender, String student_postcode, String student_address,
			String parent_name, String parent_postcode, String parent_address) {
		this.student_number = student_number;
		this.name = name;
		this.gender = gender;
		this.student_postcode = student_postcode;
		this.student_address = student_address;
		this.parent_name = parent_name;
		this.parent_postcode = parent_postcode;
		this.parent_address = parent_address;
	}

	public byte[] toBytes() {
		byte[] data = new byte[LEN_STUDENT_OBEJCT + 1];
		System.arraycopy(student_number.trim().getBytes(), 0, data, 0, student_number.trim().getBytes().length);
		System.arraycopy(name.trim().getBytes(), 0, data, LEN_STUDENT_NUMBER, name.trim().getBytes().length);
		System.arraycopy(gender.trim().getBytes(), 0, data, LEN_STUDENT_NUMBER + LEN_NAME,
				gender.trim().getBytes().length);
		System.arraycopy(student_postcode.trim().getBytes(), 0, data, LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER,
				student_postcode.trim().getBytes().length);
		System.arraycopy(student_address.trim().getBytes(), 0, data,
				LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER + LEN_STUDENT_POSTCODE,
				student_address.trim().getBytes().length);
		System.arraycopy(parent_name.trim().getBytes(), 0, data,
				LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER + LEN_STUDENT_POSTCODE + LEN_STUDENT_ADDRESS,
				parent_name.trim().getBytes().length);
		System.arraycopy(
				parent_postcode.trim().getBytes(), 0, data, LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER
						+ LEN_STUDENT_POSTCODE + LEN_STUDENT_ADDRESS + LEN_PARENT_NAME,
				parent_postcode.trim().getBytes().length);
		System.arraycopy(
				parent_address.trim().getBytes(), 0, data, LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER
						+ LEN_STUDENT_POSTCODE + LEN_STUDENT_ADDRESS + LEN_PARENT_NAME + LEN_PARENT_POSTCODE,
				parent_address.trim().getBytes().length);
		data[LEN_STUDENT_OBEJCT] = '\0';

		return data;
	}

	public static Student toStudent(byte[] packet){
		String data = new String(packet);

		String student_number = data.substring(0, LEN_STUDENT_NUMBER);
		String name = data.substring(LEN_STUDENT_NUMBER, LEN_STUDENT_NUMBER + LEN_NAME);
		String gender = data.substring(LEN_STUDENT_NUMBER + LEN_NAME, LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER);
		String student_postcode = data.substring(LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER,
				LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER + LEN_STUDENT_POSTCODE);
		String student_address = data.substring(LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER + LEN_STUDENT_POSTCODE,
				LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER + LEN_STUDENT_POSTCODE + LEN_STUDENT_ADDRESS);
		String parent_name = data.substring(
				LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER + LEN_STUDENT_POSTCODE + LEN_STUDENT_ADDRESS,
				LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER + LEN_STUDENT_POSTCODE + LEN_STUDENT_ADDRESS
						+ LEN_PARENT_NAME);
		String parent_postcode = data.substring(
				LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER + LEN_STUDENT_POSTCODE + LEN_STUDENT_ADDRESS
						+ LEN_PARENT_NAME,
				LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER + LEN_STUDENT_POSTCODE + LEN_STUDENT_ADDRESS
						+ LEN_PARENT_NAME + LEN_PARENT_POSTCODE);
		String parent_address = data.substring(
				LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER + LEN_STUDENT_POSTCODE + LEN_STUDENT_ADDRESS
						+ LEN_PARENT_NAME + LEN_PARENT_POSTCODE,
				LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER + LEN_STUDENT_POSTCODE + LEN_STUDENT_ADDRESS
						+ LEN_PARENT_NAME + LEN_PARENT_POSTCODE + LEN_PARENT_ADDRESS);

		return new Student(student_number,name,gender,student_postcode,student_address,parent_name,parent_postcode,parent_address);
	}

	public static Student toStudent(String packet){

		String student_number = packet.substring(0, LEN_STUDENT_NUMBER);
		String name = packet.substring(LEN_STUDENT_NUMBER, LEN_STUDENT_NUMBER + LEN_NAME);
		String gender = packet.substring(LEN_STUDENT_NUMBER + LEN_NAME, LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER);
		String student_postcode = packet.substring(LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER,
				LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER + LEN_STUDENT_POSTCODE);
		String student_address = packet.substring(LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER + LEN_STUDENT_POSTCODE,
				LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER + LEN_STUDENT_POSTCODE + LEN_STUDENT_ADDRESS);
		String parent_name = packet.substring(
				LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER + LEN_STUDENT_POSTCODE + LEN_STUDENT_ADDRESS,
				LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER + LEN_STUDENT_POSTCODE + LEN_STUDENT_ADDRESS
						+ LEN_PARENT_NAME);
		String parent_postcode = packet.substring(
				LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER + LEN_STUDENT_POSTCODE + LEN_STUDENT_ADDRESS
						+ LEN_PARENT_NAME,
				LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER + LEN_STUDENT_POSTCODE + LEN_STUDENT_ADDRESS
						+ LEN_PARENT_NAME + LEN_PARENT_POSTCODE);
		String parent_address = packet.substring(
				LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER + LEN_STUDENT_POSTCODE + LEN_STUDENT_ADDRESS
						+ LEN_PARENT_NAME + LEN_PARENT_POSTCODE,
				LEN_STUDENT_NUMBER + LEN_NAME + LEN_GENDER + LEN_STUDENT_POSTCODE + LEN_STUDENT_ADDRESS
						+ LEN_PARENT_NAME + LEN_PARENT_POSTCODE + LEN_PARENT_ADDRESS);

		return new Student(student_number,name,gender,student_postcode,student_address,parent_name,parent_postcode,parent_address);
	}

	public void clear(){
		student = new Student();
    }
    
    public int getLength() // 직렬화 했을때의 바이트 스트림 크기를 반환, 실패시 -1 리턴
    {
        Student test = this;
        int result = -1;
        try
        {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try
            {
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(test);
                result = baos.toByteArray().length;
            }
            catch(Exception e) { }
        }
        catch(Exception e) { }

        return result;
    }
}
