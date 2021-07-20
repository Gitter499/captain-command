package parser

class Flag(
    open val flag_name: String,
    open val flag_description: String,
    open val flag_alias: String,
    open val flag_status: Status,
    open val parent_command: Command
)