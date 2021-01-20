package sergeevvs.fc_mvp.teamcard

import sergeevvs.fc_mvp.data.Team
import sergeevvs.fc_mvp.main.MvpPresenter

interface TeamCardPresenter: MvpPresenter<TeamCardFragment> {

    // saving instance
    fun getTeam(): Team
    fun attachTeam(team: Team)
}