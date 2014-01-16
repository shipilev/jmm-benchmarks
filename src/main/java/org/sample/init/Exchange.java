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

package org.sample.init;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Group;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.logic.Control;
import org.sample.init.specs.F0;
import org.sample.init.specs.F1;
import org.sample.init.specs.F16;
import org.sample.init.specs.F2;
import org.sample.init.specs.F32;
import org.sample.init.specs.F4;
import org.sample.init.specs.F64;
import org.sample.init.specs.F8;
import org.sample.init.specs.P0;
import org.sample.init.specs.P1;
import org.sample.init.specs.P16;
import org.sample.init.specs.P2;
import org.sample.init.specs.P32;
import org.sample.init.specs.P4;
import org.sample.init.specs.P64;
import org.sample.init.specs.P8;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class Exchange {

    @State(Scope.Group)
    public static class Arena {
        F4 obj;
    }

    @Group("g")
    @GenerateMicroBenchmark
    public void injector(Control cnt, Arena a) {
        while (!cnt.stopMeasurement & a.obj != null); // busy wait for slot
        a.obj = new F4();
    }

    @Group("g")
    @GenerateMicroBenchmark
    public int acceptor(Control cnt, Arena a) {
        F4 obj;
        while (!cnt.stopMeasurement & (obj = a.obj) == null); // busy wait for slot
        int s = obj.f1 + obj.f2 + obj.f3 + obj.f4;
        a.obj = null;
        return s;
    }


}
