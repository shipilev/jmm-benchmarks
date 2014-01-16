package org.sample.init.specs;

import org.openjdk.jmh.annotations.CompilerControl;

@CompilerControl(CompilerControl.Mode.INLINE)
public class P16 {
    public int f1, f2, f3, f4, f5, f6, f7, f8, f9;
    public int f10, f11, f12, f13, f14, f15, f16;

    public P16() {
        f1 = f2 = f3 = f4 = f5 = f6 = f7 = f8 = f9 = 42;
        f10 = f11 = f12 = f13 = f14 = f15 = f16 = 42;
    }
}
