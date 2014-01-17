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
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;
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

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(10)
public class Allocation {

    @GenerateMicroBenchmark
    public Object p000() {
        return new P0();
    }

    @GenerateMicroBenchmark
    public Object p001() {
        return new P1();
    }

    @GenerateMicroBenchmark
    public Object p002() {
        return new P2();
    }

    @GenerateMicroBenchmark
    public Object p004() {
        return new P4();
    }

    @GenerateMicroBenchmark
    public Object p008() {
        return new P8();
    }

    @GenerateMicroBenchmark
    public Object p016() {
        return new P16();
    }

    @GenerateMicroBenchmark
    public Object p032() {
        return new P32();
    }

    @GenerateMicroBenchmark
    public Object p064() {
        return new P64();
    }

    @GenerateMicroBenchmark
    public Object f000() {
        return new F0();
    }

    @GenerateMicroBenchmark
    public Object f001() {
        return new F1();
    }

    @GenerateMicroBenchmark
    public Object f002() {
        return new F2();
    }

    @GenerateMicroBenchmark
    public Object f004() {
        return new F4();
    }

    @GenerateMicroBenchmark
    public Object f008() {
        return new F8();
    }

    @GenerateMicroBenchmark
    public Object f016() {
        return new F16();
    }

    @GenerateMicroBenchmark
    public Object f032() {
        return new F32();
    }

    @GenerateMicroBenchmark
    public Object f064() {
        return new F64();
    }

}
