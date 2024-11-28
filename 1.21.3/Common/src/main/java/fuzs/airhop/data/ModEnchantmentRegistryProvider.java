package fuzs.airhop.data;

import fuzs.airhop.init.ModRegistry;
import fuzs.puzzleslib.api.data.v2.AbstractRegistriesDatapackGenerator;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;

public class ModEnchantmentRegistryProvider extends AbstractRegistriesDatapackGenerator<Enchantment> {

    public ModEnchantmentRegistryProvider(DataProviderContext context) {
        super(Registries.ENCHANTMENT, context);
    }

    @Override
    public void addBootstrap(BootstrapContext<Enchantment> context) {
        HolderGetter<Item> items = context.lookup(Registries.ITEM);
        registerEnchantment(context, ModRegistry.AIR_HOP_ENCHANTMENT, Enchantment.enchantment(
                Enchantment.definition(items.getOrThrow(ItemTags.LEG_ARMOR_ENCHANTABLE), 2, 4,
                        Enchantment.dynamicCost(10, 10), Enchantment.dynamicCost(25, 10), 4, EquipmentSlotGroup.LEGS
                )).withEffect(ModRegistry.AIR_HOP_ENCHANTMENT_EFFECT_COMPONENT_TYPE.value()));
    }
}
