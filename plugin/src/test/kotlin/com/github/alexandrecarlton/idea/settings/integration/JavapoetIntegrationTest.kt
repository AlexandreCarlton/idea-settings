package com.github.alexandrecarlton.idea.settings.integration

import org.assertj.core.api.Assertions
import org.junit.BeforeClass
import org.junit.Ignore
import org.junit.Test
import java.nio.file.Path
import java.nio.file.Paths

/**
 * An integration test designed to test as much end-to-end as possible, to verify that we are actually modifying is
 * persisted.
 */
class JavapoetIntegrationTest : AbstractIntegrationTest() {

    companion object {

        @JvmStatic
        @BeforeClass
        fun setUpClass() {
            setUpClass("javapoet", """
                Project Settings:
                  Project:
                    Project name: my-project-name
                    Project SDK: my-project-sdk
                    Project language level: '6'
                  Modules:
                    - Name: javapoet
                      Sources:
                        - Content Root: .
                          Sources:
                            - Root: src/main/java
                              Properties:
                                Package prefix: foo
                                For generated sources: true

                Build, Execution, Deployment:
                  Build Tools:
                    Maven:
                      Importing:
                        VM options for importer: -Xmx1g
                      Thread count: 1C
                      Maven home directory: maven-bin
                  Compiler:
                    Resource patterns:
                      - '!?*.java'
                      - '!resource.properties'
                    Add runtime assertions for notnull-annotated methods and parameters: false
                    Nullable/NotNull Configuration:
                      Nullable annotations:
                        Annotation used for code generation: javax.annotation.Nullable
                        Annotations:
                          - javax.annotation.Nullable
                          - javax.annotation.CheckForNull
                          - my.fake.annotation.Nullable
                      NotNull annotations:
                        Annotation used for code generation: javax.annotation.Nonnull
                        Annotations:
                          - Annotation: javax.annotation.Nonnull
                            Instrument: true
                          - Annotation: androidx.annotation.Nonnull
                            Instrument: false
                          - Annotation: my.fake.annotation.Nonnull
                            Instrument: true
                    Build process heap size (Mbytes): 1234
                    Compile independent modules in parallel: true
                    Rebuild module on dependency change: false
                    Shared build process VM options: -Xms123m
                  Required Plugins:
                    - Plugin: CheckStyle-IDEA
                      Minimum version: 5.23.0
                      Maximum version: 5.24.1
                Editor:
                  Code Style:
                    Java:
                      Blank Lines:
                        Keep Maximum Blank Lines:
                          In declarations: 10
                          In code: 11
                          Before '}': 12
                          Between header and package: 13
                        Minimum Blank Lines:
                          Before package statement: 14
                          After package statement: 15
                          Before imports: 16
                          After imports: 17
                          Around class: 18
                          After class header: 19
                          Before class end: 20
                          After anonymous class header: 21
                          Around field in interface: 22
                          Around field: 23
                          Around method in interface: 24
                          Around method: 25
                          Before method body: 26
                          Around initializer: 27
                      JavaDoc:
                        Alignment:
                          Align parameter descriptions: false
                          Align thrown exception descriptions: false
                        Blank lines:
                          After description: false
                          After parameter descriptions: true
                          After return tag: true
                        Invalid tags:
                          Keep invalid tags: false
                          Keep empty @param tags: false
                          Keep empty @return tags: false
                          Keep empty @throws tags: false
                        Other:
                          Wrap at right margin: true
                          Enable leading asterisks: false
                          Use @throws rather than @exception: false
                          Generate '<p>' on empty lines: false
                          Keep empty lines: false
                          Do not wrap one line comments: true
                          Preserve line feeds: true
                          Parameter descriptions on new line: true
                          Indent continuation lines: true
                      Arrangement:
                        Matching rules:
                          - Type: field
                            Modifier:
                              - public
                              - static
                          - Type: class
                            Modifier:
                              - not protected
                            Name: unprotected class
                            Order: order by name
                      Imports:
                        Class count to use import with '*': 123
                        Names count to use static import with '*': 456
                  General:
                    Auto Import:
                      Java:
                        Optimize imports on the fly (for current project): true
                        Exclude from import and completion:
                          - com.google.inject.Inject
                          - com.sun.istack.internal.Nullable
                  Inspections:
                    Java:
                      Javadoc:
                        Missing @Deprecated annotation:
                          Enabled: true
                          Severity by Scope:
                            - Scope: In All Scopes
                              Severity: Error
                              Options:
                                Warn on missing @deprecated Javadoc tag explanation: true
                  Spelling:
                    Dictionaries:
                      - dict.dic
                    Accepted Words:
                      - abcd
                      - efgh
                Tools:
                  SonarLint:
                    Project Settings:
                      Bind to SonarQube / SonarCloud:
                        Bind project to SonarQube / SonarCloud: true
                        Project binding:
                          Connection: My Sonar Instance
                          Project: my_project
                      File Exclusions:
                        - Exclude file: LICENSE.txt
                        - Exclude directory: node_modules
                        - Exclude using GLOB pattern: '**/*.txt'
                      Analysis properties:
                        - Property Name: My Property
                          Value: My Value
                Other Settings:
                  Checkstyle:
                    Checkstyle version: '8.16'
                    Scan Scope: Only Java sources (including tests)
                    Treat Checkstyle errors as warnings: true
                    Configuration files:
                      - Active: true
                        Description: Javapoet Checkstyle
                        File: checkstyle.xml
                    Third-Party Checks:
                      - lib/checkstyle-custom-1.jar
                      - lib/checkstyle-custom-2.jar
                  Save Actions:
                    Formatting Actions:
                      Optimize imports: true
                Run/Debug Configurations:
                  - Application:
                      Name: Application Configuration
                      Share through VCS: true
                      Configuration:
                        Main class: com.Application
                        Use classpath of module: javapoet
                        VM options: -Xmx1g
                        Program arguments: foo bar
                        Working directory: src
                  - Shell Script:
                      Name: Shell Script
                      Share through VCS: true
                      Script path: maven-bin/bin/mvn
                      Script options: --version
                      Interpreter:
                        Interpreter path: /bin/sh
                        Interpreter options: -e
                  - Remote:
                      Name: Remote Configuration
                      Share through VCS: true
                      Configuration:
                        Host: 8.8.8.8
                        Port: 5000
                      Before launch:
                        - Run Another Configuration:
                            Name: Shell Script""".trimIndent())
            driver.scratchFile("javapoet/dict.dic")
            runIdeaSettings()
        }
    }

