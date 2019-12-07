package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines

import com.fasterxml.jackson.annotation.JsonProperty

data class JavaMinimumBlankLinesSettings(

    @JsonProperty("Before package statement")
    val beforePackageStatement: Int? = null,

    @JsonProperty("After package statement")
    val afterPackageStatement: Int? = null,

    @JsonProperty("Before imports")
    val beforeImports: Int? = null,

    @JsonProperty("After imports")
    val afterImports: Int? = null,

    @JsonProperty("Around class")
    val aroundClass: Int? = null,

    @JsonProperty("After class header")
    val afterClassHeader: Int? = null,

    @JsonProperty("Before class end")
    val beforeClassEnd: Int? = null,

    @JsonProperty("After anonymous class header")
    val afterAnonymousClassHeader: Int? = null,

    @JsonProperty("Around field in interface")
    val aroundFieldInInterface: Int? = null,

    @JsonProperty("Around field")
    val aroundField: Int? = null,

    @JsonProperty("Around method in interface")
    val aroundMethodInInterface: Int? = null,

    @JsonProperty("Around method")
    val aroundMethod: Int? = null,

    @JsonProperty("Before method body")
    val beforeMethodBody: Int? = null,

    @JsonProperty("Around initializer")
    val aroundInitializer: Int? = null
)
