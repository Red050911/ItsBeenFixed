package io.github.red050911.mod.itsbeenfixed;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.CustomGameRuleCategory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameRules;

public class ItsBeenFixed implements ModInitializer {

    public static final String MOD_ID = "ibfixed";

    public static CustomGameRuleCategory FIXES_RULE_CATEGORY = null;
    public static GameRules.Key<GameRules.BooleanRule> CACTI_BREAK_ITEMS_RULE = null;
    public static GameRules.Key<GameRules.BooleanRule> CACTI_BREAK_MINECARTS_RULE = null;
    public static GameRules.Key<GameRules.BooleanRule> CACTI_BREAK_BOATS_RULE = null;

    @Override
    public void onInitialize() {
        registerGamerules();
    }

    private void registerGamerules() {
        FIXES_RULE_CATEGORY = new CustomGameRuleCategory(new Identifier(MOD_ID, "fixes"), new TranslatableText("gamerule.category.ibfixed.fixes").formatted(Formatting.YELLOW, Formatting.BOLD));
        CACTI_BREAK_ITEMS_RULE = GameRuleRegistry.register("cactiBreakItems", FIXES_RULE_CATEGORY, GameRuleFactory.createBooleanRule(false));
        CACTI_BREAK_MINECARTS_RULE = GameRuleRegistry.register("cactiBreakMinecarts", FIXES_RULE_CATEGORY, GameRuleFactory.createBooleanRule(false));
        CACTI_BREAK_BOATS_RULE = GameRuleRegistry.register("cactiBreakBoats", FIXES_RULE_CATEGORY, GameRuleFactory.createBooleanRule(false));
    }

}
