package CrownAndAnchorGame;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Automates tests that reproduce reported bugs.
 */
@RunWith(org.junit.runners.Suite.class)
@SuiteClasses(
               {
                 TestBug1.class,
                 TestBug2.class,
                 TestBug3.class
               })

public class TestBugSuite
{
 /* empty class */
}
