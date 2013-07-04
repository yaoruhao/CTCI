import java.util.HashMap;
import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 * Question 8.9
 *
 */
public class Q9 {
	private HashMap<String, Object> currentDirectory;
	private HashMap<String, Object> fileSystem;
	
	public Q9() {
		fileSystem = new HashMap<String, Object>();
		currentDirectory = fileSystem;
	}
	public boolean changeDirectory(String path) {
		HashMap<String, Object> fromDirectory = currentDirectory;
		if (path.startsWith("/")) {
			fromDirectory = fileSystem;
		}
		String [] paths = path.split("/");
		for (String directoryName : paths) {
			if (!fromDirectory.containsKey(directoryName)) {
				System.err.println("Directory path: "+ path +" not exists.");
				return false;
			}
			if (!(fromDirectory.get(directoryName) instanceof HashMap<?,?>)) {
				System.err.println("Path: "+ path + " is not a directory.");
				return false;
			}
			fromDirectory = (HashMap<String, Object>) fromDirectory.get(directoryName);
		}		
		return true;
	}
	public boolean isFileExist(String path) {
		HashMap<String, Object> fromDirectory = currentDirectory;
		if (path.startsWith("/")) {
			fromDirectory = fileSystem;
		}
		String [] paths = path.split("/");
		for (int i = 0; i < paths.length - 1; i++) {
			if (!fromDirectory.containsKey(paths[i])) {
				System.err.println("Directory path: "+ path +" not exists.");
				return false;
			}
			if (!(fromDirectory.get(paths[i]) instanceof HashMap<?,?>)) {
				System.err.println("Path: "+ path + " is not a directory.");
				return false;
			}
			fromDirectory = (HashMap<String, Object>) fromDirectory.get(paths[i]);
		}
		if (!fromDirectory.containsKey(paths[paths.length - 1])) {
			System.err.println("File not exists, path:" + path);
			return false;
		}
		if (fromDirectory.get(paths[paths.length - 1]) instanceof HashMap<?, ?>) {
			System.err.println("Path : " + path + " is a directory.");
			return false;
		}
		return true;
	}
	public boolean createFile(String path) {
		HashMap<String, Object> fromDirectory = currentDirectory;
		if (path.startsWith("/")) {
			fromDirectory = fileSystem;
		}
		String [] paths = path.split("/");
		for (int i = 0; i < paths.length - 1; i++) {
			if (!fromDirectory.containsKey(paths[i])) {
				System.err.println("Directory path: "+ path +" not exists.");
				return false;
			}
			if (!(fromDirectory.get(paths[i]) instanceof HashMap<?,?>)) {
				System.err.println("Path: "+ path + " is not a directory.");
				return false;
			}
			fromDirectory = (HashMap<String, Object>) fromDirectory.get(paths[i]);
		}
		if (fromDirectory.containsKey(paths[paths.length - 1])) {
			System.err.println("File already exists, path:" + path);
			return false;
		}
		fromDirectory.put(paths[paths.length - 1], new Object());
		return true;
	}
	public boolean removeFile(String path) {
		HashMap<String, Object> fromDirectory = currentDirectory;
		if (path.startsWith("/")) {
			fromDirectory = fileSystem;
		}
		String [] paths = path.split("/");
		for (int i = 0; i < paths.length - 1; i++) {
			if (!fromDirectory.containsKey(paths[i])) {
				System.err.println("Directory path: "+ path +" not exists.");
				return false;
			}
			if (!(fromDirectory.get(paths[i]) instanceof HashMap<?,?>)) {
				System.err.println("Path: "+ path + " is not a directory.");
				return false;
			}
			fromDirectory = (HashMap<String, Object>) fromDirectory.get(paths[i]);
		}
		if (!fromDirectory.containsKey(paths[paths.length - 1])) {
			System.err.println("File not exists, path:" + path);
			return false;
		}
		if (fromDirectory.get(paths[paths.length - 1]) instanceof HashMap<?, ?>) {
			System.err.println("Path : " + path + " is a directory.");
			return false;
		}
		fromDirectory.remove(paths[paths.length - 1]);
		return true;
	}
	public boolean makeDirectory(String path) {
		HashMap<String, Object> fromDirectory = currentDirectory;
		if (path.startsWith("/")) {
			fromDirectory = fileSystem;
		}
		String [] paths = path.split("/");
		for (int i = 0; i < paths.length - 1; i++) {
			if (!fromDirectory.containsKey(paths[i])) {
				System.err.println("Directory path: "+ path +" not exists.");
				return false;
			}
			if (!(fromDirectory.get(paths[i]) instanceof HashMap<?,?>)) {
				System.err.println("Path: "+ path + " is not a directory.");
				return false;
			}
			fromDirectory = (HashMap<String, Object>) fromDirectory.get(paths[i]);
		}
		if (fromDirectory.containsKey(paths[paths.length - 1])) {
			System.err.println("Directory already exists, path:" + path);
			return false;
		}
		fromDirectory.put(paths[paths.length - 1], new HashMap<String, Object>());
		return true;
	}
	public boolean listDirectory(String path) {
		HashMap<String, Object> fromDirectory = currentDirectory;
		if (path.startsWith("/")) {
			fromDirectory = fileSystem;
		}
		String [] paths = path.split("/");
		for (int i = 0; i < paths.length; i++) {
			if (!fromDirectory.containsKey(paths[i])) {
				System.err.println("Directory path: "+ path +" not exists.");
				return false;
			}
			if (!(fromDirectory.get(paths[i]) instanceof HashMap<?,?>)) {
				System.err.println("Path: "+ path + " is not a directory.");
				return false;
			}
			fromDirectory = (HashMap<String, Object>) fromDirectory.get(paths[i]);
		}
		for (String key: fromDirectory.keySet()) {
			System.out.println(path + "/" + key);
		}
		return true;
	}

}
