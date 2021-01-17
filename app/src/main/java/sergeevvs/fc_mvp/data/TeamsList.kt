package com.sergeevvs.footballcards.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TeamsList(

    @SerializedName("teams")
    @Expose
    val list: List<Team>

)
