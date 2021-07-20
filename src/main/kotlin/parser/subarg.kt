package parser

class SubArg(
    open val subarg_description: String,
    open val subarg_required: Boolean,
    open val subarg_type: ArgType,


    ) {
    var subarg_value: Any? = null
}


