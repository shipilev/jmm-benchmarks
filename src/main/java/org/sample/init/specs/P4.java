package org.sample.init.specs;

import org.openjdk.jmh.annotations.CompilerControl;

@CompilerControl(CompilerControl.Mode.INLINE)
public class P4 {
    public int f1, f2, f3, f4;
    public P4() {
        f1 = f2 = f3 = f4 = 42;
    }
}
