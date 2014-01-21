package org.sample.init;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.CompilerControl;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(10)
@State(Scope.Thread)
public class ChainedFinals {

    int value = 42;

    @GenerateMicroBenchmark
    public Object merged_1() {
        return new M1(value);
    }

    @GenerateMicroBenchmark
    public Object merged_2() {
        return new M2(value);
    }

    @GenerateMicroBenchmark
    public Object merged_3() {
        return new M3(value);
    }

    @GenerateMicroBenchmark
    public Object merged_4() {
        return new M4(value);
    }

    @GenerateMicroBenchmark
    public Object merged_5() {
        return new M5(value);
    }

    @GenerateMicroBenchmark
    public Object merged_6() {
        return new M6(value);
    }

    @GenerateMicroBenchmark
    public Object merged_7() {
        return new M7(value);
    }

    @GenerateMicroBenchmark
    public Object merged_8() {
        return new M8(value);
    }

    @GenerateMicroBenchmark
    public Object chained_plain_1() {
        return new CP1(value);
    }

    @GenerateMicroBenchmark
    public Object chained_plain_2() {
        return new CP2(value);
    }

    @GenerateMicroBenchmark
    public Object chained_plain_3() {
        return new CP3(value);
    }

    @GenerateMicroBenchmark
    public Object chained_plain_4() {
        return new CP4(value);
    }

    @GenerateMicroBenchmark
    public Object chained_plain_5() {
        return new CP5(value);
    }

    @GenerateMicroBenchmark
    public Object chained_plain_6() {
        return new CP6(value);
    }

    @GenerateMicroBenchmark
    public Object chained_plain_7() {
        return new CP7(value);
    }

    @GenerateMicroBenchmark
    public Object chained_plain_8() {
        return new CP8(value);
    }

    @GenerateMicroBenchmark
    public Object chained_final_1() {
        return new CF1(value);
    }

    @GenerateMicroBenchmark
    public Object chained_final_2() {
        return new CF2(value);
    }

    @GenerateMicroBenchmark
    public Object chained_final_3() {
        return new CF3(value);
    }

    @GenerateMicroBenchmark
    public Object chained_final_4() {
        return new CF4(value);
    }

    @GenerateMicroBenchmark
    public Object chained_final_5() {
        return new CF5(value);
    }

    @GenerateMicroBenchmark
    public Object chained_final_6() {
        return new CF6(value);
    }

    @GenerateMicroBenchmark
    public Object chained_final_7() {
        return new CF7(value);
    }

    @GenerateMicroBenchmark
    public Object chained_final_8() {
        return new CF8(value);
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class CP1 {
        int i1;
        public CP1(int i) { i1 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class CP2 extends CP1 {
        int i2;
        public CP2(int i) { super(i); i2 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class CP3 extends CP2 {
        int i3;
        public CP3(int i) { super(i); i3 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class CP4 extends CP3 {
        int i4;
        public CP4(int i) { super(i); i4 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class CP5 extends CP4 {
        int i5;
        public CP5(int i) { super(i); i5 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class CP6 extends CP5 {
        int i6;
        public CP6(int i) { super(i); i6 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class CP7 extends CP6 {
        int i7;
        public CP7(int i) { super(i); i7 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class CP8 extends CP7 {
        int i8;
        public CP8(int i) { super(i); i8 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class CF1 {
        final int i1;
        public CF1(int i) { i1 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class CF2 extends CF1 {
        final int i2;
        public CF2(int i) { super(i); i2 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class CF3 extends CF2 {
        final int i3;
        public CF3(int i) { super(i); i3 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class CF4 extends CF3 {
        final int i4;
        public CF4(int i) { super(i); i4 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class CF5 extends CF4 {
        final int i5;
        public CF5(int i) { super(i); i5 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class CF6 extends CF5 {
        final int i6;
        public CF6(int i) { super(i); i6 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class CF7 extends CF6 {
        final int i7;
        public CF7(int i) { super(i); i7 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class CF8 extends CF7 {
        final int i8;
        public CF8(int i) { super(i); i8 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class M1 {
        final int i1;
        public M1(int i) { i1 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class M2 {
        final int i1, i2;
        public M2(int i) { i1 = i2 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class M3 {
        final int i1, i2, i3;
        public M3(int i) { i1 = i2 = i3 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class M4 {
        final int i1, i2, i3, i4;
        public M4(int i) { i1 = i2 = i3 = i4 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class M5 {
        final int i1, i2, i3, i4, i5;
        public M5(int i) { i1 = i2 = i3 = i4 = i5 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class M6 {
        final int i1, i2, i3, i4, i5, i6;
        public M6(int i) { i1 = i2 = i3 = i4 = i5 = i6 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class M7 {
        final int i1, i2, i3, i4, i5, i6, i7;
        public M7(int i) { i1 = i2 = i3 = i4 = i5 = i6 = i7 = i; }
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public static class M8 {
        final int i1, i2, i3, i4, i5, i6, i7, i8;
        public M8(int i) { i1 = i2 = i3 = i4 = i5 = i6 = i7 = i8 = i; }
    }

}