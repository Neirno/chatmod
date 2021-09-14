package com.holo.chatmod.proxy;

import com.holo.chatmod.events.EventManager;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(final FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new EventManager());
        // Добавить мод
    }

    public void init(final FMLInitializationEvent event) {
    }

    public void postInit(final FMLPostInitializationEvent event) {
    }
}