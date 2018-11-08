# java11-optional
Java 9, 10, 11 Optional API news overview.

_Reference_: http://iteratrlearning.com/java9/2016/09/05/java9-optional.html

# preface
## java 9
* public void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction)
* public Optional<T> or(Supplier<? extends Optional<? extends T>> supplier)
* public Stream<T> stream() - please refer my other github project:
[java-converting-optionals-list](https://github.com/mtumilowicz/java-converting-optionals-list)
## java 10
* public T orElseThrow() - exact copy of `get()` but with more
meaningful name:
    * **get()**
    ```
    public T get() {
        if (value == null) {
            throw new NoSuchElementException("No value present");
        }
        return value;
    }    
    ```
    * **orElseThrow()**
    ```
    public T orElseThrow() {
        if (value == null) {
            throw new NoSuchElementException("No value present");
        }
        return value;
    }    
    ```
    _Remark_: https://twitter.com/briangoetz/status/665239052380012548?lang=en
    > In hindsight, calling it get was a (my) mistake. 
    Just too easy to call get() w/o thinking.
    
    > @BrianGoetz

## java 11
* public boolean isEmpty() - !isPresent()
    ```
    public boolean isEmpty() {
            return value == null;
        }
    ```

# project description
We provide tests for mentioned above methods.