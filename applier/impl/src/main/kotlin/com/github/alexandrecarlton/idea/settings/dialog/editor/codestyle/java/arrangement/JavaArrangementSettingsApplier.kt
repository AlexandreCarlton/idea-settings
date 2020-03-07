package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.arrangement

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement.JavaArrangementSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement.MatchingRule
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement.MatchingRuleModifier
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement.MatchingRuleOrder
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement.MatchingRuleType
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.codeStyle.arrangement.match.ArrangementMatchRule
import com.intellij.psi.codeStyle.arrangement.match.StdArrangementEntryMatcher
import com.intellij.psi.codeStyle.arrangement.match.StdArrangementMatchRule
import com.intellij.psi.codeStyle.arrangement.model.ArrangementAtomMatchCondition
import com.intellij.psi.codeStyle.arrangement.model.ArrangementCompositeMatchCondition
import com.intellij.psi.codeStyle.arrangement.model.ArrangementMatchCondition
import com.intellij.psi.codeStyle.arrangement.std.StdArrangementSettings
import com.intellij.psi.codeStyle.arrangement.std.StdArrangementTokens
import javax.inject.Inject
import javax.inject.Named

class JavaArrangementSettingsApplier @Inject
constructor(@param:Named("java") private val commonCodeStyleSettings: CommonCodeStyleSettings) : SettingsApplier<JavaArrangementSettings> {

    override fun apply(settings: JavaArrangementSettings) {

        val stdArrangementSettings = StdArrangementSettings()
        settings.matchingRules?.let { matchingRules ->
            matchingRules
                .map { matchingRule ->
                    StdArrangementMatchRule(
                        StdArrangementEntryMatcher(toArrangementMatchCondition(matchingRule)),
                        matchingRule.order?.let { toOrder(it) } ?: ArrangementMatchRule.DEFAULT_ORDER_TYPE)
                }
                .forEach{ stdArrangementSettings.addSectionRule(it) }
        }

        if (stdArrangementSettings != StdArrangementSettings()) {
            commonCodeStyleSettings.setArrangementSettings(stdArrangementSettings)
        }
    }

    private fun toArrangementMatchCondition(matchingRule: MatchingRule): ArrangementCompositeMatchCondition {

        val conditions = mutableListOf<ArrangementMatchCondition>()

        matchingRule.type
            ?.let { this.toArrangementMatchCondition(it) }
            ?.let { conditions.add(it) }

        conditions.addAll(matchingRule.modifier.map { toArrangementMatchCondition(it) })

        matchingRule.name
            ?.let { name -> ArrangementAtomMatchCondition(StdArrangementTokens.Regexp.NAME, name) }
            ?.let { conditions.add(it) }

        return ArrangementCompositeMatchCondition(conditions)
    }

    private fun toArrangementMatchCondition(type: MatchingRuleType): ArrangementAtomMatchCondition {
        when (type) {
            MatchingRuleType.CLASS -> return ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.CLASS)
            MatchingRuleType.CONSTRUCTOR -> return ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.CONSTRUCTOR)
            MatchingRuleType.ENUM -> return ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.ENUM)
            MatchingRuleType.FIELD -> return ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.FIELD)
            MatchingRuleType.GETTER -> return ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.GETTER)
            MatchingRuleType.INITIALIZER_BLOCK -> return ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.INIT_BLOCK)
            MatchingRuleType.INTERFACE -> return ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.INTERFACE)
            MatchingRuleType.METHOD -> return ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.METHOD)
            MatchingRuleType.NOT_CLASS -> return ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.CLASS, false)
            MatchingRuleType.NOT_CONSTRUCTOR -> return ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.CONSTRUCTOR, false)
            MatchingRuleType.NOT_ENUM -> return ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.ENUM, false)
            MatchingRuleType.NOT_FIELD -> return ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.FIELD, false)
            MatchingRuleType.NOT_INITIALIZER_BLOCK -> return ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.INIT_BLOCK, false)
            MatchingRuleType.NOT_INTERFACE -> return ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.INTERFACE, false)
            MatchingRuleType.NOT_METHOD -> return ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.METHOD, false)
            MatchingRuleType.OVERRIDDEN -> return ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.OVERRIDDEN)
            MatchingRuleType.SETTER -> return ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.SETTER)
            else -> throw IllegalArgumentException("Unhandled MatchingRuleType: $type")
        }
    }

    private fun toArrangementMatchCondition(modifier: MatchingRuleModifier) =
        when (modifier) {
            MatchingRuleModifier.ABSTRACT -> ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.ABSTRACT)
            MatchingRuleModifier.FINAL -> ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.FINAL)
            MatchingRuleModifier.PACKAGE_PRIVATE -> ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.PACKAGE_PRIVATE)
            MatchingRuleModifier.PRIVATE -> ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.PRIVATE)
            MatchingRuleModifier.PROTECTED -> ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.PROTECTED)
            MatchingRuleModifier.PUBLIC -> ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.PUBLIC)
            MatchingRuleModifier.NOT_ABSTRACT -> ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.ABSTRACT, false)
            MatchingRuleModifier.NOT_FINAL -> ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.FINAL, false)
            MatchingRuleModifier.NOT_PACKAGE_PRIVATE -> ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.PACKAGE_PRIVATE, false)
            MatchingRuleModifier.NOT_PRIVATE -> ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.PRIVATE, false)
            MatchingRuleModifier.NOT_PROTECTED -> ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.PROTECTED, false)
            MatchingRuleModifier.NOT_PUBLIC -> ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.PUBLIC, false)
            MatchingRuleModifier.NOT_STATIC -> ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.STATIC, false)
            MatchingRuleModifier.NOT_SYNCHRONIZED -> ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.SYNCHRONIZED, false)
            MatchingRuleModifier.NOT_TRANSIENT -> ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.TRANSIENT, false)
            MatchingRuleModifier.NOT_VOLATILE -> ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.VOLATILE, false)
            MatchingRuleModifier.STATIC -> ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.STATIC)
            MatchingRuleModifier.SYNCHRONIZED -> ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.SYNCHRONIZED)
            MatchingRuleModifier.TRANSIENT -> ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.TRANSIENT)
            MatchingRuleModifier.VOLATILE -> ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.VOLATILE)
        }

    private fun toOrder(order: MatchingRuleOrder) =
        when (order) {
            MatchingRuleOrder.KEEP_ORDER -> StdArrangementTokens.Order.KEEP
            MatchingRuleOrder.ORDER_BY_NAME -> StdArrangementTokens.Order.BY_NAME
        }
}