    @Test
    fun projectName() {
        Assertions.assertThat(path.resolve(".idea/.name"))
            .hasContent("my-project-name")
    }

    @Test
    fun projectSdk() {
        assertThatXml(".idea/misc.xml")
            .valueByXPath("//component[@name='ProjectRootManager']/@project-jdk-name")
            .isEqualTo("my-project-sdk")
    }

    @Test
    fun projectLanguageLevel() {
        assertThatXml(".idea/misc.xml")
            .valueByXPath("//component[@name='ProjectRootManager']/@languageLevel")
            .isEqualTo("JDK_1_6")
    }

    @Test
    fun packagePrefixForExistingModule() {
        assertThatXml("javapoet.iml")
            .valueByXPath("//sourceFolder[@url='file://\$MODULE_DIR$/src/main/java']/@packagePrefix")
            .isEqualTo("foo")
    }

    @Test
    fun forGeneratedSourcesForExistingModule() {
        assertThatXml("javapoet.iml")
                .valueByXPath("//sourceFolder[@url='file://\$MODULE_DIR$/src/main/java']/@generated")
                .asBoolean()
                .isTrue()
    }

    @Test
    fun buildProcessHeapSize() {
        assertThatXml(".idea/compiler.xml")
            .valueByXPath("//component[@name='CompilerConfiguration']/option[@name='BUILD_PROCESS_HEAP_SIZE']/@value")
            .asInt()
            .isEqualTo(1234)
    }

    @Test
    fun compileIndependentModulesInParallel() {
        assertThatXml(".idea/workspace.xml")
            .valueByXPath("//component[@name='CompilerWorkspaceConfiguration']/option[@name='PARALLEL_COMPILATION']/@value")
            .asBoolean()
            .isTrue()
    }

