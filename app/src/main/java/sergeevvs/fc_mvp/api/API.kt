package sergeevvs.fc_mvp.api

import sergeevvs.fc_mvp.data.Team
import sergeevvs.fc_mvp.data.TeamsList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface API {

    @Headers("X-Auth-Token: 945424df6fec4ea9a5c99d6fdab38bac")
    @GET("teams/{id}")
    fun getTeam(@Path("id") id: Int): Call<Team>

    @Headers("X-Auth-Token: 945424df6fec4ea9a5c99d6fdab38bac")
    @GET("teams")
    fun getTeams(): Call<TeamsList>

}