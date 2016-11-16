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
public class ShoutCommand extends BotCommand {

	private static final Logger logger = LoggerFactory.getLogger(ShoutCommand.class);
	private static final String LOGTAG = "ShoutCommand";

    public ShoutCommand() {
    	super("Shout", "Shout to channel");
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.telegram.telegrambots.bots.commands.BotCommand#execute(org.telegram.telegrambots.bots.AbsSender, org.telegram.telegrambots.api.objects.User, org.telegram.telegrambots.api.objects.Chat, java.lang.String[])
	 */
	@Override
	public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
		// TODO Auto-generated method stub
		logger.info(chat.toString());
		logger.info(user.toString());

		String userName = chat.getUserName();
        if (userName == null || userName.isEmpty()) {
            userName = user.getFirstName() + " " + user.getLastName();
        }

        SendMessage answer = new SendMessage();

        StringBuilder messageTextBuilder = new StringBuilder().append(userName);
        if (arguments != null && arguments.length > 1) {
        	String channel = String.format("@%s", arguments[0]);
        	String[]	arguments2 = new String[arguments.length-1];
        	System.arraycopy(arguments, 1, arguments2, 0, arguments.length-1);
            messageTextBuilder.append(" send ").append(String.join(" ", arguments2));
            answer.setChatId(channel);
        } else {
            messageTextBuilder.append(" input invalid argument");
            answer.setChatId(chat.getId().toString());
        }
        logger.info(messageTextBuilder.toString());
        answer.setText(messageTextBuilder.toString());

        try {
            absSender.sendMessage(answer);
        } catch (TelegramApiException e) {
        	logger.error(LOGTAG, e);
        }

	}

}
