package GenericLibraries;
/**
 * This interface will contain all the end points
 * @author Monika
 *
 */
public interface EndPointsLibrary {

	String createProject ="/addProject";
	String getAllProjects="/projects";
	String getSingleProject ="/project/";
	String deleteProject="/projects/";
	String updateProject="/projects";
}
