package ru.mulashkin.hhtb.command;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit-level testing for UnknownCommand")
class UnknownCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return "/asdfas";
    }

    @Override
    String getCommandMessage() {
        return UnknownCommand.UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}