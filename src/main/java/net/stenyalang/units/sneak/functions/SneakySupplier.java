package net.stenyalang.units.sneak.functions;

/**
 * The interface Sneaky supplier.
 *
 * @param <T> the type parameter
 */
@FunctionalInterface
public interface SneakySupplier<T> {
    /**
     * Get t.
     *
     * @return the t
     * @throws Exception the exception
     */
    T get() throws Exception;
}