    @Test
    fun rebuildModuleOnDependencyChange() {
        assertThatXml(".idea/workspace.xml")
            .valueByXPath("//component[@name='CompilerWorkspaceConfiguration']/option[@name='REBUILD_ON_DEPENDENCY_CHANGE']/@value")
            .asBoolean()
            .isFalse()
    }

    @Test
    fun sharedBuildProcessVmOptions() {
        assertThatXml(".idea/compiler.xml")
            .valueByXPath("//component[@name='CompilerConfiguration']/option[@name='BUILD_PROCESS_ADDITIONAL_VM_OPTIONS']/@value")
            .isEqualTo("-Xms123m")
    }

    @Test
    fun vmOptionsForImporter() {
        assertThatXml(".idea/workspace.xml")
            .valueByXPath("//MavenImportingSettings/option[@name='vmOptionsForImporter']/@value")
            .isEqualTo("-Xmx1g")
    }

    @Test
    fun mavenThreadCount() {
        assertThatXml(".idea/workspace.xml")
            .valueByXPath("//MavenGeneralSettings/option[@name='threads']/@value")
            .isEqualTo("1C")
    }

    @Test
    fun mavenHome() {
        assertThatXml(".idea/workspace.xml")
            .valueByXPath("//MavenGeneralSettings/option[@name='mavenHome']/@value")
            .isEqualTo("\$PROJECT_DIR$/maven-bin")
    }

    @Test
    fun resourcePatterns() {
        assertThatXml(".idea/compiler.xml")
            .hasXPath("//wildcardResourcePatterns/entry[@name='!?*.java']")
        assertThatXml(".idea/compiler.xml")
            .hasXPath("//wildcardResourcePatterns/entry[@name='!resource.properties']")
    }

    @Test
    fun addRuntimeAssertionsForNotnullAnnotatedMethodsAndParameters() {
        assertThatXml(".idea/compiler.xml")
            .valueByXPath("//component[@name='CompilerConfiguration']/addNotNullAssertions/@enabled")
            .asBoolean()
            .isEqualTo(false)
    }

    @Test
    fun nullableAnnotationUsedForCodeGeneration() {
        assertThatXml(".idea/misc.xml")
            .valueByXPath("//component[@name='NullableNotNullManager']/option[@name='myDefaultNullable']/@value")
            .isEqualTo("javax.annotation.Nullable")
    }

    @Test
    fun nullableAnnotations() {
        val nullableAnnotations = listOf(
            "javax.annotation.Nullable",
            "javax.annotation.CheckForNull",
            "my.fake.annotation.Nullable")
        for (annotation in nullableAnnotations) {
            assertThatXml(".idea/misc.xml")
                .hasXPath(String.format("//component[@name='NullableNotNullManager']/option[@name='myNullables']//item[@itemvalue='%s']", annotation))
        }
    }

    @Test
    fun notNullAnnotationUsedForCodeGeneration() {
        assertThatXml(".idea/misc.xml")
            .valueByXPath("//component[@name='NullableNotNullManager']/option[@name='myDefaultNotNull']/@value")
            .isEqualTo("javax.annotation.Nonnull")
    }

    @Test
    fun notNullAnnotations() {
        val notNullAnnotations = listOf(
            "javax.annotation.Nonnull",
            "androidx.annotation.Nonnull",
            "my.fake.annotation.Nonnull")
        for (annotation in notNullAnnotations) {
            assertThatXml(".idea/misc.xml")
                .hasXPath(String.format("//component[@name='NullableNotNullManager']/option[@name='myNotNulls']//item[@itemvalue='%s']", annotation))
        }
    }

    @Test
    fun instrumentedNotNullAnnotations() {
        val instrumentedNotNullAnnotations = listOf(
            "javax.annotation.Nonnull",
            "my.fake.annotation.Nonnull")
        for (annotation in instrumentedNotNullAnnotations) {
            assertThatXml(".idea/misc.xml")
                .hasXPath(String.format("//component[@name='NullableNotNullManager']/instrumentedNotNulls/option[@value='%s']", annotation))
        }
    }

    @Test
    fun requiredPlugins() {
        assertThatXml(".idea/externalDependencies.xml")
            .hasXPath("//component[@name='ExternalDependencies']/plugin[@id='CheckStyle-IDEA']")
    }

