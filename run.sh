#!/bin/sh
mvn clean install
vertx uninstall com.leanscope~cljmod~1.0-SNAPSHOT
vertx runmod com.leanscope~cljmod~1.0-SNAPSHOT