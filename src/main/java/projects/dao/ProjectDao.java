package projects.dao;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import projects.entity.Material;
import projects.entity.Project;
import projects.entity.Step;
import projects.exception.dbexception;
import provided.util.DaoBase;

@SuppressWarnings ("unused")
public class ProjectDao extends DaoBase {
	private static final String CATEGORY_TABLE = "category";
	private static final String MATERIAL_TABLE = "material";
	private static final String PROJECT_TABLE = "project";
	private static final String PROJECT_CATEGORY_TABLE = "project_category";
	private static final String STEP_TABLE = "step";

	public Project insertProject(Project project) {
			String sql = " "
			+ "INSERT INTO " + PROJECT_TABLE + " "
			+ "(project_name, estimated_hours, actual_hours, difficulty,notes)"
			+ "VALUES"
			+ "(?,?,?,?,?)";
			
			try (Connection conn = dbconnection.getconnection ()){
					startTransaction (conn);
					
					try (PreparedStatement stmt = conn.prepareStatement (sql)) {
							setParameter (stmt, 1, project.getProjectName (), String.class);
							setParameter (stmt, 2, project.getEstimatedHours (), BigDecimal.class);
							setParameter (stmt, 3, project.getActualHours (), BigDecimal.class);
							setParameter (stmt, 4, project.getDifficulty (), Integer.class);
							setParameter (stmt, 5, project.getNotes (), String.class);
							
							stmt.executeUpdate ();
							
							Integer projectId = getLastInsertId (conn, PROJECT_TABLE);
							commitTransaction(conn);
							
							project.setProjectId(projectId);
							return project;
						} catch (Exception e){
								rollBackTransaction (conn);
								throw new dbexception (e);
						} 
					
					} catch (SQLException e) {
					 throw new dbexception (e);
			}
	}
	//Week 10   //WEEK 10 MODIFICATION TO PROJECT DAO
	public List<Project> fetchAllProjects() {	
		String sql = "SELECT * FROM " + PROJECT_TABLE;
		
		try (Connection conn = dbconnection.getconnection()){
		 startTransaction(conn);
	 
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			try (ResultSet rs = stmt.executeQuery()){
				List<Project> projects = new LinkedList<>();
				
				
				while(rs.next()){
					projects.add(extract(rs));
				}
				
				return projects;
			
			}
		} catch (Exception e){
			rollBackTransaction(conn);
			throw new dbexception(e);
			
		}
		
	}catch (SQLException e) {
		throw new dbexception(e);
		}
	}
	public Optional <Project> fetchProjectById(Integer projectId){
		String sql = "SELECT * FROM " + PROJECT_TABLE + " WHERE project_id = " + projectId;
		 
		try (Connection conn = dbconnection.getconnection()){
			startTransaction(conn);
			
			try { 
				Project project = null;
				
			
			    try (PreparedStatement stmt = conn.prepareStatement(sql)){
				      try (ResultSet rs = stmt.executeQuery()){
					       if (rs.next ()) {
						        project = extract(rs);
					  }
					      
				  }
			 }				  
			    commitTransaction (conn);
			    return Optional.ofNullable(project);
			} catch (Exception e) {
				 rollBackTransaction(conn);
				 throw new dbexception (e);
			}
	} catch (SQLException e) { 
			throw new dbexception (e);
		}
	}
	
    //Week 10
	public List <Material> fetchMaterialsForProjects(Connection conn, Integer projectId){
		String sql = "SELECT * FROM" + MATERIAL_TABLE + "WHERE project_id" + projectId;
		
		try (conn){
			startTransaction(conn);
			
			try (PreparedStatement stmt = conn.prepareStatement(sql)){
				try (ResultSet rs = stmt.executeQuery()){
					List <Material> materials = new LinkedList<>();
					
					while (rs.next()) {
						materials.add(extractMaterial(rs));
					}
					
					return materials;
					
				}
			}catch (Exception e) {
				rollBackTransaction (conn);
				throw new dbexception (e);
			}
			
		}catch (SQLException e) {
			throw new dbexception (e);
		}
	}

	public List<Step> fetchStepsForProject(Connection conn, Integer projectId){
		String sql = "SELECT * FROM" + STEP_TABLE + " WHERE project_id = " + projectId;
		
		try (conn){
			startTransaction(conn);
			
			try (PreparedStatement stmt = conn.prepareStatement (sql)){
				try (ResultSet rs = stmt.executeQuery ()){
					List<Step> steps = new LinkedList<>();
				
					while (rs.next()) {
						steps.add(extractStep(rs));
					}
					
					return steps;
				}
			} catch (Exception e){
				rollBackTransaction (conn);
				throw new dbexception(e);
			}
		}catch (SQLException e) {
			throw new dbexception(e);
			
		}
		}
	
	public Step extractStep(ResultSet rs){
		Step step = new Step();
	
		
		try {
			step.setStepId(rs.getInt("step_id"));
			step.setProjectId(rs.getInt("project_id"));
			step.setStepText(rs.getString("step_text"));
			step.setStepOrder(rs.getInt("step_order"));
			
		} catch (SQLException e) {
		   	 throw new RuntimeException(e);
		}
		
		return step;
	}
		
  public Material extractMaterial(ResultSet rs) {
	   Material material = new Material();
	
	
		try {
			material.setMaterialId(rs.getInt("material_id"));
			material.setProjectId(rs.getInt("project_id"));
			material.setMaterialName(rs.getString("material_name"));
			material.setNumRequired(rs.getInt("num_required"));
			material.setCost(rs.getBigDecimal("cost"));
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return material;
	}
	
	public Project extract (ResultSet rs){
		Project project = new Project ();	
		
		try {
			project.setProjectName(rs.getString("project_name"));
			project.setProjectId(rs.getInt("project_id"));
			project.setEstimatedHours(rs.getBigDecimal("estimated_hours"));
			project.setActualHours(rs.getBigDecimal("actual_hours"));
			project.setDifficulty(rs.getInt("difficulty"));
			project.setNotes(rs.getString("notes"));
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return project;
	}	
}
	