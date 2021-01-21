package sergeevvs.fc_mvp.teamslist

import android.graphics.drawable.PictureDrawable
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.bumptech.glide.RequestBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sergeevvs.fc_mvp.adapter.TeamsListAdapter
import sergeevvs.fc_mvp.data.TeamsList
import sergeevvs.fc_mvp.data.getMockTeamsList
import sergeevvs.fc_mvp.main.BasePresenter
import sergeevvs.fc_mvp.repository.MainRepository
import sergeevvs.fc_mvp.svg.GlideApp
import sergeevvs.fc_mvp.svg.SvgSoftwareLayerSetter

class TeamsListPresenterImpl(private val model: MainRepository) :
    BasePresenter<TeamsListFragment>(), TeamsListPresenter {

    private var teams = getMockTeamsList()
    private lateinit var navController: NavController
    private lateinit var requestBuilder: RequestBuilder<PictureDrawable>

    override fun getTeamsList() = teams

    override fun attachTeamsList(teams: TeamsList) {
        this.teams = teams
    }

    override fun viewIsReady() {
        requestBuilder = GlideApp.with(view as Fragment)
                .`as`(PictureDrawable::class.java)
                .listener(SvgSoftwareLayerSetter)
        view?.getNavController()?.let { navController = it }
        if (teams.list.isEmpty()) loadTeams()
    }

    private fun loadTeams() {
        model.getTeams().enqueue(object : Callback<TeamsList> {
            override fun onResponse(call: Call<TeamsList>, response: Response<TeamsList>) {
                response.body()?.let { teams = it }
                view?.updateList()
            }

            override fun onFailure(call: Call<TeamsList>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    override fun onBindTeamAtPosition(holder: TeamsListAdapter.TeamCardHolder, position: Int) {
        holder.bindTeam(teams.list[position], navController, requestBuilder)
    }

    override fun getTeamCount(): Int {
        return teams.list.size
    }
}