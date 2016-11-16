/**
 * 
 */
package com.kpcard.telegrambots.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;

/**
 * @author happymoney
 *
 */
public class HelloCommand extends BotCommand {

	private static final Logger logger = LoggerFactory.getLogger(HelloCommand.class);
    private static final String LOGTAG = "HelloCommand";

	public HelloCommand() {
		super("Hello", "Say hello to this bot");
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.telegram.telegrambots.bots.commands.BotCommand#execute(org.telegram.telegrambots.bots.AbsSender, org.telegram.telegrambots.api.objects.User, org.telegram.telegrambots.api.objects.Chat, java.lang.String[])
	 */
	@Override
	public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
		// TODO Auto-generated method stub
		logger.debug(chat.toString());
		logger.debug(user.toString());

		String userName = chat.getUserName();
        if (userName == null || userName.isEmpty()) {
            userName = user.getFirstName() + " " + user.getLastName();
        }

        StringBuilder messageTextBuilder = new StringBuilder("Hello ").append(userName);
        if (arguments != null && arguments.length > 0) {
            messageTextBuilder.append("\n");
            messageTextBuilder.append("Thank you so much for your kind words:\n");
            messageTextBuilder.append(String.join(" ", arguments));
        }
        logger.info(messageTextBuilder.toString());

        SendMessage answer = new SendMessage();
        answer.setChatId(chat.getId().toString());
        answer.setText(messageTextBuilder.toString());

        try {
            absSender.sendMessage(answer);
        } catch (TelegramApiException e) {
        	logger.error(LOGTAG, e);
        }
	}

}
