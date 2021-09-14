package com.holo.chatmod.events.chatgame;

import com.holo.chatmod.events.Event;
import com.holo.chatmod.utils.Calculator;
import com.holo.chatmod.utils.Utils;
import com.holo.chatmod.utils.Wrapper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.text.event.ClickEvent;

import java.util.Timer;
import java.util.TimerTask;

public class ClickedEvent extends Event {

    /**
     * Данные с сервера о начинающимся тексте в чате.
     */
    private String startText;
    /**
     * Данные с сервера о заканчивающимся тексте в чате.
     */
    private String endText;

    public ClickedEvent() {
        super("click");
    }

    @Override
    @SubscribeEvent
    public void onNewMessage(ClientChatReceivedEvent event) {

        String text = event.getMessage().getUnformattedText();
        if (text.startsWith("\n"))
        {
            for (ITextComponent it: event.getMessage().getSiblings()) {
                text = customComponentClick(it);
                if (!text.equals("none"))
                    sendAnswerInChat(text);
            }
        }
    }

    /**
     * Получение ивента в текстовых компанентах в сообщении.
     * @param textComponent лист
     * @return
     */
    private String customComponentClick(ITextComponent textComponent) {
        Style style = textComponent.getStyle();
        if (style.getClickEvent() != null) {
            ClickEvent clickEvent = style.getClickEvent();
            String componentText = clickEvent.getValue();
            if (clickEvent.getAction() == ClickEvent.Action.RUN_COMMAND && componentText.startsWith("/")) {
                return componentText;
            }
        }
        return "none";
    }

    private void sendAnswerInChat(String text) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Wrapper.INSTANCE.sendMessageToChat(text);
            }
        }, Utils.random(100, 700)); // 0.3 sec~
    }
}
