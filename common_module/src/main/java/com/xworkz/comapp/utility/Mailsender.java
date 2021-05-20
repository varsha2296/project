package com.xworkz.comapp.utility;

import org.apache.log4j.Logger;

public class Mailsender {

	static Logger logger;

	static {
		logger = Logger.getLogger(Mailsender.class);
	}

	public static void main(String[] args) {
		demo();
	}

	public static void demo() {
		logger.trace("trace");
		logger.debug("debug");
		logger.info("information");
		logger.warn("warning");
		logger.fatal("fatal");
		logger.error("error");
	}
}
