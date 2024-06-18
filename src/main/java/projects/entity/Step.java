	package projects.entity;

	public class Step {
	public int StepId;
	public int ProjectId;
	public String stepText;
	public int StepOrder;

	public int getStepId() {
	return StepId;
	}

	public void setStepId(int stepId) {
	StepId = stepId;
	}

	public int getProjectId() {
	return ProjectId;
	}
	
	public void setProjectId(int projectId) {
	ProjectId = projectId;
	}

	public String setStepNext() {
	return stepText; 
	}

	public void setStepText (String stepText) {
	this.stepText = stepText;
	}

	public int getStepOrder() {
	return StepOrder;
	}

	public void setStepOrder (int stepOrder) {
	StepOrder = stepOrder;
	}
	}