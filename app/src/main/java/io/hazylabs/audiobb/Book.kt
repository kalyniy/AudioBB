package io.hazylabs.audiobb

import java.io.Serializable
import java.lang.StringBuilder

class Book : Serializable
{
    var title: String? = null
    var author: String? = null

    constructor() {}
    constructor(title: String?, author: String?) {
        this.title = title
        this.author = author
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("\"title\":$title\n")
        sb.append("\"author\":$author\n")
        return sb.toString()
    }
}
