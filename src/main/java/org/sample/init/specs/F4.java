package org.sample.init.specs;

import org.openjdk.jmh.annotations.CompilerControl;

@CompilerControl(CompilerControl.Mode.INLINE)
public class F4 {
    public final int f1, f2, f3, f4;
    public F4() {
        f1 = f2 = f3 = f4 = 42;
    }
}
