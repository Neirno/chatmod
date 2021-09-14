package com.holo.chatmod.events;

import com.holo.chatmod.events.chatgame.ClickedEvent;
import com.holo.chatmod.events.chatgame.MathEvent;
import com.holo.chatmod.utils.Utils;

import com.holo.chatmod.utils.Wrapper;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraftforge.client.event.*;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.ArrayList;

public class EventManager {

    private static ArrayList<Event> e;

    public EventManager() {
        e = new ArrayList<Event>();
        addEvent(new ClickedEvent());
        addEvent(new MathEvent());
    }

    public static void addEvent(Event event) {
        e.add(event);
    }

    public static ArrayList<Event> getEvents() {
        return e;
    }

    private void printHelp() {
        Wrapper.INSTANCE.sendMessageToPlayer("§2§lЧтобы активировать функции используй:\n" +
                "§2§l/cm math - для активации калькулятор\n" +
                "§2§l/cm click - для активации кликов\n\n");
        for (Event e : getEvents()) {
            if (e.isToggled())
                Wrapper.INSTANCE.sendMessageToPlayer("§2§lФункция " + e.getName() + " активна\n");
            else
                Wrapper.INSTANCE.sendMessageToPlayer("§4§lФункция " + e.getName() + " не активна\n");
        }
        Wrapper.INSTANCE.sendMessageToPlayer("§e§l§nНЕ ЗАБЫВАЙ ЧИСТИТЬ ЛОГИ ПЕРЕД ПРОВЕРКАМИ ХЕЛПЕРОВ!\n");
    }
    /**
     * TODO: изменить код, чтобы этот хэндлер был в отдельном файле. Настроить ответ, если второй параметр не подходит
     */
    @SubscribeEvent
    public void handler(ClientChatEvent event) {
        String[] command = event.getMessage().split(" ");
        if (command[0].equals("/cm") && command.length == 2) {
            for (Event e : getEvents()) {
                if (e.getName().equals(command[1])) {
                    e.setToggled(!e.isToggled());
                    break;
                }
            }
            event.setCanceled(true);
        } else if (command[0].equals("/cm")) {
            printHelp();
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onGuiContainer(GuiContainerEvent event) {
        if (Utils.nullCheck()) return;
        for (Event e : getEvents()) {
            if(e.isToggled()) {
                e.onGuiContainer(event);
            }
        }
    }

    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent event) {
        if (Utils.nullCheck()) return;
        for (Event e : getEvents()) {
            if(e.isToggled()) {
                e.onGuiOpen(event);
            }
        }
    }

    @SubscribeEvent
    public void onMouse(MouseEvent event) {
        if (Utils.nullCheck()) return;
        for (Event e : getEvents()) {
            if(e.isToggled()) {
                e.onMouse(event);
            }
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (Utils.nullCheck()) return;
        for (Event e : getEvents()) {
            if(e.isToggled()) {
                e.onPlayerTick(event);
            }
        }
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (Utils.nullCheck()) return;
        for (Event e : getEvents()) {
            if(e.isToggled()) {
                e.onClientTick(event);
            }
        }
    }

    @SubscribeEvent
    public void onCameraSetup(EntityViewRenderEvent.CameraSetup event) {
        if (Utils.nullCheck()) return;
        for (Event e : getEvents()) {
            if(e.isToggled()) {
                e.onCameraSetup(event);
            }
        }
    }

    @SubscribeEvent
    public void onAttackEntity(AttackEntityEvent event) {
        if (Utils.nullCheck()) return;
        for (Event e : getEvents()) {
            if(e.isToggled()) {
                e.onAttackEntity(event);
            }
        }
    }

    @SubscribeEvent
    public void onItemPickup(EntityItemPickupEvent event) {
        if (Utils.nullCheck()) return;
        for (Event e : getEvents()) {
            if(e.isToggled()) {
                e.onItemPickup(event);
            }
        }
    }

    @SubscribeEvent
    public void onProjectileImpact(ProjectileImpactEvent event) {
        if (Utils.nullCheck()) return;
        for (Event e : getEvents()) {
            if(e.isToggled()) {
                e.onProjectileImpact(event);
            }
        }
    }

    @SubscribeEvent
    public void onEntityJoinWorldEvent(EntityJoinWorldEvent event) {
        if (Utils.nullCheck()) return;
        for (Event e : getEvents()) {
            if(e.isToggled()) {
                e.onEntityJoinWorldEvent(event);
            }
        }
    }

    @SubscribeEvent
    public void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (Utils.nullCheck()) return;
        for (Event e : getEvents()) {
            if(e.isToggled()) {
                e.onLivingUpdate(event);
            }
        }
    }

    @SubscribeEvent
    public void onRenderPlayer(RenderPlayerEvent event) {
        if (Utils.nullCheck()) return;
        for (Event e : getEvents()) {
            if(e.isToggled()) {
                e.onRenderPlayer(event);
            }
        }
    }

    @SubscribeEvent
    public void onRenderWorldLast(RenderWorldLastEvent event) {
        if (Utils.nullCheck()) return;
        for (Event e : getEvents()) {
            if(e.isToggled()) {
                e.onRenderWorldLast(event);
            }
        }
    }

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent.Text event) {
        if (Utils.nullCheck()) return;
        for (Event e : getEvents()) {
            if(e.isToggled()) {
                e.onRenderGameOverlay(event);
            }
        }
    }

    @SubscribeEvent
    public void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        if (Utils.nullCheck()) return;
        for (Event e : getEvents()) {
            if(e.isToggled()) {
                e.onLeftClickBlock(event);
            }
        }
    }

    @SubscribeEvent
    public void onPlayerSendChatMessage(ClientChatEvent event) {
        if (Utils.nullCheck()) return;
        for (Event e : getEvents()) {
            if(e.isToggled()) {
                e.onPlayerSendChatMessage(event);
            }
        }
    }

    @SubscribeEvent
    public void onNewMessage(ClientChatReceivedEvent event) {
        if (Utils.nullCheck()) return;
        for (Event e : getEvents()) {
            if(e.isToggled()) {
                e.onNewMessage(event);
            }
        }
    }
}
