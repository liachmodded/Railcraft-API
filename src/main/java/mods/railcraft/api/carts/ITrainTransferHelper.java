/*------------------------------------------------------------------------------
 Copyright (c) CovertJaguar, 2011-2017

 This work (the API) is licensed under the "MIT" License,
 see LICENSE.md for details.
 -----------------------------------------------------------------------------*/
package mods.railcraft.api.carts;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

/**
 * This interface is the API facing wrapper for an internal helper class that makes it
 * simple to pass items and fluids around within a Train.
 * <p/>
 * The helper object can be accessed from CartTools and is aware of the IItemCart and IFluidCart interfaces.
 * <p/>
 * Created by CovertJaguar on 5/11/2015.
 *
 * @see CartToolsAPI
 * @see mods.railcraft.api.carts.IItemCart
 * @see mods.railcraft.api.carts.IFluidCart
 */
@SuppressWarnings("unused")
public interface ITrainTransferHelper {
    // ***************************************************************************************************************************
    // Items
    // ***************************************************************************************************************************

    /**
     * Will attempt to push an ItemStack to the Train.
     *
     * @param requester the source EntityMinecart
     * @param stack     the ItemStack to be pushed
     * @return the ItemStack that remains after any pushed items were removed, or null if it was fully pushed
     * @see mods.railcraft.api.carts.IFluidCart
     */
    ItemStack pushStack(EntityMinecart requester, ItemStack stack);

    /**
     * Will request an item from the Train.
     *
     * @param requester the source EntityMinecart
     * @param filter    a Predicate<ItemStack> that defines the requested item
     * @return the ItemStack pulled from the Train, or null if the request cannot be met
     * @see mods.railcraft.api.carts.IItemCart
     */
    ItemStack pullStack(EntityMinecart requester, Predicate<@NotNull ItemStack> filter);

    /**
     * Offers an item stack to the Train or drops it if no one wants it.
     *
     * @param requester the source EntityMinecart
     * @param stack     the ItemStack to be offered
     */
    void offerOrDropItem(EntityMinecart requester, ItemStack stack);

    /**
     * Returns an IItemHandler with represents the entire train.
     *
     * @param cart a cart in the train
     * @return IItemHandler
     */
    @Nullable
    IItemHandler getTrainItemHandler(EntityMinecart cart);


    // ***************************************************************************************************************************
    // Fluids
    // ***************************************************************************************************************************

    /**
     * Will attempt to push fluid to the Train.
     *
     * @param requester  the source EntityMinecart
     * @param fluidStack the amount and type of Fluid to be pushed
     * @return the FluidStack that remains after any pushed Fluid was removed, or null if it was fully pushed
     * @see mods.railcraft.api.carts.IFluidCart
     */
    @Nullable
    FluidStack pushFluid(EntityMinecart requester, FluidStack fluidStack);

    /**
     * Will request fluid from the Train.
     *
     * @param requester  the source EntityMinecart
     * @param fluidStack the amount and type of Fluid requested
     * @return the FluidStack pulled from the Train, or null if the request cannot be met
     * @see mods.railcraft.api.carts.IFluidCart
     */
    @Nullable
    @Contract("_, null -> null")
    FluidStack pullFluid(EntityMinecart requester, @Nullable FluidStack fluidStack);

    /**
     * Returns an IFluidHandler with represents the entire train.
     *
     * @param cart a cart in the train
     * @return IFluidHandler
     */
    @Nullable
    IFluidHandler getTrainFluidHandler(EntityMinecart cart);
}
