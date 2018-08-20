import java.io.File;

public class PrintDirectoryAppl {

	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("usage: directory path");
			return;
		}
		File dir = new File(args[0]);
		if(!dir.exists()) {
			System.out.println(args[0]+" does't exist!");
			return;
		}
		if(dir.isFile()) {
			System.out.println(args[0]);
			return;
		}
		printDir(dir);
		// use "listFile" -> array of objects
	}

	private static void printDir(File dir) {
		//TODO with spaces, using recursion
		File content[] = dir.listFiles();
		for(int i = 0; i < content.length; i++) {
			System.out.println(content[i]);
		}
	}

}
