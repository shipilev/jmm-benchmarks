package org.sample.init.specs;

import org.openjdk.jmh.annotations.CompilerControl;

@CompilerControl(CompilerControl.Mode.INLINE)
public class F8 {
    public final int f1, f2, f3, f4, f5, f6, f7, f8;
    public F8() {
        f1 = f2 = f3 = f4 = f5 = f6 = f7 = f8 = 42;
    }
}
