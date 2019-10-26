package com.github.alexandrecarlton.idea.settings.dagger.project;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.IdeaSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.BuildExecutionDeploymentSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.build_tools.BuildToolsSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.build_tools.maven.MavenImportingSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.build_tools.maven.MavenSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler.AnnotationProcessorsSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler.CompilerSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.configurations.ConfigurationsSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.configurations.remote.RemoteSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.EditorSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.CodeStyleSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.JavaCodeStyleSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.JavaImportsSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.general.GeneralSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.general.auto_import.AutoImportSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.general.auto_import.JavaAutoImportSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.spelling.SpellingSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.languages_frameworks.LanguagesFrameworksSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.other_settings.OtherSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.project_settings.ProjectSettingsSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.project_settings.project.ProjectSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.tools.ToolsSettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.BuildExecutionDeploymentSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.BuildToolsSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.MavenImportingSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.MavenSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.AnnotationProcessorsSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.CompilerSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.remote.RemoteSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.EditorSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.CodeStyleSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaCodeStyleSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaImportsSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.general.GeneralSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import.AutoImportSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import.JavaAutoImportSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.spelling.SpellingSettings;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.LanguagesFrameworksSettings;
import com.github.alexandrecarlton.idea.settings.layout.other_settings.OtherSettings;
import com.github.alexandrecarlton.idea.settings.layout.project_settings.ProjectSettingsSettings;
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectSettings;
import com.github.alexandrecarlton.idea.settings.layout.tools.ToolsSettings;
import dagger.Binds;
import dagger.Module;

@Module
public interface SettingsApplierModule {

  @Binds
  SettingsApplier<AutoImportSettings> bindAutoImportSettingsApplier(AutoImportSettingsApplier applier);

  @Binds
  SettingsApplier<AnnotationProcessorsSettings> bindAnnotationProcessorsSettingsApplier(AnnotationProcessorsSettingsApplier applier);

  @Binds
  SettingsApplier<BuildExecutionDeploymentSettings> bindBuildExecutionDeploymentSettingsApplier(BuildExecutionDeploymentSettingsApplier applier);

  @Binds
  SettingsApplier<BuildToolsSettings> bindBuildToolsSettingsApplier(BuildToolsSettingsApplier applier);

  @Binds
  SettingsApplier<CodeStyleSettings> bindCodeStyleSettingsApplier(CodeStyleSettingsApplier applier);

  @Binds
  SettingsApplier<CompilerSettings> bindCompilerSettingsApplier(CompilerSettingsApplier applier);

  @Binds
  SettingsApplier<ConfigurationSettings> bindConfigurationsSettingsApplier(ConfigurationsSettingsApplier applier);

  @Binds
  SettingsApplier<EditorSettings> bindEditorSettingsApplier(EditorSettingsApplier applier);

  @Binds
  SettingsApplier<GeneralSettings> bindGeneralSettingsApplier(GeneralSettingsApplier applier);

  @Binds
  SettingsApplier<IdeaSettings> bindIdeaSettingsApplier(IdeaSettingsApplier applier);

  @Binds
  SettingsApplier<JavaAutoImportSettings> bindJavaAutoImportSettingsApplier(JavaAutoImportSettingsApplier applier);

  @Binds
  SettingsApplier<JavaCodeStyleSettings> bindJavaCodeStyleSettingsApplier(JavaCodeStyleSettingsApplier applier);

  @Binds
  SettingsApplier<JavaImportsSettings> bindJavaImportsSettingsApplier(JavaImportsSettingsApplier applier);

  @Binds
  SettingsApplier<LanguagesFrameworksSettings> bindLanguagesFrameworksSettingsApplier(LanguagesFrameworksSettingsApplier applier);

  @Binds
  SettingsApplier<MavenImportingSettings> bindMavenImportingSettingsApplier(MavenImportingSettingsApplier applier);

  @Binds
  SettingsApplier<MavenSettings> bindMavenSettingsApplier(MavenSettingsApplier applier);

  @Binds
  SettingsApplier<OtherSettings> bindOtherSettingsApplier(OtherSettingsApplier applier);

  @Binds
  SettingsApplier<ProjectSettings> bindProjectSettingsApplier(ProjectSettingsApplier applier);

  @Binds
  SettingsApplier<ProjectSettingsSettings> bindProjectSettingsSettingsApplier(ProjectSettingsSettingsApplier applier);

  @Binds
  SettingsApplier<RemoteSettings> bindRemoteSettingsApplier(RemoteSettingsApplier applier);

  @Binds
  SettingsApplier<SpellingSettings> bindSpellingSettingsApplier(SpellingSettingsApplier applier);

  @Binds
  SettingsApplier<ToolsSettings> bindToolsSettingsApplier(ToolsSettingsApplier applier);
}
