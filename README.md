
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com)
[![License](https://img.shields.io/badge/license-Apache--2.0-blue.svg)](https://github.com/beryx-gist/badass-jar-example-nqueens/blob/master/LICENSE)
[![Build Status](https://img.shields.io/travis/beryx-gist/badass-jar-example-nqueens/master.svg?label=Build)](https://travis-ci.org/beryx-gist/badass-jar-example-nqueens)

## Badass-Jar example N-Queens ##

A simple project that shows how to use the [Badass Jar Plugin](https://github.com/beryx/badass-jar-plugin/).
It implements a library for solving the [N-Queens problem](https://en.wikipedia.org/wiki/Eight_queens_puzzle).


The plugin is configured in `build.gradle` as follows:

```
plugins {
    id 'java'
    id "org.beryx.jar" version "1.0.0"
    ...
}
...
sourceCompatibility = 1.8
...
```

### Usage
To build a modular jar that targets Java 8 execute:
```
./gradlew build
```
The above command does not check the validity of `module-info.java`.
You can convince yourself of this by replacing the content of `module-info.java` with: 
```
module foo.bar {
    exports bar.foo;
    requires baz.qux;
}
```
The above gradle command will still succeed, although the new `module-info.java` is invalid.


To check the validity of `module-info.java` execute:
```
./gradlew -PjavaCompatibility=11 build
```

Note that [Travis](https://github.com/beryx-gist/badass-jar-example-nqueens/blob/master/travis-build.sh) is configured
to run gradle both with and without the `javaCompatibility` project property: 
```
./gradlew -PjavaCompatibility=11 --no-daemon -i -s build
./gradlew --no-daemon -i -s build
```
