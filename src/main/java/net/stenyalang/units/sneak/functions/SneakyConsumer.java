package net.stenyalang.units.sneak.functions;

/**
 * The interface Sneaky consumer.
 *
 * @param <T> the type parameter
 */
@FunctionalInterface
public interface SneakyConsumer<T> {
    /**
     * Accept.
     *
     * @param var1 the var 1
     * @throws Exception the exception
     */
    void accept(T var1) throws Exception;
}