    @Test
    fun requiredPluginsMinimumVersion() {
        assertThatXml(".idea/externalDependencies.xml")
            .valueByXPath("//component[@name='ExternalDependencies']/plugin[@id='CheckStyle-IDEA']/@min-version")
            .isEqualTo("5.23.0")
    }

    @Test
    fun requiredPluginsMaximumVersion() {
        assertThatXml(".idea/externalDependencies.xml")
            .valueByXPath("//component[@name='ExternalDependencies']/plugin[@id='CheckStyle-IDEA']/@max-version")
            .isEqualTo("5.24.1")
    }

    /**
     * This should be set implicitly when setting any codestyle setting.
     */
    @Test
    fun usePerProjectSettings() {
        assertThatXml(".idea/codeStyles/codeStyleConfig.xml")
            .valueByXPath("//option[@name='USE_PER_PROJECT_SETTINGS']/@value")
            .asBoolean()
            .isEqualTo(true)
    }

    @Test
    fun keepMaximumBlankLines() {
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']/option[@name='KEEP_BLANK_LINES_IN_DECLARATIONS']/@value")
            .asInt()
            .isEqualTo(10)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']/option[@name='KEEP_BLANK_LINES_IN_CODE']/@value")
            .asInt()
            .isEqualTo(11)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']/option[@name='KEEP_BLANK_LINES_BEFORE_RBRACE']/@value")
            .asInt()
            .isEqualTo(12)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']/option[@name='KEEP_BLANK_LINES_BETWEEN_PACKAGE_DECLARATION_AND_HEADER']/@value")
            .asInt()
            .isEqualTo(13)
    }

    @Test
    fun minimumBlankLines() {
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']/option[@name='BLANK_LINES_BEFORE_PACKAGE']/@value")
            .asInt()
            .isEqualTo(14)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']/option[@name='BLANK_LINES_AFTER_PACKAGE']/@value")
            .asInt()
            .isEqualTo(15)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']/option[@name='BLANK_LINES_BEFORE_IMPORTS']/@value")
            .asInt()
            .isEqualTo(16)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']/option[@name='BLANK_LINES_AFTER_IMPORTS']/@value")
            .asInt()
            .isEqualTo(17)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']/option[@name='BLANK_LINES_AROUND_CLASS']/@value")
            .asInt()
            .isEqualTo(18)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']/option[@name='BLANK_LINES_AFTER_CLASS_HEADER']/@value")
            .asInt()
            .isEqualTo(19)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']/option[@name='BLANK_LINES_BEFORE_CLASS_END']/@value")
            .asInt()
            .isEqualTo(20)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']/option[@name='BLANK_LINES_AFTER_ANONYMOUS_CLASS_HEADER']/@value")
            .asInt()
            .isEqualTo(21)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']/option[@name='BLANK_LINES_AROUND_FIELD_IN_INTERFACE']/@value")
            .asInt()
            .isEqualTo(22)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']/option[@name='BLANK_LINES_AROUND_FIELD']/@value")
            .asInt()
            .isEqualTo(23)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']/option[@name='BLANK_LINES_AROUND_METHOD_IN_INTERFACE']/@value")
            .asInt()
            .isEqualTo(24)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']/option[@name='BLANK_LINES_AROUND_METHOD']/@value")
            .asInt()
            .isEqualTo(25)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']/option[@name='BLANK_LINES_BEFORE_METHOD_BODY']/@value")
            .asInt()
            .isEqualTo(26)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//JavaCodeStyleSettings/option[@name='BLANK_LINES_AROUND_INITIALIZER']/@value")
            .asInt()
            .isEqualTo(27)
    }

    @Test
    fun javadocAlignment() {
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//JavaCodeStyleSettings/option[@name='JD_ALIGN_PARAM_COMMENTS']/@value")
            .asBoolean()
            .isEqualTo(false)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//JavaCodeStyleSettings/option[@name='JD_ALIGN_EXCEPTION_COMMENTS']/@value")
            .asBoolean()
            .isEqualTo(false)
    }

