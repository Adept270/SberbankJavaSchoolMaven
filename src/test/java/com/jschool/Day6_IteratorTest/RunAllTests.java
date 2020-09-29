package com.jschool.Day6_IteratorTest;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ParametrizedTest.class, CoreTests.class, MockTest.class})
public class RunAllTests {
    @Rule
    public TestRule timeout = new Timeout(100);

}