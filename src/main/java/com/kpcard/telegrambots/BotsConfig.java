package com.kpcard.telegrambots;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BotsConfig {
	private static Properties prop = new Properties();
	
	static {
//		Properties prop = new Properties();
		try {
			InputStream in = BotsConfig.class.getClassLoader().getResourceAsStream("settings.properties");
			prop.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getBotToken(String key) {
		String propKey = String.format("%s.%s_bot_token", prop.getProperty("profile.mode"), key);
		
		return prop.getProperty(propKey);
	}
	
	public static String getBotUsername(String key) {
		String propKey = String.format("%s.%s_bot_username", prop.getProperty("profile.mode"), key);
		
		return prop.getProperty(propKey);
		
	}
	public static final String		KPC_MESSAGE_BOT_TOKEN = "219296420:AAH5CpCdd-eEfjDXYOlCf-tXApwT2aDd4YI";
	public static final String		KPC_MESSAGE_BOT_USERNAME = "kpc_message_bot";

	public static final String		KPC_TEST_MESSAGE_BOT_TOKEN = "260464236:AAHNWWCkMqkYott-ebTSqAF-VsWtjid8RAw";
	public static final String		KPC_TEST_MESSAGE_BOT_USERNAME = "kpc_test_message_bot";

	public static final String		KPC_COMMAND_BOT_TOKEN = "260666400:AAGe-V_Hg0iYHS2bG01mSNmjaMjoBva_h2c";
	public static final String		KPC_COMMAND_BOT_USERNAME = "kpc_command_bot";

	public static final String		KPC_TEST_COMMAND_BOT_TOKEN = "269437500:AAEwAYpqj5H97RdJXbRfVJutzxNvNxwyGMo";
	public static final String		KPC_TEST_COMMAND_BOT_USERNAME = "kpc_test_command_bot";

}
