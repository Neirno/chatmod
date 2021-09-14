package com.holo.chatmod.events;

import com.holo.chatmod.utils.Wrapper;

import net.minecraft.util.text.event.ClickEvent;
import net.minecraftforge.client.event.*;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Event {

    private String name;
    private boolean toggled;

    public Event(String name) {
        this.name = name;
        this.toggled = false;
    }

    public void onGuiContainer(GuiContainerEvent event) {}
    public void onGuiOpen(GuiOpenEvent event) {}
    public void onMouse(MouseEvent event) {}
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {}
    public void onClientTick(TickEvent.ClientTickEvent event) {}
    public void onCameraSetup(EntityViewRenderEvent.CameraSetup event) {}
    public void onAttackEntity(AttackEntityEvent event) {}
    public void onItemPickup(EntityItemPickupEvent event) {}
    public void onProjectileImpact(ProjectileImpactEvent event) {}
    public void onEntityJoinWorldEvent(EntityJoinWorldEvent event) {}
    public void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {}
    public void onRenderPlayer(RenderPlayerEvent event) {}
    public void onRenderWorldLast(RenderWorldLastEvent event) {}
    public void onRenderGameOverlay(RenderGameOverlayEvent.Text event) {}
    public void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event){}
    public void onPlayerSendChatMessage(ClientChatEvent event) {}
    public void onNewMessage(ClientChatReceivedEvent event) {}

    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
