package com.erp.assignment.question1.controller;

import com.erp.assignment.question1.model.PrimeMessage;
import com.erp.assignment.question1.primeUtils.EratosthenesSieveUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PrimeController {

    @GetMapping("/getprimes/{upperBound}")
    PrimeMessage getPrimes(@PathVariable(value="upperBound") Integer upperBound) throws ValidationException {
        if (upperBound <= EratosthenesSieveUtil.MAX_INT_REQUEST) {
            List<Integer> primes = EratosthenesSieveUtil.runEratosthenesSieve(upperBound);
            return new PrimeMessage(upperBound, primes.size(), primes);
        } else {
            throw new ValidationException("System only accepts a maximum value of 10 million");
        }
    }

    @ExceptionHandler(ValidationException.class)
    ResponseEntity<String> exceptionHandler(ValidationException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
