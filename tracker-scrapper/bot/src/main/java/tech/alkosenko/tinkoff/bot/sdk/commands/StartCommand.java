package tech.alkosenko.tinkoff.bot.sdk.commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

import tech.alkosenko.tinkoff.bot.sdk.Command;

public class StartCommand implements Command {

    @Override
    public String command() {
        throw new UnsupportedOperationException("Unimplemented method 'command'");
    }

    @Override
    public String description() {
        throw new UnsupportedOperationException("Unimplemented method 'description'");
    }

    @Override
    public SendMessage handle(Update update) {
        throw new UnsupportedOperationException("Unimplemented method 'handle'");
    }
}
