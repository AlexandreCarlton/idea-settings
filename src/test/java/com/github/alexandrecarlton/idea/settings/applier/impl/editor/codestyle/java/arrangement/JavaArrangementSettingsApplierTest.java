package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.arrangement;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement.ImmutableJavaArrangementSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement.ImmutableMatchingRule;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement.JavaArrangementSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement.MatchingRuleModifier;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement.MatchingRuleOrder;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement.MatchingRuleType;
import com.google.common.collect.ImmutableList;
import com.intellij.application.options.CodeStyle;
import com.intellij.lang.java.JavaLanguage;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.arrangement.match.StdArrangementMatchRule;
import com.intellij.psi.codeStyle.arrangement.model.ArrangementAtomMatchCondition;
import com.intellij.psi.codeStyle.arrangement.model.ArrangementCompositeMatchCondition;
import com.intellij.psi.codeStyle.arrangement.model.ArrangementMatchConditionVisitor;
import com.intellij.psi.codeStyle.arrangement.std.StdArrangementTokens;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class JavaArrangementSettingsApplierTest extends IdeaSettingsTestFixture {

  private SettingsApplier<JavaArrangementSettings> settingsApplier;
  private CommonCodeStyleSettings commonCodeStyleSettings;

  @Override
  public void setUp() throws Exception {
    super.setUp();
    CodeStyleSettings codeStyleSettings = CodeStyle.getSettings(project);
    commonCodeStyleSettings = codeStyleSettings.getCommonSettings(JavaLanguage.INSTANCE);
    settingsApplier = new JavaArrangementSettingsApplier(commonCodeStyleSettings);
  }

  @Test
  public void singleMatchingRuleApplied() {
    settingsApplier.apply(ImmutableJavaArrangementSettings.builder()
      .matchingRules(ImmutableList.of(
        ImmutableMatchingRule.builder()
          .type(MatchingRuleType.CLASS)
          .addModifier(MatchingRuleModifier.FINAL)
          .addModifier(MatchingRuleModifier.NOT_ABSTRACT)
          .name("First Rule")
          .order(MatchingRuleOrder.ORDER_BY_NAME)
          .build()))
      .build());

    AtomMatchConditionCollector collector = new AtomMatchConditionCollector();
    List<StdArrangementMatchRule> matchRules = commonCodeStyleSettings.getArrangementSettings()
      .getSections()
      .get(0)
      .getMatchRules();
    StdArrangementMatchRule matchRule = matchRules.get(0);
    matchRule
      .getMatcher()
      .getCondition()
      .invite(collector);
    assertThat(collector.getTokens())
      .containsExactlyInAnyOrder(
        new ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.CLASS),
        new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.FINAL),
        new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.ABSTRACT, false),
        new ArrangementAtomMatchCondition(StdArrangementTokens.Regexp.NAME, "First Rule"));
    assertThat(matchRule.getOrderType()).isEqualTo(StdArrangementTokens.Order.BY_NAME);
  }


  /**
   * Collects all tokens from a Matcher for easy analysis.
   */
  class AtomMatchConditionCollector implements ArrangementMatchConditionVisitor {

    private final List<ArrangementAtomMatchCondition> tokens = new ArrayList<>();

    public List<ArrangementAtomMatchCondition> getTokens() {
      return tokens;
    }

    @Override
    public void visit(ArrangementAtomMatchCondition condition) {
      tokens.add(condition);
    }

    @Override
    public void visit(ArrangementCompositeMatchCondition condition) {
      condition.getOperands()
        .forEach(operand -> operand.invite(this));
    }
  }
}
