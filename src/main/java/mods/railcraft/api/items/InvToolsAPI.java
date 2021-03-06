/*------------------------------------------------------------------------------
 Copyright (c) CovertJaguar, 2011-2017

 This work (the API) is licensed under the "MIT" License,
 see LICENSE.md for details.
 -----------------------------------------------------------------------------*/

package mods.railcraft.api.items;

import mods.railcraft.api.core.RailcraftConstantsAPI;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/**
 * Created by CovertJaguar on 6/7/2017 for Railcraft.
 *
 * @author CovertJaguar <http://www.railcraft.info>
 */
public final class InvToolsAPI {
    private InvToolsAPI() {
    }

    @Contract("null -> true; !null -> _;")
    public static boolean isEmpty(@Nullable ItemStack stack) {
        return stack == null || stack.isEmpty();
    }

    public static ItemStack emptyStack() {
        return ItemStack.EMPTY;
    }

    @Contract("_, true -> !null")
    @Nullable
    public static NBTTagCompound getItemDataRailcraft(ItemStack stack, boolean create) {
        if (isEmpty(stack))
            return create ? new NBTTagCompound() : null;
        return create ? stack.getOrCreateSubCompound(RailcraftConstantsAPI.MOD_ID) : stack.getSubCompound(RailcraftConstantsAPI.MOD_ID);
    }

    public static void clearItemDataRailcraft(ItemStack stack, String tag) {
        NBTTagCompound nbt = getItemDataRailcraft(stack, false);
        if (nbt != null && nbt.hasKey(tag))
            nbt.removeTag(tag);
    }

    public static void setItemDataRailcraft(ItemStack stack, String tag, NBTTagCompound data) {
        if (isEmpty(stack)) {
            return;
        }
        NBTTagCompound nbt = getItemDataRailcraft(stack, true);
        nbt.setTag(tag, data);
    }

    @Nullable
    public static NBTTagCompound getItemDataRailcraft(ItemStack stack, String tag) {
        return getItemDataRailcraft(stack, tag, false);
    }

    @Contract("_, _, true -> !null")
    @Nullable
    public static NBTTagCompound getItemDataRailcraft(ItemStack stack, String tag, boolean create) {
        NBTTagCompound nbt = getItemDataRailcraft(stack, create);
        if (nbt != null && (create || nbt.hasKey(tag))) {
            NBTTagCompound subNBT = nbt.getCompoundTag(tag);
            nbt.setTag(tag, subNBT);
            return subNBT;
        }
        return null;
    }
}
