#!/bin/sh
mvn test -D xmlFile=smoke-test-suite.xml -D browser=chrome
mvn test -D xmlFile=smoke-test-suite.xml -D browser=edge
mvn test -D xmlFile=smoke-test-suite.xml -D browser=firefox