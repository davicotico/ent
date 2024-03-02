package com.davidticona.ent.exceptions;

import java.util.Set;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Data
@RequiredArgsConstructor
public class ObjectNotValidException extends RuntimeException {

    private final Set<String> errorMessages;
}
