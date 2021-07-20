package parser

import settings.Settings

open class Parser(
    open val argv: Array<String>,
    open val options: Settings
) {

    open var commands: MutableList<Command> = mutableListOf()


    open fun parse(): Unit {

        if (argv.isEmpty()) {
            println("No arguments provided")
        }
        if (this.options.auto_help_gen) {
            if (this.commands.isEmpty()) {
                throw Error("No commands provided, can not generate help page")
            }

        }


    }
    // Command builder, might make infix later

    open fun add_command(command: Command): Command {
        this.commands.add(command)
        return command
    }

    open fun exec_command(name: String, callback: ((subargs: String?, flags: Array<Any>?) -> Unit)): Unit {
        val command = commands.find {
            name == it.command_name
        }

        if (name.equals(command!!.command_name, ignoreCase = true) || name.equals(
                command!!.command_alias,
                ignoreCase = true
            )
        ) {

            var flags: Array<Any>? = arrayOf()
            var subargs: String? = null
            for (i in 0 until this.commands.size) {
                for (j in 0 until this.commands[i].subargs.size) {
                    this.commands[i].subargs[j].subarg_value?.let { subargs }
                }
                for (j in 0 until this.commands[i].flags.size) {
                    flags?.set(j, this.commands[i].flags[j])
                }

            }

            callback(subargs, flags)
        }
    }


}
