package org.sample.init.specs;

import org.openjdk.jmh.annotations.CompilerControl;

@CompilerControl(CompilerControl.Mode.INLINE)
public class F32 {
    public final int f01, f02, f03, f04, f05, f06, f07, f08, f09;
    public final int f10, f11, f12, f13, f14, f15, f16, f17, f18, f19;
    public final int f20, f21, f22, f23, f24, f25, f26, f27, f28, f29;
    public final int f30, f31, f32;

    public F32() {
        f01 = f02 = f03 = f04 = f05 = f06 = f07 = f08 = f09 = 42;
        f10 = f11 = f12 = f13 = f14 = f15 = f16 = f17 = f18 = f19 = 42;
        f20 = f21 = f22 = f23 = f24 = f25 = f26 = f27 = f28 = f29 = 42;
        f30 = f31 = f32 = 42;
    }
}
