# weldTestParametrized

The project is created as minimal example to show the problem using Weld junit5 library with **@ParameterizedTest** and **@ValueSource** junit5 annotations.

Run ServiceExampleTest and see the doesntWork() + doesntWork2() fail if @ExplicitParamInjection is missing.

In order to fix it you should use **@ExplicitParamInjection** annotation on test class.

