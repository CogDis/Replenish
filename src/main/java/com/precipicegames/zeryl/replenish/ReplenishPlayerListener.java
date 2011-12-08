/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.precipicegames.zeryl.replenish;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.block.Action;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

/**
 *
 * @author Zeryl
 */
public class ReplenishPlayerListener extends PlayerListener {

    private final Replenish plugin;

    public ReplenishPlayerListener(Replenish instance) {
        plugin = instance;
    }

    @Override
    public void onPlayerInteract(PlayerInteractEvent event) {
        Action action = (Action) event.getAction();
        if ((action.equals(Action.RIGHT_CLICK_AIR)) && (event.getPlayer().getItemInHand().getType() == Material.SNOW_BALL)) {
            Player player = event.getPlayer();

            if (player.getItemInHand().getAmount() == 1) {
                PlayerInventory inventory = player.getInventory();
                
                HashMap<Integer, ? extends ItemStack> invItems = player.getInventory().all(Material.SNOW_BALL);

                for (Map.Entry<Integer, ? extends ItemStack> entry : invItems.entrySet()) {
                    if (inventory.getHeldItemSlot() == entry.getKey())
                        continue;
                    
                    player.getItemInHand().setAmount(entry.getValue().getAmount() + 1);
                    inventory.clear(entry.getKey());
                    player.updateInventory();
                    break;
                }
            }
        }
    }
}
