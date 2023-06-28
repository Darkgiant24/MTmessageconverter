package com.translator.messagemt;

import com.github.javafaker.Faker;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103;
import com.prowidesoftware.swift.utils.Lib;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Calendar;

@SpringBootApplication
public class MessagemtApplication {

	/**
	 * This example creates a new MT103 using MT and Field helper classes.
	 */
	public static void main(String[] args) throws IOException {
		/*
		 * Read and parse the file content from resources into a SWIFT message object
		 * Parse from File could also be used here
		 */
		MT103 mt = MT103.parse(Lib.readResource("mt103.txt", null));

		/*
		 * Print current message content
		 */
		System.out.println("before\n:" + mt.message());

		/*
		 * Notice the MT103 and its getFieldNN API are a facade
		 * intended for parse/read, not for modification.
		 *
		 * To change values, the underlying SwiftMessage object
		 * and its Tag objects must be use
		 */
		SwiftBlock4 b4 = mt.getSwiftMessage().getBlock4();

		/*
		 * Change the reference field by setting its complete value
		 */
		b4.getTagByName("20").setValue("NEWREFERENCE");

		/*
		 * Change field 57 with new content from new field
		 */
		Field57A field57A = new Field57A();
		field57A.setAccount("12345");
		field57A.setBIC("NEWAESMMXXX");
		b4.getTagByName("57A").setValue(field57A.getValue());

		/*
		 * Update just the value date component in field 32A
		 * First we get current field and just change the date, notice the read
		 * Field instance is a detached object, changing it does not modify
		 * the actual message.
		 * Then use the detached modified field to update the current Tag
		 * value in the underlying message
		 */
		Field32A field32A = mt.getField32A().setComponent1(Calendar.getInstance());
		b4.getTagByName("32A").setValue(field32A.getValue());

		System.out.println("after\n:" + mt.message());
	}
}
