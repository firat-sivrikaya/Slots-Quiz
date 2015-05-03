
public class Question extends SlotsDatabase {
	
	String answer;
	String location;
	int id;
	
	public Question()
	{
		answer = "";
		location = "";
		id = 0;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getId() {
		return id;
	}
	
	public void setId( int id ) {
		this.id = id;
	}
	
	public String toString()
	{
		return "ID: " + id + "\nLocation: " + location + "\nAnswer: " + answer;
	}

}
