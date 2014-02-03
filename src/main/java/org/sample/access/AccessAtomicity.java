package org.sample.access;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(10)
public class AccessAtomicity {

    static final Unsafe U;
    static final long VOL_INT_OFFSET, VOL_LONG_OFFSET;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            U = (Unsafe) f.get(null);

            VOL_INT_OFFSET = U.objectFieldOffset(AccessAtomicity.class.getDeclaredField("volatileInt"));
            VOL_LONG_OFFSET = U.objectFieldOffset(AccessAtomicity.class.getDeclaredField("volatileLong"));

        } catch (NoSuchFieldException e) {
            throw new IllegalStateException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

    private int sinkInt;
    private int plainInt;
    private volatile int volatileInt;

    private long sinkLong;
    private long plainLong;
    private volatile long volatileLong;

    private float sinkFloat;
    private float plainFloat;
    private volatile float volatileFloat;

    private double sinkDouble;
    private double plainDouble;
    private volatile double volatileDouble;

    // ---------------------------------------------

    @GenerateMicroBenchmark
    public void read_plain_int() {
        sinkInt = plainInt;
    }

    @GenerateMicroBenchmark
    public void read_volatile_int() {
        sinkInt = volatileInt;
    }

    @GenerateMicroBenchmark
    public void write_plain_int() {
        plainInt = 42;
        sinkInt = 42;
    }

    @GenerateMicroBenchmark
    public void write_volatile_int() {
        volatileInt = 42;
        sinkInt = 42;
    }

    @GenerateMicroBenchmark
    public void write_ordered_int() {
        U.putOrderedInt(this, VOL_INT_OFFSET, 42);
        sinkInt = 42;
    }

    // ---------------------------------------------

    @GenerateMicroBenchmark
    public void read_plain_long() {
        sinkLong = plainLong;
    }

    @GenerateMicroBenchmark
    public void read_volatile_long() {
        sinkLong = volatileLong;
    }

    @GenerateMicroBenchmark
    public void write_plain_long() {
        plainLong = 42L;
        sinkLong = 42L;
    }

    @GenerateMicroBenchmark
    public void write_volatile_long() {
        volatileLong = 42L;
        sinkLong = 42L;
    }

    @GenerateMicroBenchmark
    public void write_ordered_long() {
        U.putOrderedLong(this, VOL_LONG_OFFSET, 42L);
        sinkLong = 42L;
    }

    // ---------------------------------------------

    @GenerateMicroBenchmark
    public void read_plain_float() {
        sinkFloat = plainFloat;
    }

    @GenerateMicroBenchmark
    public void read_volatile_float() {
        sinkFloat = volatileFloat;
    }

    @GenerateMicroBenchmark
    public void write_plain_float() {
        plainFloat = 42F;
        sinkFloat = 42F;
    }

    @GenerateMicroBenchmark
    public void write_volatile_float() {
        volatileFloat = 42F;
        sinkFloat = 42F;
    }

    // ---------------------------------------------

    @GenerateMicroBenchmark
    public void read_plain_double() {
        sinkDouble = plainDouble;
    }

    @GenerateMicroBenchmark
    public void read_volatile_double() {
        sinkDouble = volatileDouble;
    }

    @GenerateMicroBenchmark
    public void write_plain_double() {
        plainDouble = 42D;
        sinkDouble = 42D;
    }

    @GenerateMicroBenchmark
    public void write_volatile_double() {
        volatileDouble = 42D;
        sinkDouble = 42D;
    }

}
