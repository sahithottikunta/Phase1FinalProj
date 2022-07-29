package Working;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class codePrac {
		static String MY_Dir;
	    File myFolder;

	    public codePrac() 
	    {
	    	MY_Dir = System.getProperty("user.dir");
	    	myFolder = new File("C:\\Users\\SAHITH\\OneDrive\\Desktop\\myrepository");
	        if (!myFolder.exists())
	        	myFolder.mkdirs();
	        System.out.println("MyFilePath : "+ myFolder.getAbsolutePath());
	    }
	   private static final String heading=
	   "-----------------------------Welcome to LockedMe.com------------------------------";
	   private static final String str =
	            "\n Select any one of the following operations based on your requirement: \n"+
	                    "1 - List the types of files in directory\n"+
	                    "2 - Perform functions like Add, Delete or Search\n"+
	                    "3 - Exit";

	    private static final String fun =
	            "   \nSelect any one of the following  operations: \n"+
	                    "   1 - Add a file\n"+
	                    "   2 - Delete a file\n"+
	                    "   3 - Search a file\n"+
	                    "   4 - Go Back to Logic Part";

	    void work() {
	        System.out.println(str);
	        try(Scanner scanner = new Scanner(System.in)){
	            
	        	int choice = scanner.nextInt();
	            switch (choice){
	                case 1 : {
	                	showListOfFiles();
	                    work();
	                }
	                case 2 : {
	                    workInternal();
	                }
	                case 3 : {
	                    System.out.println("Ended");
	                    System.exit(0);
	                }
	                default: work();
	            }
	        }
	        catch (Exception e){
	            System.out.println("Please enter 1, 2 or 3");
	            work();
	        }
	    }

	    void workInternal() {
	        System.out.println(fun);
	        try(Scanner scanner = new Scanner(System.in))
	        {
	            char[] input = scanner.nextLine().toLowerCase().trim().toCharArray();
	            char logic = input[0];

	            switch (logic){
	                case '1' : {
	                    System.out.print("Please Enter a File Name you want to Add : ");
	                    String filename = scanner.next().trim().toLowerCase();
	                    addFileMethod(filename);
	                    break;
	                }
	                case '2' : {
	                    System.out.print("Please Enter a File Name you want to Delete : ");
	                    String filename = scanner.next().trim();
	                    deleteFileMethod(filename);
	                    break;
	                }
	                case '3' : {
	                    System.out.print("Please Enter a File Name you want to Search For : ");
	                    String filename = scanner.next().trim();
	                    searchFileMethod(filename);
	                    break;
	                }
	                case '4' : {
	                    System.out.println("Go back");
	                    work();
	                    break;
	                }
	                default : System.out.println("Please enter correct values");
	            }
	            workInternal();
	        }
	        catch (Exception e){
	            System.out.println("Please enter correct values");
	            workInternal();
	        }
	    }
	    void showListOfFiles() {
	        if (myFolder.list().length==0)
	            System.out.println("The folder is empty");
	        else {
	            String[] list = myFolder.list();
	            System.out.println("The files in "+ myFolder +" are :");
	            Arrays.sort(list);
	            for (String str:list) {
	                System.out.println(str);
	            }
	        }
	    }
	    void addFileMethod(String filename) throws IOException {
	        File filepath = new File(myFolder +"/"+filename);
	        String[] list = myFolder.list();
	        for (String file: list) {
	            if (filename.equalsIgnoreCase(file)) {
	                System.out.println("File " + filename + " already exists at " + myFolder);
	                return;
	            }
	        }
	        filepath.createNewFile();
	        System.out.println("File "+filename+" added to "+ myFolder);
	    }
	    void deleteFileMethod(String filename) {
	        File filepath = new File(myFolder +"/"+filename);
	        String[] list = myFolder.list();
	        for (String file: list) {
	            if (filename.equals(file) && filepath.delete()) {
	                System.out.println("File " + filename + " deleted from " + myFolder);
	                return;
	            }
	        }
	        System.out.println("Delete Operation failed. FILE NOT FOUND");
	    }
	    void searchFileMethod(String filename) {
	        String[] list = myFolder.list();
	        for (String file: list) {
	            if (filename.equals(file)) {
	                System.out.println("FOUND : File " + filename + " exists at " + myFolder);
	                return;
	            }
	        }
	        System.out.println("File Not found");
	    }
	    public static void main(String[] args) {
	        System.out.println(heading); 
	        codePrac req = new codePrac();
	        req.work();
	    }

		
	}


