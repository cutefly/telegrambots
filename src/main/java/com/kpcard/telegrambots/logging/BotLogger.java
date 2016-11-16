package com.kpcard.telegrambots.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Ruben Bermudez
 * @version 2.0
 * @brief Logger to file
 * @date 21/01/15
 */
public class BotLogger {
	private static final Logger logger = LoggerFactory.getLogger(BotLogger.class);

	public static void error(String tag, String msg) {
        logger.error(String.format("%s - %s", tag, msg));
    }

    public static void warn(String tag, String msg) {
        logger.warn(String.format("%s - %s", tag, msg));
    }

    public static void info(String tag, String msg) {
        logger.info(String.format("%s - %s", tag, msg));
    }

    public static void debug(String tag, String msg) {
        logger.debug(String.format("%s - %s", tag, msg));
    }

    public static void trace(String tag, String msg) {
        logger.trace(String.format("%s - %s", tag, msg));
    }

    public static void error(String tag, Throwable throwable) {
        logger.error(tag, throwable);
    }

    public static void warn(String tag, Throwable throwable) {
        logger.warn(tag, throwable);
    }

    public static void info(String tag, Throwable throwable) {
        logger.info(tag, throwable);
    }

    public static void debug(String tag, Throwable throwable) {
        logger.debug(tag, throwable);
    }

    public static void trace(String tag, Throwable throwable) {
        logger.trace(tag, throwable);
    }

    public static void error(String msg, String tag, Throwable throwable) {
    	error(String.format("%s - %s", tag, msg), throwable);
    }

    public static void warn(String msg, String tag, Throwable throwable) {
    	warn(String.format("%s - %s", tag, msg), throwable);
    }

    public static void info(String msg, String tag, Throwable throwable) {
        info(String.format("%s - %s", tag, msg), throwable);
    }

    public static void config(String msg, String tag, Throwable throwable) {
        debug(String.format("%s - %s", tag, msg), throwable);
    }

    public static void fine(String msg, String tag, Throwable throwable) {
        trace(String.format("%s - %s", tag, msg), throwable);
    }

}
