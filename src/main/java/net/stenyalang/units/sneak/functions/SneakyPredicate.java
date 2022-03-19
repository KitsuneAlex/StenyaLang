package net.stenyalang.units.sneak.functions;

/**
 * The interface Sneaky predicate.
 *
 * @param <T> the type parameter
 */
@FunctionalInterface
public interface SneakyPredicate<T> {
    /**
     * Test boolean.
     *
     * @param var1 the var 1
     * @return the boolean
     * @throws Exception the exception
     */
    boolean test(T var1) throws Exception;
}
