package ru.mulashkin.hhtb.command;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Unit-level testing for StopCommand")
class StopCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return CommandName.STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return StopCommand.STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService);
    }
}