package com.teseus.skeleton.test.api

import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor
import org.springframework.restdocs.operation.preprocess.Preprocessors
import org.springframework.restdocs.snippet.Attributes
import java.util.Arrays
import java.util.function.Function
import java.util.stream.Collectors

object RestDocsUtils {
    private const val KEY_FORMAT = "format"
    private const val KEY_SAMPLE = "sample"
    private const val KEY_REQUIRED = "required"
    private const val KEY_DEFAULT_VALUE = "defaultValue"

    fun preprocessRequest(): OperationRequestPreprocessor {
        return preprocessRequest("http", "skeleton.dev.teseus.bz")
    }

    fun preprocessRequest(scheme: String?, host: String?): OperationRequestPreprocessor {
        return Preprocessors.preprocessRequest(
            Preprocessors.modifyUris().scheme(scheme).host(host).removePort(),
            Preprocessors.prettyPrint()
        )
    }

    fun preprocessResponse(): OperationResponsePreprocessor {
        return Preprocessors.preprocessResponse(Preprocessors.prettyPrint())
    }

    fun required(): Attributes.Attribute {
        return Attributes.key(KEY_REQUIRED).value("true")
    }

    fun optional(): Attributes.Attribute {
        return Attributes.key(KEY_REQUIRED).value("false")
    }

    fun defaultValue(defaultValue: String?): Attributes.Attribute {
        return Attributes.key(KEY_DEFAULT_VALUE).value(defaultValue)
    }

    fun emptyDefaultValue(): Attributes.Attribute {
        return Attributes.key(KEY_DEFAULT_VALUE).value("")
    }

    fun customFormat(custom: String?): Attributes.Attribute {
        return Attributes.key(KEY_FORMAT).value(custom)
    }

    fun emptyFormat(): Attributes.Attribute {
        return Attributes.key(KEY_FORMAT).value("")
    }

    fun dateTimeFormat(): Attributes.Attribute {
        return Attributes.key(KEY_FORMAT).value("YYYY-MM-DD HH:MM:SS")
    }

    fun dateFormat(): Attributes.Attribute {
        return Attributes.key(KEY_FORMAT).value("YYYY-MM-DD")
    }

    fun <T : Enum<T>?> enumFormat(enums: Class<T>): Attributes.Attribute {
        return Attributes.key(KEY_FORMAT)
            .value(Arrays.stream(enums.enumConstants).map { obj: T -> obj!!.name }.collect(Collectors.joining(" | ")))
    }

    fun <T : Enum<T>?> enumFormat(enums: Collection<T>): Attributes.Attribute {
        return Attributes.key(KEY_FORMAT)
            .value(enums.stream().map { obj: T -> obj!!.name }.collect(Collectors.joining(" | ")))
    }

    fun <T : Enum<T>?> enumFormat(enums: Collection<T>, detailFcuntion: Function<T, String>): Attributes.Attribute {
        return Attributes.key(KEY_FORMAT)
            .value(
                enums.stream().map { en: T -> en!!.name + "(" + detailFcuntion.apply(en) + ")" }
                    .collect(Collectors.joining(" | "))
            )
    }

    fun emptySample(): Attributes.Attribute {
        return Attributes.key(KEY_SAMPLE).value("")
    }

    fun customSample(custom: String?): Attributes.Attribute {
        return Attributes.key(KEY_SAMPLE).value(custom)
    }
}
