package sergeevvs.fc_mvp.teamslist

import androidx.navigation.NavController
import sergeevvs.fc_mvp.main.MvpView

interface TeamsListFragment: MvpView {

    fun getNavController(): NavController
    fun updateList()
}