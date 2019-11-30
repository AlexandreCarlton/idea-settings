package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.arrangement

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement.JavaArrangementSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement.MatchingRule
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement.MatchingRuleModifier
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement.MatchingRuleOrder
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement.MatchingRuleType
import com.intellij.application.options.CodeStyle
import com.intellij.lang.java.JavaLanguage
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.codeStyle.arrangement.model.ArrangementAtomMatchCondition
import com.intellij.psi.codeStyle.arrangement.model.ArrangementCompositeMatchCondition
import com.intellij.psi.codeStyle.arrangement.model.ArrangementMatchConditionVisitor
import com.intellij.psi.codeStyle.arrangement.std.StdArrangementTokens
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class JavaArrangementSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<JavaArrangementSettings>
    private lateinit var commonCodeStyleSettings: CommonCodeStyleSettings

    @Before
    public override fun setUp() {
        val codeStyleSettings = CodeStyle.getSettings(project)
        commonCodeStyleSettings = codeStyleSettings.getCommonSettings(JavaLanguage.INSTANCE)
        settingsApplier = JavaArrangementSettingsApplier(commonCodeStyleSettings)
    }

    @Test
    fun singleMatchingRuleApplied() {
        settingsApplier.apply(JavaArrangementSettings(
            matchingRules = listOf(
                MatchingRule(
                    type = MatchingRuleType.CLASS,
                    modifier = listOf(
                        MatchingRuleModifier.FINAL,
                        MatchingRuleModifier.NOT_ABSTRACT),
                    name = "First Rule",
                    order = MatchingRuleOrder.ORDER_BY_NAME))))

        val collector = AtomMatchConditionCollector()
        val matchRules = commonCodeStyleSettings.arrangementSettings!!
            .sections[0]
            .matchRules
        val matchRule = matchRules[0]
        matchRule
            .matcher
            .condition
            .invite(collector)
        assertThat(collector.getTokens())
            .containsExactlyInAnyOrder(
                ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.CLASS),
                ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.FINAL),
                ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.ABSTRACT, false),
                ArrangementAtomMatchCondition(StdArrangementTokens.Regexp.NAME, "First Rule"))
        assertThat(matchRule.orderType).isEqualTo(StdArrangementTokens.Order.BY_NAME)
    }

    /**
     * Collects all tokens from a Matcher for easy analysis.
     */
    internal inner class AtomMatchConditionCollector : ArrangementMatchConditionVisitor {

        private val tokens = mutableListOf<ArrangementAtomMatchCondition>()

        fun getTokens(): List<ArrangementAtomMatchCondition> {
            return tokens
        }

        override fun visit(condition: ArrangementAtomMatchCondition) {
            tokens.add(condition)
        }

        override fun visit(condition: ArrangementCompositeMatchCondition) {
            condition.operands
                .forEach { operand -> operand.invite(this) }
        }
    }
}
