package com.vagdedes.spartan.compatibility.manual.abilities;

import com.nisovin.magicspells.events.SpellCastEvent;
import com.nisovin.magicspells.events.SpellCastedEvent;
import com.vagdedes.spartan.compatibility.Compatibility;
import com.vagdedes.spartan.functionality.server.Config;
import com.vagdedes.spartan.functionality.server.SpartanBukkit;
import me.vagdedes.spartan.system.Enums;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class MagicSpells implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    private void SpellCast(SpellCastEvent e) {
        if (Compatibility.CompatibilityType.MAGIC_SPELLS.isFunctional()) {
            LivingEntity caster = e.getCaster();

            if (caster instanceof Player) {
                Config.compatibility.evadeFalsePositives(
                        SpartanBukkit.getProtocol((Player) caster),
                        Compatibility.CompatibilityType.MAGIC_SPELLS,
                        new Enums.HackCategoryType[]{
                                Enums.HackCategoryType.MOVEMENT,
                                Enums.HackCategoryType.COMBAT
                        },
                        40
                );
            }
        }
    }

    @EventHandler
    private void SpellCasted(SpellCastedEvent e) {
        if (Compatibility.CompatibilityType.MAGIC_SPELLS.isFunctional()) {
            LivingEntity caster = e.getCaster();

            if (caster instanceof Player) {
                Config.compatibility.evadeFalsePositives(
                        SpartanBukkit.getProtocol((Player) caster),
                        Compatibility.CompatibilityType.MAGIC_SPELLS,
                        new Enums.HackCategoryType[]{
                                Enums.HackCategoryType.MOVEMENT,
                                Enums.HackCategoryType.COMBAT
                        },
                        40
                );
            }
        }
    }

    /*@EventHandler
    private void Spell(SpellEvent e) {
    }*/
}
