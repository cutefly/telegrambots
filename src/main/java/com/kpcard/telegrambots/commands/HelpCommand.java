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
import org.telegram.telegrambots.bots.commands.ICommandRegistry;

/**
 * @author happymoney
 *
 */
public class HelpCommand extends BotCommand {

	private static final Logger logger = LoggerFactory.getLogger(HelpCommand.class);
    private static final String LOGTAG = "HelpCommand";
    
    private final ICommandRegistry commandRegistry;

	public HelpCommand(ICommandRegistry commandRegistry) {
		super("Help", "Get all the commands this bot provides");
		// TODO Auto-generated constructor stub
		this.commandRegistry = commandRegistry;
	}

	/* (non-Javadoc)
	 * @see org.telegram.telegrambots.bots.commands.BotCommand#execute(org.telegram.telegrambots.bots.AbsSender, org.telegram.telegrambots.api.objects.User, org.telegram.telegrambots.api.objects.Chat, java.lang.String[])
	 */
	@Override
	public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
		// TODO Auto-generated method stub
        StringBuilder helpMessageBuilder = new StringBuilder("<b>Help</b>\n");
        helpMessageBuilder.append("These are the registered commands for this Bot:\n\n");

        for (BotCommand botCommand : commandRegistry.getRegisteredCommands()) {
            helpMessageBuilder.append(botCommand.toString()).append("\n\n");
        }
        logger.info(helpMessageBuilder.toString());

        SendMessage helpMessage = new SendMessage();
        helpMessage.setChatId(chat.getId().toString());
        helpMessage.enableHtml(true);
        helpMessage.setText(helpMessageBuilder.toString());

        try {
            absSender.sendMessage(helpMessage);
        } catch (TelegramApiException e) {
        	logger.error(LOGTAG, e);
        }

	}

}
