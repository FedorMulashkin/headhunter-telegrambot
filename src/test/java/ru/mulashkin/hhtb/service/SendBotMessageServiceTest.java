package ru.mulashkin.hhtb.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.mulashkin.hhtb.bot.HHFindNewJobBot;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Unit-level testing for SendBotMessageService")
class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private HHFindNewJobBot bot;

    @BeforeEach
    public void init(){
        bot = Mockito.mock(HHFindNewJobBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(bot);
    }

    @Test
    void shouldProperlySendMessage() throws TelegramApiException {
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.enableHtml(true);
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);

        sendBotMessageService.sendMessage(chatId, message);

        Mockito.verify(bot).execute(sendMessage);
    }
}