package sergeevvs.fc_mvp.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import sergeevvs.fc_mvp.data.Area
import sergeevvs.fc_mvp.data.Player


const val ID = "id"

data class Team(

    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("area")
    @Expose
    val area: Area,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("crestUrl")
    @Expose
    val crestUrl: String,

    @SerializedName("website")
    @Expose
    val website: String,

    @SerializedName("email")
    @Expose
    val email: String,

    @SerializedName("squad")
    @Expose
    val squad: List<Player>

)