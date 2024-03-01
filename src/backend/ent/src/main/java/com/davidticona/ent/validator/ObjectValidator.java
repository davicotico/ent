package com.davidticona.ent.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Component
public class ObjectValidator<T> {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public Set<String> validate(T objectDto) {
        Set<ConstraintViolation<T>> errors = validator.validate(objectDto);
        if (!errors.isEmpty()) {
            return errors.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());
        }
        return Collections.emptySet();
    }
}
