package projects;
import projects.dao.dbconnection;
public class ProjectsApp {

	public static void main(String[] args) {
		System.out.print(dbconnection.getconnection());

	}

}
