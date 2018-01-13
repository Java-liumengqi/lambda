package com.jnape.palatable.lambda.monoid.builtin;

import com.jnape.palatable.lambda.functions.Fn1;
import com.jnape.palatable.lambda.functions.specialized.BiPredicate;
import com.jnape.palatable.lambda.monoid.Monoid;

/**
 * A {@link Monoid} instance formed by <code>Boolean</code>. Equivalent to logical <code>||</code>.
 *
 * @see And
 * @see Monoid
 */
public class Or implements Monoid<Boolean>, BiPredicate<Boolean, Boolean> {

    private static final Or INSTANCE = new Or();

    private Or() {
    }

    @Override
    public Boolean identity() {
        return false;
    }

    @Override
    public Boolean apply(Boolean x, Boolean y) {
        return x || y;
    }

    @Override
    public boolean test(Boolean x, Boolean y) {
        return apply(x, y);
    }

    @Override
    public Or flip() {
        return this;
    }

    public static Or or() {
        return INSTANCE;
    }

    public static Fn1<Boolean, Boolean> or(Boolean x) {
        return or().apply(x);
    }

    public static Boolean or(Boolean x, Boolean y) {
        return or(x).apply(y);
    }
}