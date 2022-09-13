package ru.mulashkin.hhtb.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.mulashkin.hhtb.service.SendBotMessageService;
import ru.mulashkin.hhtb.service.TelegramUserService;
/**
 * Statistics {@link Command}.
 */
public class StatCommand implements Command {
    private final TelegramUserService telegramUserService;
    private final SendBotMessageService sendBotMessageService;

    public final static String STAT_MESSAGE = "HeadHunter Telegram Bot использует %s человек.";


    public StatCommand(SendBotMessageService sendBotMessageService, @Autowired TelegramUserService telegramUserService) {
        this.telegramUserService = telegramUserService;
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        int activeUserCount = telegramUserService.retrieveAllActiveUsers().size();
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),
                String.format(STAT_MESSAGE, activeUserCount));
    }
}
