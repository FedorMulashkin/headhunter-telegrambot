package ru.mulashkin.hhtb.command;

import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit-level testing for NoCommand")
class NoCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return CommandName.NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NoCommand.NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}