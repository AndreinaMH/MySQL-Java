package projects.entity;
import java.math.BigDecimal;


public class Project {
	public BigDecimal ActualHours;
	public int Difficulty;
	public String Notes;
	public int ProjectId;
	public String ProjectName;
	public BigDecimal EstimatedHours;
	
	
	public void setProjectId (int projectId) {
		this.ProjectId= projectId;
	}
	
	public int getProjectId (){
		return ProjectId;
	}
	
	public void setNotes (String notes) {
		this.Notes = notes;
	}
	
	public void setDifficulty(int difficulty) {
		this.Difficulty = difficulty;
	}
	
	public void setActualHours (BigDecimal actualHours) {
		this.ActualHours = actualHours;
	}
	
	public void setEstimatedHours (BigDecimal EstimatedHours) {
		this.EstimatedHours = EstimatedHours;
	}
	
	public void setProjectName (String projectName) {
		this.ProjectName = projectName;
	}
	
	public String getProjectName (){
		return this.ProjectName;
	}
	
	public BigDecimal getEstimatedHours (){
		return this.EstimatedHours;
	}
	public BigDecimal getActualHours () {
		return this.ActualHours;
	}
	public String getNotes () {
		return this.Notes;
	}
	public int getDifficulty () {
		return this.Difficulty;
	}
	}


