package net.stenyalang.units.sneak.functions;

/**
 * The interface Sneaky bi predicate.
 *
 * @param <T> the type parameter
 * @param <U> the type parameter
 */
@FunctionalInterface
public interface SneakyBiPredicate<T, U> {
    /**
     * Test boolean.
     *
     * @param var1 the var 1
     * @param var2 the var 2
     * @return the boolean
     * @throws Exception the exception
     */
    boolean test(T var1, U var2) throws Exception;
}
