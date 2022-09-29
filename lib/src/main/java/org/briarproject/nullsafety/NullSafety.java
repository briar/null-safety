package org.briarproject.nullsafety;

import javax.annotation.Nullable;

/**
 * Helper method for ensuring null safety.
 */
@NotNullByDefault
public class NullSafety {

	/**
	 * Stand-in for {@code Objects.requireNonNull()} on older Java/Android versions.
	 *
	 * @throws NullPointerException If the argument is null.
	 */
	public static <T> T requireNonNull(@Nullable T t) {
		if (t == null) throw new NullPointerException();
		return t;
	}

	/**
	 * Checks that exactly one of the arguments is null.
	 *
	 * @throws AssertionError If both or neither of the arguments are null
	 */
	public static void requireExactlyOneNull(@Nullable Object a, @Nullable Object b) {
		if ((a == null) == (b == null)) throw new AssertionError();
	}

	/**
	 * Checks that the argument is null.
	 *
	 * @throws AssertionError If the argument is not null.
	 */
	public static void requireNull(@Nullable Object o) {
		if (o != null) throw new AssertionError();
	}

	/**
	 * Stand-in for {@code Objects.equals()} on older Java/Android versions.
	 *
	 * @return True if both arguments are null, or if the arguments are the same object, or if
	 * 		neither argument is null and {@code a.equals(b)}.
	 */
	public static boolean equals(@Nullable Object a, @Nullable Object b) {
		return (a == b) || (a != null && a.equals(b));
	}

}
