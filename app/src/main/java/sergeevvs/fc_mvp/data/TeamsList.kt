package sergeevvs.fc_mvp.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import sergeevvs.fc_mvp.data.Team

data class TeamsList(

    @SerializedName("teams")
    @Expose
    val list: List<Team>

)
