package tech.alkosenko.tinkoff.bot.sdk;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import java.util.List;
import tech.alkosenko.tinkoff.bot.sdk.Command;

public interface UserMessageProcessor {
    List<? extends Command> commands();

    SendMessage process(Update update);
}
