package org.sample.init.specs;

import org.openjdk.jmh.annotations.CompilerControl;

@CompilerControl(CompilerControl.Mode.INLINE)
public class P2 {
    public int f1, f2;
    public P2() {
        f1 = f2 = 42;
    }
}
