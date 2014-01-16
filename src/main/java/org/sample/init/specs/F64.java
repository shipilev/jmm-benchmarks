package org.sample.init.specs;

import org.openjdk.jmh.annotations.CompilerControl;

@CompilerControl(CompilerControl.Mode.INLINE)
public class F64 {
    public final int f01, f02, f03, f04, f05, f06, f07, f08, f09;
    public final int f10, f11, f12, f13, f14, f15, f16, f17, f18, f19;
    public final int f20, f21, f22, f23, f24, f25, f26, f27, f28, f29;
    public final int f30, f31, f32, f33, f34, f35, f36, f37, f38, f39;
    public final int f40, f41, f42, f43, f44, f45, f46, f47, f48, f49;
    public final int f50, f51, f52, f53, f54, f55, f56, f57, f58, f59;
    public final int f60, f61, f62, f63, f64;

    public F64() {
        f01 = f02 = f03 = f04 = f05 = f06 = f07 = f08 = f09 = 42;
        f10 = f11 = f12 = f13 = f14 = f15 = f16 = f17 = f18 = f19 = 42;
        f20 = f21 = f22 = f23 = f24 = f25 = f26 = f27 = f28 = f29 = 42;
        f30 = f31 = f32 = f33 = f34 = f35 = f36 = f37 = f38 = f39 = 42;
        f40 = f41 = f42 = f43 = f44 = f45 = f46 = f47 = f48 = f49 = 42;
        f50 = f51 = f52 = f53 = f54 = f55 = f56 = f57 = f58 = f59 = 42;
        f60 = f61 = f62 = f63 = f64 = 42;
    }
}
