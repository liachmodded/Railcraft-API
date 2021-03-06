/*
 * ******************************************************************************
 *  Copyright 2011-2015 CovertJaguar
 *
 *  This work (the API) is licensed under the "MIT" License, see LICENSE.md for details.
 * ***************************************************************************
 */

package mods.railcraft.api.crafting;

/**
 * These variables are defined during the pre-init phase.
 * Do not attempt to access them during pre-init.
 *
 * @author CovertJaguar <http://www.railcraft.info>
 */
public final class RailcraftCraftingManager {
    static ICokeOvenCraftingManager cokeOven = CraftingDummies.COKE_OVEN_CRAFTING_MANAGER;
    static IBlastFurnaceCraftingManager blastFurnace = CraftingDummies.BLAST_FURNACE_CRAFTING_MANAGER;
    //TODO initialize
    static ICrusherCraftingManager rockCrusher;
    static IRollingMachineCraftingManager rollingMachine = CraftingDummies.ROLLING_MACHINE_CRAFTING_MANAGER;

    /**
     * Returns the coke oven crafting manager.
     *
     * <p>If railcraft is not available, a dummy one is returned.</p>
     *
     * @return The coke oven crafting manager
     */
    public static ICokeOvenCraftingManager getCokeOvenCraftings() {
        return cokeOven;
    }

    /**
     * Returns the blast furnace crafting manager.
     *
     * <p>If railcraft is not available, a dummy one is returned.</p>
     *
     * @return The blast furnace crafting manager
     */
    public static IBlastFurnaceCraftingManager getBlastFurnaceCraftings() {
        return blastFurnace;
    }

    /**
     * Returns the rock crusher crafting manager.
     *
     * <p>If railcraft is not available, a dummy one is returned.</p>
     *
     * @return The rock crusher crafting manager
     */
    public static ICrusherCraftingManager getRockCrusherCraftings() {
        return rockCrusher;
    }

    /**
     * Returns the rolling machine crafting manager.
     *
     * <p>If railcraft is not available, a dummy one is returned.</p>
     *
     * @return The rolling machine crafting manager
     */
    public static IRollingMachineCraftingManager getRollingMachineCraftings() {
        return rollingMachine;
    }

    private RailcraftCraftingManager() {
    }

}
