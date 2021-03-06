/*------------------------------------------------------------------------------
 Copyright (c) CovertJaguar, 2011-2016

 This work (the API) is licensed under the "MIT" License,
 see LICENSE.md for details.
 -----------------------------------------------------------------------------*/

package mods.railcraft.api.tracks;

/**
 * Implementing this interface will allow your track to be direction specific.
 *
 * And so long as you inherit from TrackInstanceBase it will automatically be
 * reversible via the Crowbar.
 *
 * @author CovertJaguar <http://www.railcraft.info>
 */
public interface ITrackKitReversible extends ITrackKitInstance {

    boolean isReversed();

    void setReversed(boolean reversed);
}
