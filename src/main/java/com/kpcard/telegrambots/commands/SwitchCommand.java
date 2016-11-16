/**
 * 
 */
package com.kpcard.telegrambots.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;

import com.kpcard.array.processor.CommandProcessor;

/**
 * @author happymoney
 *
 */
public class SwitchCommand extends BotCommand {

	/**
     * 
     */
	private static final Logger logger = LoggerFactory.getLogger(SwitchCommand.class);
	private static final String LOGTAG = "SwitchCommand";
	
    private static final int MAX_MESSAGE_LENGTH = 1000;

	public SwitchCommand() {
		super("Switch", "Execute switch command.");
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

        StringBuilder messageTextBuilder = new StringBuilder("");
        if (arguments != null && arguments.length > 0) {
        	CommandProcessor processor = new CommandProcessor();
        	
        	String executeResult = processor.executeCommand(arguments);
            messageTextBuilder.append("Executor : ").append(userName).append("\n");
            messageTextBuilder.append("Command : ").append(String.join(" ", arguments)).append("\n");
            messageTextBuilder.append("Result : ").append(executeResult);
        } else {
        	messageTextBuilder.append("No command");
        }

        SendMessage answer = new SendMessage();
        answer.setChatId(chat.getId().toString());
//        answer.setText(messageTextBuilder.toString());

        try {
        	Collection<String> arr = splitStringBySize(messageTextBuilder.toString(), MAX_MESSAGE_LENGTH);        	
        	Iterator<String> iter = arr.iterator();
        	String curMessage = "";
        	
        	while ( iter.hasNext() ) {
        		curMessage = iter.next();
                answer.setText(curMessage);
            	absSender.sendMessage(answer);
        	}
            answer.setChatId("@KPCChannel");
            
            iter = arr.iterator();
        	while ( iter.hasNext() ) {
        		curMessage = iter.next();
                answer.setText(curMessage);
            	absSender.sendMessage(answer);
        	}
            absSender.sendMessage(answer);
        } catch (TelegramApiException e) {
        	logger.error(LOGTAG, e);
        }
	}
	
	private static Collection<String> splitStringBySize(String str, int size) {
	    ArrayList<String> split = new ArrayList<>();
	    for (int i = 0; i <= str.length() / size; i++) {
	        split.add(str.substring(i * size, Math.min((i + 1) * size, str.length())));
	    }
	    return split;
	}

}
