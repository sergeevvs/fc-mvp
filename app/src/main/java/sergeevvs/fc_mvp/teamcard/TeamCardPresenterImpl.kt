package sergeevvs.fc_mvp.teamcard

import android.graphics.drawable.PictureDrawable
import androidx.fragment.app.Fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sergeevvs.fc_mvp.data.ID
import sergeevvs.fc_mvp.data.Team
import sergeevvs.fc_mvp.data.getMockTeam
import sergeevvs.fc_mvp.main.BasePresenter
import sergeevvs.fc_mvp.repository.MainRepository
import sergeevvs.fc_mvp.svg.GlideApp
import sergeevvs.fc_mvp.svg.SvgSoftwareLayerSetter
import javax.inject.Inject

class TeamCardPresenterImpl @Inject constructor(
    private val repository: MainRepository
) : BasePresenter<TeamCardFragment>(),
    TeamCardPresenter {

    private var team = getMockTeam()
    private val requestBuilder by lazy {
        GlideApp.with(view as Fragment)
                .`as`(PictureDrawable::class.java)
                .listener(SvgSoftwareLayerSetter)
    }

    override fun getTeam() = team

    override fun attachTeam(team: Team) {
        this.team = team
    }

    override fun viewIsReady() {
        if (team.id == 0) loadTeam()
        else view?.showTeam(team, requestBuilder)
    }

    private fun loadTeam() {
        view?.getArguments()?.getInt(ID)?.let {
            repository.getTeam(it).enqueue(object : Callback<Team> {
                override fun onResponse(call: Call<Team>, response: Response<Team>) {
                    response.body()?.let { it1 -> team = it1 }
                    view?.showTeam(team, requestBuilder)
                }

                override fun onFailure(call: Call<Team>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        }
    }
}