    @Test
    fun javadocBlankLines() {
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//JavaCodeStyleSettings/option[@name='JD_ADD_BLANK_AFTER_DESCRIPTION']/@value")
            .asBoolean()
            .isEqualTo(false)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//JavaCodeStyleSettings/option[@name='JD_ADD_BLANK_AFTER_PARM_COMMENTS']/@value")
            .asBoolean()
            .isEqualTo(true)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//JavaCodeStyleSettings/option[@name='JD_ADD_BLANK_AFTER_RETURN']/@value")
            .asBoolean()
            .isEqualTo(true)
    }

    @Test
    fun javadocInvalidTags() {
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//JavaCodeStyleSettings/option[@name='JD_KEEP_INVALID_TAGS']/@value")
            .asBoolean()
            .isEqualTo(false)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//JavaCodeStyleSettings/option[@name='JD_KEEP_EMPTY_PARAMETER']/@value")
            .asBoolean()
            .isEqualTo(false)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//JavaCodeStyleSettings/option[@name='JD_KEEP_EMPTY_EXCEPTION']/@value")
            .asBoolean()
            .isEqualTo(false)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//JavaCodeStyleSettings/option[@name='JD_KEEP_EMPTY_RETURN']/@value")
            .asBoolean()
            .isEqualTo(false)
    }

    @Test
    fun javadocOther() {
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']/option[@name='WRAP_COMMENTS']/@value")
            .asBoolean()
            .isEqualTo(true)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//JavaCodeStyleSettings/option[@name='JD_LEADING_ASTERISKS_ARE_ENABLED']/@value")
            .asBoolean()
            .isEqualTo(false)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//JavaCodeStyleSettings/option[@name='JD_USE_THROWS_NOT_EXCEPTION']/@value")
            .asBoolean()
            .isEqualTo(false)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//JavaCodeStyleSettings/option[@name='JD_P_AT_EMPTY_LINES']/@value")
            .asBoolean()
            .isEqualTo(false)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//JavaCodeStyleSettings/option[@name='JD_KEEP_EMPTY_LINES']/@value")
            .asBoolean()
            .isEqualTo(false)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//JavaCodeStyleSettings/option[@name='JD_DO_NOT_WRAP_ONE_LINE_COMMENTS']/@value")
            .asBoolean()
            .isEqualTo(true)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//JavaCodeStyleSettings/option[@name='JD_PRESERVE_LINE_FEEDS']/@value")
            .asBoolean()
            .isEqualTo(true)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//JavaCodeStyleSettings/option[@name='JD_PARAM_DESCRIPTION_ON_NEW_LINE']/@value")
            .asBoolean()
            .isEqualTo(true)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//JavaCodeStyleSettings/option[@name='JD_INDENT_ON_CONTINUATION']/@value")
            .asBoolean()
            .isEqualTo(true)
    }

    @Test
    fun arrangement() {
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']//arrangement/rules/section[1]/rule/match/AND/FIELD")
            .asBoolean()
            .isEqualTo(true)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']//arrangement/rules/section[1]/rule/match/AND/PUBLIC")
            .asBoolean()
            .isEqualTo(true)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']//arrangement/rules/section[1]/rule/match/AND/STATIC")
            .asBoolean()
            .isEqualTo(true)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']//arrangement/rules/section[2]/rule/match/AND/CLASS")
            .asBoolean()
            .isEqualTo(true)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']//arrangement/rules/section[2]/rule/match/AND/PROTECTED")
            .asBoolean()
            .isEqualTo(false)
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']//arrangement/rules/section[2]/rule/match/AND/NAME")
            .isEqualTo("unprotected class")
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//codeStyleSettings[@language='JAVA']//arrangement/rules/section[2]/rule/order")
            .isEqualTo("BY_NAME")
    }

    @Test
    fun classCountToUseImportWithWildcard() {
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//JavaCodeStyleSettings/option[@name='CLASS_COUNT_TO_USE_IMPORT_ON_DEMAND']/@value")
            .asInt()
            .isEqualTo(123)
    }

    @Test
    fun namesCountToUseStaticImportWithWildcard() {
        assertThatXml(".idea/codeStyles/Project.xml")
            .valueByXPath("//JavaCodeStyleSettings/option[@name='NAMES_COUNT_TO_USE_IMPORT_ON_DEMAND']/@value")
            .asInt()
            .isEqualTo(456)
    }

