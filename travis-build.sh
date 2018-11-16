#!/bin/bash
set -ev
./gradlew -PjavaCompatibility=9 --no-daemon -i -s build
./gradlew --no-daemon -i -s build
