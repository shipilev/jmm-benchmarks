package org.sample.init.specs;

import org.openjdk.jmh.annotations.CompilerControl;

@CompilerControl(CompilerControl.Mode.INLINE)
public class P1 {
    public int f1;
    public P1() {
        f1 = 42;
    }
}
