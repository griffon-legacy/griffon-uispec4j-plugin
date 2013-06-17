
Enables testing with UISpec4j
-----------------------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/uispec4j](http://artifacts.griffon-framework.org/plugin/uispec4j)


Enables UI testing with [UISpec4J][1]. UISpec4J is an Open Source functional and/or unit testing library for
Swing-based Java applications.

Usage
-----

Tests are run just like normal Griffon tests via grails `test-app`.

Every UISpec4j test must initialize the application properly and cleanup any resources after each test method has run.
The base UISpec4j testcase enforces this by making the following methods final: `setUp()`, `tearDown()`. However you may
perform additional steps during those phases by overriding `onSetup()` and `onTearDown()` respectively.
Here as a sample testcase that demonstrates UISpec4j in action

        package dictionary
        import org.uispec4j.*
        import griffon.uispec4j.GriffonUISpecTestCase
        class DictionaryUiTests extends GriffonUISpecTestCase {
            void testInitialState() {
                 not(getMainWindow().getButton('search').isEnabled())
            }
 
            void testWordIsFound() {
                 Window window = getMainWindow()
                 window.getTextBox('word').text = 'griffon'
                 window.getButton('search').click()
                 assertThat(window.getTextBox('result')
                                  .textEquals('griffon: Grails inspired desktop application development platform.'))
            }
 
            void testWordIsNotFound() {
                 Window window = getMainWindow()
                 window.getTextBox('word').text = 'spock'
                 window.getButton('search').click()
                 assertThat(window.getTextBox('result')
                                  .textEquals("spock: Word doesn't exist in dictionary"))
            }
        }

Scripts
-------

 * **create-uispec-test** - creates a new UISpec4j enabled integration test


[1]: http://www.uispec4j.org/

