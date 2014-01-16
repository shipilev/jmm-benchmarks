package org.sample;

import org.openjdk.jmh.logic.results.RunResult;
import org.openjdk.jmh.output.OutputFormatType;
import org.openjdk.jmh.runner.BenchmarkRecord;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.VerboseMode;
import org.openjdk.jmh.runner.parameters.TimeValue;

import java.util.SortedMap;

public class Main {

    public static void main(String[] args) throws RunnerException {
        boolean headerPrinted = false;

        for (int t = 1; t <= Runtime.getRuntime().availableProcessors(); t++) {
            Options opt = new OptionsBuilder()
                    .include(".*")
                    .measurementIterations(5)
                    .measurementTime(TimeValue.seconds(1))
                    .warmupIterations(5)
                    .warmupTime(TimeValue.seconds(1))
                    .forks(5)
                    .threads(t)
                    .verbosity(VerboseMode.SILENT)
                    .build();

            SortedMap<BenchmarkRecord, RunResult> results = new Runner(opt).run();

            if (!headerPrinted) {
                System.out.print("threads, ");
                for (BenchmarkRecord br: results.keySet()) {
                    System.out.print(br.getUsername() + ", ");
                    System.out.print(br.getUsername() + ":error, ");
                }
                System.out.println();
                headerPrinted = true;
            }

            System.out.printf("%d, ", t);
            for (BenchmarkRecord br : results.keySet()) {
                RunResult result = results.get(br);
                System.out.printf("%.3f, %.3f, ", result.getPrimaryResult().getScore(), result.getPrimaryResult().getStatistics().getMeanErrorAt(0.99));
            }
            System.out.println();
        }

    }

}
