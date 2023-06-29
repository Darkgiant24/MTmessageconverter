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

		Faker faker = new Faker();

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

		b4.getTagByName("20").setValue(faker.regexify("[A-Z0-9]{1,16}") + "/////");


		if (b4.getTagByName("50F") != null) {
			Field50A field50A = new Field50A();
			field50A.setAccount(faker.regexify("[A-Z0-9]{1,34}"));
			field50A.setIdentifierCode(faker.finance().bic());
			b4.getTagByName("50A").setValue(field50A.getValue() + "/////");
		}

		if (b4.getTagByName("50F") != null) {
			Field50F field50F = new Field50F();
			field50F.setPartyIdentifier(faker.regexify("[A-Z0-9]{1,34}"));
			int number50F = Integer.parseInt(faker.regexify("[1-4]"));
			if (number50F > 0) {
				field50F.setNumber1(faker.numerify("##"));
				if (number50F > 1) {
					field50F.setNameAndAddress1(faker.address().firstName());
					if (number50F > 2) {
						field50F.setNameAndAddress2(faker.address().cityName());
						if (number50F > 3) {
							field50F.setNameAndAddress3(faker.address().country());
						}
					}

				}
			}
			b4.getTagByName("50F").setValue(field50F.getValue() + "/////");
		}

		if (b4.getTagByName("50K") != null) {
			Field50K field50K = new Field50K();
			field50K.setAccount(faker.regexify("[A-Z0-9]{1,34}"));
			int number50K = Integer.parseInt(faker.regexify("[1-4]"));
			if (number50K > 0) {
				field50K.setNameAndAddressLine1(faker.address().firstName());
				if (number50K > 1) {
					field50K.setNameAndAddressLine2(faker.address().cityName());
					if (number50K > 2) {
						field50K.setNameAndAddressLine3(faker.address().country());
						if (number50K > 3) {
							field50K.setNameAndAddressLine4(faker.address().country() + "/////");
						}
					}
				}
			}
			b4.getTagByName("50K").setValue(field50K.getValue() + "/////");
		}


		if (b4.getTagByName("51A") != null) {
			Field51A field51A = new Field51A();
			field51A.setPartyIdentifier(faker.regexify("[A-Z0-9]{1,34}"));
			field51A.setIdentifierCode(faker.finance().bic());
			b4.getTagByName("51A").setValue(field51A.getValue() + "/////");
		}


		if (b4.getTagByName("52A") != null) {
			Field52A field52A = new Field52A();
			field52A.setAccount(faker.regexify("[A-Z0-9]{1,34}"));
			field52A.setIdentifierCode(faker.finance().bic());
			b4.getTagByName("52A").setValue(field52A.getValue() + "/////");
		}

		if (b4.getTagByName("52D") != null) {
			Field52D field52D = new Field52D();
			field52D.setPartyIdentifier(faker.regexify("[A-Z0-9]{1,34}"));
			int number52D = Integer.parseInt(faker.regexify("[1-4]"));
			if (number52D > 0) {
				field52D.setNameAndAddressLine1(faker.address().firstName());
				if (number52D > 1) {
					field52D.setNameAndAddressLine2(faker.address().cityName());
					if (number52D > 2) {
						field52D.setNameAndAddressLine3(faker.address().country());
						if (number52D > 3) {
							field52D.setNameAndAddressLine4(faker.address().country());
						}
					}
				}
			}
			b4.getTagByName("52D").setValue(field52D.getValue() + "/////");
		}

		if (b4.getTagByName("53A") != null) {
			Field53A field53A = new Field53A();
			field53A.setPartyIdentifier(faker.regexify("[A-Z0-9]{1,34}"));
			field53A.setIdentifierCode(faker.finance().bic());
			b4.getTagByName("53A").setValue(field53A.getValue() + "/////");
		}

		if (b4.getTagByName("53B") != null) {
			Field53B field53B = new Field53B();
			field53B.setPartyIdentifier(faker.regexify("[A-Z0-9]{1,34}"));
			field53B.setLocation(faker.regexify("[A-Z0-9]{1,35}"));
			b4.getTagByName("53B").setValue(field53B.getValue() + "/////");
		}

		if (b4.getTagByName("53D") != null) {
			Field53D field53D = new Field53D();
			field53D.setPartyIdentifier(faker.regexify("[A-Z0-9]{1,34}"));
			int number53D = Integer.parseInt(faker.regexify("[1-4]"));
			if (number53D > 0) {
				field53D.setNameAndAddressLine1(faker.address().firstName());
				if (number53D > 1) {
					field53D.setNameAndAddressLine2(faker.address().cityName());
					if (number53D > 2) {
						field53D.setNameAndAddressLine3(faker.address().country());
						if (number53D > 3) {
							field53D.setNameAndAddressLine4(faker.address().country());
						}
					}
				}
			}
			b4.getTagByName("53D").setValue(field53D.getValue() + "/////");
		}

		if (b4.getTagByName("54A") != null) {
			Field54A field54A = new Field54A();
			field54A.setPartyIdentifier(faker.regexify("[A-Z0-9]{1,34}"));
			field54A.setIdentifierCode(faker.finance().bic());
			b4.getTagByName("54A").setValue(field54A.getValue() + "/////");
		}

		if (b4.getTagByName("54B") != null) {
			Field54B field54B = new Field54B();
			field54B.setPartyIdentifier(faker.regexify("[A-Z0-9]{1,34}"));
			field54B.setLocation(faker.regexify("[A-Z0-9]{1,35}"));
			b4.getTagByName("54B").setValue(field54B.getValue() + "/////");
		}

		if (b4.getTagByName("54D") != null) {
			Field54D field54D = new Field54D();
			field54D.setPartyIdentifier(faker.regexify("[A-Z0-9]{1,34}"));
			int number54D = Integer.parseInt(faker.regexify("[1-4]"));
			if (number54D > 0) {
				field54D.setNameAndAddressLine1(faker.address().firstName());
				if (number54D > 1) {
					field54D.setNameAndAddressLine2(faker.address().cityName());
					if (number54D > 2) {
						field54D.setNameAndAddressLine3(faker.address().country());
						if (number54D > 3) {
							field54D.setNameAndAddressLine4(faker.address().country());
						}
					}
				}
			}
			b4.getTagByName("54D").setValue(field54D.getValue() + "/////");
		}
		/*
		 * Change field 57 with new content from new field
		 */
		if (b4.getTagByName("57A") != null) {
			Field57A field57A = new Field57A();
			field57A.setAccount(faker.regexify("[A-Z0-9]{1,34}"));
			field57A.setIdentifierCode(faker.finance().bic());
			b4.getTagByName("57A").setValue(field57A.getValue() + "/////");
		}

		if (b4.getTagByName("57B") != null) {
			Field57B field57B = new Field57B();
			field57B.setPartyIdentifier(faker.regexify("[A-Z0-9]{1,34}"));
			field57B.setLocation(faker.regexify("[A-Z0-9]{1,35}"));
			b4.getTagByName("57B").setValue(field57B.getValue() + "/////");
		}
