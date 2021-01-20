package sergeevvs.fc_mvp.data

const val ID = "id"
const val TEAM = "team"
const val TEAMS_LIST = "teams_list"


fun getMockTeam() = Team(
    id = 0,
    area = Area(id = 0, name = "Mocked data"),
    name = "Mocked data",
    crestUrl = "https://crests.football-data.org/58.svg",
    website = "Mocked data",
    email = "Mocked data",
    squad = mutableListOf(Player(id = 0, name = "Mocked data", position = "Mocked data"))
)

fun getMockTeamsList() = TeamsList(mutableListOf(getMockTeam(), getMockTeam(), getMockTeam()))