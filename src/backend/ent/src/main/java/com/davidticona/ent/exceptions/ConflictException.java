package com.davidticona.ent.exceptions;

import java.util.LinkedList;
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
public class ConflictException extends RuntimeException {
    private final List<String> errorMessages;
}
