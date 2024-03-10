package com.davidticona.ent.validator;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface BusinessValidator {
    <T> void validate(T objectDto);
}
