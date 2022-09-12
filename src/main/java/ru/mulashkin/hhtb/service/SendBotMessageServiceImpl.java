package ru.mulashkin.hhtb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.mulashkin.hhtb.bot.HHFindNewJobBot;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {
    private final HHFindNewJobBot bot;

    @Autowired
    public SendBotMessageServiceImpl(HHFindNewJobBot bot) {
        this.bot = bot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        sendMessage.enableHtml(true);
        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
