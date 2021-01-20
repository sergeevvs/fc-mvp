package sergeevvs.fc_mvp.teamcard

import android.os.Bundle
import androidx.navigation.NavController
import sergeevvs.fc_mvp.data.Team
import sergeevvs.fc_mvp.main.MvpView

interface TeamCardFragment: MvpView {

    fun getArguments(): Bundle?
    fun showTeam(team: Team)
}