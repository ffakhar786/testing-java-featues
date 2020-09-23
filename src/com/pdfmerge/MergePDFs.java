package com.pdfmerge;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import java.io.File;
import java.io.IOException;

public class MergePDFs {
	public static void main(String[] args) throws IOException {
		// Instantiating PDFMergerUtility class
		PDFMergerUtility PDFmerger = new PDFMergerUtility();
		File file1 = new File("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\CheckDetailfor_1912.pdf");
		// adding the source files
		PDFmerger.addSource(file1);
		file1 = new File("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\CheckDetailfor_1911.pdf");
		PDFmerger.addSource(file1);
		file1 = new File("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\CheckDetailfor_1910.pdf");
		PDFmerger.addSource(file1);
		file1 = new File("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\CheckDetailfor_1909.pdf");
		PDFmerger.addSource(file1);		
		file1 = new File("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\CheckDetailfor_1908.pdf");
		PDFmerger.addSource(file1);
		file1 = new File("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\CheckDetailfor_1907.pdf");
		PDFmerger.addSource(file1);
		file1 = new File("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\CheckDetailfor_1906.pdf");
		PDFmerger.addSource(file1);
		file1 = new File("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\CheckDetailfor_1905.pdf");
		PDFmerger.addSource(file1);
		file1 = new File("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\CheckDetailfor_1904.pdf");
		PDFmerger.addSource(file1);
		file1 = new File("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\CheckDetailfor_1903.pdf");
		PDFmerger.addSource(file1);
		file1 = new File("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\CheckDetailfor_1902.pdf");
		PDFmerger.addSource(file1);
		file1 = new File("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\CheckDetailfor_1901.pdf");
		PDFmerger.addSource(file1);

		// Setting the destination file
		PDFmerger.setDestinationFileName("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\merged_2019.pdf");

		PDFmerger = new PDFMergerUtility();
		file1 = new File("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\CheckDetailfor_2008.pdf");
		// adding the source files
		PDFmerger.addSource(file1);
		file1 = new File("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\CheckDetailfor_2007.pdf");
		PDFmerger.addSource(file1);
		file1 = new File("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\CheckDetailfor_2006.pdf");
		PDFmerger.addSource(file1);
		file1 = new File("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\CheckDetailfor_2005.pdf");
		PDFmerger.addSource(file1);		
		file1 = new File("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\CheckDetailfor_2004.pdf");
		PDFmerger.addSource(file1);
		file1 = new File("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\CheckDetailfor_2003.pdf");
		PDFmerger.addSource(file1);
		file1 = new File("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\CheckDetailfor_2002.pdf");
		PDFmerger.addSource(file1);
		file1 = new File("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\CheckDetailfor_2001.pdf");
		PDFmerger.addSource(file1);

		// Setting the destination file
		PDFmerger.setDestinationFileName("C:\\Users\\fm245e\\Documents\\Macro\\pstubs\\merged_2020.pdf");

		// Merging the two documents
		PDFmerger.mergeDocuments();
		System.out.println("Documents merged");
	}
}