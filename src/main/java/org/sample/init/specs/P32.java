package org.sample.init.specs;

import org.openjdk.jmh.annotations.CompilerControl;

@CompilerControl(CompilerControl.Mode.INLINE)
public class P32 {
    public int f1, f2, f3, f4, f5, f6, f7, f8, f9;
    public int f10, f11, f12, f13, f14, f15, f16, f17, f18, f19;
    public int f20, f21, f22, f23, f24, f25, f26, f27, f28, f29;
    public int f30, f31, f32;

    public P32() {
        f1 = f2 = f3 = f4 = f5 = f6 = f7 = f8 = f9 = 42;
        f10 = f11 = f12 = f13 = f14 = f15 = f16 = f17 = f18 = f19 = 42;
        f20 = f21 = f22 = f23 = f24 = f25 = f26 = f27 = f28 = f29 = 42;
        f30 = f31 = f32 = 42;
    }
}
