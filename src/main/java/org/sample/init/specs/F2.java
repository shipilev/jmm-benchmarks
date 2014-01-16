package org.sample.init.specs;

import org.openjdk.jmh.annotations.CompilerControl;

@CompilerControl(CompilerControl.Mode.INLINE)
public class F2 {
    public final int f1, f2;
    public F2() {
        f1 = f2 = 42;
    }
}
