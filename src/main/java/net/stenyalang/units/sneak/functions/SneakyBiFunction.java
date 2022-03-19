package net.stenyalang.units.sneak.functions;

/**
 * The interface Sneaky bi function.
 *
 * @param <T> the type parameter
 * @param <U> the type parameter
 * @param <R> the type parameter
 */
@FunctionalInterface
public interface SneakyBiFunction<T, U, R> {
    /**
     * Apply r.
     *
     * @param var1 the var 1
     * @param var2 the var 2
     * @return the r
     * @throws Exception the exception
     */
    R apply(T var1, U var2) throws Exception;
}
