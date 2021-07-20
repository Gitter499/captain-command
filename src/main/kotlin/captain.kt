import parser.*
import settings.Settings

// Demo file


fun main(args: Array<String>) {
    // Library Info

    val parser: Parser = Parser(args, Settings("Test App", global_args = false, auto_help_gen = true))


    parser.parse()

    parser.add_command(
        Command(
            "echo",
            "prints message to the console",
            command_alias = null,
            command_short_name = "ec",
            command_required = null,
            command_status = Status.SUPPORTED,
        )
    ).add_arg(SubArg("String to echo", subarg_required = true, subarg_type = ArgType.String))

    parser.exec_command("echo") { subarg, flags ->
        if (subarg != null) {

            println(subarg)

        }
    }
}

