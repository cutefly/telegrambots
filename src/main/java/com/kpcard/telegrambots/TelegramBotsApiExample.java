package com.kpcard.telegrambots;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;

import com.kpcard.telegrambots.handler.CommandsHandler;
import com.kpcard.telegrambots.handler.MessageHandler;

public class TelegramBotsApiExample {

	private static final Logger logger = LoggerFactory.getLogger(TelegramBotsApiExample.class);
	private static final String LOGTAG = "MAIN";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        BotLogger.setLevel(Level.ALL);
//        Handler	handler = new ConsoleHandler();
//        handler.setLevel(Level.ALL);
//        BotLogger.registerLogger(handler);
//        try {
//            BotLogger.registerLogger(new BotsFileHandler());
//        } catch (IOException e) {
//        }
        
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
        	telegramBotsApi.registerBot(new MessageHandler());
        	telegramBotsApi.registerBot(new CommandsHandler());
        } catch (TelegramApiException e) {
        	logger.error(LOGTAG, e);
        }
	}

}
