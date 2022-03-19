package net.stenyalang.units;

/**
 * The type Multi replacement.
 */
public class MultiReplacement {

    /**
     * Strip string.
     *
     * @param original the original
     * @param toRemove the to remove
     * @return the string
     */
    public static String strip(final String original, final String... toRemove) {
        return replaceWith(original, "", toRemove);
    }

    /**
     * Replace with string.
     *
     * @param original       the original
     * @param replaceContext the replace context
     * @param toReplace      the to replace
     * @return the string
     */
    public static String replaceWith(final String original, final String replaceContext, final String... toReplace) {
        String copied = original.trim();
        for (String current : toReplace) {
            copied = copied.replace(current, replaceContext);
        }
        return copied;
    }

}
