/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.spongepowered.api.world;

import java.util.Optional;

/**
 * An agent that handles teleportation locations. This can be understood as
 * an agent that handles the creation of "portals" between {@link World}s.
 *
 * <p>An example is the agent handling nether portals.</p>
 */
public interface TeleporterAgent {

    /**
     * Gets the search radius before a new acceptable "portal" location is
     * created.
     *
     * @return The search radius
     */
    int getTeleporterSearchRadius();

    /**
     * Sets the search radius before a new acceptable "portal" location is
     * created.
     *
     * @param radius The new radius
     * @return This agent, for chaining
     */
    TeleporterAgent setTeleporterSearchRadius(int radius);

    /**
     * Gets the radius of where a "portal" can be created.
     *
     * @return The radius of where a portal can be created
     */
    int getTeleporterCreationRadius();

    /**
     * Sets the creation radius of where a portal may be created.
     *
     * @param radius The new radius
     * @return This agent, for chaining
     */
    TeleporterAgent setTeleporterCreationRadius(int radius);

    /**
     * Gets whether this agent is able to create "portals".
     *
     * @return True if this agent can create portals
     */
    boolean canCreateTeleporter();

    /**
     * Sets whether this agent is able to create "portals".
     *
     * @return This agent, for chaining
     */
    TeleporterAgent setCanCreateTeleporter();

    /**
     * Attempts to find a "portal" location, or if none are available,
     * creates one. Returns {@link Optional#empty()} if none are found.
     *
     * @param targetLocation The suggested location
     * @return The found location of the "portal", if available
     */
    Optional<Location<World>> findOrCreateTeleporter(Location<World> targetLocation);

    /**
     * Attempts to find a "portal" location. Returns {@link Optional#empty()}
     * if none are found.
     *
     * @param targetLocation The suggested location
     * @return The found location of the "portal", if available
     */
    Optional<Location<World>> findTeleporter(Location<World> targetLocation);

    /**
     * Tells this agent to create a new "portal" location at the suggested
     * {@link Location}. If none can be created, or {@link #canCreateTeleporter()}
     * returns {@code false}, {@link Optional#empty()} is returned.
     *
     * @param targetLocation The targeted location
     * @return The newly created "portal" location, if available
     */
    Optional<Location<World>> createTeleporter(Location<World> targetLocation);

}
