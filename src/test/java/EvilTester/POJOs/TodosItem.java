package EvilTester.POJOs;

public class TodosItem{
	private boolean doneStatus;
	private String description;
	private int id;
	private String title;

	public void setDoneStatus(boolean doneStatus){
		this.doneStatus = doneStatus;
	}

	public boolean isDoneStatus(){
		return doneStatus;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"TodosItem{" + 
			"doneStatus = '" + doneStatus + '\'' + 
			",description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}
