package com.lyc.homebasespringboot.utilities;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * Customized gson exclusion strategy to remove the password field when serializing.
 */
public class GsonPasswordExclusionStrategy implements ExclusionStrategy {
    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return f.getName().contains("password");
    }

    @Override
    public boolean shouldSkipClass(Class<?> incomingClass) {
        return false;
    }
}
