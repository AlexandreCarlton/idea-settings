package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java;

import static java.util.stream.Collectors.toList;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaArrangementSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.MatchingRule;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.MatchingRuleModifier;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.MatchingRuleOrder;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.MatchingRuleType;
import com.google.common.collect.ImmutableList;
import com.intellij.lang.java.JavaLanguage;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.arrangement.match.ArrangementMatchRule;
import com.intellij.psi.codeStyle.arrangement.match.StdArrangementEntryMatcher;
import com.intellij.psi.codeStyle.arrangement.match.StdArrangementMatchRule;
import com.intellij.psi.codeStyle.arrangement.model.ArrangementAtomMatchCondition;
import com.intellij.psi.codeStyle.arrangement.model.ArrangementCompositeMatchCondition;
import com.intellij.psi.codeStyle.arrangement.model.ArrangementMatchCondition;
import com.intellij.psi.codeStyle.arrangement.std.ArrangementSettingsToken;
import com.intellij.psi.codeStyle.arrangement.std.StdArrangementSettings;
import com.intellij.psi.codeStyle.arrangement.std.StdArrangementTokens;
import javax.inject.Inject;

// TODO: Add tests (Unit AND Integration)
public class JavaArrangementSettingsApplier implements SettingsApplier<JavaArrangementSettings> {

  private final CodeStyleSettings codeStyleSettings;

  @Inject
  public JavaArrangementSettingsApplier(CodeStyleSettings codeStyleSettings) {
    this.codeStyleSettings = codeStyleSettings;
  }

  @Override
  public void apply(JavaArrangementSettings settings) {

    Logger LOG = Logger.getInstance(getClass());
    LOG.warn("Invoking JavaArrangementSettingsApplier#apply");

    final StdArrangementSettings stdArrangementSettings = new StdArrangementSettings();
    settings.matchingRules().ifPresent(matchingRules -> {
      matchingRules
        .stream()
        .map(matchingRule -> new StdArrangementMatchRule(
          new StdArrangementEntryMatcher(toArrangementMatchCondition(matchingRule)),
          matchingRule.order()
            .map(this::toOrder)
            .orElse(ArrangementMatchRule.DEFAULT_ORDER_TYPE)))
        .forEach(stdArrangementSettings::addSectionRule);
    });

    if (!stdArrangementSettings.equals(new StdArrangementSettings())) {
      CommonCodeStyleSettings commonCodeStyleSettings = codeStyleSettings.getCommonSettings(JavaLanguage.INSTANCE);
      commonCodeStyleSettings.setArrangementSettings(stdArrangementSettings);
    }
  }

  private ArrangementCompositeMatchCondition toArrangementMatchCondition(MatchingRule matchingRule) {

    ImmutableList.Builder<ArrangementMatchCondition> conditionsBuilder = ImmutableList.builder();

    matchingRule.type()
      .map(this::toArrangementMatchCondition)
      .ifPresent(conditionsBuilder::add);

    conditionsBuilder.addAll(matchingRule.modifier()
      .stream()
      .map(this::toArrangementMatchCondition)
      .collect(toList()));

    matchingRule.name()
      .map(name -> new ArrangementAtomMatchCondition(StdArrangementTokens.Regexp.NAME, name))
      .ifPresent(conditionsBuilder::add);

    return new ArrangementCompositeMatchCondition(conditionsBuilder.build());

  }

  private ArrangementAtomMatchCondition toArrangementMatchCondition(MatchingRuleType type) {
    switch (type) {
      case CLASS: return new ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.CLASS);
      case CONSTRUCTOR: return new ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.CONSTRUCTOR);
      case ENUM : return new ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.ENUM);
      case FIELD: return new ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.FIELD);
      case GETTER: return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.GETTER);
      case INITIALIZER_BLOCK: return new ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.INIT_BLOCK);
      case INTERFACE: return new ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.INTERFACE);
      case METHOD: return new ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.METHOD);
      case NOT_CLASS: return new ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.CLASS, false);
      case NOT_CONSTRUCTOR: return new ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.CONSTRUCTOR, false);
      case NOT_ENUM : return new ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.ENUM, false);
      case NOT_FIELD: return new ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.FIELD, false);
      case NOT_INITIALIZER_BLOCK: return new ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.INIT_BLOCK, false);
      case NOT_INTERFACE: return new ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.INTERFACE, false);
      case NOT_METHOD: return new ArrangementAtomMatchCondition(StdArrangementTokens.EntryType.METHOD, false);
      case OVERRIDDEN: return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.OVERRIDDEN);
      case SETTER: return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.SETTER);
      default:
        throw new IllegalArgumentException("Unhandled MatchingRuleType: " + type);
    }
  }

  private ArrangementAtomMatchCondition toArrangementMatchCondition(MatchingRuleModifier modifier) {
    switch (modifier) {
      case ABSTRACT: return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.ABSTRACT);
      case FINAL: return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.FINAL);
      case PACKAGE_PRIVATE: return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.PACKAGE_PRIVATE);
      case PRIVATE: return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.PRIVATE);
      case PROTECTED:return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.PROTECTED);
      case PUBLIC: return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.PUBLIC);
      case NOT_ABSTRACT: return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.ABSTRACT, false);
      case NOT_FINAL: return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.FINAL, false);
      case NOT_PACKAGE_PRIVATE: return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.PACKAGE_PRIVATE, false);
      case NOT_PRIVATE: return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.PRIVATE, false);
      case NOT_PROTECTED :return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.PROTECTED, false);
      case NOT_PUBLIC: return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.PUBLIC, false);
      case NOT_STATIC: return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.STATIC, false);
      case NOT_SYNCHRONIZED: return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.SYNCHRONIZED, false);
      case NOT_TRANSIENT: return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.TRANSIENT, false);
      case NOT_VOLATILE: return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.VOLATILE, false);
      case STATIC: return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.STATIC);
      case SYNCHRONIZED: return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.SYNCHRONIZED);
      case TRANSIENT: return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.TRANSIENT);
      case VOLATILE: return new ArrangementAtomMatchCondition(StdArrangementTokens.Modifier.VOLATILE);
      default:
        throw new IllegalArgumentException("Unhandled MatchingRuleModifier: " + modifier);
    }
  }

  private ArrangementSettingsToken toOrder(MatchingRuleOrder order) {
    switch (order) {
      case KEEP_ORDER: return StdArrangementTokens.Order.KEEP;
      case ORDER_BY_NAME: return StdArrangementTokens.Order.BY_NAME;
      default:
        throw new IllegalArgumentException("Unhandled MatchingRuleOrder: " + order);
    }
  }
}
