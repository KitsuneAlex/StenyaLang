package net.stenyalang.units.sneak;

import net.stenyalang.units.sneak.functions.*;

import java.util.function.*;

/**
 * Name: SneakyThrow
 * Date: 24.08.2021
 * Project: FurryLang
 * Author: CryCodes | Nils Luca Schrock
 */
public final class SneakyThrow {

    /**
     * Sneak t.
     *
     * @param <T>      the type parameter
     * @param supplier the supplier
     * @return the t
     */
    public static <T> T sneak(SneakySupplier<T> supplier) {
        return sneaky(supplier).get();
    }

    /**
     * Sneaky bi function.
     *
     * @param <T>        the type parameter
     * @param <U>        the type parameter
     * @param <R>        the type parameter
     * @param biFunction the bi function
     * @return the bi function
     */
    public static <T, U, R> BiFunction<T, U, R> sneaky(SneakyBiFunction<T, U, R> biFunction) {
        return (t, u) -> {
            try {
                return biFunction.apply(t, u);
            } catch (final Exception exception) {
                throw new SneakyException(exception);
            }
        };
    }

    /**
     * Sneaky binary operator.
     *
     * @param <T>            the type parameter
     * @param binaryOperator the binary operator
     * @return the binary operator
     */
    public static <T> BinaryOperator<T> sneaky(SneakyBinaryOperator<T> binaryOperator) {
        return (t1, t2) -> {
            try {
                return binaryOperator.apply(t1, t2);
            } catch (final Exception exception) {
                throw new SneakyException(exception);
            }
        };
    }

    /**
     * Sneaky bi predicate.
     *
     * @param <T>         the type parameter
     * @param <U>         the type parameter
     * @param biPredicate the bi predicate
     * @return the bi predicate
     */
    public static <T, U> BiPredicate<T, U> sneaky(SneakyBiPredicate<T, U> biPredicate) {
        return (t, u) -> {
            try {
                return biPredicate.test(t, u);
            } catch (final Exception exception) {
                throw new SneakyException(exception);
            }
        };
    }

    /**
     * Sneaky consumer.
     *
     * @param <T>      the type parameter
     * @param consumer the consumer
     * @return the consumer
     */
    public static <T> Consumer<T> sneaky(SneakyConsumer<T> consumer) {
        return (t) -> {
            try {
                consumer.accept(t);
            } catch (final Exception var3) {
                throw new SneakyException(var3);
            }
        };
    }

    /**
     * Sneaky function.
     *
     * @param <T>      the type parameter
     * @param <R>      the type parameter
     * @param function the function
     * @return the function
     */
    public static <T, R> Function<T, R> sneaky(SneakyFunction<T, R> function) {
        return (t) -> {
            try {
                return function.apply(t);
            } catch (final Exception var3) {
                throw new SneakyException(var3);
            }
        };
    }

    /**
     * Sneaky predicate.
     *
     * @param <T>       the type parameter
     * @param predicate the predicate
     * @return the predicate
     */
    public static <T> Predicate<T> sneaky(SneakyPredicate<T> predicate) {
        return (t) -> {
            try {
                return predicate.test(t);
            } catch (final Exception var3) {
                throw new SneakyException(var3);
            }
        };
    }

    /**
     * Sneaky runnable.
     *
     * @param runnable the runnable
     * @return the runnable
     */
    public static Runnable sneaky(SneakyRunnable runnable) {
        return () -> {
            try {
                runnable.run();
            } catch (final Exception var2) {
                throw new SneakyException(var2);
            }
        };
    }

    /**
     * Sneaky supplier.
     *
     * @param <T>      the type parameter
     * @param supplier the supplier
     * @return the supplier
     */
    public static <T> Supplier<T> sneaky(SneakySupplier<T> supplier) {
        return () -> {
            try {
                return supplier.get();
            } catch (final Exception var2) {
                throw new SneakyException(var2);
            }
        };
    }

    /**
     * Sneaky unary operator.
     *
     * @param <T>           the type parameter
     * @param unaryOperator the unary operator
     * @return the unary operator
     */
    public static <T> UnaryOperator<T> sneaky(SneakyUnaryOperator<T> unaryOperator) {
        return (t) -> {
            try {
                return unaryOperator.apply(t);
            } catch (final Exception var3) {
                throw new SneakyException(var3);
            }
        };
    }

}
