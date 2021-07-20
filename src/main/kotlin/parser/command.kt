package parser


class Command(
    open var command_name: String,
    open var command_description: String?,
    open var command_alias: String?,
    open var command_short_name: String?,
    open var command_required: Boolean?,
    open var command_status: Status,


) {

    open var flags: MutableList<Flag> = mutableListOf()
    open var subargs: MutableList<SubArg> = mutableListOf()

    open fun add_arg(subArg: SubArg): Command {
        this.subargs.add(subArg)

        return this
    }

    open fun add_flag(flag: Flag): Command {
        this.flags.add(flag)
        return this
    }

    open fun required(): Unit {
        this.command_required = true
    }




}

