package com.github.alexandrecarlton.idea.settings.layout.other_settings.save_actions

import com.fasterxml.jackson.annotation.JsonProperty

data class JavaInspectionAndQuickFixSettings(

    @JsonProperty("Add final modifier to field")
    val addFinalModifierToField: Boolean? = null,

    @JsonProperty("Add final modifier to local variable or parameter")
    val addFinalModifierToLocalVariableOrParameter: Boolean? = null,

    @JsonProperty("Add final modifier to local variable or parameter except if it is implicit")
    val addFinalModifierToLocalVariableOrParameterExecptIfItIsImplicit: Boolean? = null,

    @JsonProperty("Add static modifier to methods")
    val addStaticModifierToMethods: Boolean? = null,

    @JsonProperty("Add this to field access")
    val addThisToFieldAccess: Boolean? = null,

    @JsonProperty("Add this to method access")
    val addThisToMethodAccess: Boolean? = null,

    @JsonProperty("Add class qualifier to static member access")
    val addClassQualifierToStaticMemberAccess: Boolean? = null,

    @JsonProperty("Add class qualifier to static member access outside declaring class")
    val addClassQualifierToStaticMemberAccessOutsideDeclaringClass: Boolean? = null,

    @JsonProperty("Add missing @Override annotations")
    val addMissingOverrideAnnotations: Boolean? = null,

    @JsonProperty("Add blocks to if/while/for statements")
    val addBlocksToIfWhileForStatements: Boolean? = null,

    @JsonProperty("Add serialVersionUID field for Serializable classes")
    val addSerialVersionUidFieldForSerializableClasses: Boolean? = null,

    @JsonProperty("Remove unnecessary this to field and method")
    val removeUnnecessaryThisToFieldAndMethod: Boolean? = null,

    @JsonProperty("Remove final from private method")
    val removeFinalFromPrivateMethod: Boolean? = null,

    @JsonProperty("Remove unnecessary final to local variable or parameter")
    val removeUnnecessaryFinalToLocalVariableOrParameter: Boolean? = null,

    @JsonProperty("Remove explicit generic type for diamond")
    val removeExplicitGenericTypeForDiamond: Boolean? = null,

    @JsonProperty("Remove unused suppress warning annotation")
    val removeUnusedSuppressWarningAnnotation: Boolean? = null,

    @JsonProperty("Remove unnecessary semicolon")
    val removeUnnecessarySemicolon: Boolean? = null,

    @JsonProperty("Remove blocks from if/while/for statements")
    val removeBlocksFromIfWhileForStatements: Boolean? = null,

    @JsonProperty("Change visibility of field or method to lower access")
    val changeVisibilityOfFieldOrMethodToLowerAccess: Boolean? = null
)
