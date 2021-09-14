package com.holo.chatmod.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.Packet;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public class Wrapper {

    public static volatile Wrapper INSTANCE = new Wrapper();

    public Minecraft mc() {
        return Minecraft.getMinecraft();
    }

    public EntityPlayerSP player() {
        return Wrapper.INSTANCE.mc().player;
    }

    public WorldClient world() {
        return Wrapper.INSTANCE.mc().world;
    }

    public GameSettings mcSettings() {
        return Wrapper.INSTANCE.mc().gameSettings;
    }

    public FontRenderer fontRenderer() {
        return Wrapper.INSTANCE.mc().fontRenderer;
    }

    public void sendPacket(Packet packet) {
        this.player().connection.sendPacket(packet);
    }

    public void sendMessageToPlayer(String str) {
        Wrapper.INSTANCE.player().sendMessage((ITextComponent)new TextComponentTranslation(str));
    }

    public void sendMessageToChat(String str) {
        Wrapper.INSTANCE.player().sendChatMessage(str);
    }

    public InventoryPlayer inventory() {
        return this.player().inventory;
    }

    public PlayerControllerMP controller() {
        return Wrapper.INSTANCE.mc().playerController;
    }
}