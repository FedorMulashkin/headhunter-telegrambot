package ru.mulashkin.hhtb.command;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit-level testing for HelpCommand")
class HelpCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return CommandName.HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HelpCommand.HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}