    @Test
    fun `Editor | Inspections`() {
        assertThatXml(".idea/inspectionProfiles/Project_Default.xml").apply {
            valueByXPath("//inspection_tool[@class='MissingDeprecatedAnnotation']/option[@name='warnOnMissingJavadoc']/@value").asBoolean().isTrue()
        }
    }

    @Test
    fun optimizeImportsOnTheFly() {
        assertThatXml(".idea/workspace.xml")
            .valueByXPath("//component[@name='CodeInsightWorkspaceSettings']/option[@name='optimizeImportsOnTheFly']/@value")
            .asBoolean()
            .isTrue()
    }

    @Test
    fun excludeFromImportAndCompletion() {
        assertThatXml(".idea/codeInsightSettings.xml")
            .hasXPath("//component[@name='JavaProjectCodeInsightSettings']/excluded-names/name[text()='com.google.inject.Inject']")
        assertThatXml(".idea/codeInsightSettings.xml")
            .hasXPath("//component[@name='JavaProjectCodeInsightSettings']/excluded-names/name[text()='com.sun.istack.internal.Nullable']")
    }

    @Test
    fun dictionaryRelativeToProject() {
        assertThatXml(".idea/workspace.xml")
            .valueByXPath("//component[@name='SpellCheckerSettings']/@CustomDictionary0")
            .asString()
            .isEqualTo("\$PROJECT_DIR$/dict.dic")
    }

    @Test
    fun acceptedWords() {
        for (word in listOf("abcd", "efgh")) {
            assertThatXml(".idea/dictionaries/${System.getProperty("user.name")}.xml")
                .hasXPath("//component[@name='ProjectDictionaryState']/dictionary/words/w[text()='$word']")
        }
    }

    @Test
    @Ignore("SonarLint 4.6.0 does not work with IntelliJ 2020.1")
    fun SonarLint() {
        assertThatXml(".idea/sonarlint.xml").apply {
            valueByXPath("//option[@name='bindingEnabled']/@value").asBoolean().isTrue()
            valueByXPath("//option[@name='projectKey']/@value").isEqualTo("my_project")
            valueByXPath("//option[@name='serverId']/@value").isEqualTo("My Sonar Instance")

            hasXPath("//option[@name='fileExclusions']/list/option[@value='FILE:LICENSE.txt']")
            hasXPath("//option[@name='fileExclusions']/list/option[@value='DIRECTORY:node_modules']")
            hasXPath("//option[@name='fileExclusions']/list/option[@value='GLOB:**/*.txt']")

            valueByXPath("//option[@name='additionalProperties']/map/entry[@key='My Property']/@value").isEqualTo("My Value")
        }
    }

    @Test
    fun checkstyleVersion() {
        assertThatXml(".idea/checkstyle-idea.xml")
            .valueByXPath("//entry[@key='checkstyle-version']/@value")
            .isEqualTo("8.16")
    }

    @Test
    fun checkstyleScanScope() {
        assertThatXml(".idea/checkstyle-idea.xml")
            .valueByXPath("//entry[@key='scanscope']/@value")
            .isEqualTo("JavaOnlyWithTests")
    }

    @Test
    fun checkstyleTreatCheckstyleErrorsAsWarnings() {
        assertThatXml(".idea/checkstyle-idea.xml")
            .valueByXPath("//entry[@key='suppress-errors']/@value")
            .asBoolean()
            .isTrue()
    }

    @Test
    fun checkstyleLocalConfigurationFile() {
        assertThatXml(".idea/checkstyle-idea.xml")
            .valueByXPath("//entry[@key='active-configuration']/@value")
            .isEqualTo("PROJECT_RELATIVE:\$PROJECT_DIR$/checkstyle.xml:Javapoet Checkstyle")
    }

    @Test
    fun checkstyleThirdPartyChecks() {
        assertThatXml(".idea/checkstyle-idea.xml")
            .valueByXPath("//entry[@key='thirdparty-classpath']/@value")
            .isEqualTo("\$PROJECT_DIR\$/lib/checkstyle-custom-1.jar;\$PROJECT_DIR\$/lib/checkstyle-custom-2.jar")
    }

