package ru.mulashkin.hhtb.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.mulashkin.hhtb.entity.TelegramUser;
import ru.mulashkin.hhtb.service.SendBotMessageService;
import ru.mulashkin.hhtb.service.TelegramUserService;

/**
 * Start {@link Command}.
 */
public class StartCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;
    public final static String START_MESSAGE = "Привет. Я HH Telegram Bot. Я помогу тебе быть в курсе последних " +
            "вакансий, которые тебе интересны. Я еще маленький и только учусь.";

    public StartCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();

        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                user -> {
                    user.setActive(true);
                    telegramUserService.save(user);
                },
                ()->{
                    TelegramUser telegramUser = new TelegramUser();
                    telegramUser.setActive(true);
                    telegramUser.setChatId(chatId);
                    telegramUserService.save(telegramUser);
                }
        );

        sendBotMessageService.sendMessage(chatId, START_MESSAGE);
    }
}
