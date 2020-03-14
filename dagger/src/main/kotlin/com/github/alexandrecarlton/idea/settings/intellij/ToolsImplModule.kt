package com.github.alexandrecarlton.idea.settings.intellij

import com.intellij.codeInspection.ex.InspectionProfileImpl
import com.intellij.openapi.project.Project
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Retrieves all possible ToolsImpl classes.
 * Note that, for simplicity, the value in [Named] should match the first argument of [InspectionProfileImpl.getTools]
 */
@Module
object ToolsImplModule {

    @Provides
    @Named("ArrayEquality")
    fun provideArrayEquality(inspectionProfileImpl: InspectionProfileImpl, project: Project) =
        inspectionProfileImpl.getTools("ArrayEquality", project)

    @Provides
    @Named("Eslint")
    fun provideEslint(inspectionProfileImpl: InspectionProfileImpl, project: Project) =
        inspectionProfileImpl.getTools("Eslint", project)

    @Provides
    @Named("MissingDeprecatedAnnotation")
    fun provideMissingDeprecatedAnnotation(inspectionProfileImpl: InspectionProfileImpl, project: Project) =
        inspectionProfileImpl.getTools("MissingDeprecatedAnnotation", project)

    @Provides
    @Named("UnnecessarySuperConstructor")
    fun provideUnnecessarySuperConstructor(inspectionProfileImpl: InspectionProfileImpl, project: Project) =
        inspectionProfileImpl.getTools("UnnecessarySuperConstructor", project)

    @Provides
    @Named("UnnecessaryParentheses")
    fun provideUnnecessaryParentheses(inspectionProfileImpl: InspectionProfileImpl, project: Project) =
        inspectionProfileImpl.getTools("UnnecessaryParentheses", project)

    @Provides
    @Named("UnnecessaryQualifierForThis")
    fun provideUnnecessaryQualifierForThis(inspectionProfileImpl: InspectionProfileImpl, project: Project) =
        inspectionProfileImpl.getTools("UnnecessaryQualifierForThis", project)

}
