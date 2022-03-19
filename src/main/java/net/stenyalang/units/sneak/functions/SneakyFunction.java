package net.stenyalang.units.sneak.functions;

/**
 * The interface Sneaky function.
 *
 * @param <T> the type parameter
 * @param <R> the type parameter
 */
@FunctionalInterface
public interface SneakyFunction<T, R> {
    /**
     * Apply r.
     *
     * @param var1 the var 1
     * @return the r
     * @throws Exception the exception
     */
    R apply(T var1) throws Exception;
}
