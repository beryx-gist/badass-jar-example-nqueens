[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com)
[![License](https://img.shields.io/badge/license-Apache--2.0-blue.svg)](https://github.com/beryx-gist/badass-jar-example-nqueens/blob/master/LICENSE)
[![Build Status](https://img.shields.io/github/workflow/status/beryx-gist/badass-jar-example-nqueens/build)](https://github.com/beryx-gist/badass-jar-example-nqueens/actions?query=workflow%22build%22)

## Badass-Jar example N-Queens ##

A simple project that shows how to use the [Badass Jar Plugin](https://github.com/beryx/badass-jar-plugin/).
It implements a library for solving the [N-Queens problem](https://en.wikipedia.org/wiki/Eight_queens_puzzle).


The plugin is configured in `build.gradle` as follows:

```
plugins {
    id 'java'
    id "org.beryx.jar" version "2.0.0-rc-1"
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

Note that [the GitHub Actions](https://github.com/beryx-gist/badass-jar-example-nqueens/actions) are configured to run Gradle both with and without the `javaCompatibility` project property:
```
./gradlew -PjavaCompatibility=11 build
./gradlew build
```
