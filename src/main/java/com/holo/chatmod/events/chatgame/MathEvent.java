package com.holo.chatmod.events.chatgame;

import com.holo.chatmod.events.Event;
import com.holo.chatmod.server.Client;
import com.holo.chatmod.utils.Calculator;
import com.holo.chatmod.utils.Utils;
import com.holo.chatmod.utils.Wrapper;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Timer;
import java.util.TimerTask;

public class MathEvent extends Event {
    /**
     * Данные с сервера о начинающимся тексте в чате. Например "Решите пример:"
     * чтобы в последствии обрезать текст до примера.
     */
    private String startText = "Решите пример ";
    /**
     * Данные с сервера о заканчивающимся тексте в чате.
     * Пока не используется. В будущем может пригодиться.
     */
    private String endText;

    private boolean canWrite = false;

    private int numberOfResponses = 0;

    public MathEvent() {
        super("math");

    }

    @Override
    @SubscribeEvent
    public void onNewMessage(ClientChatReceivedEvent event) {
        String text = event.getMessage().getUnformattedText().trim(); // Получаем сообщение, убирая лишние пробелы.
        if (text.startsWith(startText)) {
            switch (numberOfResponses) {
                case 0:
                case 2:
                case 5:
                    sendAnswerInChat(text);
                    numberOfResponses++;
                    break;
                case 6:
                    numberOfResponses = 0;
                    break;
                default:
                    numberOfResponses++;
                    break;
            }
        } /*else if (text.startsWith()) {

        }*/
    }

    private void sendAnswerInChat(String text) {
        String answ = text.substring(startText.length());

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Wrapper.INSTANCE.sendMessageToChat(Calculator.calculate(answ));
            }
        }, Utils.random(2601, 3000)); // 3 sec~
    }
}
