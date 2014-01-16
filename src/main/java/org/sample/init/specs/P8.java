package org.sample.init.specs;

import org.openjdk.jmh.annotations.CompilerControl;

@CompilerControl(CompilerControl.Mode.INLINE)
public class P8 {
    public int f1, f2, f3, f4, f5, f6, f7, f8;
    public P8() {
        f1 = f2 = f3 = f4 = f5 = f6 = f7 = f8 = 42;
    }
}
