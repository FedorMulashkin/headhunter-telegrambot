package ru.mulashkin.hhtb.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.mulashkin.hhtb.service.SendBotMessageService;

public class StartCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    private final static String START_MESSAGE = "Привет. Я HH Telegram Bot. Я помогу тебе быть в курсе последних " +
            "вакансий, которые тебе интересны. Я еще маленький и только учусь.";

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
