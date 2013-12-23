/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package org.sample;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Group;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.logic.Control;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class PingPong {

    @State(Scope.Group)
    public static class PlainStore {
        private int v;

        @Setup(Level.Iteration)
        public void setup() {
            v = 0;
        }
    }


    @State(Scope.Group)
    public static class VolatileStore {
        private volatile int v;

        @Setup(Level.Iteration)
        public void setup() {
            v = 0;
        }
    }

    @State(Scope.Thread)
    public static class Local1 {
        private int nextV;

        @Setup(Level.Iteration)
        public void setup() {
            nextV = 0;
        }
    }

    @State(Scope.Thread)
    public static class Local2 {
        private int nextV = 1;

        @Setup(Level.Iteration)
        public void setup() {
            nextV = 1;
        }
    }

    @Group("pingpong_plain")
    @GenerateMicroBenchmark
    public int plain1(PlainStore a, Local1 l, Control cnt) {
        int nextV = l.nextV;
        while (!cnt.stopMeasurement & a.v != nextV);
        l.nextV = nextV + 2;
        return a.v++;
    }

    @Group("pingpong_plain")
    @GenerateMicroBenchmark
    public int plain2(PlainStore a, Local2 l, Control cnt) {
        int nextV = l.nextV;
        while (!cnt.stopMeasurement & a.v != nextV);
        l.nextV = nextV + 2;
        return a.v++;
    }

    @Group("pingpong_volatile")
    @GenerateMicroBenchmark
    public int volatile1(PlainStore a, Local1 l, Control cnt) {
        int nextV = l.nextV;
        while (!cnt.stopMeasurement & a.v != nextV);
        l.nextV = nextV + 2;
        return a.v++;
    }

    @Group("pingpong_volatile")
    @GenerateMicroBenchmark
    public int volatile2(PlainStore a, Local2 l, Control cnt) {
        int nextV = l.nextV;
        while (!cnt.stopMeasurement & a.v != nextV);
        l.nextV = nextV + 2;
        return a.v++;
    }

}
