package za.ac.cput.calender.group8.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Utilities {

	private Utilities() {
	}


	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T copyOf(T obj) {
		try {
			// Serializing
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			ObjectOutputStream objOut = new ObjectOutputStream(byteArrayOut);
			objOut.writeObject(obj);
			objOut.close();

			// Deserializing
			ByteArrayInputStream byteArrayIn = new ByteArrayInputStream(
					byteArrayOut.toByteArray());
			ObjectInputStream objIn = new ObjectInputStream(byteArrayIn);
			T deepCopy = (T) objIn.readObject();
			objIn.close();
			return deepCopy;
		} catch (Exception e) {
			// This shouldn't happen since T is Serializable
			return null;
		}
	}


	public static void serializeObject(Object object, String fileSpecification)
			throws Exception {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(
					new FileOutputStream(fileSpecification));
			out.writeObject(object);
		} catch (Exception e) {
			throw new Exception("Error serializing object\n" + e.getMessage());
		} finally {
			if (out != null)
				out.close();
		}
	}

	public static Object deserializeObject(String fileSpecification)
			throws Exception {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(fileSpecification));

			Object obj = in.readObject();

			return obj;
		} catch (Exception e) {
			throw new Exception("Error deserializing object\n" + e.getMessage());
		} finally {
			if (in != null)
				in.close();
		}
	}

}
