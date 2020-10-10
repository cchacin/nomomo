# Decoupling in Java

## Example Application

### Sequence Diagram

![Sequence Diagram](./sequence-diagram.png)

### Class Diagram
![Class Diagram Before](./diagram-before.png)

### What's wrong with this design

- Primitives Obsession
- Shared DTOs between layers
- Coupling

## Running the Application

```shell script
$ mvn compile exec:java
```

```shell script
$ curl http://localhost:8080/commits/abcdef

Commit[message=Commit from git, filenames=[filea.txt,, fileb.txt]]
```