    @Test
    fun `Other Settings | Save Actions`() {
        assertThatXml(".idea/saveactions_settings.xml").apply {
            hasXPath("//option[@name='actions']/set/option[@value='organizeImports']")
        }
    }

    @Test
    fun applicationConfigurationMainClassName() {
        assertThatXml(".idea/runConfigurations/Application_Configuration.xml")
            .valueByXPath("//configuration[@name='Application Configuration']/option[@name='MAIN_CLASS_NAME']/@value")
            .isEqualTo("com.Application")
    }

    @Test
    fun applicationConfigurationModule() {
        assertThatXml(".idea/runConfigurations/Application_Configuration.xml")
            .valueByXPath("//configuration[@name='Application Configuration']/module/@name")
            .isEqualTo("javapoet")
    }

    @Test
    fun applicationConfigurationVmOptions() {
        assertThatXml(".idea/runConfigurations/Application_Configuration.xml")
            .valueByXPath("//configuration[@name='Application Configuration']/option[@name='VM_PARAMETERS']/@value")
            .isEqualTo("-Xmx1g")
    }

    @Test
    fun applicationConfigurationProgramArguments() {
        assertThatXml(".idea/runConfigurations/Application_Configuration.xml")
            .valueByXPath("//configuration[@name='Application Configuration']/option[@name='PROGRAM_PARAMETERS']/@value")
            .isEqualTo("foo bar")
    }

    @Test
    fun applicationConfigurationWorkingDirectory() {
        assertThatXml(".idea/runConfigurations/Application_Configuration.xml")
            .valueByXPath("//configuration[@name='Application Configuration']/option[@name='WORKING_DIRECTORY']/@value")
            .isEqualTo("\$PROJECT_DIR$/src")
    }

    @Test
    fun checkShellScriptPath() {
        assertThatXml(".idea/runConfigurations/Shell_Script.xml")
            .valueByXPath("//configuration[@name='Shell Script']/option[@name='SCRIPT_PATH']/@value")
            .isEqualTo("\$PROJECT_DIR$/maven-bin/bin/mvn")
    }

    @Test
    fun checkShellScriptOptions() {
        assertThatXml(".idea/runConfigurations/Shell_Script.xml")
            .valueByXPath("//configuration[@name='Shell Script']/option[@name='SCRIPT_OPTIONS']/@value")
            .isEqualTo("--version")
    }

    @Test
    fun checkShellScriptInterpreterPath() {
        val shellPath: Path = Paths.get("/bin/sh")
        assertThatXml(".idea/runConfigurations/Shell_Script.xml")
            .valueByXPath("//configuration[@name='Shell Script']/option[@name='INTERPRETER_PATH']/@value")
            .isEqualTo(shellPath.toString())
    }

    @Test
    fun checkShellScriptInterpreterOptions() {
        assertThatXml(".idea/runConfigurations/Shell_Script.xml")
            .valueByXPath("//configuration[@name='Shell Script']/option[@name='INTERPRETER_OPTIONS']/@value")
            .isEqualTo("-e")
    }

    @Test
    fun checkRemoteConfiguration() {
        assertThatXml(".idea/runConfigurations/Remote_Configuration.xml")
            .valueByXPath("//configuration[@name='Remote Configuration']/option[@name='HOST']/@value")
            .isEqualTo("8.8.8.8")
        assertThatXml(".idea/runConfigurations/Remote_Configuration.xml")
            .valueByXPath("//configuration[@name='Remote Configuration']/option[@name='PORT']/@value")
            .isEqualTo("5000")
    }

    @Test
    fun checkRemoteConfigurationShellScript() {
        assertThatXml(".idea/runConfigurations/Remote_Configuration.xml")
            .valueByXPath("//configuration[@name='Remote Configuration']/method[@v='2']/option[@name='RunConfigurationTask']/@run_configuration_name")
            .isEqualTo("Shell Script")
    }

    @Test
    fun checkRemoteConfigurationShellScriptEnabled() {
        assertThatXml(".idea/runConfigurations/Remote_Configuration.xml")
            .valueByXPath("//configuration[@name='Remote Configuration']/method[@v='2']/option[@name='RunConfigurationTask']/@enabled")
            .asBoolean()
            .isTrue()
    }
}
