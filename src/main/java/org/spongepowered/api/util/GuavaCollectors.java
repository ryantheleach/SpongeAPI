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
package org.spongepowered.api.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.util.stream.Collector;

/**
 * A set of collectors to allow interoperability between immutable guava collections and the JDK 8 Streams API.
 */
public class GuavaCollectors {
    private GuavaCollectors() {
    }

    private static final Collector<Object, ImmutableList.Builder<Object>, ImmutableList<Object>> IMMUTABLE_LIST_COLLECTOR =
        Collector.of(ImmutableList::builder,
                     ImmutableList.Builder::add, (ImmutableList.Builder<Object> a, ImmutableList.Builder<Object> b) -> a.addAll(b.build()),
                     ImmutableList.Builder::build);

    private static final Collector<Object, ImmutableSet.Builder<Object>, ImmutableSet<Object>> IMMUTABLE_SET_COLLECTOR =
        Collector.of(ImmutableSet::builder,
                     ImmutableSet.Builder::add, (ImmutableSet.Builder<Object> a, ImmutableSet.Builder<Object> b) -> a.addAll(b.build()),
                     ImmutableSet.Builder::build,
                     Collector.Characteristics.UNORDERED);

    /**
     * Collect the values from a stream to an {@link ImmutableList}.
     *
     * @param <T> The type of elements contained by the list
     * @return The appropriate collector
     */
    @SuppressWarnings({"unchecked", "rawtypes"}) // We are just sharing an instance
    public static <T> Collector<T, ImmutableList.Builder<T>, ImmutableList<T>> toImmutableList() {
        return (Collector) IMMUTABLE_LIST_COLLECTOR;
    }

    /**
     * Collect the values from a stream to an {@link ImmutableSet}.
     *
     * @param <T> The type of elements contained in the set
     * @return The appropriate collector
     */
    @SuppressWarnings({"unchecked", "rawtypes"}) // We are just sharing an instance
    public static <T> Collector<T, ImmutableSet.Builder<T>, ImmutableSet<T>> toImmutableSet() {
        return (Collector) IMMUTABLE_SET_COLLECTOR;
    }
}
