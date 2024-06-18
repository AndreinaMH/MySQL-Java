package projects.entity;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import projects.entity.Step;
import projects.entity.Material;

//WEEK 10. IN WEEK 10 New imports were made in week 10. We imported lines 6 and 7 today. 
public class Project {
	
	public String ProjectName;
	public int ProjectId;
	public BigDecimal EstimatedHours;
	public BigDecimal ActualHours;
	public int Difficulty;
	public String Notes;
	
//.WEEK 10. We added these new lists.
		public List<Material> materials = new LinkedList<>();
		public List<Step> steps = new LinkedList<>();	

//Week10
		public List<Step> getSteps() {
			return steps;
		}
		
		public void setSteps (List<Step> steps) {
				this.steps = steps;
		}
//Week 10
		public List<Material> getMaterials() {
			return materials;
			}
	
		public void setMaterials(List<Material> materials) {
			this.materials = materials;
		}
		
		public void setProjectId (int projectId) {
			this.ProjectId= projectId;
		}
	
		public int getProjectId () {
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
