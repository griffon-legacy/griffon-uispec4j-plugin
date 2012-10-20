/*
 * Copyright 2011-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Andres Almiray
 */
class Uispec4jGriffonPlugin {
    // the plugin version
    String version = '1.0.0'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '1.0.0 > *'
    // the other plugins this plugin depends on
    Map dependsOn = [swing: '1.0.0']
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'Apache Software License 2.0'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, gtk
    List toolkits = ['swing']
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-fest-plugin'

    List authors = [
            [
                    name: 'Andres Almiray',
                    email: 'aalmiray@yahoo.com'
            ]
    ]
    String title = 'Enables testing with UISpec4j'
    // accepts Markdown syntax. See http://daringfireball.net/projects/markdown/ for details
    String description = '''
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
'''
}