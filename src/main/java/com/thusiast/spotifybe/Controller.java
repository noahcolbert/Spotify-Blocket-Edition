package com.thusiast.spotifybe;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.function.Function;

public class Controller extends Item {

    public Controller(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand){
        //TODO: Update this to open Spotify menu when menu logic is added.
        return ActionResult.PASS;
    }

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SpotifyBlocketEdition.MOD_ID, name));

        // Create instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static final Item CONTROLLER = register("controller", Item::new, new Item.Settings());

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.add(Controller.CONTROLLER));
    }

}
