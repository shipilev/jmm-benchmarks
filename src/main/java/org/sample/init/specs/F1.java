package org.sample.init.specs;

import org.openjdk.jmh.annotations.CompilerControl;

@CompilerControl(CompilerControl.Mode.INLINE)
public class F1 {
    public final int f1;
    public F1() {
        f1 = 42;
    }
}
