package sergeevvs.fc_mvp.data

const val ID = "id"
const val TEAM = "team"
const val TEAMS_LIST = "teams_list"


fun getMockTeam() = Team(
    id = 0,
    area = Area(id = 0, name = ""),
    name = "",
    crestUrl = "",
    website = "",
    email = "",
    squad = mutableListOf()
)

fun getMockTeamsList() = TeamsList(mutableListOf())