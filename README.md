# java11-optional
Java 9, 10, 11 Optional API news overview.

_Reference_: http://iteratrlearning.com/java9/2016/09/05/java9-optional.html

# preface
## java 9
* public void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction)
* public Optional<T> or(Supplier<? extends Optional<? extends T>> supplier)
* public Stream<T> stream()
## java 10
* public T orElseThrow()
## java 11
* public boolean isEmpty()

# project description
We provide tests for mentioned above methods.