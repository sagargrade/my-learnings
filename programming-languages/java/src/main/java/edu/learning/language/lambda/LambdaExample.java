package edu.learning.language.lambda;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import java.util.function.LongToIntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Slf4j
public class LambdaExample {

    public static void main(String[] args) {
        LambdaExample lambdaExample = new LambdaExample();
        lambdaExample.supplierFunctionalInterfaceExample();
        lambdaExample.consumerFunctionalInterfaceExample();
        lambdaExample.predicateFunctionalInterfaceExample();
        lambdaExample.functionFunctionalInterfaceExample();
    }

    public void supplierFunctionalInterfaceExample() {
        Supplier<String> supplier = () -> "Supplier";
        log.info(supplier.get());
    }

    public void consumerFunctionalInterfaceExample() {
        //Consumer<String> consumer = (text) -> log.info(text);
        Consumer<String> consumer = log::info; // Lambda replaced with method reference
        consumer.accept("Consumer");
    }

    public void predicateFunctionalInterfaceExample() {
        //Predicate<String> predicate = (text) -> text.isEmpty();
        Predicate<String> predicate = String::isEmpty; // Lambda replaced with method reference
        log.info(String.valueOf(predicate.test("Predicate")));
    }

    public void functionFunctionalInterfaceExample() {
        //Function<String, Integer> function = (text) -> text.length();
        Function<String, Integer> function = String::length; // Lambda replaced with method reference
        log.info(String.valueOf(function.apply("Function")));

        LongToIntFunction longToIntFunction = value -> (int) value % Integer.MAX_VALUE;
        log.info(String.valueOf(longToIntFunction.applyAsInt(124256L)));

        //DoubleToLongFunction doubleToLongFunction = value -> Math.round(value);
        DoubleToLongFunction doubleToLongFunction = Math::round;
        log.info(String.valueOf(doubleToLongFunction.applyAsLong(12345.67)));
    }
}
