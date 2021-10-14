package za.ac.cput.calender.group8.util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.IOException;

import java.util.Arrays;
import java.util.List;


public class ListUtilities {


	private ListUtilities() {
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Comparable[] merge(Comparable[] list1, Comparable[] list2,
			String duplicateFileName) throws IOException {

		// If a parameter is null, it sends an IllegalArgumentException.
		if (list1 == null || list2 == null || duplicateFileName == null)
			throw new IllegalArgumentException(
					"The parameters must not be null.");

		int maxLength = list1.length + list2.length;
		Comparable[] mergedList = new Comparable[maxLength];
		String[] duplicateList = new String[maxLength];
		int indexL1 = 0, indexL2 = 0, indexML = 0, indexDL = 0;

		// As long as no list has reached the end.
		while (indexL1 < list1.length && indexL2 < list2.length) {

			// To know which record is greater
			int compared = list1[indexL1].compareTo(list2[indexL2]);
			if (compared < 0) {
				mergedList[indexML] = list1[indexL1];
				indexL1++;

			} else if (compared > 0) {
				mergedList[indexML] = list2[indexL2];
				indexL2++;

			} else {
				mergedList[indexML] = list1[indexL1];
				duplicateList[indexDL] = list1[indexL1].toString()
						+ " (merged)";
				indexDL++;
				duplicateList[indexDL] = list2[indexL2].toString();
				indexDL++;
				indexL1++;
				indexL2++;
			}
			indexML++;
		}// End while

		// If list1 has reached the end
		if (indexL1 == list1.length) {
			// If list2 hasn't reached the end, we add it to mergedList
			if (indexL2 < list2.length) {
				indexML = addList(list2, mergedList, indexL2, indexML);
			}
		}
		// If list1 hasn't reached the end, list2 has, so we add list1 to
		// mergedList.
		else {
			indexML = addList(list1, mergedList, indexL1, indexML);
		}

		if (indexML < mergedList.length)
			mergedList = Arrays.copyOf(mergedList, indexML);

		if (indexDL < duplicateList.length)
			duplicateList = Arrays.copyOf(duplicateList, indexDL);

		save(duplicateList, duplicateFileName, true);

		return mergedList;
	}



	public static void save(Object[] list, String filename, boolean append)
			throws IOException {
		PrintWriter outputFile = null;
		try {
			FileOutputStream f = new FileOutputStream(filename, append);
			OutputStreamWriter out = new OutputStreamWriter(f,
					System.getProperty("file.encoding"));
			outputFile = new PrintWriter(new BufferedWriter(out));

			for (Object obj : list)
				if (obj != null)
					outputFile.println(obj);
		} catch (FileNotFoundException e) {
			throw new IOException(
					"Error saving list! Unable to access the device "
							+ filename);
		}

		catch (SecurityException se) {
			throw new SecurityException(
					"The file does not have writtable permissions.");
		} finally {
			if (outputFile != null)
				outputFile.close();
		}
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void sort(Comparable[] list) {

		int size;

		if (list == null)
			throw new IllegalArgumentException(
					"The parameter should not be null.");

		size = list.length;
		// If the list does not contain at least one entry, it will throw an
		// ArrayIndexOutOfBoundsException
		if (size > 0)
			while (list[size - 1] == null)
				size--;
		int minIndex;
		Comparable minObject;

		int outerLoopSize = size - 1;

		for (int pass = 0; pass < outerLoopSize; pass++) {
			minIndex = pass;

			for (int index = pass + 1; index < size; index++) {
				// If one of the entries is null, it will throw a
				// NullPointerException
				if (list[index].compareTo(list[minIndex]) < 0)
					minIndex = index;
			}// end of inner loop

			// swap positions
			minObject = list[minIndex];
			list[minIndex] = list[pass];
			list[pass] = minObject;
		}// end of outer loop
	}

	public static void saveListToTextFile(Object[] objects, String filename)
			throws FileNotFoundException, UnsupportedEncodingException {

		saveListToTextFile(objects, filename, false,
				System.getProperty("file.encoding"));

	}

	public static void saveListToTextFile(Object[] objects, String filename,
			boolean append) throws FileNotFoundException,
			UnsupportedEncodingException {

		saveListToTextFile(objects, filename, append,
				System.getProperty("file.encoding"));
	}

	public static void saveListToTextFile(Object[] objects, String filename,
			boolean append, String encoding) throws FileNotFoundException,
			UnsupportedEncodingException {

		PrintWriter outputFile = null;
		try {
			FileOutputStream f = new FileOutputStream(filename, append);
			OutputStreamWriter out = new OutputStreamWriter(f, encoding);
			outputFile = new PrintWriter(new BufferedWriter(out));

			for (Object obj : objects)
				if (obj != null)
					outputFile.println(obj);

		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(
					"Error saving list! Unable to access the device "
							+ filename);

		} finally {
			if (outputFile != null)
				outputFile.close();
		}
	}

	public static <T extends Object> void saveListToTextFile(List<T> objects,
			String filename) throws FileNotFoundException,
			UnsupportedEncodingException {
		saveListToTextFile(objects, filename, false,
				System.getProperty("file.encoding"));
	}


	public static <T extends Object> void saveListToTextFile(List<T> objects,
			String filename, boolean append) throws FileNotFoundException,
			UnsupportedEncodingException {
		saveListToTextFile(objects, filename, append,
				System.getProperty("file.encoding"));
	}


	public static <T extends Object> void saveListToTextFile(List<T> objects,
			String filename, boolean append, String encoding)
			throws FileNotFoundException, UnsupportedEncodingException {

		PrintWriter outputFile = null;
		try {
			FileOutputStream f = new FileOutputStream(filename, append);
			OutputStreamWriter out = new OutputStreamWriter(f, encoding);
			outputFile = new PrintWriter(new BufferedWriter(out));

			for (Object obj : objects)
				if (obj != null)
					outputFile.println(obj);

		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(
					"Error saving list! Unable to access the device "
							+ filename);

		} finally {
			if (outputFile != null)
				outputFile.close();
		}
	}


	@SuppressWarnings({ "rawtypes" })
	private static int addList(Comparable[] list1, Comparable[] list2,
			int indexL1, int indexL2) {
		while (indexL1 < list1.length) {
			list2[indexL2] = list1[indexL1];
			indexL1++;
			indexL2++;
		}

		return indexL2;
	}

	public static <T extends Comparable<? super T>> int binarySearch(
			List<T> list, T key) {

		int low = 0, high = list.size() - 1;
		int mid, result;

		while (high >= low) {
			mid = (high + low) / 2;
			result = list.get(mid).compareTo(key);
			if (result > 0) {
				high = mid - 1;
			} else if (result == 0) {
				return mid;
			} else
				low = mid + 1;
		}

		return -(low + 1);
	}
}
