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
	}

	private static void printDir(File dir) {
		File content[] = dir.listFiles();
		System.out.println(dir.toString()+"\n");
		printTree(content, 0, 0);
	}

	private static void printTree(File content[], int i, int space_count) {
		if(i == content.length) return;
		String space = "";
		for(int s = 0; s < space_count; s++) {
			space += "    ";
		}
		System.out.println(space + content[i].getName());
		if(content[i].isDirectory()) {
			printTree(content[i].listFiles(), 0, space_count + 1);
		}
		i++;
		printTree(content, i, space_count);
		
		
//		if(content[i].isDirectory()) {
//			System.out.println(content[i].getName());
//			printTree(content[i].listFiles(), 0);
//		} else {
//			System.out.println(content[i].getName());
//			i++;
//			printTree(content, i);
//		}
	}
}
