package ru.mulashkin.hhtb.command;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Unit-level testing for StartCommand")
class StartCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return CommandName.START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return StartCommand.START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService);
    }
}