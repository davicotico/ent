package com.davidticona.ent.exceptions;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Getter
@Setter
@RequiredArgsConstructor
public class ObjectNotValidException extends RuntimeException {

    private final List<String> errorMessages;
}
