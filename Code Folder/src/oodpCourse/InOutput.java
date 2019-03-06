package oodpCourse;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class InOutput {
	
	public static List readSerializedObject(String filename) {
		List pDetails = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			pDetails = (ArrayList) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		// print out the size
		//System.out.println(" Details Size: " + pDetails.size());
		//System.out.println();
		return pDetails;
	}
	
	public static void writeSerializedObject(String filename, List list) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(list);
			out.close();
		//	System.out.println("Object Persisted");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public List readFile(String fileName) {
		List list = null;
		try	{
				// read from serialized file the list of professors
				list = (ArrayList)InOutput.readSerializedObject(fileName);		

		}  catch ( Exception e ) {
					System.out.println( "Exception >> " + e.getMessage() );
		}
		return list;
	}
	
	public void writeFile(String fileName,List list) {
		try	{
			InOutput.writeSerializedObject(fileName, list);	

		}  catch ( Exception e ) {
				System.out.println( "Exception >> " + e.getMessage() );
		}
	}
	
}
