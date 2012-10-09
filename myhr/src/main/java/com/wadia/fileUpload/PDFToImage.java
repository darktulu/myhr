package com.wadia.fileUpload;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import javax.imageio.ImageIO;

import org.apache.pdfbox.exceptions.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFImageWriter;

public class PDFToImage implements Serializable {


	public void convert(String pdfFile , String outputPrefix) throws Exception {
		
		String password = "";
		String imageFormat = "jpg";
		int startPage = 1;
		int endPage = Integer.MAX_VALUE;
		String color = "rgb";
		int resolution;
		try {
			resolution = Toolkit.getDefaultToolkit().getScreenResolution();
		} catch (HeadlessException e) {
			resolution = 96;
		}
		
	
		
		if (pdfFile == null) {
			usage();
		} else {
			

			PDDocument document = null;
			try {
				document = PDDocument.load(pdfFile);
				// document.print();

				if (document.isEncrypted()) {
					try {
						document.decrypt(password);
					} catch (InvalidPasswordException e) {
						
							// they didn't supply a password and the default of
							// "" was wrong.
							System.err.println("Error: The document is encrypted.");
							usage();
						}
					}
				
				int imageType = 24;
				if ("bilevel".equalsIgnoreCase(color)) {
					imageType = BufferedImage.TYPE_BYTE_BINARY;
				} else if ("indexed".equalsIgnoreCase(color)) {
					imageType = BufferedImage.TYPE_BYTE_INDEXED;
				} else if ("gray".equalsIgnoreCase(color)) {
					imageType = BufferedImage.TYPE_BYTE_GRAY;
				} else if ("rgb".equalsIgnoreCase(color)) {
					imageType = BufferedImage.TYPE_INT_RGB;
				} else if ("rgba".equalsIgnoreCase(color)) {
					imageType = BufferedImage.TYPE_INT_ARGB;
				} else {
					System.err.println("Error: the number of bits per pixel must be 1, 8 or 24.");
					System.exit(2);
				}

				// Make the call
				PDFImageWriter imageWriter = new PDFImageWriter();
				boolean success = imageWriter.writeImage(document, imageFormat,
						password, startPage, endPage, outputPrefix, imageType,
						resolution);
				
				if (!success) {
					System.err.println("Error: no writer found for image format '"
									+ imageFormat + "'");
					System.exit(1);
				}
			} catch (Exception e) {
				System.err.println(e);
			} finally {
				if (document != null) {
					document.close();
				}
			}
		}
	}

	/**
	 * This will print the usage requirements and exit.
	 */
	private void usage() {
		System.out
				.println("Usage: java org.apache.pdfbox.PDFToImage [OPTIONS] <PDF file>\n"
						+ "  -password  <password>          Password to decrypt document\n"
						+ "  -imageType <image type>        ("
						+ getImageFormats()
						+ ")\n"
						+ "  -outputPrefix <output prefix>  Filename prefix for image files\n"
						+ "  -startPage <number>            The first page to start extraction(1 based)\n"
						+ "  -endPage <number>              The last page to extract(inclusive)\n"
						+ "  -color <string>                The color depth (valid: bilevel, indexed, gray, rgb, rgba)\n"
						+ "  -resolution <number>           The bitmap resolution in dpi\n"
						+ "  <PDF file>                     The PDF document to use\n");
	}

	private String getImageFormats() {
		StringBuffer retval = new StringBuffer();
		String[] formats = ImageIO.getReaderFormatNames();
		for (int i = 0; i < formats.length; i++) {
			retval.append(formats[i]);
			if (i + 1 < formats.length) {
				retval.append(",");
			}
		}
		return retval.toString();
	}
}

