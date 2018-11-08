# java11-optional
Java 9, 10, 11 Optional API news overview.

_Reference_: http://iteratrlearning.com/java9/2016/09/05/java9-optional.html

# preface
## java 9
* `public void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction)` -
it is a way of simplifying such task:
    ```
    Optional<Person> person = get(...);
    if (person.isPresent()) {
        render(person.get());
    } else {
        renderEmpty();
    }
    ```
    just to:
    ```
    get(...).ifPresentOrElse(X::render, X::renderEmpty)
    ```
* `public Optional<T> or(Supplier<? extends Optional<? extends T>> supplier)` - 
it is a way of simplifying:
    **assumptions**:
    ```
    Optional<Person> findByName(...)
    Optional<Person> findById(...)
    ```
    then something like this:
    ```
    Optional<Person> person = 
        Optional.ofNullable(
            findByName(person.getName())
            .orElseGet(() -> findById(person.getId())
        ));
    ```
    could be rewritten just to:
    ```
    Optional<Person> person = 
                findByName(person.getName())
                .or(() -> findById(person.getId());
    ```
* `public Stream<T> stream()` - please refer my other github project:
[java-converting-optionals-list](https://github.com/mtumilowicz/java-converting-optionals-list)

## java 10
* `public T orElseThrow()` - exact copy of `get()` but with more
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
    
    _Remark_: `get()` will be deprecated: http://mail.openjdk.java.net/pipermail/core-libs-dev/2016-April/040531.html

## java 11
* `public boolean isEmpty()` ~ !isPresent()
    * isPresent()
        ```
        public boolean isPresent() {
                return value != null;
        }
        ```
    * isEmpty()
        ```
        public boolean isEmpty() {
            return value == null;
        }
        ```

# project description
We provide tests for mentioned above methods.