package projects.entity;
import java.math.BigDecimal;

public class Material {
       public int MaterialId;
       public int ProjectId; 
       public String MaterialName;
       public int NumRequired;
       public BigDecimal Cost; 

public int getMaterialId( ) {
return MaterialId;
}

public void setMaterialId (int materialId) {
MaterialId = materialId;
}


public int getProjectId() {
return ProjectId;
}

public void setProjectId (int projectId) {
ProjectId = projectId;
}

public String getMaterialName () {
return MaterialName;
}

public void setMaterialName (String materialName) {
MaterialName= materialName;
}

public int getNumRequired() {
return NumRequired;
}

public void setNumRequired(int numRequired) {
NumRequired = numRequired;
}
public BigDecimal getCost () {
return Cost;
}

public void setCost (BigDecimal cost) {
Cost = cost;

}
}
