package application.Dialog.ChoiceDialog;

public class Book {
    long number;
    String code;
    String name;

    public Book(long number, String code, String name) {
        this.number = number;
        this.code = code;
        this.name = name;
    }

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @Override
    public String toString() {
        return "Book [code=" + code + ", name=" + name + ", number=" + number + "]";
    }

}
