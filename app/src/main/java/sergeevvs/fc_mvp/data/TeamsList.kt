package sergeevvs.fc_mvp.data

import androidx.lifecycle.ViewModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TeamsList(

    @SerializedName("teams")
    @Expose
    val list: MutableList<Team>

) : Serializable