//		if(b4.getTagByName("57C")!=null) {
//			Field57C field57C = new Field57C();
//			field57C.setPartyIdentifier(faker.regexify("[A-Z0-9]{1,34}"));
//			b4.getTagByName("57C").setValue(field57C.getValue());
//		}
		if (b4.getTagByName("57D") != null) {
			Field57D field57D = new Field57D();
			field57D.setPartyIdentifier(faker.regexify("[A-Z0-9]{1,34}"));
			int number57D = Integer.parseInt(faker.regexify("[1-4]"));
			if (number57D > 0) {
				field57D.setNameAndAddressLine1(faker.address().firstName());
				if (number57D > 1) {
					field57D.setNameAndAddressLine2(faker.address().cityName());
					if (number57D > 2) {
						field57D.setNameAndAddressLine3(faker.address().country());
						if (number57D > 3) {
							field57D.setNameAndAddressLine4(faker.address().country());
						}
					}
				}
			}
			b4.getTagByName("57D").setValue(field57D.getValue() + "/////");
		}

		if (b4.getTagByName("59") != null) {
			Field59 field59 = new Field59();
			field59.setAccount(faker.regexify("[A-Z0-9]{1,34}"));
			int number59 = Integer.parseInt(faker.regexify("[1-4]"));
			if (number59 > 0) {
				field59.setNameAndAddressLine1(faker.address().firstName());
				if (number59 > 1) {
					field59.setNameAndAddressLine2(faker.address().cityName());
					if (number59 > 2) {
						field59.setNameAndAddressLine3(faker.address().country());
						if (number59 > 3) {
							field59.setNameAndAddressLine4(faker.address().country());
						}
					}
				}
			}
			b4.getTagByName("59").setValue(field59.getValue() + "/////");
		}

		if (b4.getTagByName("59A") != null) {
			Field59A field59A = new Field59A();
			field59A.setAccount(faker.regexify("[A-Z0-9]{1,34}"));
			field59A.setIdentifierCode(faker.finance().bic());
			b4.getTagByName("59A").setValue(field59A.getValue() + "/////");
		}


		if (b4.getTagByName("59F") != null) {
			Field59F field59F = new Field59F();
			field59F.setAccount(faker.regexify("[A-Z0-9]{1,34}"));
			int number59F = Integer.parseInt(faker.regexify("[1-4]"));
			if (number59F > 0) {
				field59F.setNumber1(faker.numerify("##"));
				if (number59F > 1) {
					field59F.setNameAndAddress1(faker.address().firstName());
					if (number59F > 2) {
						field59F.setNameAndAddress2(faker.address().cityName());
						if (number59F > 3) {
							field59F.setNameAndAddress3(faker.address().country());
						}
					}

				}
			}
			b4.getTagByName("59K").setValue(field59F.getValue() + "/////");
		}



				/*
				 * Update just the value date component in field 32A
				 * First we get current field and just change the date, notice the read
				 * Field instance is a detached object, changing it does not modify
				 * the actual message.
				 * Then use the detached modified field to update the current Tag
				 * value in the underlying message
				 */
//		Field32A field32A = mt.getField32A().setComponent1(Calendar.getInstance());
//		b4.getTagByName("32A").setValue(field32A.getValue());

				System.out.println("after\n:" + mt.message());
			}
		}


