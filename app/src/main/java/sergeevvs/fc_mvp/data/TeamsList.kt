package sergeevvs.fc_mvp.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

fun getMockTeamsList() = TeamsList(listOf(getMockTeam(), getMockTeam(), getMockTeam()))

data class TeamsList(

    @SerializedName("teams")
    @Expose
    val list: List<Team>

)
