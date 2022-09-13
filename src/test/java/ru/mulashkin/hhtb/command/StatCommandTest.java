package ru.mulashkin.hhtb.command;

import static org.junit.jupiter.api.Assertions.*;
import static ru.mulashkin.hhtb.command.CommandName.STAT;
import static ru.mulashkin.hhtb.command.StatCommand.STAT_MESSAGE;

class StatCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return STAT.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return String.format(STAT_MESSAGE, 0);
    }

    @Override
    Command getCommand() {
        return new StatCommand(sendBotMessageService, telegramUserService);
    }
}